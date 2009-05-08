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
	symbols.put("~populationSize",new SnowAtom(100));
}



public void moleDef_chromosome(){
types.put("chromosome",new SnowAtom(SnowType.NIL));
String mName = "chromosome";
	types.get(mName).addList("gene", 8);
}

public void moleDef_organism(){
types.put("organism",new SnowAtom(SnowType.NIL));
String mName = "organism";
	types.get(mName).addList("chromosome", 1);
}
public SnowType snw_construct (SnowType newOrganism){
 for(SnowType gene1 : newOrganism.getField("chromosome")){
gene1.set(snw_randI(new SnowAtom(0),new SnowAtom(1)));
}
return newOrganism;

}

public SnowType snw_evaluateFitness (SnowType org){
SnowType  curfit = SnowAtom.makeNil();;
curfit.set(new SnowAtom(0));

 for(SnowType gene1 : org.getField("chromosome")){
curfit.set(curfit.plus(gene1));
}

return curfit;

}

public SnowType snw_mate (SnowType organismA, SnowType organismB, SnowType newOrganism){
newOrganism.getField("chromosome").set(snw_splice(((snw_rand(new SnowAtom(0),new SnowAtom(100))).divide(new SnowAtom(100))),organismA.getField("chromosome"),organismB.getField("chromosome")).clone());
return newOrganism;

}

public SnowType snw_mutate (SnowType organismA){
snw_setNth(organismA.getField("chromosome"),(snw_randI(new SnowAtom(0),new SnowAtom(7))),snw_randI(new SnowAtom(0),new SnowAtom(1)));
return organismA;

}

public void dbg_afterGENERATION(){
snw_print(symbols.get("~generationCount").plus(new SnowAtom(",")).plus(symbols.get("~averageFitness")));
}


public void dbg_beforeTERMINATION(){
snw_print(symbols.get("~endFitness"));
}



public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp(); 
	this_prog.startProgram();
}

}
