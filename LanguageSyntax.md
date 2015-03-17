# Introduction #

Example program/snippets demonstrating functionality

# Keywords #
## Predefined Events ##
Actions can be provided to zero, many, or all of these predefined event hooks.

> each _EVENT_ {IMPLICIT PARAMETER}

> each _generation_ occurs as an entire iteration happens

> each _mutation_ occurs at the mutation stage

> each _mating_ occurs at the mating stage

> each _selection_ occurs at the selection stage

> each _organismConstructed_ {organism} occurs as a single organism is created.  Initial creation-inclusive.

> each _organismKilled_ {organism} occurs as a single organism is removed from the population.

> each _organismMutated_ {organism} occurs as a single organism is randomly mutated.

> each _organismMatesWithOrganism_ {organismA organismB} occurs when two organisms recombine to construct a new organism.

> each _childBorn_ {organism} occurs as a single organism is created through mating. Initial creation-exclusive.

> each _organismFitnessChanges_ {organism} occurs as the fitness of an organism changes.

> each _termination_ occurs as the program reaches the termination conditions.

**Example:**
```
each organism killed:
   print "killing " . organism.fitness
```

## Event Modifiers ##
Defines at relative to an event the execution of an action.

> _before_ hooks action to pre-event

> _after_ **default** hooks action to post-event

**Example:**
```
before each selection:
  print "before selection, current population size: " . populationSize

after each selection:
  print "after selection, current population size: " . populationSize
```


## Environmental Parameters ##
Parameters are set by the programmer and modify the behavior of the population.
Global parameters that should be re-evaluated `each generation`.
Read-only accessible at all points of the simulation flow.

> _populationSize_ defines the total population after mating.

> _topParentPool_ defines the elite subset from which to mate.

> _bottomParentPool_ defines the highly suboptimal subset from which to mate, to improve genetic differentiation.

> _organismLifespan_ defines the lifespan of a single organism.

> _mutationRate_ defines the probability of mutation on a per-organism basis.

> _selectMethod_

**Termination Conditions**

> _maxGenerations_

> _maxFitness_

**Example:**
```
each generation:
  populationSize *=  1.05
```


## Environmental Variables ##
Variables describe the current state of the environment.
Environmental variables are re-evaluated by the compiler at `each generation`.
Read-only accessible at all points of the simulation flow.

> PARAMETER {TYPE}

> _averageFitness_ {value} describes the average fitness of the population.

> _averageAge_ {value} describes the average age of the population.

> _maxFitness_ {organism} describes the top organism in the current population.

> _minFitness_ {organism} describes the bottom organism in the current population.

> _oldest_ {organism} describes the oldest organism in the current population.

> _maxFitnessAllTime_ {organism} describes  the top organism ever encountered.

> _minFitnessAllTime_ {organism} describes the bottom organism ever encountered.

**Example:**
```
each generation:
  print "best solution thus far: " . maxFitnessAllTime
```


## Functions/Operators ##

> _to ACTION NAME_ defines a new subroutine/function. I have no idea how parameters are passed. Closures?
ACTION NAME should be a camelCased single world.  How is an action called?

**example**
```
to printTopSolution:
  print "best solution thus far: " . maxFitnessAllTime

each generation:
  printTopSolution
```

> _define_



### List operators ###
```
first()
last()
max()
min() 
sum()
average() 
append()
extend()
pop() 
push() 
index() 
for..in..
reverse() 
filter() 
search() 
sort()
```

### Chromosome Operators ###
`splice [at \d[%] [and \d]]`  on two implicit chromosomes

**example**
```
to mate:
  splice at 5 and 15
```

### Required Actions ###
> _to construct_ {chromosome} should create a new, initial chromosome. Often random.

> _to mate_ {chromosomeA chromosomeB} should define how to recombine chromosomes to form a new chromosome.

> _to mutate_ {chromosomeA chromosomeB} should define how to recombine a chromosome with a newly-constructed chromosome, yielding a mutated chromosome.

> _to getFitness_ {chromosome} should define the calculation of fitness for a chromosome.

# Other thoughts #
To be included if we have time:
  * Provide a built in function for iterating over all pairs of items in a list