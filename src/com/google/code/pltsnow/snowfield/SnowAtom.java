package com.google.code.pltsnow.snowfield;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

//Author - Jon & Willi
public class SnowAtom extends SnowType {
	public static final SnowAtom TRUE = new SnowAtom(1);
	public static final SnowAtom FALSE = new SnowAtom(0);

	protected HashMap<String, SnowType> fields;
	protected Object data;

	public SnowAtom(Object s) {
		super(s);
		data = s;
		fields = new HashMap<String, SnowType>();
	}

	@Override
	public SnowType getField(String fieldName) {
		if (!fields.containsKey(fieldName)
				&& BaseSnowProgram.types.containsKey(fieldName))
			fields.put(fieldName, BaseSnowProgram.types.get(fieldName).clone());
		else if (!fields.containsKey(fieldName))
			fields.put(fieldName, SnowAtom.makeNil());

		SnowType t = fields.get(fieldName);
		if (t instanceof SnowAtom && ((SnowAtom) t).getRawData() == null
				&& ((SnowAtom) t).getFields().size() == 1)
			return ((SnowAtom) t).getFields().values().iterator().next();
		else
			return fields.get(fieldName);
	}

	public Object getRawData() {
		if (data instanceof SnowAtom)
			return ((SnowAtom) data).get();
		else
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

	public boolean isDouble() {
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
		if (o instanceof SnowType) {
			data = ((SnowType) o).get();
			SnowType t = (SnowType) o;
			t.populateFields();
			for (String fieldName : t.getFieldNames()) {
				setField(fieldName, t.getField(fieldName));
			}
		}

		/*
		 * if(o instanceof SnowList) { data = ((SnowList) o ).get(); } else if
		 * (o instanceof SnowAtom) { data = ((SnowAtom) o).get(); for(String
		 * field : ((SnowAtom) o).fields.keySet()) { this.setField(field,
		 * fields.get(field).clone()); } //fields = ((SnowAtom) o).fields; }
		 */
		else
			data = o;
	}

	public Object get() {
		if (data instanceof SnowAtom)
			return ((SnowAtom) data).get();
		else if (data == null && fields.size() == 1)
			return fields.values().iterator().next();
		else
			return data;
	}

	private SnowType doMathOp(SnowType other, char op) {
		Double f1 = (isInt()) ? ((Integer) data).doubleValue()
				: ((Double) data);

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
		Double t1 = (isInt()) ? ((Integer) data).doubleValue()
				: ((Double) data);

		Double t2 = (other.isInt()) ? ((Integer) other.get()).doubleValue()
				: ((Double) other.get());
		double f1 = t1.doubleValue();
		double f2 = t2.doubleValue();
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
		if (isNumeric() && other.isNull())
			return doMathOp(new SnowAtom(0), '+');
		if (isString()) {
			return new SnowAtom(((String) data).concat(other.toString()));
		}
		if (other.isString()) {
			return new SnowAtom(data.toString().concat(other.toString()));
		}
		// System.out.println(this + " " + other);
		throw new UnsupportedOperationException(
				"Addition operator applied on incompatible types.");

	}

	@Override
	public SnowType push(SnowType other) {
		SnowList l = new SnowList();
		l.push(this);
		l.push(other);
		return l;
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
		SnowAtom r = makeNil();
		for (String field : fields.keySet()) {
			r.setField(field, fields.get(field).clone());
		}
		r.data = data;
		return r;
	}

	public static SnowAtom makeNil() {
		return new SnowAtom(null);
	}

	@Override
	public String toString() {
		// if(data instanceof SnowType)
		// return data.toString();
		if (isFloat())
			return ((Float) data).toString();
		else if (isInt())
			return ((Integer) data).toString();
		else if (isString())
			return ((String) data);
		else if (isDouble())
			return ((Double) data).toString();
		else if (data == null)
			return "[Null SnowAtom]";
		else
			return "[Unknown data typed SnowAtom. " + data.getClass().getName()
					+ "]";
	}

	@Override
	public SnowAtom equals(SnowType other) throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 1) ? TRUE : FALSE;
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) == 0 ? TRUE
					: FALSE;
		}

		throw new UnsupportedOperationException(
				"Equals operator applied on incompatible types.");
	}

	@Override
	public SnowAtom ge(SnowType other) throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 5) ? TRUE : FALSE;
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) != -1 ? TRUE
					: FALSE;
		}
		throw new UnsupportedOperationException(
				"Greater Than Or Equals operator applied on incompatible types.");
	}

	@Override
	public SnowAtom gt(SnowType other) throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 6) ? TRUE : FALSE;
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) == 1 ? TRUE
					: FALSE;
		}
		throw new UnsupportedOperationException(
				"Greater Than operator applied on incompatible types.");
	}

	@Override
	public SnowAtom le(SnowType other) throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 3) ? TRUE : FALSE;
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) != 1 ? TRUE
					: FALSE;
		}
		throw new UnsupportedOperationException(
				"Less Than Or Equals operator applied on incompatible types.");
	}

	@Override
	public SnowAtom lt(SnowType other) throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 4) ? TRUE : FALSE;
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) == -1 ? TRUE
					: FALSE;
		}
		throw new UnsupportedOperationException(
				"Less Than operator applied on incompatible types.");
	}

	@Override
	public SnowAtom nequals(SnowType other)
			throws UnsupportedOperationException {

		if (isNumeric() && other.isNumeric()) {
			return doRelOp(other, 2) ? TRUE : FALSE;
		}

		if (isString()) {
			return ((String) data).compareTo(other.toString()) != 0 ? TRUE
					: FALSE;
		}
		throw new UnsupportedOperationException(
				"Not Equals operator applied on incompatible types.");
	}

	@Override
	public SnowType power(SnowType other) throws UnsupportedOperationException {
		if (isNumeric() && other.isNumeric()) {
			return doMathOp(other, '^');
		}

		throw new UnsupportedOperationException(
				"Powed operator applied on incompatible types.");
	}

	@Override
	/*
	 * from willi: i dont know what this means...
	 * 
	 * @willi - it means basically is this equal to that. there is a bug in the
	 * translator that requires this to be the opposite though
	 */
	public boolean hasApproached(SnowType other, SnowType from)
			throws UnsupportedOperationException {
		if (from.getDouble() > other.getDouble()) // We want to check for
			return getDouble() <= other.getDouble();
		else
			// We are counting up
			return getDouble() >= other.getDouble(); // do not change this
														// without talking to
														// me. - jb
	}

	@Override
	public boolean moveTowardsBy(SnowType other, SnowType unit, SnowType from)
			throws UnsupportedOperationException {
		if (ge(other).getInt() == 1) {
			// We are bigger than the other, subtract
			data = minus(unit).get();
		} else
			data = plus(unit).get();
		return true;
	}

	@Override
	public boolean isNull() {
		return data == null;
	}

	@Override
	public SnowType pop() throws UnsupportedOperationException {
		return SnowList.makeNil();
	}

	@Override
	public void populateFields() {
		for (String s : fields.keySet()) {
			SnowType t = fields.get(s);
			if (BaseSnowProgram.types.containsKey(s)
					&& !(fields.get(s) instanceof SnowList && ((SnowList) fields
							.get(s)).getSize() > 1)) {
				fields.put(s, BaseSnowProgram.types.get(s));
				// System.out.println("Expanded " + s + " to " +
				// BaseSnowProgram.types.get(s));
				BaseSnowProgram.types.get(s).populateFields();
			}
		}
	}

	@Override
	public Set<String> getFieldNames() {
		return fields.keySet();
	}

	@Override
	public SnowType log_and(SnowType other_)
			throws UnsupportedOperationException {
		try {
			if (getInt() == 0) {
				return FALSE;
			} else if (other_.getInt() == 0) {
				return FALSE;
			} else {
				return TRUE;
			}
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public SnowType log_not() throws UnsupportedOperationException {
		try {
			if (getInt() == 0) {
				return TRUE;
			} else {
				return FALSE;
			}
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public SnowType log_or(SnowType other_)
			throws UnsupportedOperationException {
		try {
			if (getInt() != 0) {
				return TRUE;
			} else if (other_.getInt() != 0) {
				return TRUE;
			} else {
				return FALSE;
			}
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public SnowType decrement() throws UnsupportedOperationException {
		if (isNumeric()) {
			data = minus(new SnowAtom(1)).get();
			return this;
		}

		throw new UnsupportedOperationException();
	}

	@Override
	public SnowType increment() throws UnsupportedOperationException {
		if (isNumeric()) {
			data = plus(new SnowAtom(1)).get();
			return this;
		}

		throw new UnsupportedOperationException();
	}
}
