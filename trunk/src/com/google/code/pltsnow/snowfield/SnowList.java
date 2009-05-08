package com.google.code.pltsnow.snowfield;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class SnowList extends SnowType {

	protected LinkedList<SnowType> data;
	private int size = 0;

	public int getSize() {
		return size;
	}

	/**
	 * THERE BE DRAGONS HERE!!!!!!!!
	 * 
	 * THIS WILL INITIALIZE THE LIST TOO!!!!!!
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
		data = new LinkedList<SnowType>();
		for (int i = 0; i < size; i++) {
			data.add(SnowAtom.makeNil());
		}
	}

	public SnowList(Object s) {
		super(s);
		data = new LinkedList<SnowType>();
		data.add(new SnowAtom(s));
		size = 1;
		for (int i = 0; i < size; i++) {
			data.add(SnowAtom.makeNil());
		}
	}

	/**
	 * @author willi basic default constructor?
	 */
	public SnowList() {
		super(null);
		data = new LinkedList<SnowType>();
	}

	/**
	 * @author willi implemented just so that it conforms to snowtype
	 */
	public Object get() {
		return data.getFirst();
	}

	/**
	 * @author willi
	 * @return SnowType at index i of the list if i > size, return null if i <
	 *         size, i > this.data.size, expand list and return data.get(i) if i
	 *         < this.data.size, return data.get(i) <-- probably expected this
	 *         handles lazy instantiation
	 */
	public SnowType get(int i) {
		if (i > this.size)
			return null;
		if (i < this.data.size())
			return this.data.get(i);
		else {
			while (this.data.size() < i)
				this.push(SnowAtom.makeNil());
			return this.data.get(i);
		}
	}

	public void remove(int i) {
		this.size--;
		this.data.remove(i);
	}

	@Override
	/*
	 * @author willi is this what was intended?
	 * 
	 * btw, pop def doesnt have a parameter
	 */
	public SnowType pop() {
		this.size--;
		return this.data.pop();
	}

	public SnowType peek() {
		return this.data.peek();
	}

	/**
	 * @author willi is this what was intended?
	 * 
	 * @return the object added
	 */
	public SnowType push(SnowType other) {
		this.size++;
		this.data.push(other);
		return other;
	}

	/**
	 * @author willi convenience method, rather than looping through pushes used
	 *         initially to add child population to adult at the end of mating
	 * @param other
	 * @return
	 */
	public SnowType addAll(SnowList other) {
		for (SnowType s : other) {
			this.data.add(s);
			this.size++;
		}

		return this;
	}

	public void reverse() {
		Collections.reverse(this.data);
	}

	/**
	 * @author willi sorts in ascending order
	 * @param c
	 *            a comparator for the list
	 * @return i dont really know why this returns anything
	 */
	public SnowList sort(Comparator<SnowType> c) {
		Collections.sort(this.data, c);
		return this;
	}

	@Override
	/*
	 * returns the field of the first element of the list null if the list is
	 * empty
	 */
	public SnowType getField(String fieldName) {
		if (data.size() == 0)
			return null;
		else
			return data.getFirst().getField(fieldName);
	}

	@Override
	public boolean isFloat() {
		if (data.size() == 0)
			return false;
		else
			return data.getFirst().isFloat();
	}

	@Override
	public boolean isInt() {
		if (data.size() == 0)
			return false;
		else
			return data.getFirst().isInt();
	}

	@Override
	public boolean isString() {
		if (data.size() == 0)
			return false;
		else
			return data.getFirst().isString();
	}

	@Override
	public boolean isType(String type) throws IllegalArgumentException {
		if (data.size() == 0)
			return false;
		else
			return data.getFirst().isType(type);
	}

	@Override
	/*
	 * sets the field given by fieldName of _each_ element in the list
	 */
	public SnowType setField(String fieldName, SnowType v) {
		for (SnowType a : data)
			a.setField(fieldName, v);
		return v;
	}

	public Iterator<SnowType> iterator() {
		// TODO Auto-generated method stub
		return this.data.iterator();
	}

	@Override
	public void set(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof SnowList) {
			SnowList o1 = (SnowList) o;
			data = o1.data;
			this.size = o1.size;
		} else {
			data.clear();
			data.add((SnowType) o);
			// System.out.println("SnowList.set not implemented");
			// System.exit(-1);
		}
	}

	public void setNth(int n, SnowType d) {
		data.get(n).set(d);
		// data.set(n, d);
	}

	@Override
	public SnowType divide(SnowType other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getFieldNames() {
		return data.getFirst().getFieldNames();
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
		SnowList r = makeNilList(0);
		r.data = new LinkedList<SnowType>();
		for (SnowType d : data)
			r.push(d.clone());

		return r;
	}

	public static SnowType makeNil() {
		// TODO Auto-generated method stub
		return new SnowList(null);
	}

	public static SnowList makeNilList(int len) {
		SnowList r = new SnowList(null);
		r.setSize(len);
		// System.out.println("Make nil list of " + len);
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
	public SnowAtom equals(SnowType other_)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowAtom ge(SnowType other_) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowAtom gt(SnowType other_) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowAtom le(SnowType other_) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowAtom lt(SnowType other_) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowAtom nequals(SnowType other_)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/*
	 * from willi: i dont know what these are...
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
	public String toString() {
		String r = "[SnowList; Data: {";
		for (SnowType d : data) {
			r += d + ", ";
		}
		r += "}, size= " + size + "]";
		return r;
	}

	@Override
	public boolean isNull() {
		// TODO Auto-generated method stub
		return data.size() == 0;
	}

	public SnowType getNth(int i) {
		// TODO Auto-generated method stub
		return data.get(i);
	}

	@Override
	public void populateFields() {
		for (SnowType d : data) {
			d.populateFields();
		}
	}

	@Override
	public SnowType log_and(SnowType other_)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowType log_not() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SnowType log_or(SnowType other_)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}
}
