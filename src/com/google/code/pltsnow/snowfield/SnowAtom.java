package com.google.code.pltsnow.snowfield;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


public class SnowAtom extends SnowType {
	protected HashMap<String, SnowType> fields;
	protected Object data;

	public SnowAtom(Object s) {
		super(s);
		data = s;
		fields = new HashMap<String, SnowType>();
	}

	@Override
	public SnowType getField(String fieldName) {
		if(!fields.containsKey(fieldName) && BaseSnowProgram.types.containsKey(fieldName))
			fields.put(fieldName, BaseSnowProgram.types.get(fieldName).clone());
		else if(!fields.containsKey(fieldName))
			fields.put(fieldName, SnowAtom.makeNil());
		
		SnowType t = fields.get(fieldName);
		if(t instanceof SnowAtom && ((SnowAtom) t).getRawData() == null &&  ((SnowAtom) t).getFields().size() == 1)
			return ((SnowAtom) t).getFields().values().iterator().next();
		else
			return fields.get(fieldName);
	}
	public Object getRawData() {
		return data;
	}
	protected HashMap<String, SnowType> getFields() {
		return fields;
	}
	@Override
	public boolean isFloat() {
		if (data instanceof Float) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isInt() {
		if (data instanceof Integer) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isString() {
		if (data instanceof String) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isNumeric() {
		return isInt() || isFloat() || isDouble();
	}
	public boolean isDouble()
	{
		return data instanceof Double;
	}
	@Override
	public boolean isType(String type) throws IllegalArgumentException {
		if (type.equals("String")) {
			return isString();
		}

		if (type.equals("Float")) {
			return isFloat();
		}

		if (type.equals("Integer")) {
			return isInt();
		}

		throw new IllegalArgumentException("Unknown Type : " + type);

	}

	@Override
	public SnowType setField(String fieldName, SnowType v) {
		fields.put(fieldName, v);
		return v;
	}

	/**
	 * from willi: this doesnt make sense?
	 */
	public Iterator<SnowType> iterator() {
		LinkedList l = new LinkedList();
		l.add(data);
		return l.iterator();
	}

	@Override
	public void set(Object o) {
		if(o instanceof SnowType)
		{
			data = ((SnowType) o ).get();
			SnowType t = (SnowType) o;
			t.populateFields();
			for(String fieldName : t.getFieldNames())
			{
				System.out.println("Setting on a snowtype " + fieldName);
				setField(fieldName, t.getField(fieldName));
			}
		}
		else
			data = o;
	}

	public Object get() {
		if(data instanceof SnowAtom)
			return ((SnowAtom) data).get();
		else if(data == null  && fields.size() == 1)
			return fields.values().iterator().next();
		else
			return data;
	}

	private SnowType doMathOp(SnowType other, char op) {
		Double f1 = (isInt()) ? ((Integer) data).doubleValue() : ((Double) data);

		Double f2 = (other.isInt()) ? ((Integer) other.get()).doubleValue()
				: ((Double) other.get());

		switch (op) {
		case '+':
			return new SnowAtom(f1 + f2);
		case '-':
			return new SnowAtom(f1 - f2);
		case '*':
			return new SnowAtom(f1 * f2);
		case '/':
			return new SnowAtom(f1 / f2);
		case '%':
			return new SnowAtom(f1 % f2);
		case '^':
			return new SnowAtom(Math.pow(f1, f2));
		}

		return null;

	}

	private boolean doRelOp(SnowType other, int choice) {
		Double f1 = (isInt()) ? ((Integer) data).doubleValue() : ((Double) data);

		Double f2 = (isInt()) ? ((Integer) other.get()).doubleValue()
				: ((Double) other.get());

		switch (choice) {
		case 1:
			return f1 == f2;
		case 2:
			return f1 != f2;
		case 3:
			return f1 <= f2;
		case 4:
			return f1 < f2;
		case 5:
			return f1 >= f2;
		case 6:
			return f1 > f2;
		}

		return false;

	}

	@Override
	public SnowType divide(SnowType other) throws UnsupportedOperationException {
		if (isNumeric() && other.isNumeric()) {
			return doMathOp(other, '/');
		}

		throw new UnsupportedOperationException(
				"Division operator applied on incompatible types.");
	}

	@Override
	public SnowType minus(SnowType other) throws UnsupportedOperationException {
		if (isNumeric() && other.isNumeric()) {
			return doMathOp(other, '-');
		}

		throw new UnsupportedOperationException(
				"Minus operator applied on incompatible types.");
	}

	@Override
	public SnowType modulo(SnowType other) throws UnsupportedOperationException {
		if (isNumeric() && other.isNumeric()) {
			return doMathOp(other, '%');
		}

		throw new UnsupportedOperationException(
				"Modulo operator applied on incompatible types.");

	}

	@Override
	public SnowType plus(SnowType other) throws UnsupportedOperationException {
		if (isNumeric() && other.isNumeric()) {
			return doMathOp(other, '+');
		}
		if(isNumeric() && other.isNull())
			return doMathOp(new SnowAtom(0),'+');
		if (isString()) {
			return new SnowAtom(((String) data).concat(other.toString()));
		}
//		System.out.println(this + " " + other);
		throw new UnsupportedOperationException(
				"Addition operator applied on incompatible types.");

	}


	@Override
	/**
	 * from willi: this also doesnt make sense?
	 * whats the conversion?
	 */
	public SnowType push(SnowType other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowType times(SnowType other) {
		if (isNumeric() && other.isNumeric()) {
			return doMathOp(other, '*');
		}

		throw new UnsupportedOperationException(
				"Multiplication operator applied on incompatible types.");
	}

	@Override
	public SnowType clone() {
		// TODO Auto-generated method stub
		SnowAtom r = makeNil();
		for(String field : fields.keySet())
		{
			r.setField(field, fields.get(field).clone());
		}
		return r;
	}

	public static SnowAtom makeNil() {
		// TODO Auto-generated method stub
		return new SnowAtom(null);
	}

	@Override
	public String toString() {
//		if(data instanceof SnowType)
//			return data.toString();
		if (isFloat())
			return ((Float) data).toString();
		else if (isInt())
			return ((Integer) data).toString();
		else if (isString())
			return ((String) data);
		else if(isDouble())
			return ((Double) data).toString();
		else if(data == null)
			return "[Null SnowAtom]";
		else
			return "[Unknown data typed SnowAtom. " + data.getClass().getName() + "]";
	}

	@Override
	public boolean equals(SnowType other)
			throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 1);
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) == 0;
		}

		throw new UnsupportedOperationException(
				"Equals operator applied on incompatible types.");
	}

