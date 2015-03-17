
```
#These two variables define the stopping criteria. You can specify either or both.
#MaxGenerations will limit the number of generations to run for (may not be optimal!)
#MaxFitness will limit to some fitness stopping point.
#If you provide both, then it will stop at whichever comes first.
~MaxGenerations = 800
~MaxFitness     = 28
~topParentPool  = 10%
~mutationRate   = rand(10:50)

#This defines a gene. In this case, the gene just contains 1 atom - "value"
define gene
	num
end

#This defines a chromosome. In this case, a chromosome is composed of 8 genes
define chromosome
	8 genes
end

#This defines an organism and how it is initialized
to construct: organism
   #Set each gene to have a random value from 1-8
   foreach gene in organism.chromosome as gene1
   		gene1.num = rand:0 8
   end
end

to evaluateFitness: organism
        var cur_fit = 28
		var i
		var j
		var gene1
		var gene2
		
		for i from 0 to 6
			# a deep copy. by value
			gene1 = nth(i, organism.chromosome)
			
			for j from 1 to 7
				gene2 = nth(j, organism.chromosome)
				
				# by value comparison.
				if gene1 = gene2
					cur_fit = cur_fit - 1
				end
				
				if ((gene1.num - gene2.num) / (i - j)) = 1
					cur_fit = cur_fit - 1
				end
			end
		end

		organism.fitness = cur_fit
end

to mate: organismA organismB
	#Randomly splice 2 organisms to get the child
	splice at (rand: 0 8) 
end

to mutate chromosome: organismA
   #mutate the organism by randomly changing a gene
   nth( (rand: 0 8), organism.chromosome ) =  rand: 1 8
end

each generation:
  #print the average fitness
  print "average fitness: " + averageFitness

end
```