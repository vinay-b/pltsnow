import com.google.code.pltsnow.snowfield.*;
import com.google.code.pltsnow.gen.*;
import java.util.ArrayList;
public class SnowProgramImp extends BaseSnowProgram {


public void dbg_afterTERMINATION(){
SnowType  i = new SnowAtom(2);;
SnowType  j = new SnowAtom(1);;
SnowType  k = new SnowAtom(2);;

SnowType  val1 = i.plus(j);;
if ((val1.equals(new SnowAtom(3))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic + works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic + does not work\n"));

}

SnowType  val2 = i.minus(j);;
if ((val2.equals(new SnowAtom(1))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic - works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic - does not work\n"));

}

SnowType  val3 = k.times(j);;
if ((val3.equals(new SnowAtom(2))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic * works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic * does not work\n"));

}

SnowType  val4 = k.divide(i);;
if ((val4.equals(new SnowAtom(1))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic / works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic / does not work\n"));

}

SnowType  val5 = j.modulo(i);;
if ((val5.equals(new SnowAtom(1))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic % works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic % does not work\n"));

}

SnowType  val6 = k.power(i);;
if ((val6.equals(new SnowAtom(4))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic ^ works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic ^ does not work\n"));

}

SnowType  a = new SnowAtom(1);;
SnowType  b = new SnowAtom(2);;
SnowType  c = new SnowAtom(3);;

SnowType  val7 = b.power(a).times(c);;
if ((val7.equals(new SnowAtom(6))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic Precedence 1 works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic Precedence 1 does not work\n"));

}

SnowType  val8 = b.power((a.times(c)));;
if ((val8.equals(new SnowAtom(8))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic Precedence 2 works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic Precedence 2 does not work\n"));

}

SnowType  val9a = a.times(b).minus(c);;
SnowType  val9b = a.minus(b.times(c));;
SnowType  val9c = a.times(b).plus(c);;
SnowType  val9d = a.plus(b.times(c));;
SnowType  val9e = b.divide(a).minus(c);;
SnowType  val9f = b.minus(a.divide(c));;
SnowType  val9g = b.divide(a).plus(c);;
SnowType  val9h = b.plus(a.divide(c));;
if ((val9a.equals(new SnowAtom(-1))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic Precedence 3a works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic Precedence 3a does not work\n"));

}

if ((val9b.equals(new SnowAtom(-5))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic Precedence 3b works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic Precedence 3b does not work\n"));

}

if ((val9c.equals(new SnowAtom(5))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic Precedence 3c works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic Precedence 3c does not work\n"));

}

if ((val9d.equals(new SnowAtom(7))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic Precedence 3d works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic Precedence 3d does not work\n"));

}

if ((val9e.equals(new SnowAtom(-1))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic Precedence 3e works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic Precedence 3e does not work\n"));

}

if ((val9f.equals(new SnowAtom(1.6666666666666667))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic Precedence 3f works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic Precedence 3f does not work\n"));

}

if ((val9g.equals(new SnowAtom(5))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic Precedence 3g works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic Precedence 3g does not work\n"));

}

if ((val9h.equals(new SnowAtom(2.3333333333333333))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic Precedence 3h works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic Precedence 3h does not work\n"));

}

SnowType  val10 = b.times((a.minus(c)));;
if ((val10.equals(new SnowAtom(-4))).getInt() !=0 ){

snw_print(new SnowAtom("Arithmetic Precedence 4 works\n"));

}
else {

snw_print(new SnowAtom("Arithmetic Precedence 4 does not work\n"));

}

val1.set(new SnowAtom("i").plus(new SnowAtom("j")));
if ((val1.equals(new SnowAtom("ij"))).getInt() !=0 ){

snw_print(new SnowAtom("String + works\n"));

}
else {

snw_print(new SnowAtom("String + does not work\n"));

}

}


public static void main(String[] args) {
	SnowProgramImp this_prog = new SnowProgramImp(); 
	this_prog.startProgram();
}

}
