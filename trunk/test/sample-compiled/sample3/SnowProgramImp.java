import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {


public void set_endGenerations(){
	symbols.put("~endGenerations",new SnowAtom(-1));
}

public void set_endFitness(){
	symbols.put("~endFitness",new SnowAtom(8));
}

public void set_populationSize(){
	symbols.put("~populationSize",new SnowAtom(10));
}


public void moleDef_gene(){
types.put("gene",new SnowAtom(SnowType.NIL));
String mName = "gene";
	types.get(mName).addField("num");
}

public void moleDef_chromosome(){
types.put("chromosome",new SnowAtom(SnowType.NIL));
String mName = "chromosome";
	types.get(mName).addList("genes", 8);
}

public SnowType snw_construct (SnowType newOrganism){
 for(SnowType gene1 : newOrganism.getField("chromosome")){
gene1.getField("num").set(snw_randI(new SnowAtom(0),new SnowAtom(1)));
}
return newOrganism;

}

public SnowType snw_evaluateFitness (SnowType organism){
SnowAtom  curfit = new SnowAtom(null);;
curfit.set((new SnowAtom(100).plus(new SnowAtom(3))));

 for(SnowType gene1 : organism.getField("chromosome")){
curfit.set(curfit.plus(gene1.getField("num")));
}

return curfit;

}

public SnowType snw_mate (SnowType organismA, SnowType organismB, SnowType newOrganism){
newOrganism.getField("chromsome").set(snw_splice(((snw_rand(new SnowAtom(0),new SnowAtom(100))).divide(new SnowAtom(100))),organismA.getField("chromosome"),organismB.getField("chromosome")).clone());
return newOrganism;

}

public void dbg_afterGENERATION(){
snw_print(new SnowAtom("average fitness: ").plus(symbols.get("~averageFitness")));
}


public void dbg_beforeTERMINATION(){
snw_print(symbols.get("~endFitness"));
}



public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp();
	this_prog.startProgram();
}
}