	@Override
	public boolean ge(SnowType other)
			throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 5);
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) != -1;
		}
		throw new UnsupportedOperationException(
				"Greater Than Or Equals operator applied on incompatible types.");
	}

	@Override
	public boolean gt(SnowType other)
			throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 6);
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) == 1;
		}
		throw new UnsupportedOperationException(
				"Greater Than operator applied on incompatible types.");
	}

	@Override
	public boolean le(SnowType other)
			throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 3);
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) != 1;
		}
		throw new UnsupportedOperationException(
				"Less Than Or Equals operator applied on incompatible types.");
	}

	@Override
	public boolean lt(SnowType other)
			throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 4);
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) == -1;
		}
		throw new UnsupportedOperationException(
				"Less Than operator applied on incompatible types.");
	}

	@Override
	public boolean nequals(SnowType other)
			throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 2);
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) != 0;
		}
		throw new UnsupportedOperationException(
				"Not Equals operator applied on incompatible types.");
	}

	@Override
	public SnowType power(SnowType other)
			throws UnsupportedOperationException {
		if (isNumeric() && other.isNumeric()) {
			return doMathOp(other, '^');
		}

		throw new UnsupportedOperationException(
				"Powed operator applied on incompatible types.");
	}

	@Override
	/**
	 * from willi: i dont know what this means...
	 */
	public boolean hasApproached(SnowType other_)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveTowardsBy(SnowType other_, SnowType unit_)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return data == null;
	}

	@Override
	public SnowType pop() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void populateFields() {
		for(String s : fields.keySet())
		{
			SnowType t = fields.get(s);
			if(BaseSnowProgram.types.containsKey(s) && !(fields.get(s) instanceof SnowList && ((SnowList) fields.get(s)).getSize() > 1))
			{
				fields.put(s, BaseSnowProgram.types.get(s));
//				System.out.println("Expanded " + s + " to " + BaseSnowProgram.types.get(s));
				BaseSnowProgram.types.get(s).populateFields();
			}
		}
	}

	@Override
	public Set<String> getFieldNames() {
		return fields.keySet();
	}
}
