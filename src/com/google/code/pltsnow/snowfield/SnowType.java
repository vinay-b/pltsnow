package com.google.code.pltsnow.snowfield;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class SnowType implements Iterable<SnowType>, Cloneable {

	protected String complexTypeName;

	public static SnowType NIL = new SnowAtom(null);

	public abstract void set(Object o);

	public abstract Object get();

	public abstract SnowType getField(String fieldName);

	public abstract SnowType setField(String fieldName, SnowType v);

	public SnowType(Object s) {
	}

	public abstract boolean isInt();

	public abstract boolean isString();

	public abstract boolean isFloat();

	public abstract boolean isNumeric();

	public abstract boolean isType(String type) throws IllegalArgumentException;

	public abstract SnowType plus(SnowType other)
			throws UnsupportedOperationException;

	public abstract SnowType minus(SnowType other)
			throws UnsupportedOperationException;

	public abstract SnowType push(SnowType other)
			throws UnsupportedOperationException;

	/**
	 * @author willi
	 * change: no parameter?
	 * @return
	 * @throws UnsupportedOperationException
	 */
	public abstract SnowType pop()
			throws UnsupportedOperationException;

	public abstract SnowType times(SnowType other)
			throws UnsupportedOperationException;

	public abstract SnowType divide(SnowType other)
			throws UnsupportedOperationException;

	public abstract SnowType modulo(SnowType other)
			throws UnsupportedOperationException;

	public abstract SnowType power(SnowType other)
			throws UnsupportedOperationException;

	public abstract boolean lt(SnowType other)
			throws UnsupportedOperationException;

	public abstract boolean gt(SnowType other)
			throws UnsupportedOperationException;

	public abstract boolean le(SnowType other)
			throws UnsupportedOperationException;

	public abstract boolean ge(SnowType other)
			throws UnsupportedOperationException;

	public abstract boolean equals(SnowType other)
			throws UnsupportedOperationException;

	public abstract boolean nequals(SnowType other)
			throws UnsupportedOperationException;

	public abstract boolean hasApproached(SnowType other)
			throws UnsupportedOperationException;

	public abstract boolean moveTowardsBy(SnowType other, SnowType unit)
			throws UnsupportedOperationException;

	public abstract SnowType clone();

	public void addField(String string) {
		setField(string, SnowAtom.makeNil());
	}

	public void addList(String string, int len) {
		setField(string, SnowList.makeNilList(len));
	}
	
	public float getFloat() {
		if (isFloat())
			return (Float) get();
		else if (isInt())
			return Float.parseFloat(get().toString());
		else
			throw new ClassCastException(
					"Can not make a float out of this type," + get().getClass().getName());
	}
	public int getInt()
	{
		if(isInt())
			return (Integer) get();
		else
			throw new ClassCastException("Can not make an integer out of " + this.getClass().getName());
	}

	public abstract boolean isNull();
	public boolean isDouble()
	{
		return get() instanceof Double;
	}
	public double getDouble() {
		if(isDouble())
			return (Double) get();
		else if(isInt())
			return ((Integer) get()).doubleValue();
		else if(isFloat())
			return ((Float) get()).floatValue();
		else
			throw new ClassCastException("Can not make an double out of " + this.getClass().getName());
	}

	public abstract void populateFields();
}
