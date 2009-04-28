package com.google.code.pltsnow.snowfield;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class SnowList extends SnowType {
		
	protected LinkedList<SnowType> data;
	private int size = 0;
	public int getSize() {
		return size;
	}
	
	/**
	 * this could make things pretty confusing,
	 * but thats whats great about lazy 
	 * initialization!
	 * 
	 * actually, this is going to take some work
	 * because Iterator, since it comes from this.data.iterator,
	 * is going to only iterate objects truely in the list
	 * not "virtually" in the list
	 * 
	 * aka, dont use setSize?
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	public SnowList(Object s) {
		super(s);
		data = new LinkedList<SnowType>();
		data.add(new SnowAtom(s));
		size = 1;
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
	 * probably want to use SnowType.get(int)
	 */
	public Object get()
	{
		return null;
	}
	
	/**
	 * @author willi
	 * @return SnowType at index i of the list
	 * if i > size, return null
	 * if i < size, i > this.data.size, expand list and return data.get(i)
	 * if i < this.data.size, return data.get(i) <-- probably expected
	 * this handles lazy instantiation
	 */
	public SnowType get(int i)
	{
		if(i > this.size)
			return null;
		if(i < this.data.size())
			return this.data.get(i);
		else
		{
			while(this.data.size() < i)
				this.push(SnowAtom.makeNil());
			return this.data.get(i);
		}
	}
	
	public void remove(int i)
	{
		this.size--;
		this.data.remove(i);
	}
	
	@Override
	/**
	 * @author willi
	 * is this what was intended?
	 * 
	 * btw, pop def doesnt have a parameter
	 */
	public SnowType pop() {
		this.size--;
		return this.data.pop();
	}

	@Override
	/**
	 * @author willi
	 * is this what was intended?
	 * 
	 * @return the object added
	 */
	public SnowType push(SnowType other) {
		this.size++;
		this.data.push(other);
		return other;
	}
	
	/**
	 * @author willi
	 * convenience method, rather than looping through pushes
	 * used initially to add child population to adult at the
	 * end of mating
	 * @param other
	 * @return
	 */
	public SnowType addAll(SnowList other) {
		for (SnowType s : other) { 
			this.data.add(s);
			this.size ++ ;
		}
		
		return this;
	}
	
	public void reverse() {
		Collections.reverse(this.data);
	}


	/**
	 * @author willi
	 * sorts in ascending order
	 * @param c a comparator for the list
	 * @return i dont really know why this returns anything
	 */
	public SnowList sort(Comparator<SnowType> c)
	{
		Collections.sort(this.data, c);
		return this;
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
	public boolean isType(String type) throws IllegalArgumentException {
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

	/**
	 * @author willi
	 */
	public Iterator<SnowType> iterator() {
		return this.data.iterator();
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
