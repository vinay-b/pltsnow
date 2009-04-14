package com.google.code.pltsnow.snowfield;

import java.util.HashMap;
import java.util.List;


public class BaseSnowProgram {
	private static final int DEFAULT_POPULATION_SIZE = 100;
	private static final int DEFAULT_TOP_PARENT_POOL = 10;
	private static final int DEFAULT_BOTTOM_PARENT_POOL = 10;
	private static final int DEFAULT_ORGANISM_LIFESPAN = 30;
	private static final double DEFAULT_MUTATION_RATE = 0.50;
	private static final String DEFAULT_SELECT_METHOD = "top_half";
	
	protected HashMap<String, SnowType> symbols;
	protected final void initProgram()
	{
		symbols = new HashMap<String, SnowType>();
		
	}
	protected final SnowAtom snw_randI(Object a1, Object a2)
	{
		return null;
	}
	protected final void doSnowLoop()
	{
		
	}
	protected final void snw_print(Object arg)
	{
		System.out.println(arg.toString());
	}
	protected final SnowType first(List<SnowType> list)
	{
		//TODO
		return null;
	}
	protected final SnowType last(List<SnowType> list)
	{
		//TODO
		return null;
	}
	protected final SnowType max(List<SnowType> list)
	{
		//TODO
		return null;
	}
	protected final SnowType min(List<SnowType> list)
	{
		//TODO
		return null;
	}
	protected final SnowType sum(List<SnowType> list)
	{
		//TODO
		return null;
	}
	protected final SnowType average(List<SnowType> list)
	{
		//TODO
		return null;
	}
	protected final List<SnowType> append(List<SnowType> list,SnowType a)
	{
		//TODO
		return null;
	}
	protected final SnowType pop(List<SnowType> list)
	{
		//TODO
		return null;
	}
	protected final void push(List<SnowType> list, SnowType a)
	{
		//TODO
	}
	protected final SnowType nth(List<SnowType> list, int n)
	{
		//TODO
		return null;
	}
	protected final List<SnowType> reverse(List<SnowType> list)
	{
		//TODO
		return null;
	}
	protected final int search(List<SnowType> list, SnowType s)
	{
		//TODO
		return 0;
	}
	protected final List<SnowType> sort(List<SnowType> list)
	{
		return null;
	}
	protected final SnowType splice(SnowType o1, SnowType o2, SnowType r)
	{
		return null;
	}
	protected final double rand(SnowType a1, SnowType a2, SnowType o3)
	{
		//TODO - implement. also check the args, i think this is missing some
		return 0;
	}
	//these are default initializers
	protected void set_populationSize()
	{
		symbols.put("~populationSize", new SnowAtom(DEFAULT_POPULATION_SIZE));
	}
	protected void set_topParentPool()
	{
		symbols.put("~topParentPool", new SnowAtom(DEFAULT_TOP_PARENT_POOL));
	}
	protected void set_bottomParentPool()
	{
		symbols.put("~bottomParentPool", new SnowAtom(DEFAULT_BOTTOM_PARENT_POOL));
	}
	protected void set_organismLifespan()
	{
		symbols.put("~organismLifespan", new SnowAtom(DEFAULT_ORGANISM_LIFESPAN));
	}
	protected void set_mutationRate()
	{
		symbols.put("~mutationRate", new SnowAtom(DEFAULT_MUTATION_RATE));
	}
	protected void set_selectMethod()
	{
		symbols.put("~selectMethod", new SnowAtom(DEFAULT_SELECT_METHOD));
	}
	
	//These are all of the stub definitions for the debug hooks
	
	protected void dbg_beforeGENERATION(){
		//User Implemented
	}

	protected void dbg_beforeTERMINATION(){
		//User Implemented
	}

	protected void dbg_beforeMUTATION(){
		//User Implemented
	}

	protected void dbg_beforeMATING(){
		//User Implemented
	}

	protected void dbg_beforeSELECTION(){
		//User Implemented
	}

	protected void dbg_beforeORGANISMCONSTRUCTED(){
		//User Implemented
	}

	protected void dbg_beforeORGANISMKILLED(){
		//User Implemented
	}

	protected void dbg_beforeORGANISMMUTATED(){
		//User Implemented
	}

	protected void dbg_beforeORGANISMMATESWITHORGANISM(){
		//User Implemented
	}

	protected void dbg_beforeCHILDBORN(){
		//User Implemented
	}

	protected void dbg_beforeORGANISMFITNESSCHANGES(){
		//User Implemented
	}
	protected void dbg_afterGENERATION(){
		//User Implemented
	}

	protected void dbg_afterTERMINATION(){
		//User Implemented
	}

	protected void dbg_afterMUTATION(){
		//User Implemented
	}

	protected void dbg_afterMATING(){
		//User Implemented
	}

	protected void dbg_afterSELECTION(){
		//User Implemented
	}

	protected void dbg_afterORGANISMCONSTRUCTED(){
		//User Implemented
	}

	protected void dbg_afterORGANISMKILLED(){
		//User Implemented
	}

	protected void dbg_afterORGANISMMUTATED(){
		//User Implemented
	}

	protected void dbg_afterORGANISMMATESWITHORGANISM(){
		//User Implemented
	}

	protected void dbg_afterCHILDBORN(){
		//User Implemented
	}

	protected void dbg_afterORGANISMFITNESSCHANGES(){
		//User Implemented
	}

}
