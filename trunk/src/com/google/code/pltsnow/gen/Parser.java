//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";



package com.google.code.pltsnow.gen;



//#line 2 "snow.y"
import java.lang.Math;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
//#line 22 "Parser.java"




public class Parser
             extends BaseSnowParser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short TO=257;
public final static short FOR=258;
public final static short FOREACH=259;
public final static short WHILE=260;
public final static short RETURN=261;
public final static short DO=262;
public final static short END=263;
public final static short DEFINE=264;
public final static short VAR=265;
public final static short IF=266;
public final static short THEN=267;
public final static short ELSE=268;
public final static short ELSIF=269;
public final static short FROM=270;
public final static short AS=271;
public final static short BY=272;
public final static short BEFORE=273;
public final static short AFTER=274;
public final static short EACH=275;
public final static short IN=276;
public final static short PLUSPLUS=277;
public final static short MINUSMINUS=278;
public final static short PLUS=279;
public final static short MINUS=280;
public final static short MUL=281;
public final static short DIV=282;
public final static short MODULO=283;
public final static short POWER=284;
public final static short LIST_OP_PUSH=285;
public final static short LIST_OP_POP=286;
public final static short REL_OP_LE=287;
public final static short REL_OP_GE=288;
public final static short REL_OP_LT=289;
public final static short REL_OP_GT=290;
public final static short REL_OP_NE=291;
public final static short EQUALS=292;
public final static short LOG_OP_AND=293;
public final static short LOG_OP_OR=294;
public final static short LOG_OP_NOT=295;
public final static short LPAREN=296;
public final static short RPAREN=297;
public final static short COLON=298;
public final static short COMMA=299;
public final static short DOT=300;
public final static short TRUE=301;
public final static short FALSE=302;
public final static short NIL=303;
public final static short NEWLINE=304;
public final static short SPACE=305;
public final static short EVENT_NAME_IDENTIFIER=306;
public final static short RESERVED_IDENTIFIER=307;
public final static short IDENTIFIER=308;
public final static short SYS_IDENTIFIER=309;
public final static short STRING=310;
public final static short NUMERIC=311;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    2,    2,    2,    2,    2,    2,    7,
    9,    9,   10,   10,   11,   11,   11,   11,   12,   12,
   13,   13,   13,   13,   14,   14,   15,   15,   16,   16,
   16,   16,   17,   18,   18,   19,   20,   20,   20,   21,
   21,   21,   22,   22,   22,   22,   23,   23,   24,   24,
   24,   24,   24,   25,   25,   25,   26,   26,   27,   27,
   28,   29,   29,   29,   29,   29,   29,   34,   34,   33,
   30,    8,    8,   35,   31,   36,   36,   36,   32,   32,
   32,   39,   39,   38,   38,   40,   40,   37,   37,    6,
   41,   41,    3,   42,   42,    4,   43,   43,   44,   44,
    5,   45,   45,   46,   46,   46,   46,
};
final static short yylen[] = {                            2,
    1,    1,    2,    1,    1,    1,    1,    1,    1,    3,
    1,    1,    1,    0,    5,    5,    5,    3,    3,    1,
    1,    1,    1,    3,    1,    1,    3,    1,    1,    2,
    2,    1,    3,    3,    0,    1,    1,    2,    2,    1,
    3,    3,    3,    3,    3,    1,    1,    3,    1,    3,
    3,    3,    3,    1,    3,    3,    1,    3,    1,    3,
    3,    2,    2,    2,    2,    2,    1,    1,    2,    1,
    1,    1,    3,    1,    3,    3,    5,    5,    5,   10,
    8,    2,    0,    2,    0,    4,    0,    2,    0,    6,
    1,    1,    8,    3,    0,    2,    1,    3,    1,    3,
    6,    1,    2,    3,    2,    2,    1,
};
final static short yydefred[] = {                         0,
    0,    0,    0,   91,   92,    9,    0,    0,    0,    2,
    4,    5,    6,    7,    8,    0,    0,    0,    0,    0,
   97,    0,    3,    0,   35,    0,    0,    0,    0,    0,
    0,    0,   26,   12,   11,   10,   21,   22,   29,   23,
    0,    0,   32,   47,    0,    0,    0,    0,    0,    0,
    0,   72,    0,    0,    0,  100,   98,    0,   38,   39,
    0,    0,    0,   35,    0,   30,   31,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   13,    0,    0,    0,  107,   28,    0,    0,
    0,    0,  102,    0,   24,    0,   18,    0,    0,   27,
    0,    0,    0,    0,    0,   48,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   67,    0,
   71,    0,   70,   68,    0,    0,    0,    0,    0,    0,
   36,   34,    0,    0,  106,  105,  101,  103,   24,    0,
    0,    0,   19,    0,    0,    0,    0,    0,   65,    0,
   62,   63,   64,   66,   90,   69,    0,    0,  104,   15,
   16,   17,    0,    0,    0,    0,    0,   75,   61,    0,
   93,    0,   84,    0,    0,    0,    0,   94,    0,   82,
    0,    0,   79,    0,    0,    0,    0,    0,    0,   78,
    0,    0,    0,    0,   88,    0,   86,   81,    0,   80,
};
final static short yydgoto[] = {                          8,
    9,   10,   11,  120,   13,   14,   15,  121,   37,   85,
   38,   63,   39,   40,   41,   42,   43,   54,  132,   44,
   45,   46,   47,   48,   49,   50,   51,  123,  124,  125,
  126,  127,  128,  129,   52,  148,  192,  165,  175,  182,
   16,  158,   20,   21,   92,   93,
};
final static short yysindex[] = {                      -243,
 -281, -271, -260,    0,    0,    0, -230,    0, -243,    0,
    0,    0,    0,    0,    0, -239, -229, -226, -218, -222,
    0, -210,    0, -207,    0, -192, -210, -260, -119, -119,
 -210, -204,    0,    0,    0,    0,    0,    0,    0,    0,
 -182, -190,    0,    0, -171, -199, -163,  -76, -175, -169,
 -160,    0, -166, -254,  250,    0,    0, -210,    0,    0,
 -153, -147, -253,    0, -154,    0,    0, -119, -119, -119,
 -119, -119, -119, -119, -119, -119, -119, -119, -119, -119,
 -119, 1280,    0, 1280, -210, -184,    0,    0, -150, -144,
 -142, -257,    0, -125,    0, -278,    0, -184, -147,    0,
 -199, -199, -163, -163, -163,    0, -171, -171, -171, -171,
  -76,  -76, -175, -169, -176, -176, -210, -210,    0, -136,
    0, -266,    0,    0, -131, -130, -126, -121, -110,  -56,
    0,    0, -147, -120,    0,    0,    0,    0,    0, -109,
 -102, -101,    0,  -83,  -79,  -98,  -59,  -48,    0, -210,
    0,    0,    0,    0,    0,    0, -210,  -38,    0,    0,
    0,    0, -210, -176,  -64, 1280, 1280,    0,    0,  -70,
    0,  -20,    0, -176,  -32, 1198, -129,    0, -210,    0,
 -210,  -57,    0, 1280, -210,  -21,   -1, 1280, 1280,    0,
 -210,  -47, -210, 1223,    0, 1280,    0,    0, 1257,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,  259,    0,
    0,    0,    0,    0,    0,    0,    0,    0, 1176, 1195,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   49,    0,    0,    0,    0,    0,    0,    0,    0,
    1,  491,    0,    0,  539,  895,   97, 1039,  597,  145,
  193,    0,    0, 1233,    0,    0,    0,    0,    0,    0,
    0,  -61, -168,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  241,    0,
  943,  991,  299,  347,  395,    0,  645,  693,  741,  789,
 1087, 1135,  837,  443,    0,    0,    0,    0,    0,    0,
    0, 1315,    0,    0,    0,    0,    0,    0,    0,   -3,
    0,    0, -268,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0, -251,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0, -247,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -43,    0,    4,    0,    0,    0,
    0,    0,    0,    0,    0,  -42,    0,    0,    6,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  254,    0,   15,    0,    0,    0,  -22,  -18,  -60,
  -17,    0,    0,  -51,  -74,    0,    0,  200,    0,  -13,
  169,   78,   34,   86,  190,  195,    0,    0, -118,    0,
    0,    0,    0,  -77,    0,  101,    0,    0,    0,    0,
    0,    0,    0,  273,    0,  210,
};
final static int YYTABLESIZE=1619;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         36,
   25,   96,   98,   91,   56,  137,  130,  122,   61,  122,
  156,  156,   62,    1,   12,   59,   60,   86,   85,   85,
    2,    3,   83,   12,  140,  150,   17,   14,   20,    4,
    5,   34,   35,   65,   14,   94,   18,   90,   86,   62,
   91,   14,   14,   97,   83,   83,   87,   19,   28,   84,
   88,   33,   85,   89,  122,  122,   83,  156,  156,  106,
    6,   22,  131,  144,  145,    7,   24,  133,   25,   29,
  156,   26,   96,   27,   90,  156,   28,  141,  142,  143,
  156,   70,   71,   72,   30,   31,   66,   67,  176,  177,
   53,  122,  122,   64,  146,  147,   46,   32,   33,   34,
   35,  122,  122,  103,  104,  105,  189,   68,   69,  122,
  194,   55,  173,  122,  122,   78,   79,   65,  199,  122,
   73,  122,  180,   80,  122,   34,   35,  169,  115,  116,
  117,   88,   33,   81,  170,    3,  118,   82,  184,  185,
  172,   14,   14,   95,   59,  101,  102,  115,  116,  117,
   29,   83,  155,  100,    3,  118,  186,  134,  187,  135,
   29,  136,  147,  111,  112,   30,   31,  149,  195,   29,
  197,  139,  151,  152,  119,   30,   58,  153,   32,   33,
   34,   35,  154,  159,   30,   31,  163,  160,   32,   33,
   34,   35,   74,  119,  161,  162,  164,   32,   33,   34,
   35,  115,  116,  117,  157,  166,  174,  167,    3,  118,
   74,   75,   76,   77,  168,   21,   21,   21,   21,   21,
   21,   21,   21,   29,  171,   21,   21,   21,   21,   21,
   21,   21,   21,  178,   14,   20,  179,  181,   30,   31,
   33,   14,  107,  108,  109,  110,  188,  119,   14,   14,
  191,   32,   33,   34,   35,  193,  196,   25,    1,   95,
   87,   89,   23,   99,   25,   25,   76,   25,   77,  113,
   25,   25,   25,   25,   25,  114,   25,   25,   25,   25,
   25,   25,   25,   25,   25,  190,    0,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   43,   25,
   57,  138,    0,    0,   25,   28,    0,    0,   25,   25,
   25,   25,   28,   28,    0,   28,    0,    0,    0,    0,
   28,   28,   28,    0,    0,   28,   28,   28,   28,   28,
   28,   28,   28,    0,    0,   28,   28,   28,   28,   28,
   28,   28,   28,   28,   28,   28,   44,   28,   28,    0,
    0,    0,   28,   46,    0,    0,   28,   28,   28,   28,
   46,   46,    0,   46,    0,    0,    0,    0,   46,   46,
   46,    0,    0,   46,   46,   46,   46,   46,   46,   46,
    0,    0,    0,   46,   46,   46,   46,   46,   46,   46,
   46,   46,   46,   46,   45,   46,    0,    0,    0,    0,
   46,   59,    0,    0,   46,   46,   46,   46,   59,   59,
    0,   59,    0,    0,    0,    0,   59,   59,   59,    0,
    0,   59,   59,   59,   59,   59,   59,   59,   59,    0,
    0,   59,   59,   59,   59,   59,   59,    0,   59,   59,
   59,   59,   60,   59,    0,    0,    0,    0,   59,   74,
    0,    0,   59,   59,   59,   59,   74,   74,    0,   74,
    0,    0,    0,    0,   74,   74,   74,    0,    0,   74,
   74,   74,   74,   74,   74,   74,   74,    0,    0,   74,
   74,   74,   74,   74,   74,   74,    0,   74,   74,   74,
   37,   74,    0,    0,    0,    0,   74,   33,    0,    0,
   74,   74,   74,   74,   33,   33,    0,   33,    0,    0,
    0,    0,   33,   33,   33,    0,    0,   33,   33,   33,
   14,   33,   33,   33,   33,    0,    0,   33,   33,   33,
   33,   33,   33,   33,   33,   14,   14,   33,   49,    0,
    0,    0,    0,    0,   33,   86,    0,    0,   14,   14,
   14,   14,    0,   87,    0,   43,    0,   88,   33,    0,
   89,    0,   43,   43,    0,   43,    0,    0,    0,    0,
   43,   43,   43,    0,    0,   43,   43,   43,   43,   43,
   43,   43,    0,    0,    0,   43,   43,   43,   43,   43,
   43,   43,   43,   43,   43,   43,   57,   43,    0,    0,
    0,    0,   43,   44,    0,    0,   43,   43,   43,   43,
   44,   44,    0,   44,    0,    0,    0,    0,   44,   44,
   44,    0,    0,   44,   44,   44,   44,   44,   44,   44,
    0,    0,    0,   44,   44,   44,   44,   44,   44,   44,
   44,   44,   44,   44,   52,   44,    0,    0,    0,    0,
   44,   45,    0,    0,   44,   44,   44,   44,   45,   45,
    0,   45,    0,    0,    0,    0,   45,   45,   45,    0,
    0,   45,   45,   45,   45,   45,   45,   45,    0,    0,
    0,   45,   45,   45,   45,   45,   45,   45,   45,   45,
   45,   45,   53,   45,    0,    0,    0,    0,   45,   60,
    0,    0,   45,   45,   45,   45,   60,   60,    0,   60,
    0,    0,    0,    0,   60,   60,   60,    0,    0,   60,
   60,   60,   60,   60,   60,   60,   60,    0,    0,   60,
   60,   60,   60,   60,   60,    0,   60,   60,   60,   60,
   50,   60,    0,    0,    0,    0,   60,   37,    0,    0,
   60,   60,   60,   60,   37,   37,    0,   37,    0,    0,
    0,    0,   37,   37,   37,    0,    0,    0,    0,   37,
   37,   37,   37,   37,   37,    0,    0,   37,   37,   37,
   37,   37,   37,   37,   37,   37,   37,   37,   51,   37,
    0,    0,    0,    0,   37,   49,    0,    0,   37,   37,
   37,   37,   49,   49,    0,   49,    0,    0,    0,    0,
   49,   49,   49,    0,    0,   49,   49,    0,    0,   49,
   49,   49,   49,    0,    0,   49,   49,   49,   49,   49,
   49,   49,   49,   49,   49,   49,   58,   49,    0,    0,
    0,    0,   49,    0,    0,    0,   49,   49,   49,   49,
    0,    0,    0,   57,    0,    0,    0,    0,    0,    0,
   57,   57,    0,   57,    0,    0,    0,    0,   57,   57,
   57,    0,    0,   57,   57,   57,   57,   57,   57,   57,
   57,    0,    0,   57,   57,   57,   57,    0,    0,   57,
   57,   57,   57,   57,   40,   57,    0,    0,    0,    0,
   57,   52,    0,    0,   57,   57,   57,   57,   52,   52,
    0,   52,    0,    0,    0,    0,   52,   52,   52,    0,
    0,   52,   52,    0,    0,   52,   52,   52,   52,    0,
    0,   52,   52,   52,   52,   52,   52,   52,   52,   52,
   52,   52,   41,   52,    0,    0,    0,    0,   52,   53,
    0,    0,   52,   52,   52,   52,   53,   53,    0,   53,
    0,    0,    0,    0,   53,   53,   53,    0,    0,   53,
   53,    0,    0,   53,   53,   53,   53,    0,    0,   53,
   53,   53,   53,   53,   53,   53,   53,   53,   53,   53,
   42,   53,    0,    0,    0,    0,   53,   50,    0,    0,
   53,   53,   53,   53,   50,   50,    0,   50,    0,    0,
    0,    0,   50,   50,   50,    0,    0,   50,   50,    0,
    0,   50,   50,   50,   50,    0,    0,   50,   50,   50,
   50,   50,   50,   50,   50,   50,   50,   50,   54,   50,
    0,    0,    0,    0,   50,   51,    0,    0,   50,   50,
   50,   50,   51,   51,    0,   51,    0,    0,    0,    0,
   51,   51,   51,    0,    0,   51,   51,    0,    0,   51,
   51,   51,   51,    0,    0,   51,   51,   51,   51,   51,
   51,   51,   51,   51,   51,   51,   56,   51,    0,    0,
    0,    0,   51,   58,    0,    0,   51,   51,   51,   51,
   58,   58,    0,   58,    0,    0,    0,    0,   58,   58,
   58,    0,    0,   58,   58,   58,   58,   58,   58,   58,
   58,    0,    0,   58,   58,   58,   58,    0,    0,   58,
   58,   58,   58,   58,   55,   58,    0,    0,    0,    0,
   58,    0,    0,    0,   58,   58,   58,   58,    0,    0,
    0,   40,    0,    0,    0,    0,    0,    0,   40,   40,
    0,   40,    0,    0,    0,    0,   40,   40,   40,    0,
    0,   40,   40,   40,   40,   99,    0,    0,   40,    0,
    0,   40,   40,   40,   40,   40,   40,   40,   40,   40,
   40,   40,    0,   40,   96,    0,    0,    0,   40,   41,
    0,    0,   40,   40,   40,   40,   41,   41,    0,   41,
    0,    0,    0,    0,   41,   41,   41,    0,    0,   41,
   41,   41,   41,    0,    0,    0,   41,    0,    0,   41,
   41,   41,   41,   41,   41,   41,   41,   41,   41,   41,
    0,   41,    0,    0,    0,    0,   41,   42,    0,    0,
   41,   41,   41,   41,   42,   42,    0,   42,    0,    0,
    0,    0,   42,   42,   42,    0,    0,   42,   42,   42,
   42,    0,    0,    0,   42,    0,    0,   42,   42,   42,
   42,   42,   42,   42,   42,   42,   42,   42,    0,   42,
    0,    0,    0,    0,   42,   54,    0,    0,   42,   42,
   42,   42,   54,   54,    0,   54,    0,    0,    0,    0,
   54,   54,   54,    0,    0,   54,   54,   54,   54,   54,
   54,   54,   54,    0,    0,    0,    0,    0,    0,   54,
   54,   54,   54,   54,   54,   54,    0,   54,    0,    0,
    0,    0,   54,   56,    0,    0,   54,   54,   54,   54,
   56,   56,    0,   56,    0,    0,    0,    0,   56,   56,
   56,    0,    0,   56,   56,   56,   56,   56,   56,   56,
   56,    0,    0,    0,    0,    0,    0,   56,   56,   56,
   56,   56,   56,   56,    0,   56,    0,    0,    0,    0,
   56,   55,    0,    0,   56,   56,   56,   56,   55,   55,
    0,   55,    0,    0,    0,    0,   55,   55,   55,    0,
    0,   55,   55,   55,   55,   55,   55,   55,   55,    0,
    0,    0,    0,    0,    0,   55,   55,   55,   55,   55,
   55,   55,   99,   55,    0,    0,    0,    0,   55,   99,
   99,    0,   55,   55,   55,   55,    0,    0,   99,   99,
    0,   96,    0,    0,    0,  115,  116,  117,   96,   96,
  183,    0,    3,  118,    0,    0,    0,   96,   96,    0,
    0,    0,    0,    0,   99,    0,    0,   29,    0,   99,
  115,  116,  117,    0,   99,  198,    0,    3,  118,    0,
    0,    0,   30,   31,    0,    0,    0,    0,   96,    0,
    0,  119,   29,   96,    0,   32,   33,   34,   35,    0,
    0,    0,   14,    0,  115,  116,  117,   30,   31,  200,
    0,    3,  118,    0,    0,    0,  119,   14,   14,    0,
   32,   33,   34,   35,    0,    0,   29,  115,  116,  117,
   14,   14,   14,   14,    3,  118,    0,    0,    0,    0,
    0,   30,   31,    0,    0,    0,    0,    0,    0,   29,
  119,    0,    0,    0,   32,   33,   34,   35,    0,    0,
    0,    0,    0,    0,   30,   31,    0,    0,    0,    0,
    0,    0,    0,  119,    0,    0,    0,   32,   33,   34,
   35,   25,   25,   25,   25,   25,   25,   25,   25,    0,
    0,   25,   25,   25,   25,   25,    0,   25,   25,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   25,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         22,
    0,   62,   63,   55,   27,  263,   84,   82,   31,   84,
  129,  130,   31,  257,    0,   29,   30,  296,  270,  271,
  264,  265,  270,    9,  303,  292,  308,  296,  297,  273,
  274,  310,  311,  300,  303,   58,  308,   55,  296,   58,
   92,  310,  311,  297,  299,  299,  304,  308,    0,  304,
  308,  309,  304,  311,  129,  130,  304,  176,  177,   73,
  304,  292,   85,  115,  116,  309,  306,   86,  298,  280,
  189,  298,  133,  292,   92,  194,  299,   96,   96,   98,
  199,  281,  282,  283,  295,  296,  277,  278,  166,  167,
  298,  166,  167,  298,  117,  118,    0,  308,  309,  310,
  311,  176,  177,   70,   71,   72,  184,  279,  280,  184,
  188,  304,  164,  188,  189,  291,  292,  300,  196,  194,
  284,  196,  174,  293,  199,  310,  311,  150,  258,  259,
  260,  308,  309,  294,  157,  265,  266,  304,  268,  269,
  163,  310,  311,  297,    0,   68,   69,  258,  259,  260,
  280,  299,  263,  308,  265,  266,  179,  308,  181,  304,
  280,  304,  185,   78,   79,  295,  296,  304,  191,  280,
  193,  297,  304,  304,  304,  295,  296,  304,  308,  309,
  310,  311,  304,  304,  295,  296,  270,  297,  308,  309,
  310,  311,    0,  304,  297,  297,  276,  308,  309,  310,
  311,  258,  259,  260,  261,  304,  271,  267,  265,  266,
  287,  288,  289,  290,  263,  277,  278,  279,  280,  281,
  282,  283,  284,  280,  263,  287,  288,  289,  290,  291,
  292,  293,  294,  304,  296,  297,  257,  270,  295,  296,
    0,  303,   74,   75,   76,   77,  304,  304,  310,  311,
  272,  308,  309,  310,  311,  257,  304,  257,    0,  263,
  304,  304,    9,   64,  264,  265,  263,  267,  263,   80,
  270,  271,  272,  273,  274,   81,  276,  277,  278,  279,
  280,  281,  282,  283,  284,  185,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,    0,  299,
   28,   92,   -1,   -1,  304,  257,   -1,   -1,  308,  309,
  310,  311,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,  279,  280,  281,
  282,  283,  284,   -1,   -1,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,    0,  299,  300,   -1,
   -1,   -1,  304,  257,   -1,   -1,  308,  309,  310,  311,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,  279,  280,  281,  282,  283,
   -1,   -1,   -1,  287,  288,  289,  290,  291,  292,  293,
  294,  295,  296,  297,    0,  299,   -1,   -1,   -1,   -1,
  304,  257,   -1,   -1,  308,  309,  310,  311,  264,  265,
   -1,  267,   -1,   -1,   -1,   -1,  272,  273,  274,   -1,
   -1,  277,  278,  279,  280,  281,  282,  283,  284,   -1,
   -1,  287,  288,  289,  290,  291,  292,   -1,  294,  295,
  296,  297,    0,  299,   -1,   -1,   -1,   -1,  304,  257,
   -1,   -1,  308,  309,  310,  311,  264,  265,   -1,  267,
   -1,   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,
  278,  279,  280,  281,  282,  283,  284,   -1,   -1,  287,
  288,  289,  290,  291,  292,  293,   -1,  295,  296,  297,
    0,  299,   -1,   -1,   -1,   -1,  304,  257,   -1,   -1,
  308,  309,  310,  311,  264,  265,   -1,  267,   -1,   -1,
   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,  279,
  280,  281,  282,  283,  284,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,    0,   -1,
   -1,   -1,   -1,   -1,  304,  296,   -1,   -1,  308,  309,
  310,  311,   -1,  304,   -1,  257,   -1,  308,  309,   -1,
  311,   -1,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,  279,  280,  281,
  282,  283,   -1,   -1,   -1,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,    0,  299,   -1,   -1,
   -1,   -1,  304,  257,   -1,   -1,  308,  309,  310,  311,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,  279,  280,  281,  282,  283,
   -1,   -1,   -1,  287,  288,  289,  290,  291,  292,  293,
  294,  295,  296,  297,    0,  299,   -1,   -1,   -1,   -1,
  304,  257,   -1,   -1,  308,  309,  310,  311,  264,  265,
   -1,  267,   -1,   -1,   -1,   -1,  272,  273,  274,   -1,
   -1,  277,  278,  279,  280,  281,  282,  283,   -1,   -1,
   -1,  287,  288,  289,  290,  291,  292,  293,  294,  295,
  296,  297,    0,  299,   -1,   -1,   -1,   -1,  304,  257,
   -1,   -1,  308,  309,  310,  311,  264,  265,   -1,  267,
   -1,   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,
  278,  279,  280,  281,  282,  283,  284,   -1,   -1,  287,
  288,  289,  290,  291,  292,   -1,  294,  295,  296,  297,
    0,  299,   -1,   -1,   -1,   -1,  304,  257,   -1,   -1,
  308,  309,  310,  311,  264,  265,   -1,  267,   -1,   -1,
   -1,   -1,  272,  273,  274,   -1,   -1,   -1,   -1,  279,
  280,  281,  282,  283,  284,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,    0,  299,
   -1,   -1,   -1,   -1,  304,  257,   -1,   -1,  308,  309,
  310,  311,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,   -1,   -1,  281,
  282,  283,  284,   -1,   -1,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,    0,  299,   -1,   -1,
   -1,   -1,  304,   -1,   -1,   -1,  308,  309,  310,  311,
   -1,   -1,   -1,  257,   -1,   -1,   -1,   -1,   -1,   -1,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,  279,  280,  281,  282,  283,
  284,   -1,   -1,  287,  288,  289,  290,   -1,   -1,  293,
  294,  295,  296,  297,    0,  299,   -1,   -1,   -1,   -1,
  304,  257,   -1,   -1,  308,  309,  310,  311,  264,  265,
   -1,  267,   -1,   -1,   -1,   -1,  272,  273,  274,   -1,
   -1,  277,  278,   -1,   -1,  281,  282,  283,  284,   -1,
   -1,  287,  288,  289,  290,  291,  292,  293,  294,  295,
  296,  297,    0,  299,   -1,   -1,   -1,   -1,  304,  257,
   -1,   -1,  308,  309,  310,  311,  264,  265,   -1,  267,
   -1,   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,
  278,   -1,   -1,  281,  282,  283,  284,   -1,   -1,  287,
  288,  289,  290,  291,  292,  293,  294,  295,  296,  297,
    0,  299,   -1,   -1,   -1,   -1,  304,  257,   -1,   -1,
  308,  309,  310,  311,  264,  265,   -1,  267,   -1,   -1,
   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,   -1,
   -1,  281,  282,  283,  284,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,    0,  299,
   -1,   -1,   -1,   -1,  304,  257,   -1,   -1,  308,  309,
  310,  311,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,   -1,   -1,  281,
  282,  283,  284,   -1,   -1,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,    0,  299,   -1,   -1,
   -1,   -1,  304,  257,   -1,   -1,  308,  309,  310,  311,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,  279,  280,  281,  282,  283,
  284,   -1,   -1,  287,  288,  289,  290,   -1,   -1,  293,
  294,  295,  296,  297,    0,  299,   -1,   -1,   -1,   -1,
  304,   -1,   -1,   -1,  308,  309,  310,  311,   -1,   -1,
   -1,  257,   -1,   -1,   -1,   -1,   -1,   -1,  264,  265,
   -1,  267,   -1,   -1,   -1,   -1,  272,  273,  274,   -1,
   -1,  277,  278,  279,  280,    0,   -1,   -1,  284,   -1,
   -1,  287,  288,  289,  290,  291,  292,  293,  294,  295,
  296,  297,   -1,  299,    0,   -1,   -1,   -1,  304,  257,
   -1,   -1,  308,  309,  310,  311,  264,  265,   -1,  267,
   -1,   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,
  278,  279,  280,   -1,   -1,   -1,  284,   -1,   -1,  287,
  288,  289,  290,  291,  292,  293,  294,  295,  296,  297,
   -1,  299,   -1,   -1,   -1,   -1,  304,  257,   -1,   -1,
  308,  309,  310,  311,  264,  265,   -1,  267,   -1,   -1,
   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,  279,
  280,   -1,   -1,   -1,  284,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,   -1,  299,
   -1,   -1,   -1,   -1,  304,  257,   -1,   -1,  308,  309,
  310,  311,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,  279,  280,  281,
  282,  283,  284,   -1,   -1,   -1,   -1,   -1,   -1,  291,
  292,  293,  294,  295,  296,  297,   -1,  299,   -1,   -1,
   -1,   -1,  304,  257,   -1,   -1,  308,  309,  310,  311,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,  279,  280,  281,  282,  283,
  284,   -1,   -1,   -1,   -1,   -1,   -1,  291,  292,  293,
  294,  295,  296,  297,   -1,  299,   -1,   -1,   -1,   -1,
  304,  257,   -1,   -1,  308,  309,  310,  311,  264,  265,
   -1,  267,   -1,   -1,   -1,   -1,  272,  273,  274,   -1,
   -1,  277,  278,  279,  280,  281,  282,  283,  284,   -1,
   -1,   -1,   -1,   -1,   -1,  291,  292,  293,  294,  295,
  296,  297,  257,  299,   -1,   -1,   -1,   -1,  304,  264,
  265,   -1,  308,  309,  310,  311,   -1,   -1,  273,  274,
   -1,  257,   -1,   -1,   -1,  258,  259,  260,  264,  265,
  263,   -1,  265,  266,   -1,   -1,   -1,  273,  274,   -1,
   -1,   -1,   -1,   -1,  299,   -1,   -1,  280,   -1,  304,
  258,  259,  260,   -1,  309,  263,   -1,  265,  266,   -1,
   -1,   -1,  295,  296,   -1,   -1,   -1,   -1,  304,   -1,
   -1,  304,  280,  309,   -1,  308,  309,  310,  311,   -1,
   -1,   -1,  280,   -1,  258,  259,  260,  295,  296,  263,
   -1,  265,  266,   -1,   -1,   -1,  304,  295,  296,   -1,
  308,  309,  310,  311,   -1,   -1,  280,  258,  259,  260,
  308,  309,  310,  311,  265,  266,   -1,   -1,   -1,   -1,
   -1,  295,  296,   -1,   -1,   -1,   -1,   -1,   -1,  280,
  304,   -1,   -1,   -1,  308,  309,  310,  311,   -1,   -1,
   -1,   -1,   -1,   -1,  295,  296,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  304,   -1,   -1,   -1,  308,  309,  310,
  311,  277,  278,  279,  280,  281,  282,  283,  284,   -1,
   -1,  287,  288,  289,  290,  291,   -1,  293,  294,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  304,
};
}
final static short YYFINAL=8;
final static short YYMAXTOKEN=311;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"TO","FOR","FOREACH","WHILE","RETURN","DO","END","DEFINE","VAR",
"IF","THEN","ELSE","ELSIF","FROM","AS","BY","BEFORE","AFTER","EACH","IN",
"PLUSPLUS","MINUSMINUS","PLUS","MINUS","MUL","DIV","MODULO","POWER",
"LIST_OP_PUSH","LIST_OP_POP","REL_OP_LE","REL_OP_GE","REL_OP_LT","REL_OP_GT",
"REL_OP_NE","EQUALS","LOG_OP_AND","LOG_OP_OR","LOG_OP_NOT","LPAREN","RPAREN",
"COLON","COMMA","DOT","TRUE","FALSE","NIL","NEWLINE","SPACE",
"EVENT_NAME_IDENTIFIER","RESERVED_IDENTIFIER","IDENTIFIER","SYS_IDENTIFIER",
"STRING","NUMERIC",
};
final static String yyrule[] = {
"$accept : program_program",
"program_program : program_unit",
"program_unit : external_declaration",
"program_unit : program_unit external_declaration",
"external_declaration : function_declarator",
"external_declaration : var_declarator",
"external_declaration : molecule_declarator",
"external_declaration : debug_hook_declarator",
"external_declaration : global_variable_assignment",
"external_declaration : NEWLINE",
"global_variable_assignment : SYS_IDENTIFIER EQUALS expression",
"atom : NUMERIC",
"atom : STRING",
"commaq : COMMA",
"commaq :",
"pair : LPAREN atom commaq NIL RPAREN",
"pair : LPAREN atom commaq atom RPAREN",
"pair : LPAREN atom commaq pair RPAREN",
"pair : LPAREN atoms RPAREN",
"atoms : atoms commaq atom",
"atoms : atom",
"primary_expression : atom",
"primary_expression : pair",
"primary_expression : identifier",
"primary_expression : LPAREN expression RPAREN",
"identifier : compound_identifier",
"identifier : SYS_IDENTIFIER",
"compound_identifier : compound_identifier DOT IDENTIFIER",
"compound_identifier : IDENTIFIER",
"postfix_expression : primary_expression",
"postfix_expression : postfix_expression PLUSPLUS",
"postfix_expression : postfix_expression MINUSMINUS",
"postfix_expression : function_expression",
"function_expression : IDENTIFIER COLON params",
"params : params commaq param",
"params :",
"param : expression",
"unary_expression : postfix_expression",
"unary_expression : MINUS unary_expression",
"unary_expression : LOG_OP_NOT unary_expression",
"additive_expression : multiplicative_expression",
"additive_expression : additive_expression PLUS multiplicative_expression",
"additive_expression : additive_expression MINUS multiplicative_expression",
"multiplicative_expression : multiplicative_expression MUL pow_expression",
"multiplicative_expression : multiplicative_expression DIV pow_expression",
"multiplicative_expression : multiplicative_expression MODULO pow_expression",
"multiplicative_expression : pow_expression",
"pow_expression : unary_expression",
"pow_expression : pow_expression POWER unary_expression",
"relational_expression : additive_expression",
"relational_expression : relational_expression REL_OP_LT additive_expression",
"relational_expression : relational_expression REL_OP_GT additive_expression",
"relational_expression : relational_expression REL_OP_LE additive_expression",
"relational_expression : relational_expression REL_OP_GE additive_expression",
"equality_expression : relational_expression",
"equality_expression : equality_expression EQUALS relational_expression",
"equality_expression : equality_expression REL_OP_NE relational_expression",
"logical_and_expression : equality_expression",
"logical_and_expression : logical_and_expression LOG_OP_AND equality_expression",
"logical_or_expression : logical_and_expression",
"logical_or_expression : logical_or_expression LOG_OP_OR logical_and_expression",
"assignment_expression : compound_identifier EQUALS expression",
"statement : expression_statement NEWLINE",
"statement : selection_statement NEWLINE",
"statement : iteration_statement NEWLINE",
"statement : var_declarator NEWLINE",
"statement : assignment_statement NEWLINE",
"statement : NEWLINE",
"statements : statement",
"statements : statements statement",
"assignment_statement : assignment_expression",
"expression_statement : expression",
"expression : expression_t",
"expression : LPAREN expression RPAREN",
"expression_t : logical_or_expression",
"selection_statement : IF partial_selection_statement END",
"partial_selection_statement : expression THEN statements",
"partial_selection_statement : expression THEN statements ELSE statements",
"partial_selection_statement : expression THEN statements ELSIF partial_selection_statement",
"iteration_statement : WHILE expression NEWLINE statements END",
"iteration_statement : FOR identifier FROM expression TO expression by_statement NEWLINE statements END",
"iteration_statement : FOREACH identifier in_statement as_statement from_statement NEWLINE statements END",
"as_statement : AS identifier",
"as_statement :",
"in_statement : IN identifier",
"in_statement :",
"from_statement : FROM expression TO expression",
"from_statement :",
"by_statement : BY expression",
"by_statement :",
"debug_hook_declarator : time_seq EVENT_NAME_IDENTIFIER COLON NEWLINE statements END",
"time_seq : BEFORE",
"time_seq : AFTER",
"function_declarator : TO IDENTIFIER COLON params NEWLINE statements opt_return END",
"opt_return : RETURN expression NEWLINE",
"opt_return :",
"var_declarator : VAR declaration_list",
"declaration_list : declarator",
"declaration_list : declaration_list COMMA declarator",
"declarator : IDENTIFIER",
"declarator : IDENTIFIER EQUALS expression",
"molecule_declarator : DEFINE IDENTIFIER COLON NEWLINE molecule_defs END",
"molecule_defs : molecule_def",
"molecule_defs : molecule_defs molecule_def",
"molecule_def : NUMERIC IDENTIFIER NEWLINE",
"molecule_def : identifier NEWLINE",
"molecule_def : pair NEWLINE",
"molecule_def : NEWLINE",
};

