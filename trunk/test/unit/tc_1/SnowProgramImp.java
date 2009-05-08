import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {



public void dbg_afterTERMINATION(){
snw_print(new SnowAtom("Hello Word\n"));
SnowType  i = new SnowAtom(1);;
if ((i.equals(new SnowAtom(1))).getInt() !=0 ){

snw_print(new SnowAtom("If Construct Works\n"));

}

if ((i.equals(new SnowAtom(1))).getInt() !=0 ){

snw_print(new SnowAtom("If-Else Construct Works\n"));

}
else {

snw_print(new SnowAtom("If-Else Construct Works\n"));

}

if ((i.equals(new SnowAtom(1))).getInt() != 0){

snw_print(new SnowAtom("If-Elseif Construct Works\n"));

}
else if ((i.equals(new SnowAtom(3))).getInt() !=0 ){

snw_print(new SnowAtom("If-Elseif Construct Works\n"));

}

if ((i.equals(new SnowAtom(1))).getInt() != 0){

snw_print(new SnowAtom("If-Elsif Construct Works\n"));

}
else if ((i.equals(new SnowAtom(4))).getInt() !=0 ){

snw_print(new SnowAtom("If-Elsif Construct Works\n"));

}

if ((i.equals(new SnowAtom(1))).getInt() != 0){

snw_print(new SnowAtom("If-Elseif-Else Construct Works\n"));

}
else if ((i.equals(new SnowAtom(5))).getInt() !=0 ){

snw_print(new SnowAtom("If-Elseif-Else Construct Works\n"));

}
else {

snw_print(new SnowAtom("If-Elseif-Else Construct Works\n"));

}

if ((i.equals(new SnowAtom(1))).getInt() != 0){

snw_print(new SnowAtom("If-Elsif-Else Construct Works\n"));

}
else if ((i.equals(new SnowAtom(6))).getInt() !=0 ){

snw_print(new SnowAtom("If-Elsif-Else Construct Works\n"));

}
else {

snw_print(new SnowAtom("If-Elsif-Else Construct Works\n"));

}
}



public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp(); 
	this_prog.startProgram();
}

}
