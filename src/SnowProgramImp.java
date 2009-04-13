import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {

protected void set_endGenerations(){
	symbols.put("~endGenerations",new SnowType("800"));
}

protected void set_endFitness(){
	symbols.put("~endFitness",new SnowType("-1"));
}

protected void set_populationSize(){
	symbols.put("~populationSize",new SnowType("100"));
}


class gene extends BaseGene{
	public Object num;
}

class chromosome extends BaseChromosome{
	public ArrayList<SnowType> genes;
}

class organism extends BaseOrganism{
	public ArrayList<SnowType> chromosome;
	public Object fitness;
	public Object name;
}

protected SnowType snw_construct (SnowType organism){

organism.fitness=1;
organism.name=symbols.get("~organismCount");

 for(SnowType gene1 : organism.chromosome){
gene1.num=organism.name;}
return organism;
}

protected void dbg_afterGENERATION(){
snw_print(symbols.get("~generationCount"));
}



}
