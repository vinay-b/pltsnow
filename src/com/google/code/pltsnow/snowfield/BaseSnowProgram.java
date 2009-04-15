package com.google.code.pltsnow.snowfield;

import java.util.HashMap;
import java.util.List;


public class BaseSnowProgram {
	private static final int DEFAULT_POPULATION_SIZE  = 100;
	private static final int DEFAULT_TOP_PARENT_POOL  = 10;
	private static final int DEFAULT_BOTTOM_PARENT_POOL = 10;
	private static final int DEFAULT_ORGANISM_LIFESPAN = 30;
	private static final double DEFAULT_MUTATION_RATE  = 0.50;
	private static final String DEFAULT_SELECT_METHOD  = "top_half";
	private static final int DEFAULT_END_GENERATION    = 100;
	private static final float DEFAULT_END_FITNESS     = -1;
	
	protected HashMap<String, SnowType> symbols;
	protected HashMap<String, SnowType> types;
	
	protected final void initProgram()
	{
		symbols = new HashMap<String, SnowType>();
		types   = new HashMap<String, SnowType>();	
		
		symbols.put("~populationSize", new SnowAtom(new Integer(DEFAULT_POPULATION_SIZE)));
		symbols.put("~topParentPool", new SnowAtom(new Integer(DEFAULT_TOP_PARENT_POOL)));
		symbols.put("~bottomParentPool", new SnowAtom(new Integer(DEFAULT_BOTTOM_PARENT_POOL)));
		symbols.put("~organismLifespan", new SnowAtom(new Integer(DEFAULT_ORGANISM_LIFESPAN)));
		symbols.put("~mutationRate", new SnowAtom(new Double(DEFAULT_MUTATION_RATE)));
		symbols.put("~selectionMethod", new SnowAtom(new String(DEFAULT_SELECT_METHOD)));
		symbols.put("~maxFitness", SnowAtom.makeNil());
		symbols.put("~minFitness", SnowAtom.makeNil());
		symbols.put("~avgFitness", SnowAtom.makeNil());
		symbols.put("~generationCount", new SnowAtom(new Integer(0)));
		
		//call all of the defMole_ functions now!
		
		initializePopulation();
		while(! terminationMet())
			doSnowLoop();
	}
	
	private final boolean terminationMet()
	{
		return false;
	}
	
	protected final void initializePopulation()
	{
		
	}
	
	protected final SnowAtom snw_randI(Object a1, Object a2)
	{
		return null;
	}
	
	protected final void doSnowLoop()
	{
		snw_evaluateFitness();
		snw_doSelection();
		doTheMating();
		doTheMutating();
	}
	
	private void doTheMutating() {
			//find the people to mutate, then
		snw_mutate(null);
	}
	
	protected void snw_mutate(SnowType object) {
		// TODO Auto-generated method stub
		
	}
	
	private void doTheMating() {
		// TODO Auto-generated method stub
		//find the parents to mate then
		snw_mate(null,null);
	}
	
	protected void snw_mate(SnowType object, SnowType object2) {
		// TODO Auto-generated method stub
		
	}
	
	protected void snw_doSelection() {
		// TODO Auto-generated method stub
		
	}
	
	protected void snw_evaluateFitness() {
		// TODO Auto-generated method stub
		
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
