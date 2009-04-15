package com.google.code.pltsnow.snowfield;

import java.util.HashMap;
import java.util.Iterator;

public class SnowAtom extends SnowType {
	protected HashMap<String, SnowType> fields;
	private Object data;
	
	public SnowAtom(Object s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public SnowType getField(String fieldName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFloat() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isString() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isType(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SnowType setField(String fieldName, SnowType v) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<SnowType> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(Object o) {
		// TODO Auto-generated method stub
		
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

}
