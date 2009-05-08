import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {


public void dbg_afterTERMINATION(){
SnowType  i = new SnowAtom(0);;
SnowType  j = new SnowAtom(1);;

if ((i.equals(new SnowAtom(1)).log_and(j.equals(new SnowAtom(0)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical And works\n"));

}

if ((i.equals(new SnowAtom(1)).log_and(j.equals(new SnowAtom(0)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical And works\n"));

}

if ((i.equals(new SnowAtom(1)).log_or(j.equals(new SnowAtom(0)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical Ot works\n"));

}

if ((i.equals(new SnowAtom(1)).log_or(j.equals(new SnowAtom(0)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical Or works\n"));

}

if (((i.equals(new SnowAtom(1))).log_not()).getInt() !=0 ){

snw_print(new SnowAtom("Logical Not works\n"));

}

if (((i.equals(new SnowAtom(1))).log_not()).getInt() !=0 ){

snw_print(new SnowAtom("Logical Not works\n"));

}
}


public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp(); 
	this_prog.startProgram();
}

}
