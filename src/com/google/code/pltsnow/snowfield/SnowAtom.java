package com.google.code.pltsnow.snowfield;

import java.util.HashMap;
import java.util.Iterator;


public class SnowAtom extends SnowType {
	protected HashMap<String, SnowType> fields;
	private Object data;

	public SnowAtom(Object s) {
		super(s);
		data = s;
		fields = new HashMap<String, SnowType>();
	}

	@Override
	public SnowType getField(String fieldName) {
		return fields.get(fieldName);
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
		return isInt() || isFloat();
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

	public Iterator<SnowType> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(Object o) {
		data = o;
	}

	public Object get() {

		return data;
	}

	private SnowType doMathOp(SnowType other, char op) {
		Float f1 = (isInt()) ? ((Integer) data).floatValue() : ((Float) data);

		Float f2 = (other.isInt()) ? ((Integer) other.get()).floatValue()
				: ((Float) other.get());

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
		Float f1 = (isInt()) ? ((Integer) data).floatValue() : ((Float) data);

		Float f2 = (isInt()) ? ((Integer) other.get()).floatValue()
				: ((Float) other.get());

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

		if (isString()) {
			return new SnowAtom(((String) data).concat(other.toString()));
		}

		throw new UnsupportedOperationException(
				"Addition operator applied on incompatible types.");

	}

	@Override
	public SnowType pop() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * @author willi
	 * shallow cloning
	 */
	public SnowType clone() {
		SnowAtom newAtom = new SnowAtom(this.data);
		
		// shallow. is this what we want?
		newAtom.fields = (HashMap<String, SnowType>)this.fields.clone();
		return newAtom;
	}

	public static SnowAtom makeNil() {
		return new SnowAtom(null);
	}

	@Override
	public String toString() {
		if (isFloat())
			return ((Float) data).toString();
		else if (isInt())
			return ((Integer) data).toString();
		else if (isString())
			return ((String) data);
		return "Unknown data typed SnowAtom";
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
}
