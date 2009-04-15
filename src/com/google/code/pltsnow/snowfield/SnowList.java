package com.google.code.pltsnow.snowfield;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class SnowList extends SnowType {
		
	protected LinkedList<SnowType> data;
	private int size;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public SnowList(Object s) {
		super(s);
		data = new LinkedList<SnowType>();
		data.add(new SnowAtom(s));
	}
	
	/**
	 * @author willi
	 * basic default constructor?
	 */
	public SnowList() {
		super(null);
		data = new LinkedList<SnowType>();
	}
	
	
	/**
	 * @author willi
	 * implemented just so that it conforms to snowtype
	 */
	public Object get()
	{
		return null;
	}

	public SnowList sort()
	{
		return null;
	}
	@Override
	public SnowType getField(String fieldName) {
		if(data.size() == 0)
			return null;
		else
			return data.getFirst().getField(fieldName);
	}

	@Override
	public boolean isFloat() {
		if(data.size() == 0)
			return false;
		else
			return data.getFirst().isFloat();
	}

	@Override
	public boolean isInt() {
		if(data.size() == 0)
			return false;
		else
			return data.getFirst().isInt();
	}

	@Override
	public boolean isString() {
		if(data.size() == 0)
			return false;
		else
			return data.getFirst().isString();
	}

	@Override
	public boolean isType(String type) {
		if(data.size() == 0)
			return false;
		else
			return data.getFirst().isType(type);
	}

	@Override
	public SnowType setField(String fieldName, SnowType v) {
		for(SnowType a : data)
			a.setField(fieldName, v);
		return v;
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
