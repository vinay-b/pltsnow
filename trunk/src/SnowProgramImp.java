import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {


protected void dbg_afterTERMINATION(){
snw_print("Hello Word\n");
}



public static void main(String[] args) {	SnowProgramImp this_prog = new SnowProgramImp(); this_prog.startProgram();}
}
