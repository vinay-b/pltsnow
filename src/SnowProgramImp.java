import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {

null
protected void set_endGenerations(){
	symbols.put("~endGenerations",new SnowAtom("-1"));
}

protected void set_endFitness(){
	symbols.put("~endFitness",new SnowAtom("8"));
}

protected void set_populationSize(){
	symbols.put("~populationSize",new SnowAtom("10"));
}




protected void moleDef_gene(){
symbols.put("gene",new SnowAtom(SnowType.NIL));
String mName = "gene";

	symbols.get(mName).addField("num");
}

protected void moleDef_chromosome(){
symbols.put("chromosome",new SnowAtom(SnowType.NIL));
String mName = "chromosome";

	symbols.get(mName).addField("genes");
}

protected SnowType snw_construct (SnowType newOrganism){

 for(SnowType gene1 : newOrganism.getField("chromosome")){

gene1.getField("num").set(snw_randI(0,1));
}
return newOrganism;

}

protected SnowType snw_evaluateFitness (SnowType checkOrganism){
SnowAtom  curfit = new SnowAtom(null);;
curfit.set(100.plus(3));


 for(SnowType gene1 : checkOrganism.getField("chromosome")){
curfit.set(curfit.plus(gene1.getField("num")));
}

return curfit;

}

protected SnowType snw_mate (SnowType organismA, SnowType organismB, SnowType newOrganism){
newOrganism.getField("chromsome").set(snw_splice(snw_rand(0100).divide(100),organismA.getField("chromosome"),organismB.getField("chromosome")).clone());
return newOrganism;

}

protected void dbg_afterGENERATION(){
snw_print("average fitness: ".plus(symbols.get("~averageFitness")));
}


protected void dbg_beforeTERMINATION(){
snw_print(symbols.get("~endFitness"));
}



}
