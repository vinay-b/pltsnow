import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {

protected void set_endGenerations(){
	symbols.put("~endGenerations",new SnowAtom("800"));
}

protected void set_endFitness(){
	symbols.put("~endFitness",new SnowAtom("-1"));
}

protected void set_populationSize(){
	symbols.put("~populationSize",new SnowAtom("100"));
}


protected void moleDef_gene(){
symbols.put("gene",new SnowAtom(SnowType.NIL));
String mName = "gene";
	types.get(mName).addField("num");
}

protected void moleDef_chromosome(){
symbols.put("chromosome",new SnowAtom(SnowType.NIL));
String mName = "chromosome";
	types.get(mName).addList("genes", 2);
}

protected void moleDef_organism(){
symbols.put("organism",new SnowAtom(SnowType.NIL));
String mName = "organism";
	types.get(mName).addList("chromosome", 1);
	types.get(mName).addField("fitness");
	types.get(mName).addField("name");
}

protected SnowType snw_construct (SnowType newOrganism){
newOrganism.getField("fitness").set(1);

newOrganism.getField("name").set(symbols.get("~organismCount").clone());

 for(SnowType gene1 : newOrganism.getField("chromosome")){
gene1.getField("num").set(newOrganism.getField("name").clone());
}
return newOrganism;

}

protected void dbg_afterGENERATION(){
snw_print(symbols.get("~generationCount"));
}



}
