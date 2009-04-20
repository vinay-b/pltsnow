com.google.code.pltsnow.gen.ParserVal@e24e2a
com.google.code.pltsnow.gen.ParserVal@79c285
null
com.google.code.pltsnow.gen.ParserVal@d1e604
com.google.code.pltsnow.gen.ParserVal@54172f
com.google.code.pltsnow.gen.ParserVal@be2358
com.google.code.pltsnow.gen.ParserVal@27b4d
com.google.code.pltsnow.gen.ParserVal@5eb0a9
com.google.code.pltsnow.gen.ParserVal@a05308
null
com.google.code.pltsnow.gen.ParserVal@ab50cd
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

public void set_topParentPool(){
	symbols.put("~topParentPool",new SnowAtom(0.1));
}

public void set_mutationRate(){
	symbols.put("~mutationRate",(snw_rand(new SnowAtom(1),new SnowAtom(5))).divide(new SnowAtom(10)));
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

public void moleDef_organism(){
types.put("organism",new SnowAtom(SnowType.NIL));
String mName = "organism";
	types.get(mName).addList("chromosome", 1);
}
public SnowType snw_construct (SnowType newOrganism){
	for(SnowType gene1 : newOrganism.getField("chromosome")){
			gene1.getField("num").set(snw_rand(new SnowAtom(0),new SnowAtom(8)));
	}
	return newOrganism;

}

public SnowType snw_evaluateFitness (SnowType checkOrganism){
SnowAtom  curfit = new SnowAtom(null);;
SnowAtom  i = new SnowAtom(null);;

for(i = new SnowAtom(0); i.nequals(new SnowAtom(6));i.plus(new SnowAtom(1))){gene1.set(snw_nth(i,checkOrganism.getField("chromosome")));

for(j = new SnowAtom(1); j.nequals(new SnowAtom(7));j.plus(new SnowAtom(1))){gene2.set(snw_nth(j,checkOrganism.getField("chromosome")));

if (gene1.equals(gene2)){

curfit.set(curfit.minus(new SnowAtom(1)));

}
else if (((gene1.getField("num").minus(gene2.getField("num"))).divide((i.minus(j)))).equals(new SnowAtom(1))){

curfit.set(curfit.minus(new SnowAtom(1)));

}

}
}
return new SnowAtom(28).minus(curfit);

}

public SnowType snw_mate (SnowType organismA, SnowType organismB, SnowType child){
child.getField("chromosome").set(snw_splice((snw_rand(new SnowAtom(0),new SnowAtom(8)))));
return child;

}

public SnowType snw_mutate (SnowType organismA){
snw_nth((snw_rand(new SnowAtom(0),new SnowAtom(8))),symbols.get("organism").getField("chromosome").equals(snw_rand(new SnowAtom(0),new SnowAtom(8))));
return organismA;

}

public void dbg_beforeGENERATION(){
snw_print(new SnowAtom("average fitness: ").plus(averageFitness));
}


public void dbg_afterTERMINATION(){
snw_print(new SnowAtom("The best solution found was:\n"));
 for(SnowType org1 : symbols.get("~population")){
if ((snw_evaluateFitness(org1)).equals(symbols.get("~endFitness"))){

for(SnowAtom i = new SnowAtom(0); i.nequals(new SnowAtom(7));i.plus(new SnowAtom(1))){
	snw_print(new SnowAtom("queen at").plus(i).plus(new SnowAtom(",")).plus((snw_nth(i,org1.getField("gene")))).plus(new SnowAtom("\n")));

}
}
}
}


public static void main(String[] args) {	SnowProgramImp this_prog = new SnowProgramImp(); this_prog.startProgram();}
}
