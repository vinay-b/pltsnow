import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {


public void dbg_afterTERMINATION(){
SnowType  i = new SnowAtom(1);;
for(i = new SnowAtom(1); !i.hasApproached(new SnowAtom(10),new SnowAtom(1));i.moveTowardsBy(new SnowAtom(10),new SnowAtom(1),new SnowAtom(1))){snw_print(new SnowAtom("For Construct Works ").plus(i).plus(new SnowAtom(" \n")));

}
for(i = new SnowAtom(1); !i.hasApproached(new SnowAtom(10),new SnowAtom(1));i.moveTowardsBy(new SnowAtom(10),new SnowAtom(2),new SnowAtom(1))){snw_print(new SnowAtom("For Construct Works ").plus(i).plus(new SnowAtom(" \n")));

}
for(i = new SnowAtom(10); !i.hasApproached(new SnowAtom(1),new SnowAtom(10));i.moveTowardsBy(new SnowAtom(1),new SnowAtom(1),new SnowAtom(10))){snw_print(new SnowAtom("For Construct Works ").plus(i).plus(new SnowAtom(" \n")));

}
for(i = new SnowAtom(10); !i.hasApproached(new SnowAtom(1),new SnowAtom(10));i.moveTowardsBy(new SnowAtom(1),new SnowAtom(2),new SnowAtom(10))){snw_print(new SnowAtom("For Construct Works ").plus(i).plus(new SnowAtom(" \n")));

}}


public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp(); 
	this_prog.startProgram();
}

}
