import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {

public void set_endGenerations(){
	symbols.put("~endGenerations",new SnowAtom(800));
}

public void set_endFitness(){
	symbols.put("~endFitness",new SnowAtom(-1));
}

public void set_populationSize(){
	symbols.put("~populationSize",new SnowAtom(100));
}


public void moleDef_gene(){
types.put("gene",new SnowAtom(SnowType.NIL));
String mName = "gene";
	types.get(mName).addField("num");
}

public void moleDef_chromosome(){
types.put("chromosome",new SnowAtom(SnowType.NIL));
String mName = "chromosome";
	types.get(mName).addList("genes", 2);
}

public void moleDef_organism(){
types.put("organism",new SnowAtom(SnowType.NIL));
String mName = "organism";
	types.get(mName).addList("chromosome", 1);
	types.get(mName).addField("fitness");
	types.get(mName).addField("name");
}

public SnowType snw_construct (SnowType newOrganism){
newOrganism.getField("fitness").set(new SnowAtom(1));

newOrganism.getField("name").set(symbols.get("~organismCount").clone());

 for(SnowType gene1 : newOrganism.getField("chromosome")){
gene1.getField("num").set(newOrganism.getField("name").clone());
}
return newOrganism;

}

public void dbg_afterGENERATION(){
snw_print(new SnowAtom("Number of generations: ").plus(symbols.get("~generationCount")));
}



public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp();
	this_prog.startProgram();
}
}