//#line 271 "snow.y"

	protected Parser(Reader r) {
	    lexer = new Yylex(r, this);
	  }
	public static void main(String args[]) throws IOException {
	    Parser yyparser = new Parser(new FileReader(args[0]));
	    yyparser.yyparse();    
	  }
//#line 738 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 21 "snow.y"
{
System.out.println("import com.google.code.pltsnow.snowfield.*;");
System.out.println("import com.google.code.pltsnow.gen.*;");
System.out.println("import java.util.ArrayList;");

System.out.println("public class SnowProgramImp extends BaseSnowProgram {\n");
System.out.println(val_peek(0).sval);
System.out.println("}");
}
break;
case 2:
//#line 30 "snow.y"
{yyval=val_peek(0);}
break;
case 3:
//#line 31 "snow.y"
{yyval = new ParserVal(val_peek(1).sval + val_peek(0).sval);}
break;
case 4:
//#line 35 "snow.y"
{yyval=val_peek(0);}
break;
case 5:
//#line 36 "snow.y"
{yyval=val_peek(0);}
break;
case 6:
//#line 37 "snow.y"
{yyval=val_peek(0);}
break;
case 7:
//#line 38 "snow.y"
{yyval=val_peek(0);}
break;
case 8:
//#line 39 "snow.y"
{yyval=val_peek(0);}
break;
case 9:
//#line 40 "snow.y"
{yyval=val_peek(0);}
break;
case 10:
//#line 44 "snow.y"
{ yyval = assignVariable(val_peek(2),val_peek(0)); }
break;
case 11:
//#line 48 "snow.y"
{yyval=val_peek(0);}
break;
case 12:
//#line 49 "snow.y"
{yyval=val_peek(0);}
break;
case 13:
//#line 53 "snow.y"
{yyval= new ParserVal(",");}
break;
case 14:
//#line 54 "snow.y"
{yyval=new ParserVal("");}
break;
case 21:
//#line 71 "snow.y"
{yyval=val_peek(0);}
break;
case 22:
//#line 72 "snow.y"
{yyval=val_peek(0);}
break;
case 23:
//#line 73 "snow.y"
{yyval=val_peek(0);}
break;
case 24:
//#line 74 "snow.y"
{yyval = val_peek(1);}
break;
case 25:
//#line 78 "snow.y"
{yyval= val_peek(0);}
break;
case 26:
//#line 79 "snow.y"
{ yyval = new ParserVal("symbols.get(\""+val_peek(0).sval+"\")");}
break;
case 27:
//#line 83 "snow.y"
{ yyval = buildCompoundIdentifier(val_peek(2),val_peek(0)); }
break;
case 28:
//#line 84 "snow.y"
{yyval = val_peek(0);}
break;
case 29:
//#line 87 "snow.y"
{yyval=val_peek(0);}
break;
case 30:
//#line 88 "snow.y"
{yyval = doOp("plus",val_peek(1),new ParserVal(1)); }
break;
case 31:
//#line 89 "snow.y"
{yyval = doOp("minus",val_peek(1),new ParserVal(1)); }
break;
case 32:
//#line 90 "snow.y"
{yyval=val_peek(0);}
break;
case 33:
//#line 94 "snow.y"
{ yyval = executeFunction(val_peek(2),val_peek(0)); }
break;
case 34:
//#line 98 "snow.y"
{yyval = new ParserVal(val_peek(2).sval+val_peek(1).sval+val_peek(0).sval);}
break;
case 35:
//#line 99 "snow.y"
{yyval = new ParserVal("");}
break;
case 36:
//#line 103 "snow.y"
{yyval = val_peek(0); }
break;
case 37:
//#line 107 "snow.y"
{yyval=val_peek(0);}
break;
case 40:
//#line 114 "snow.y"
{yyval=val_peek(0);}
break;
case 41:
//#line 115 "snow.y"
{yyval = doOp("plus",val_peek(2),val_peek(0));}
break;
case 42:
//#line 116 "snow.y"
{yyval = doOp("minus",val_peek(2),val_peek(0));}
break;
case 43:
//#line 120 "snow.y"
{yyval = doOp("times",val_peek(2),val_peek(0));}
break;
case 44:
//#line 121 "snow.y"
{yyval = doOp("divide",val_peek(2),val_peek(0));}
break;
case 45:
//#line 122 "snow.y"
{yyval = doOp("modulo",val_peek(2),val_peek(0));}
break;
case 46:
//#line 123 "snow.y"
{yyval=val_peek(0);}
break;
case 47:
//#line 126 "snow.y"
{yyval=val_peek(0);}
break;
case 48:
//#line 127 "snow.y"
{yyval = doOp("power",val_peek(2),val_peek(0));}
break;
case 49:
//#line 131 "snow.y"
{yyval = val_peek(0);}
break;
case 50:
//#line 132 "snow.y"
{yyval = doOp("lt",val_peek(2),val_peek(0));}
break;
case 51:
//#line 133 "snow.y"
{yyval = doOp("gt",val_peek(2),val_peek(0));}
break;
case 52:
//#line 134 "snow.y"
{yyval = doOp("le",val_peek(2),val_peek(0));}
break;
case 53:
//#line 135 "snow.y"
{yyval = doOp("ge",val_peek(2),val_peek(0));}
break;
case 54:
//#line 139 "snow.y"
{yyval = val_peek(0);}
break;
case 55:
//#line 140 "snow.y"
{yyval = doOp("equals",val_peek(2),val_peek(0));}
break;
case 56:
//#line 141 "snow.y"
{yyval = doOp("nequals",val_peek(2),val_peek(0));}
break;
case 57:
//#line 145 "snow.y"
{yyval=val_peek(0);}
break;
case 59:
//#line 150 "snow.y"
{yyval=val_peek(0);}
break;
case 61:
//#line 155 "snow.y"
{ yyval = assignVariable(val_peek(2),val_peek(0)); }
break;
case 62:
//#line 159 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 63:
//#line 160 "snow.y"
{yyval=val_peek(1);}
break;
case 64:
//#line 161 "snow.y"
{yyval=val_peek(1);}
break;
case 65:
//#line 162 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 66:
//#line 163 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 68:
//#line 168 "snow.y"
{ yyval=val_peek(0); }
break;
case 69:
//#line 169 "snow.y"
{yyval =new ParserVal(val_peek(1).sval+val_peek(0).sval);}
break;
case 70:
//#line 173 "snow.y"
{yyval=val_peek(0);}
break;
case 71:
//#line 177 "snow.y"
{yyval=val_peek(0);}
break;
case 72:
//#line 179 "snow.y"
{yyval=val_peek(0);}
break;
case 73:
//#line 180 "snow.y"
{yyval=val_peek(1);}
break;
case 74:
//#line 182 "snow.y"
{yyval=val_peek(0);}
break;
case 81:
//#line 198 "snow.y"
{ yyval = doForeach(val_peek(6),val_peek(5),val_peek(4),val_peek(3),val_peek(1)); }
break;
case 82:
//#line 202 "snow.y"
{ yyval = val_peek(0); }
break;
case 83:
//#line 203 "snow.y"
{yyval = null; }
break;
case 84:
//#line 207 "snow.y"
{ yyval = val_peek(0); }
break;
case 85:
//#line 208 "snow.y"
{yyval = null; }
break;
case 86:
//#line 212 "snow.y"
{ yyval = new ParserVal(val_peek(2).sval + ":" + val_peek(0).sval); }
break;
case 87:
//#line 213 "snow.y"
{yyval = null; }
break;
case 90:
//#line 222 "snow.y"
{ 
				yyval = createDebugHook(val_peek(5),val_peek(4),val_peek(1));
				}
break;
case 91:
//#line 228 "snow.y"
{yyval = new ParserVal("before"); }
break;
case 92:
//#line 229 "snow.y"
{yyval = new ParserVal("after"); }
break;
case 93:
//#line 233 "snow.y"
{ yyval = createFunction(val_peek(6),val_peek(4),val_peek(2),val_peek(1)); }
break;
case 94:
//#line 236 "snow.y"
{yyval = val_peek(1);}
break;
case 96:
//#line 240 "snow.y"
{ yyval = declareLocalVariable(val_peek(0)); }
break;
case 101:
//#line 254 "snow.y"
{ yyval = defineMolecule(val_peek(4),val_peek(1)); }
break;
case 102:
//#line 258 "snow.y"
{yyval = val_peek(0);}
break;
case 103:
//#line 259 "snow.y"
{ yyval= new ParserVal(val_peek(1).sval +val_peek(0).sval); }
break;
case 104:
//#line 263 "snow.y"
{ yyval = moleLazyCreate(val_peek(2),val_peek(1));}
break;
case 105:
//#line 264 "snow.y"
{ yyval = moleCreateOne(val_peek(1));  }
break;
//#line 1221 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
