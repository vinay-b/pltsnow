package com.google.code.pltsnow.snowfield;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import java.util.NoSuchElementException;
import java.util.Random;

//Original author - Jon & Willi
public class BaseSnowProgram {
	private static final int DEFAULT_POPULATION_SIZE   = 100;
	private static final int DEFAULT_TOP_PARENT_POOL   = 10;
	private static final int DEFAULT_BOTTOM_PARENT_POOL = 4;
	private static final int DEFAULT_ORGANISM_LIFESPAN = 3;
	private static final double DEFAULT_MUTATION_RATE  = 0.50;
	private static final String DEFAULT_SELECT_METHOD  = "top_half";
	private static final int DEFAULT_END_GENERATION    = 100;
	private static final float DEFAULT_END_FITNESS     = -1;
	
	protected HashMap<String, SnowType> symbols;
	public static HashMap<String, SnowType> types;
	
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
		
		symbols.put("~maxFitness",       new SnowAtom(-1f));
		symbols.put("~minFitness",       SnowAtom.makeNil());
		symbols.put("~averageFitness",       new SnowAtom(new Integer(0)));
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
			

		types.put("organism", new SnowList(SnowAtom.makeNil()));
		
			
		
		callAllDefMoles();
		
		// add basic fields to organism
		// MUST go after user definition
		SnowType organism = types.get("organism");
		organism.setField("name", SnowAtom.makeNil());
		organism.setField("age", new SnowAtom(new Integer(0)));
		organism.setField("fitness", new SnowAtom(new Integer(0)));
		types.put("organism", organism);
		
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
		int populationSize = (Integer) (symbols.get("~populationSize").get());

		types.get("organism").populateFields();
//		types.get("chromosome").populateFields();
		
		
		SnowType baseChromosome = types.get("chromosome");

		SnowType baseOrganism = types.get("organism");

		for (int i = 0; i < populationSize; i++) 
		{
			SnowType organism = baseOrganism.clone();
			organism          = snw_construct(organism);
			population.push(organism);
			// increment organism count
			Integer currentCount = (Integer)symbols.get("~organismCount").get();
			symbols.put("~organismCount",  new SnowAtom(new Integer(currentCount + 1)));
		}
		
		symbols.put("~population", population);
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
		if (symbols.get("~maxFitness").getFloat() >= symbols.get("~endFitness").getFloat() &&
				symbols.get("~endFitness").getFloat() > 0)
			return true;
		
		// generationCount
		if (symbols.get("~generationCount").getDouble() >= symbols.get("~endGenerations").getDouble() &&
				symbols.get("~endGenerations").getDouble() > 0)
			return true;
		
