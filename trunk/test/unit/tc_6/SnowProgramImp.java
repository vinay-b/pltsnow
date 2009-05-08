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

if ((i.le(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Lesser Than Equals works\n"));

}

if ((i.gt(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than works\n"));

}

if ((i.ge(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Greater Than Equals works\n"));

}

if ((i.equals(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Equals works\n"));

}

if ((i.nequals(j)).getInt() !=0 ){

snw_print(new SnowAtom("Relation Not Equals works\n"));

}
}


public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp(); 
	this_prog.startProgram();
}

}
