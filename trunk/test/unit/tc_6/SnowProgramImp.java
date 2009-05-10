import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {


public void dbg_afterTERMINATION(){
SnowType  i = new SnowAtom(0);;
SnowType  j = new SnowAtom(1);;

if ((i.lt(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Lesser Than works\n"));

}

if ((j.lt(i)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Lesser Than does not work\n"));

}

if ((j.le(new SnowAtom(1))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Lesser Than Equals works\n"));

}

if ((j.le(new SnowAtom(2))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Lesser Than Equals works\n"));

}

if ((j.le(new SnowAtom(0))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Lesser Than Equals does not work\n"));

}

if ((j.gt(i)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than works\n"));

}

if ((i.gt(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than does not work\n"));

}

if ((j.ge(new SnowAtom(1))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than Equals works\n"));

}

if ((j.ge(new SnowAtom(0))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than Equals works\n"));

}

if ((j.ge(new SnowAtom(2))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than Equals does not work\n"));

}

if ((i.equals(new SnowAtom(0))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Equals works\n"));

}

if ((i.equals(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Equals does not work\n"));

}

if ((i.nequals(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Not Equals works\n"));

}

if ((i.nequals(new SnowAtom(0))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Not Equals does not work\n"));

}

i.set(new SnowAtom("a"));
j.set(new SnowAtom("b"));
if ((i.lt(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Lesser Than works\n"));

}

if ((j.lt(i)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Lesser Than does not work\n"));

}

if ((j.le(new SnowAtom("b"))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Lesser Than Equals works\n"));

}

if ((j.le(new SnowAtom("c"))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Lesser Than Equals works\n"));

}

if ((j.le(new SnowAtom("a"))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Lesser Than Equals does not work\n"));

}

if ((j.gt(i)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than works\n"));

}

if ((i.gt(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than does not work\n"));

}

if ((j.ge(new SnowAtom("b"))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than Equals works\n"));

}

if ((j.ge(new SnowAtom("a"))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than Equals works\n"));

}

if ((j.ge(new SnowAtom("c"))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than Equals does not work\n"));

}

if ((i.equals(new SnowAtom("a"))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Equals works\n"));

}

if ((i.equals(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Equals does not work\n"));

}

if ((i.nequals(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Not Equals works\n"));

}

if ((i.nequals(new SnowAtom("a"))).getInt() !=0 ){

snw_print(new SnowAtom("Relation Not Equals does not work\n"));

}

}


public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp(); 
	this_prog.startProgram();
}

}
