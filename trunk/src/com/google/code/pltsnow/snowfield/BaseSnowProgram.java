package com.google.code.pltsnow.snowfield;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class BaseSnowProgram {
	private static final int DEFAULT_POPULATION_SIZE   = 100;
	private static final int DEFAULT_TOP_PARENT_POOL   = 10;
	private static final int DEFAULT_BOTTOM_PARENT_POOL = 10;
	private static final int DEFAULT_ORGANISM_LIFESPAN = 30;
	private static final double DEFAULT_MUTATION_RATE  = 0.50;
	private static final String DEFAULT_SELECT_METHOD  = "top_half";
	private static final int DEFAULT_END_GENERATION    = 100;
	private static final float DEFAULT_END_FITNESS     = -1;
	
	protected HashMap<String, SnowType> symbols;
	protected HashMap<String, SnowType> types;
	public BaseSnowProgram() {
		// TODO Auto-generated constructor stub
		initProgram();
		
	}
	protected final void initProgram()
	{
		symbols = new HashMap<String, SnowType>();
		types   = new HashMap<String, SnowType>();	
		
		// TODO: create readonly sybil, suchas '@'
		symbols.put("~maxFitness", new SnowAtom(-1f));
		symbols.put("~minFitness",       SnowAtom.makeNil());
		symbols.put("~avgFitness",       SnowAtom.makeNil());
		symbols.put("~generationCount",  new SnowAtom(new Integer(0)));
		
		set_bottomParentPool();
		set_mutationRate();
		set_organismLifespan();
		set_populationSize();
		set_selectMethod();
		set_topParentPool();
		set_endGenerations();
		set_endFitness();
		
		types.put("organism", SnowList.makeNil());
		//TODO: add default types to the table
		
		//TODO: call all of the defMole_ functions now!
		callAllDefMoles();
		
		dbg_beforeINITIALIZATION();
		initializePopulation();
		dbg_afterINITIALIZATION();
	}
	protected void set_endFitness()
	{
		symbols.put("~endFitness",       new SnowAtom(new Float(DEFAULT_END_FITNESS)));
	}
	protected void set_endGenerations() {
		symbols.put("~endGenerations",    new SnowAtom(new Integer(DEFAULT_END_GENERATION)));
		
	}
	private void callAllDefMoles() {
		try {
			for(Method m : Class.forName("SnowProgramImp").getMethods())
			{

				if(m.getName().contains("moleDef"))
				{
					System.out.println("Invoking " + m.getName());

					try {
						m.invoke(this);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected final void initializePopulation()
	{
		SnowList population = new SnowList();
		
		for (int i = 0; i < (Integer) (symbols.get("~populationSize").get()); i++) 
		{
			SnowType organism = types.get("organism").clone();
			organism = snw_toConstructOrganism(organism);
			population.push(organism);
		}
		
		symbols.put("population", population);
	}
	
	protected final void startProgram()
	{
		while(! terminationMet())
			doSnowLoop();
		
		dbg_beforeTERMINATION();
		dbg_afterTERMINATION();
	}
	
	/**
	 * @return true if termination conditions met
	 * such as maxFitness and generationCount
	 */
	private final boolean terminationMet()
	{
		if (symbols.get("~maxFitness").getFloat() > symbols.get("~endFitness").getFloat() && symbols.get("~endFitness").getFloat() > 0)
			return true;
		if ((Integer)symbols.get("~generationCount").get() > (Integer)symbols.get("~endGenerations").get())
			return true;
		return false;
	}

	protected final SnowAtom snw_rand(SnowType a1, SnowType a2)
	{
		return null;
	}
	protected final SnowAtom snw_randI(Object a1, Object a2)
	{
		return null;
	}
	
	protected final SnowType snw_toConstructOrganism(SnowType organism) 
	{
		// user does this?
		return organism;
	}

	
	protected final void doSnowLoop()
	{
		dbg_beforeGENERATION();
		
		snw_evaluateFitness();
		
		dbg_beforeSELECTION();
		doTheSelection();
		dbg_afterSELECTION();
		
		dbg_beforeMATING();
		doTheMating();
		dbg_afterMATING();
		
		dbg_beforeMUTATION();
		doTheMutating();
		dbg_afterMUTATION();
		
		dbg_afterGENERATION();
		
		//INCREASE THE GENERATION COUNT
		symbols.put("~generationCount", symbols.get("~generationCount").plus(new SnowAtom(1)));
	}
	
	private void doTheMutating() {
		//find the people to mutate, then
		//snw_mutate(null);
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
	
	protected void doTheSelection() {
		// TODO Auto-generated method stub
		
	}
	
	protected void snw_evaluateFitness() {
		//TODO WRITE IT! lol
		symbols.put("~maxFitness", new SnowAtom(100f));
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
	
	protected final SnowType snw_splice(SnowType o1, SnowType o2, SnowType r)
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
	
	protected void dbg_beforeINITIALIZATION(){
		//User Implemented
	}
	
	
	protected void dbg_afterINITIALIZATION(){
		//User Implemented
	}
	
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


