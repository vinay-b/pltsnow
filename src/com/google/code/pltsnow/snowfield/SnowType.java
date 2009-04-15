package com.google.code.pltsnow.snowfield;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
				
public abstract class SnowType implements Iterable<SnowType>, Cloneable {

	protected String complexTypeName;
	
	public static SnowType NIL = new SnowAtom(null);
	public abstract void set(Object o);
	public abstract SnowType getField(String fieldName);
	
	public abstract SnowType setField(String fieldName,SnowType v);
	
	public SnowType(Object s) {
	}
	public abstract boolean isInt();
	public abstract boolean isString();
	public abstract boolean isFloat();
	public abstract boolean isType(String type);
	
	public abstract SnowType plus(SnowType other);
	public abstract SnowType minus(SnowType other);
	public abstract SnowType push(SnowType other);
	public abstract SnowType pop(SnowType other);
	public abstract SnowType times(SnowType other);
	public abstract SnowType divide(SnowType other);
	public abstract SnowType modulo(SnowType other);
	public abstract SnowType clone();
}
