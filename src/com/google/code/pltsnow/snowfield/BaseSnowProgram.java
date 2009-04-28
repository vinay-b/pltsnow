package com.google.code.pltsnow.snowfield;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


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
		initProgram();
	}
	
	/**
	 * fill symbol tables with default values
	 * define all molecules
	 * initialize population
	 *
	 */
	protected final void initProgram()
	{
		symbols = new HashMap<String, SnowType>();
		types   = new HashMap<String, SnowType>();	
		
		// TODO: create readonly sybil, such as '@'
		symbols.put("~maxFitness",       new SnowAtom(-1f));
		symbols.put("~minFitness",       SnowAtom.makeNil());
		symbols.put("~avgFitness",       SnowAtom.makeNil());
		symbols.put("~generationCount",  new SnowAtom(new Integer(0)));
		// total number of organisms constructed thus far
		symbols.put("~organismCount",    new SnowAtom(new Integer(0)));
		
		
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
	

	/**
	 * define all molecule types
	 *
	 */
	private void callAllDefMoles() {
		try {
			for(Method m : Class.forName("SnowProgramImp").getMethods())
			{

				if(m.getName().contains("moleDef"))
				{
					try {
						m.invoke(this);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * fill the population with ~populationSize organisms
	 * add population to the symbol table
	 *
	 *@author willi
	 */
	protected final void initializePopulation()
	{
		SnowList population = new SnowList();
		
		for (int i = 0; i < (Integer) (symbols.get("~populationSize").get()); i++) 
		{
			SnowType organism = types.get("organism").clone();
			organism          = snw_toConstructOrganism(organism);
			population.push(organism);
		}
		
		symbols.put("population", population);
	}
	
	
	/**
	 * top level run loop
	 * @author willi
	 *
	 */
	protected final void startProgram()
	{
		while(! terminationMet())
			doSnowLoop();
		
		// currently there is not real difference between the two...
		// cept one goes before the other?
		dbg_beforeTERMINATION();
		dbg_afterTERMINATION();
	}
	
	/**
	 * @return true if termination conditions met
	 * such as maxFitness and generationCount
	 */
	private final boolean terminationMet()
	{
		// maxFitness > endFitness > 0
		if (symbols.get("~maxFitness").getFloat() > symbols.get("~endFitness").getFloat() &&
				symbols.get("~endFitness").getFloat() > 0)
			return true;
		
		// generationCount
		if (symbols.get("~generationCount").getFloat() > symbols.get("~endGenerations").getFloat() &&
				symbols.get("~endGenerations").getFloat() > 0)
			return true;
		
		return false;
	}

	
	/**
	 * @author willi
	 * @param organism
	 * @return default organism, no extra fields
	 */
	protected final SnowType snw_toConstructOrganism(SnowType organism) 
	{		
		// increment organism count
		Integer currentCount = (Integer)symbols.get("~organismCount").get();
		symbols.put("~organismCount",  new SnowAtom(new Integer(currentCount + 1)));
		
		// basic fields: name, age, fitness
		organism.setField("name", SnowAtom.makeNil());
		organism.setField("age", new SnowAtom(new Integer(0)));
		organism.setField("fitness", new SnowAtom(new Integer(0)));
		
		return organism;
	}

	/**
	 * generic run loop
	 * @author willi
	 *
	 */
	protected final void doSnowLoop()
	{
		dbg_beforeGENERATION();
		
		
		doTheFitnessEvaluation();
		
		
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
		
		//TODO: age
		
		//INCREASE THE GENERATION COUNT
		try {
			symbols.put("~generationCount", symbols.get("~generationCount").plus(new SnowAtom(1)));
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * mutates ~mutationRate of the population
	 * @author willi
	 */
	private void doTheMutating() {

		SnowList population = (SnowList)symbols.get("population");
		float mutationRate = symbols.get("~mutationRate").getFloat();
		
		for (SnowType o : population) {
			double rand = Math.random();
			if (rand < mutationRate) {
				dbg_beforeORGANISMMUTATED();
				// o is mutated by reference
				snw_mutate(o);
				dbg_afterORGANISMMUTATED();
			}
		}
	}

	
	private void doTheMating() {

		SnowList population = (SnowList)symbols.get("population");
		Integer populationSize = (Integer)symbols.get("~populationSize").get();
		
		// children should be stored separate from adults until after mating
		SnowList children = new SnowList();
		
		Random rand = new Random();
		
		// mate until reaching population capacity
		while (population.getSize() + children.getSize() < populationSize)
		{
			int r = rand.nextInt(population.getSize());
			SnowType o1 = population.get(r);
			r = rand.nextInt(population.getSize());
			SnowType o2 = population.get(r);
			
			// TODO: these methods should take parameters
			dbg_beforeORGANISMMATESWITHORGANISM();
			SnowType child = snw_mate(o1, o2, types.get("organism").clone());
			dbg_afterORGANISMMATESWITHORGANISM();
			
			// TODO: should there be a constructed hook here?
			children.push(child);
		}
		
		// add children to adult population
		population.addAll(children);
	}
	

	/**
	 * @author willi
	 * takes the top and bottom pools, forms a new population
	 * and kills the rest
	 */
	protected void doTheSelection() {
		SnowList population      = (SnowList)symbols.get("population");
		Integer organismLifespan = (Integer) symbols.get("~organismLifespan").get();
		Integer topParentPool    = (Integer) symbols.get("~topParentPool").get();
		Integer bottomParentPool = (Integer) symbols.get("~bottomParentPool").get();
		
		Iterator<SnowType> iterator = population.iterator();
		
		// remove age'd organisms
		while(iterator.hasNext()) {
			SnowType o = iterator.next();
			// all this casting seems a bit dangerous...
			if ((Integer)o.getField("age").get() > organismLifespan)
				iterator.remove();
		}
		
		// anonymous classes FTW!!!
		population.sort(new 
				Comparator<SnowType>() 
				{
					public int compare(SnowType a1, SnowType a2)
					{
						float f1 = a1.getField("fitness").getFloat();
						float f2 = a2.getField("fitness").getFloat();
						if (f1 < f2)
							return -1;
						if (f2 > f2)
							return 1;
						return 0;
					}
				});
		
		SnowList newPopulation = new SnowList();
		
		// take worst candidates
		for (int i = 0; i < bottomParentPool; i++)
			newPopulation.push(population.pop());
		
		population.reverse();
		
		// take top candidates
		for (int i = 0; i < topParentPool; i++)
			newPopulation.push(population.pop());
		
		// kill off remaining organisms
		while (population.getSize() > 0) {
			// TODO: these should take the dying organism as a parameter?
			dbg_beforeORGANISMKILLED();
			population.pop();
			dbg_afterORGANISMKILLED();
		}
		
		symbols.put("population", newPopulation);
	}
	
	/**
	 * @author willi
	 * loops through the population applying the fitness method
	 * on each organism
	 */
	protected void doTheFitnessEvaluation() {
		SnowList population = (SnowList)symbols.get("population");
		float maxFitness    = symbols.get("~maxFitness").getFloat();
		for (SnowType o : population) {
			dbg_beforeORGANISMFITNESSCHANGES();
			snw_evaluateFitness(o);
			dbg_afterORGANISMFITNESSCHANGES();
			float fitness = o.getField("fitness").getFloat();
			if (fitness > maxFitness)
				maxFitness =  fitness;
		}
		
		symbols.put("~maxFitness", new SnowAtom(new Float(maxFitness)));
	}
	

	
	//
	//
	//
	//
	//
	//	override-able methods
	//
	//
	//
	//
	//
	
	/**
	 * @author willi
	 * default sets fitness to 0
	 */
	protected void snw_evaluateFitness(SnowType organism) {
		organism.setField("fitness", new SnowAtom(new Float(0.0)));
		return;
	}
	
	/**
	 * this must either return a new organism and mutate the
	 * reference passed in
	 * 
	 * @param parent 1
	 * @param parent 2
	 * @param child reference to work with
	 * @return a new organism
	 */
	protected SnowType snw_mate(SnowType parent1, SnowType parent2, SnowType child) {
		return snw_toConstructOrganism(child);
	}
	
	
	/**
	 * this should not return anything useful
	 * it should mutate the object directly
	 * 
	 * default doesnt do anything
	 * 
	 * @param organism to mutate by reference
	 * @return the organism
	 */
	protected SnowType snw_mutate(SnowType object) {
		return object;
	}
	
	
	
	//
	//
	//
	//
	//
	//	snow datatype operators
	//
	//
	//
	//
	//
	
	protected final void snw_print(Object arg)
	{
		System.out.println(arg.toString());
	}
	
	protected final SnowType first(SnowType list)
	{
		//TODO
		return null;
	}
	
	protected final SnowType last(SnowType list)
	{
		//TODO
		return null;
	}
	
	protected final SnowType max(SnowType list)
	{
		//TODO
		return null;
	}
	
	protected final SnowType min(SnowType list)
	{
		//TODO
		return null;
	}
	
	protected final SnowType sum(SnowType list)
	{
		//TODO
		return null;
	}
	
	protected final SnowType average(SnowType list)
	{
		//TODO
		return null;
	}
	
	protected final SnowType append(SnowType list,SnowType a)
	{
		//TODO
		return null;
	}
	
	protected final SnowType pop(SnowType list)
	{
		//TODO
		return null;
	}
	
	protected final void push(SnowType list, SnowType a)
	{
		//TODO
	}
	
	protected final SnowType snw_nth(SnowType t, SnowType n)
	{
		//TODO
		return null;
	}
	protected final void snw_setNth(SnowType list,SnowType n, SnowType rval)
	{
		//TODO
	}
	protected final SnowType snw_reverse(SnowType list)
	{
		//TODO
		return null;
	}
	
	protected final int snw_search(SnowType list, SnowType s)
	{
		//TODO
		return 0;
	}
	
	protected final SnowType snw_sort(SnowType list)
	{
		return null;
	}
	
	protected final SnowType snw_splice(SnowType o1, SnowType o2, SnowType r)
	{
		return null;
	}
	
	//
	//
	//	why all the randoms?
	//
	//
	
	
	protected final double snw_rand(SnowType a1, SnowType a2, SnowType o3)
	{
		//TODO - implement. also check the args, i think this is missing some
		return 0;
	}
	

	/**
	 * 
	 * @param a1 contains float
	 * @param a2 contains float
	 * @return SnowAtom containing a float in range a1 to a2
	 * @author willi
	 */
	protected final SnowAtom snw_rand(SnowType a1, SnowType a2)
	{
		
		Double rand = Math.random();
		rand = rand * a2.getFloat();
		rand = rand / a1.getFloat();
		rand = rand + a1.getFloat();
		// rand is now in range a1 - a2 ?
		
		return new SnowAtom(rand);
	}
	
	/**
	 * from willi: i dont remember the difference between rand and randI
	 * sorry :-/
	 * @param a1
	 * @param a2
	 * @return
	 */
	protected final SnowAtom snw_randI(Object a1, Object a2)
	{
		return null;
	}
	
	//
	//
	//
	//
	//	default initializers
	//
	//
	//
	//
	
	
	protected void set_endFitness()
	{
		symbols.put("~endFitness",       new SnowAtom(new Float(DEFAULT_END_FITNESS)));
	}
	
	protected void set_endGenerations() {
		symbols.put("~endGenerations",    new SnowAtom(new Integer(DEFAULT_END_GENERATION)));
	}
	
	
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
	
	
	//
	//
	//
	//
	//
	//These are all of the stub definitions for the debug hooks
	//
	//
	//
	//
	//
	
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

	/**
	 * does not necessarily have to change
	 * just be evaluated?
	 *
	 */
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

	/**
	 * does not necessarily have to change
	 * just be evaluated?
	 *
	 */
	protected void dbg_afterORGANISMFITNESSCHANGES(){
		//User Implemented
	}
}


