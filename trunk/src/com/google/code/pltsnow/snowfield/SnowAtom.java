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
		if(data instanceof Float)
			return true;
		return false;
	}

	@Override
	public boolean isInt() {
		if(data instanceof Integer)
			return true;
		return false;
	}

	@Override
	public boolean isString() {
		if(data instanceof String)
			return true;
		return false;
	}

	@Override
	public boolean isType(String type) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public SnowType divide(SnowType other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowType minus(SnowType other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowType modulo(SnowType other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowType plus(SnowType other) {
		// TODO Auto-generated method stub
		if(isString())
			return new SnowAtom(((String) data).concat(other.toString()));
		if(isInt() && other.isInt())
			return new SnowAtom(((Integer) data) + ((Integer) other.get()));
		return null;
	}

	@Override
	public SnowType pop(SnowType other) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowType clone() {
		// TODO Auto-generated method stub
		return null;
	}

	public static SnowType makeNil() {
		// TODO Auto-generated method stub
		return new SnowAtom(null);
	}

	@Override
	public String toString() {
		if(isFloat())
			return ((Float) data).toString();
		else if(isInt())
			return ((Integer) data).toString();
		else if(isString())
			return ((String) data);
		return "Unknown data typed SnowAtom";
	}
}