		return false;
	}

	
	/**
	 * @author willi
	 * @param organism
	 * @return default organism, no extra fields
	 */
	public SnowType snw_construct(SnowType organism) 
	{		
		
		
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

		SnowList population = (SnowList)symbols.get("~population");
		double mutationRate = (Double)symbols.get("~mutationRate").get();
		
		for(SnowType t : population)
		{			
			double rand = Math.random();
			if (rand < mutationRate) {
				dbg_beforeORGANISMMUTATED();
				snw_mutate(t);
				
				dbg_afterORGANISMMUTATED();
			}
		}
		
	}

	
	private void doTheMating() {
		SnowList population = (SnowList)symbols.get("~population");
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
			
			// TODO: these dbg methods should take parameters
			dbg_beforeORGANISMMATESWITHORGANISM();
			SnowType child = snw_mate(o1, o2, types.get("organism").clone());
			// increment organism count
			Integer currentCount = (Integer)symbols.get("~organismCount").get();
			symbols.put("~organismCount",  new SnowAtom(new Integer(currentCount + 1)));
			dbg_afterORGANISMMATESWITHORGANISM();
			
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
		SnowList population      = (SnowList)symbols.get("~population");

		Integer organismLifespan = (Integer) symbols.get("~organismLifespan").get();
		Integer topParentPool    = (Integer) symbols.get("~topParentPool").get();
		Integer bottomParentPool = (Integer) symbols.get("~bottomParentPool").get();
		
		Iterator<SnowType> iterator = population.iterator();

		// unfortunately there need to be two loops here
		// according to the java api, remove() is undefined if
		// the collection changes during iteration.
		while(iterator.hasNext()) 
		{
			SnowType o = iterator.next();
			int age = (Integer)o.getField("age").get();
			o.setField("age", new SnowAtom(new Integer(age + 1)));
		}
		
		iterator = population.iterator();
		while(iterator.hasNext()) 
		{
			SnowType o = iterator.next();
			
			int age = (Integer)o.getField("age").get();
			
			if (age > organismLifespan)
			{
				dbg_beforeORGANISMKILLED();
				iterator.remove();
				dbg_afterORGANISMKILLED();
			}
		}
		
		// anonymous classes FTW!!!
		population.sort(new 
				Comparator<SnowType>() 
				{
					public int compare(SnowType a1, SnowType a2)
					{
						double f1 = a1.getField("fitness").getDouble();
						double f2 = a2.getField("fitness").getDouble();
						if (f1 < f2)
							return -1;
						if (f1 > f2)
							return 1;
						return 0;
					}
				});
		
		SnowList newPopulation = new SnowList();
		
		// take worst candidates
		for (int i = 0; i < bottomParentPool; i++)
		{
			newPopulation.push(population.pop());
		}
		population.reverse();
		
		// take top candidates
		for (int i = 0; i < topParentPool; i++)
		{
			newPopulation.push(population.pop());
		}
		
		// kill off remaining organisms
		while (population.getSize() > 0) {
			// TODO: these should take the dying organism as a parameter?
			try
			{
				dbg_beforeORGANISMKILLED();
				population.pop();
				dbg_afterORGANISMKILLED();
			} catch (NoSuchElementException e)
			{
				// do nothing.
				// iterator.remove() doesnt seem to decrement the size
				// of the population, which means the bounds are overrun 
				// here.
				// ideally this would be fixed elsewhere...
			}
		}
		
		symbols.put("~population", newPopulation);
	}
	
	/**
	 * @author willi
	 * loops through the population applying the fitness method
	 * on each organism
	 */
	protected void doTheFitnessEvaluation() {
		SnowList population  = (SnowList)symbols.get("~population");
		double maxFitness    = symbols.get("~maxFitness").getDouble();
		double minFitness = Double.MAX_VALUE;
		int avgFitness = 0;
		int c = 0;
		for (SnowType o : population) {
			dbg_beforeORGANISMFITNESSCHANGES();
			o.setField("fitness", snw_evaluateFitness(o));
			dbg_afterORGANISMFITNESSCHANGES();
			
			double fitness = o.getField("fitness").getDouble();
			avgFitness += fitness;
			c++;
			if (fitness > maxFitness)
			{
				maxFitness =  fitness;
			}
			if(fitness < minFitness)
			{
				minFitness = fitness;
			}
		}
		if(c > 0)
			avgFitness /= c;
		
		symbols.put("~minFitness", new SnowAtom(new Float(minFitness)));
		symbols.put("~maxFitness", new SnowAtom(new Float(maxFitness)));
		symbols.put("~averageFitness",new SnowAtom(avgFitness));
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
	protected SnowType snw_evaluateFitness(SnowType organism) {
		return new SnowAtom(new Double(0.0));
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
		return snw_construct(child);
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
	
	protected final SnowType snw_first(SnowType list)
	{
		if(list instanceof SnowAtom)
			return list;
		else
			return ((SnowList) list).data.getFirst();
	}
	
	protected final SnowType snw_last(SnowType list)
	{
		if(list instanceof SnowAtom)
			return list;
		else
			return ((SnowList) list).data.getLast();
	}
	
	protected final SnowType snw_max(SnowType list)
	{
		if(list instanceof SnowAtom)
			return list;
		else
		{
			SnowList l = (SnowList) list;
			SnowType r = l.data.getFirst();
			for(SnowType d : l)
			{
				if(d.gt(r) != SnowAtom.FALSE)
				{
					r = d;
				}
			}
			return r;
		}
	}
	
	protected final SnowType snw_min(SnowType list)
	{
		if(list instanceof SnowAtom)
			return list;
		else
		{
			SnowList l = (SnowList) list;
			SnowType r = l.data.getFirst();
			for(SnowType d : l)
			{
				if(d.lt(r) == (SnowAtom.TRUE))
				{
					r = d;
				}
			}
			return r;
		}
	}
	
	protected final SnowType snw_sum(SnowType list)
	{
		if(list instanceof SnowAtom)
			return list;
		else
		{
			SnowList l = (SnowList) list;
			SnowType r = l.data.getFirst();
			for(SnowType d : l)
			{
				if(d != l.data.getFirst())
					r = r.plus(d);
			}
			return r;
		}
	}
	
	protected final SnowType snw_average(SnowType list)
	{
		if(list instanceof SnowAtom)
			return list;
		else
		{
			SnowList l = (SnowList) list;
			SnowType r = l.data.getFirst();
			for(SnowType d : l)
			{
				if(d != l.data.getFirst())
					r = r.plus(d);
			}
			return r.divide(new SnowAtom(l.getSize()));
		}
	}
	
	protected final SnowType snw_append(SnowType list,SnowType a)
	{
		return list.push(a);
	}
	
	protected final SnowType snw_pop(SnowType list)
	{
		return list.pop();
	}
	
	protected final void snw_push(SnowType list, SnowType a)
	{
		list = list.push(a);
	}
	
	protected final SnowType snw_nth(SnowType t, SnowType n)
	{
		SnowList l = (SnowList) t;
		return l.getNth(n.getInt());
	}
	protected final void snw_setNth(SnowType list,SnowType n, SnowType rval)
	{
		SnowList l = (SnowList) list;
		l.setNth((int) n.getDouble(), rval);
	}
	protected final SnowType snw_reverse(SnowType list)
	{
		SnowList r = (SnowList) list.clone();
		r.reverse();
		return r;
	}

	protected final SnowType snw_sort(SnowType list)
	{
		//This is not implemented in snow :(
		throw new UnsupportedOperationException("Sort not implemented :(");
	}
	
	protected final SnowType snw_splice(SnowType ratio, SnowType a1, SnowType a2)
	{
		SnowList c = SnowList.makeNilList(0);
		SnowList p1 = (SnowList) a1;
		SnowList p2 = (SnowList) a2;
		SnowAtom r = (SnowAtom) ratio;

		
//		System.out.println("Splice got:");
//		for (SnowType a : a1)
//			System.out.print(a + " ");
//		System.out.println("");
//		for (SnowType a : a2)
//			System.out.print(a.getField("num") + " ");
//		System.out.println("");
//		System.out.println(r.data);
		if(r.isInt())
		{
			//Intertwine the two at r
			for(int i = 0; i < r.getInt(); i++)
			{
				c.push(p1.get(i).clone());
			}
			for(int j = r.getInt();j<p2.getSize();j++)
			{
				c.push(p2.get(j).clone());
			}
		}
		else if(r.isNumeric())
		{
			//It's r% p1 and (100-r)% p2
			for(int i = 0; i < p1.getSize(); i++)
			{
				Double rate = r.getDouble();
				if(Math.random() > rate)
				{
					c.push(p1.get(i).clone());
				}
				else
				{
					c.push(p2.get(i).clone());
				}
			}
		}
		//c.reverse();
//		System.out.println("0Splice produced:");
//		for (SnowType a : c)
//			System.out.print(a.getField("num") + " ");
//		System.out.println("");
		return c;
	}
	
	//
	//
	//	why all the randoms?
	//
	//
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
		rand = rand * (a2.getFloat() + a1.getFloat());
		rand = rand + a1.getFloat();
		
		if(a1.isInt() && a2.isInt())
			return new SnowAtom(rand.intValue());
		else
			return new SnowAtom(rand);
	}
	
	protected final void snw_printPopulation()
	{
		SnowList population = (SnowList) symbols.get("~population");
		
//		population.sort(new 
//				Comparator<SnowType>() 
//				{
//					public int compare(SnowType a1, SnowType a2)
//					{
//						double f1 = a1.getField("fitness").getDouble();
//						double f2 = a2.getField("fitness").getDouble();
//						//double f1 = snw_evaluateFitness(a1).getDouble();
//						//double f2 = snw_evaluateFitness(a2).getDouble();
//						if (f1 < f2)
//						{	
//							return -1;
//						}
//						if (f1 > f2)
//						{
//							return 1;
//						}
//						else
//						{	
//							return 0;
//						}
//					}
//				});
		

		for(SnowType t : population)
		{
			snw_printOrganism(t);
		}
	}
	
	protected final void snw_printOrganism(SnowType o)
	{
		String r = "Org: ";
		SnowList genes = (SnowList) o.getField("chromosome");
		for(SnowType g : genes)
		{
			r+=g.get() + " ";
		}
		r+=" f "+snw_evaluateFitness(o);
		snw_print(r);
	}
	
	/**
	 * @param a1 Low val
	 * @param a2 High val
	 * @return Random # between a1 and a2, inclusive on both sides of range.
	 */
	protected final SnowAtom snw_randI(SnowType a1, SnowType a2)
	{
		Double rand = Math.random();
		rand = rand * (1 + a1.getFloat() + a2.getFloat());
		rand = rand + a1.getFloat();
		
		if(a1.isInt())
			return new SnowAtom(Math.floor(rand));
		else
			return new SnowAtom(rand);
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


