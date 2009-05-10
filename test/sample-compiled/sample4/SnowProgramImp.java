import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {

public void set_endGenerations(){
	symbols.put("~endGenerations",new SnowAtom(800));
}

public void set_endFitness(){
	symbols.put("~endFitness",new SnowAtom(28));
}

public void set_mutationRate(){
	symbols.put("~mutationRate",(snw_rand(new SnowAtom(1),new SnowAtom(5))).divide(new SnowAtom(10)));
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
gene1.set(snw_rand(new SnowAtom(0),new SnowAtom(8)));
}
return newOrganism;

}

public SnowType snw_evaluateFitness (SnowType checkOrganism){
SnowType  curfit = new SnowAtom(28);;
SnowType  i = SnowAtom.makeNil();SnowType  j = SnowAtom.makeNil();SnowType  gene1 = SnowAtom.makeNil();SnowType  gene2 = SnowAtom.makeNil();;

for(i = new SnowAtom(0); !i.hasApproached(new SnowAtom(7),new SnowAtom(0));i.moveTowardsBy(new SnowAtom(7),new SnowAtom(1),new SnowAtom(0))){gene1.set(snw_nth(checkOrganism.getField("chromosome"),i));

for(j = i.plus(new SnowAtom(1)); !j.hasApproached(new SnowAtom(8),i.plus(new SnowAtom(1)));j.moveTowardsBy(new SnowAtom(8),new SnowAtom(1),i.plus(new SnowAtom(1)))){gene2.set(snw_nth(checkOrganism.getField("chromosome"),j));

if ((gene1.equals(gene2).log_and(i.equals(j))).getInt() != 0){


}
else if ((gene1.equals(gene2)).getInt() != 0){

curfit.set(curfit.minus(new SnowAtom(1)));

}
else if ((((gene1.minus(gene2)).divide((i.minus(j)))).equals(new SnowAtom(1))).getInt() != 0){

curfit.set(curfit.minus(new SnowAtom(1)));

}
else if ((((gene1.minus(gene2)).divide((i.minus(j)))).equals(new SnowAtom(-1))).getInt() !=0 ){

curfit.set(curfit.minus(new SnowAtom(1)));

}

}
}
return curfit;

}

public SnowType snw_mate (SnowType organismA, SnowType organismB, SnowType child){
child.getField("chromosome").set(snw_splice((snw_rand(new SnowAtom(0),new SnowAtom(8))),organismA.getField("chromosome"),organismB.getField("chromosome")).clone());
return child;

}

public SnowType snw_mutate (SnowType organismA){
snw_setNth(organismA.getField("chromosome"),(snw_rand(new SnowAtom(0),new SnowAtom(8))),snw_rand(new SnowAtom(0),new SnowAtom(8)));
return organismA;

}

public void dbg_beforeGENERATION(){
snw_print(new SnowAtom("average fitness: ").plus(symbols.get("~averageFitness")));
}


public void dbg_afterTERMINATION(){
snw_printPopulation();
SnowType  solCount = new SnowAtom(0);;
 for(SnowType org1 : symbols.get("~population")){
if (((snw_evaluateFitness(org1)).equals(symbols.get("~endFitness"))).getInt() !=0 ){

solCount.set(solCount.plus(new SnowAtom(1)));
snw_print(new SnowAtom("Optimal Solution ").plus(solCount).plus(new SnowAtom(" \n")));
snw_print(new SnowAtom("############################ \n"));
SnowType  i = SnowAtom.makeNil();SnowType  row = SnowAtom.makeNil();SnowType  col = SnowAtom.makeNil();;
for(i = new SnowAtom(0); !i.hasApproached(new SnowAtom(8),new SnowAtom(0));i.moveTowardsBy(new SnowAtom(8),new SnowAtom(1),new SnowAtom(0))){row.set(i);
col.set(snw_nth(org1.getField("chromosome"),i));
snw_print(new SnowAtom("queen at (").plus(row).plus(new SnowAtom(" , ")).plus(col).plus(new SnowAtom(")\n")));

}snw_print(new SnowAtom("############################ \n"));

}
}
if ((solCount.equals(new SnowAtom(0))).getInt() !=0 ){

snw_print(new SnowAtom("No optimal solution was found\n"));

}

}


public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp(); 
	this_prog.startProgram();
}

}
