import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {


public void dbg_afterTERMINATION(){
SnowType  i = new SnowAtom(1);;
while((i.nequals(new SnowAtom(10))).getInt() != 0){
snw_print(new SnowAtom("While Construct works ").plus(i).plus(new SnowAtom("\n")));
i.increment();

}
}


public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp(); 
	this_prog.startProgram();
}

}
