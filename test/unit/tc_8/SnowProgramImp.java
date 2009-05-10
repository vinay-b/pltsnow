import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {



public void dbg_afterTERMINATION(){
SnowType  i = new SnowAtom(0);;

i.increment();

if ((i.equals(new SnowAtom(1))).getInt() !=0 ){

snw_print(new SnowAtom("Postfix ++ works\n"));

}

i.decrement();

if ((i.equals(new SnowAtom(0))).getInt() !=0 ){

snw_print(new SnowAtom("Postfix -- works\n"));

}

i.set(new SnowAtom(-2));

if ((i.equals(new SnowAtom(-2))).getInt() !=0 ){

snw_print(new SnowAtom("Unary - works\n"));

}
}


public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp(); 
	this_prog.startProgram();
}

}
