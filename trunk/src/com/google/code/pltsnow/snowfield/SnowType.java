package com.google.code.pltsnow.snowfield;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class SnowType implements Iterable<SnowType> {
	private LinkedList<Object> data;
	private HashMap<String, SnowType> fields;
	protected String complexTypeName;
	public static SnowType NIL = new SnowType(null);
	public void set(Object o)
	{
		data.clear();
		data.add(o);
	}
	public SnowType getField(String fieldName)
	{
		if(!fields.containsKey(fieldName))
		{
			fields.put(fieldName, NIL);
		}
		return fields.get(fieldName);
	}
	public SnowType setField(String fieldName,SnowType v)
	{
		return fields.put(fieldName,v);
	}
	public void addField(String fieldName)
	{
		fields.put(fieldName, NIL);
	}
	public SnowType(Object s) {
		data = new LinkedList<Object>();
		fields = new HashMap<String, SnowType>();
		data.add(s);
	}
	public boolean isInt(Object arg)
	{
		//TODO - needs to be done :)
		return false;
	}
	public boolean isString(Object arg)
	{
		//TODO - needs to be done :)
		return false;
	}
	public boolean isFloat(Object arg)
	{
		//TODO - needs to be done :)
		return false;
	}
	public boolean isChromosome(Object arg)
	{
		//TODO - needs to be done :)
		return false;
	}
	public boolean isGene(Object arg)
	{
		//TODO - needs to be done :)
		return false;
	}
	public boolean isOrganism(Object arg)
	{
		//TODO - needs to be done :)
		return false;
	}
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return data.iterator();
	}
}
