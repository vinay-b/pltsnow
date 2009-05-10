import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {


public void dbg_afterTERMINATION(){
SnowType  i = new SnowAtom(1);;
SnowType  j = new SnowAtom(0);;

if ((i.equals(new SnowAtom(1)).log_and(j.equals(new SnowAtom(0)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical And works\n"));

}

if ((i.equals(new SnowAtom(0)).log_and(j.equals(new SnowAtom(0)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical And does not work\n"));

}

if ((i.equals(new SnowAtom(1)).log_and(j.equals(new SnowAtom(1)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical And does not work\n"));

}

if ((i.equals(new SnowAtom(0)).log_and(j.equals(new SnowAtom(1)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical And does not work\n"));

}

if ((i.equals(new SnowAtom(1)).log_and(j.equals(new SnowAtom(0)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical And works\n"));

}

if ((i.equals(new SnowAtom(1)).log_or(j.equals(new SnowAtom(0)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical Or works\n"));

}

if ((i.equals(new SnowAtom(1)).log_or(j.equals(new SnowAtom(1)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical Or works\n"));

}

if ((i.equals(new SnowAtom(0)).log_or(j.equals(new SnowAtom(0)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical Or works\n"));

}

if ((i.equals(new SnowAtom(0)).log_or(j.equals(new SnowAtom(1)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical Or does not work\n"));

}

if ((i.equals(new SnowAtom(1)).log_or(j.equals(new SnowAtom(0)))).getInt() !=0 ){

snw_print(new SnowAtom("Logical Or works\n"));

}

if (((i.equals(new SnowAtom(0))).log_not()).getInt() !=0 ){

snw_print(new SnowAtom("Logical Not works\n"));

}

if (((i.equals(new SnowAtom(1))).log_not()).getInt() !=0 ){

snw_print(new SnowAtom("Logical Not does not work\n"));

}

if (((i.equals(new SnowAtom(0))).log_not()).getInt() !=0 ){

snw_print(new SnowAtom("Logical Not works\n"));

}
}


public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp(); 
	this_prog.startProgram();
}

}
