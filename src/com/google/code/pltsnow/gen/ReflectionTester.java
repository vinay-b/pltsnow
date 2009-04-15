package com.google.code.pltsnow.gen;

import sun.reflect.Reflection;

public class ReflectionTester {

	/**
	 * @param args
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws IllegalArgumentException 
	 */
	
	public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
		TestBase a = new Testa();
		System.out.println(a.getClass().getName());
		//a.astuff = 5;
		a.getClass().getField("astuff").set(a, "5");
		System.out.println(((Testa) a).astuff);
	}

}
