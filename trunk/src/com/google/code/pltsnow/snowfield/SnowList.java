package com.google.code.pltsnow.snowfield;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import com.google.code.pltsnow.exception.InvalidArgumentException;
import com.google.code.pltsnow.exception.UnsupportedOperationException;

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
	public boolean isType(String type) throws InvalidArgumentException {
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
	public static SnowType makeNil() {
		// TODO Auto-generated method stub
		return new SnowList(null);
	}
	public static SnowList makeNilList(int len)
	{
		SnowList r = new SnowList(null);
		r.setSize(len);
		return r;
	}
	@Override
	public boolean isNumeric() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SnowType power(SnowType other_) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean equals(SnowType other_) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean ge(SnowType other_) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean gt(SnowType other_) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean le(SnowType other_) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean lt(SnowType other_) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean nequals(SnowType other_)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return false;
	}
}
