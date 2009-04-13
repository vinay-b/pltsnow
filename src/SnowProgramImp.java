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


protected void moleDef_gene(){
symbols.put("gene",new SnowType(SnowType.NIL));
String mName = "gene";
	symbols.get(mName).addField("num");
}

protected void moleDef_chromosome(){
symbols.put("chromosome",new SnowType(SnowType.NIL));
String mName = "chromosome";
	symbols.get(mName).addField("genes");
}

protected void moleDef_organism(){
symbols.put("organism",new SnowType(SnowType.NIL));
String mName = "organism";
	symbols.get(mName).addField("chromosome");
	symbols.get(mName).addField("fitness");
	symbols.get(mName).addField("name");
}

protected SnowType snw_construct (SnowType organism){

symbols.get("organism").getField("fitness").set(1);
symbols.get("organism").getField("name").set(symbols.get("~organismCount"));

 for(SnowType gene1 : symbols.get("organism").getField("chromosome")){
gene1.getField("num").set(symbols.get("organism").getField("name"));}
return organism;
}

protected void dbg_afterGENERATION(){
snw_print(symbols.get("~generationCount"));
}



}
