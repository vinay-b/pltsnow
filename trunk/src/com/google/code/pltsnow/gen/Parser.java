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
public final static short EVENT_NAME_IDENTIFIER=305;
public final static short RESERVED_IDENTIFIER=306;
public final static short IDENTIFIER=307;
public final static short SYS_IDENTIFIER=308;
public final static short STRING=309;
public final static short NUMERIC=310;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    2,    2,    2,    2,    2,    2,    7,
    9,    9,   10,   10,   11,   11,   11,   11,   12,   12,
   13,   13,   13,   13,   14,   14,   15,   15,   16,   16,
   16,   16,   17,   18,   18,   19,   20,   20,   20,   21,
   21,   21,   22,   22,   22,   22,   23,   23,   24,   24,
   24,   24,   24,   25,   25,   25,   26,   26,   27,   27,
   28,   29,   29,   29,   29,   29,   29,   34,   34,   33,
   30,    8,   31,   35,   35,   35,   32,   32,   32,   38,
   38,   37,   37,   39,   39,   36,   36,    6,   40,   40,
    3,    4,   41,   41,   42,   42,    5,   43,   43,   44,
   44,   44,   44,   45,   45,
};
final static short yylen[] = {                            2,
    1,    1,    2,    1,    1,    1,    1,    1,    1,    3,
    1,    1,    1,    0,    5,    5,    5,    3,    3,    1,
    1,    1,    1,    3,    1,    1,    3,    1,    1,    2,
    2,    1,    3,    3,    0,    1,    1,    2,    2,    1,
    3,    3,    3,    3,    3,    1,    1,    3,    1,    3,
    3,    3,    3,    1,    3,    3,    1,    3,    1,    3,
    3,    2,    2,    2,    2,    2,    1,    1,    2,    1,
    1,    1,    3,    3,    5,    5,    5,   10,    8,    2,
    0,    2,    0,    4,    0,    2,    0,    6,    1,    1,
    7,    2,    1,    3,    1,    3,    6,    1,    2,    3,
    2,    2,    1,    3,    1,
};
final static short yydefred[] = {                         0,
    0,    0,    0,   89,   90,    9,    0,    0,    0,    2,
    4,    5,    6,    7,    8,    0,    0,    0,    0,    0,
   93,    0,    3,    0,   35,    0,    0,    0,    0,    0,
    0,    0,   26,   12,   11,   10,   21,   22,   29,   23,
    0,    0,   32,   47,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   96,   94,   38,   39,    0,    0,
    0,   35,    0,   30,   31,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   13,    0,    0,    0,  103,   28,    0,    0,    0,    0,
   98,   24,    0,   18,    0,    0,   27,    0,    0,    0,
    0,    0,   48,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   67,    0,   71,    0,   70,
   68,    0,    0,    0,    0,    0,    0,   36,   34,    0,
    0,  102,  101,   97,   99,    0,    0,    0,   19,    0,
    0,    0,    0,    0,   65,    0,   62,   63,   64,   66,
   88,   69,   91,  100,   15,   16,   17,    0,    0,    0,
    0,    0,   73,   61,    0,   82,    0,    0,    0,    0,
    0,   80,    0,    0,   77,    0,    0,    0,    0,    0,
    0,   76,    0,    0,    0,    0,   86,    0,   84,   79,
    0,   78,
};
final static short yydgoto[] = {                          8,
    9,   10,   11,  117,   13,   14,   15,  118,   37,   83,
   38,   61,   39,   40,   41,   42,   43,   53,  129,   44,
   45,   46,   47,   48,   49,   50,   51,  120,  121,  122,
  123,  124,  125,  126,  144,  184,  160,  168,  174,   16,
   20,   21,   90,   91,    0,
};
final static short yysindex[] = {                      -237,
 -299, -264, -247,    0,    0,    0, -208,    0, -237,    0,
    0,    0,    0,    0,    0, -275, -203, -188, -201, -170,
    0, -251,    0, -164,    0, -167, -251, -247, -251, -251,
 -251, -158,    0,    0,    0,    0,    0,    0,    0,    0,
 -156, -226,    0,    0, -207, -176, -132, -210, -193, -143,
 -127, -144, -266, -134,    0,    0,    0,    0, -122, -120,
 -233,    0, -126,    0,    0, -251, -251, -251, -251, -251,
 -251, -251, -251, -251, -251, -251, -251, -251, -251, 1304,
    0, 1304, -251, -184,    0,    0, -125, -124, -119, -169,
    0,    0, -262,    0, -184, -120,    0, -176, -176, -132,
 -132, -132,    0, -207, -207, -207, -207, -210, -210, -193,
 -143, -165, -165, -251, -251,    0, -117,    0, -277,    0,
    0, -115, -114, -113, -110,  -94, 1198,    0,    0, -120,
 -105,    0,    0,    0,    0, -109,  -97,  -93,    0,  -67,
  -71,  -98,  -59,  -56,    0, -251,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0, -251, -165,  -62,
 1304, 1304,    0,    0,  -46,    0, -165,  -45, 1232, -112,
 -251,    0, -251,  -92,    0, 1304, -251,  -37,  -31, 1304,
 1304,    0, -251,  -66, -251, 1251,    0, 1304,    0,    0,
 1285,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,  239,    0,
    0,    0,    0,    0,    0,    0,    0,    0, 1176, 1195,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   49,    0,    0,    0,    0,    0,    0,    0,    0,
    1,  491,    0,    0,  539,  895,   97, 1039,  597,  145,
  193,    0, -194,    0,    0,    0,    0,    0,    0,  -60,
 -178,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  241,    0,  943,  991,  299,
  347,  395,    0,  645,  693,  741,  789, 1087, 1135,  837,
  443,    0,    0,    0,    0,    0,    0,    0, 1338,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0, -278,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
 -254,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0, -258,
    0,    0,    0,    0,    0,    0,    0,  -64,    0,  -21,
    0,    0,    0,    0,    0,    0,    0,  -57,    0,    0,
  -19,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,
};
final static short yygindex[] = {                         0,
    0,  236,    0,   26,    0,    0,    0,  -22,  -10,  -54,
  -51,    0,    0,  -50,  -58,    0,    0,  184,    0,  -16,
   15,   92,   51,  101,  170,  172,    0,    0, -116,    0,
    0,    0,    0,  -80,   75,    0,    0,    0,    0,    0,
    0,  225,    0,  164,    0,
};
final static int YYTABLESIZE=1642;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         36,
   25,  127,   88,   89,   55,   93,   95,   17,   59,  152,
  152,   81,   57,   58,  146,   83,   83,   14,   20,    1,
   60,  119,   63,  119,   14,   12,    2,    3,   29,   24,
   14,   14,   81,   84,   12,    4,    5,   82,   88,   89,
  136,  138,   18,   30,   31,   81,   34,   35,   28,   83,
   64,   65,  152,  152,  103,   32,   33,   34,   35,   19,
  128,  140,  141,   94,  152,   81,    6,  119,  119,  152,
    7,   66,   67,  130,  152,   93,   72,   73,   74,   75,
  169,  170,  137,   22,  139,   14,  104,  105,  106,  107,
   27,  142,  143,  134,   25,  181,   46,   76,   77,  186,
   14,   14,  119,  119,   68,   69,   70,  191,  166,   26,
  119,  119,   14,   14,   14,   14,  172,  119,  100,  101,
  102,  119,  119,  164,   34,   35,   84,  119,   28,  119,
   14,   14,  119,   52,   85,  165,   54,   86,   33,   62,
   87,   86,   33,   63,   59,  112,  113,  114,  178,   78,
  179,   71,    3,  115,  143,  176,  177,   98,   99,   80,
  187,   84,  189,  112,  113,  114,   79,   29,  151,   85,
    3,  115,   86,   33,   92,   87,  108,  109,   81,  132,
   97,  131,   30,   31,  133,   29,  145,  155,  147,  148,
  149,  116,   72,  150,   32,   33,   34,   35,  154,  156,
   30,   31,  158,  157,  159,  161,  163,  162,  167,  116,
  171,  180,   32,   33,   34,   35,   21,   21,   21,   21,
   21,   21,   21,   21,  173,  185,   21,   21,   21,   21,
   21,   21,   21,   21,  183,   14,   20,  188,    1,   85,
   33,   74,   14,   75,   23,   96,   87,  110,   14,   14,
  111,  182,   56,  135,    0,    0,    0,   25,    0,    0,
    0,    0,    0,    0,   25,   25,    0,   25,    0,    0,
   25,   25,   25,   25,   25,    0,   25,   25,   25,   25,
   25,   25,   25,   25,   25,    0,    0,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   43,   25,
    0,    0,    0,    0,   25,   28,    0,   25,   25,   25,
   25,    0,   28,   28,    0,   28,    0,    0,    0,    0,
   28,   28,   28,    0,    0,   28,   28,   28,   28,   28,
   28,   28,   28,    0,    0,   28,   28,   28,   28,   28,
   28,   28,   28,   28,   28,   28,   44,   28,   28,    0,
    0,    0,   28,   46,    0,   28,   28,   28,   28,    0,
   46,   46,    0,   46,    0,    0,    0,    0,   46,   46,
   46,    0,    0,   46,   46,   46,   46,   46,   46,   46,
    0,    0,    0,   46,   46,   46,   46,   46,   46,   46,
   46,   46,   46,   46,   45,   46,    0,    0,    0,    0,
   46,   59,    0,   46,   46,   46,   46,    0,   59,   59,
    0,   59,    0,    0,    0,    0,   59,   59,   59,    0,
    0,   59,   59,   59,   59,   59,   59,   59,   59,    0,
    0,   59,   59,   59,   59,   59,   59,    0,   59,   59,
   59,   59,   60,   59,    0,    0,    0,    0,   59,   72,
    0,   59,   59,   59,   59,    0,   72,   72,    0,   72,
    0,    0,    0,    0,   72,   72,   72,    0,    0,   72,
   72,   72,   72,   72,   72,   72,   72,    0,    0,   72,
   72,   72,   72,   72,   72,   72,    0,   72,   72,   72,
   37,   72,    0,    0,    0,    0,   72,   33,    0,   72,
   72,   72,   72,    0,   33,   33,    0,   33,    0,    0,
    0,    0,   33,   33,   33,    0,    0,   33,   33,   33,
   14,   33,   33,   33,   33,    0,    0,   33,   33,   33,
   33,   33,   33,   33,   33,   14,   14,   33,   49,    0,
    0,    0,    0,    0,   33,    0,    0,   14,   14,   14,
   14,    0,    0,    0,    0,   43,    0,    0,    0,    0,
    0,    0,   43,   43,    0,   43,    0,    0,    0,    0,
   43,   43,   43,    0,    0,   43,   43,   43,   43,   43,
   43,   43,    0,    0,    0,   43,   43,   43,   43,   43,
   43,   43,   43,   43,   43,   43,   57,   43,    0,    0,
    0,    0,   43,   44,    0,   43,   43,   43,   43,    0,
   44,   44,    0,   44,    0,    0,    0,    0,   44,   44,
   44,    0,    0,   44,   44,   44,   44,   44,   44,   44,
    0,    0,    0,   44,   44,   44,   44,   44,   44,   44,
   44,   44,   44,   44,   52,   44,    0,    0,    0,    0,
   44,   45,    0,   44,   44,   44,   44,    0,   45,   45,
    0,   45,    0,    0,    0,    0,   45,   45,   45,    0,
    0,   45,   45,   45,   45,   45,   45,   45,    0,    0,
    0,   45,   45,   45,   45,   45,   45,   45,   45,   45,
   45,   45,   53,   45,    0,    0,    0,    0,   45,   60,
    0,   45,   45,   45,   45,    0,   60,   60,    0,   60,
    0,    0,    0,    0,   60,   60,   60,    0,    0,   60,
   60,   60,   60,   60,   60,   60,   60,    0,    0,   60,
   60,   60,   60,   60,   60,    0,   60,   60,   60,   60,
   50,   60,    0,    0,    0,    0,   60,   37,    0,   60,
   60,   60,   60,    0,   37,   37,    0,   37,    0,    0,
    0,    0,   37,   37,   37,    0,    0,    0,    0,   37,
   37,   37,   37,   37,   37,    0,    0,   37,   37,   37,
   37,   37,   37,   37,   37,   37,   37,   37,   51,   37,
    0,    0,    0,    0,   37,   49,    0,   37,   37,   37,
   37,    0,   49,   49,    0,   49,    0,    0,    0,    0,
   49,   49,   49,    0,    0,   49,   49,    0,    0,   49,
   49,   49,   49,    0,    0,   49,   49,   49,   49,   49,
   49,   49,   49,   49,   49,   49,   58,   49,    0,    0,
    0,    0,   49,    0,    0,   49,   49,   49,   49,    0,
    0,    0,    0,   57,    0,    0,    0,    0,    0,    0,
   57,   57,    0,   57,    0,    0,    0,    0,   57,   57,
   57,    0,    0,   57,   57,   57,   57,   57,   57,   57,
   57,    0,    0,   57,   57,   57,   57,    0,    0,   57,
   57,   57,   57,   57,   40,   57,    0,    0,    0,    0,
   57,   52,    0,   57,   57,   57,   57,    0,   52,   52,
    0,   52,    0,    0,    0,    0,   52,   52,   52,    0,
    0,   52,   52,    0,    0,   52,   52,   52,   52,    0,
    0,   52,   52,   52,   52,   52,   52,   52,   52,   52,
   52,   52,   41,   52,    0,    0,    0,    0,   52,   53,
    0,   52,   52,   52,   52,    0,   53,   53,    0,   53,
    0,    0,    0,    0,   53,   53,   53,    0,    0,   53,
   53,    0,    0,   53,   53,   53,   53,    0,    0,   53,
   53,   53,   53,   53,   53,   53,   53,   53,   53,   53,
   42,   53,    0,    0,    0,    0,   53,   50,    0,   53,
   53,   53,   53,    0,   50,   50,    0,   50,    0,    0,
    0,    0,   50,   50,   50,    0,    0,   50,   50,    0,
    0,   50,   50,   50,   50,    0,    0,   50,   50,   50,
   50,   50,   50,   50,   50,   50,   50,   50,   54,   50,
    0,    0,    0,    0,   50,   51,    0,   50,   50,   50,
   50,    0,   51,   51,    0,   51,    0,    0,    0,    0,
   51,   51,   51,    0,    0,   51,   51,    0,    0,   51,
   51,   51,   51,    0,    0,   51,   51,   51,   51,   51,
   51,   51,   51,   51,   51,   51,   56,   51,    0,    0,
    0,    0,   51,   58,    0,   51,   51,   51,   51,    0,
   58,   58,    0,   58,    0,    0,    0,    0,   58,   58,
   58,    0,    0,   58,   58,   58,   58,   58,   58,   58,
   58,    0,    0,   58,   58,   58,   58,    0,    0,   58,
   58,   58,   58,   58,   55,   58,    0,    0,    0,    0,
   58,    0,    0,   58,   58,   58,   58,    0,    0,    0,
    0,   40,    0,    0,    0,    0,    0,    0,   40,   40,
    0,   40,    0,    0,    0,    0,   40,   40,   40,    0,
    0,   40,   40,   40,   40,   95,    0,    0,   40,    0,
    0,   40,   40,   40,   40,   40,   40,   40,   40,   40,
   40,   40,    0,   40,   92,    0,    0,    0,   40,   41,
    0,   40,   40,   40,   40,    0,   41,   41,    0,   41,
    0,    0,    0,    0,   41,   41,   41,    0,    0,   41,
   41,   41,   41,    0,    0,    0,   41,    0,    0,   41,
   41,   41,   41,   41,   41,   41,   41,   41,   41,   41,
    0,   41,    0,    0,    0,    0,   41,   42,    0,   41,
   41,   41,   41,    0,   42,   42,    0,   42,    0,    0,
    0,    0,   42,   42,   42,    0,    0,   42,   42,   42,
   42,    0,    0,    0,   42,    0,    0,   42,   42,   42,
   42,   42,   42,   42,   42,   42,   42,   42,    0,   42,
    0,    0,    0,    0,   42,   54,    0,   42,   42,   42,
   42,    0,   54,   54,    0,   54,    0,    0,    0,    0,
   54,   54,   54,    0,    0,   54,   54,   54,   54,   54,
   54,   54,   54,    0,    0,    0,    0,    0,    0,   54,
   54,   54,   54,   54,   54,   54,    0,   54,    0,    0,
    0,    0,   54,   56,    0,   54,   54,   54,   54,    0,
   56,   56,    0,   56,    0,    0,    0,    0,   56,   56,
   56,    0,    0,   56,   56,   56,   56,   56,   56,   56,
   56,    0,    0,    0,    0,    0,    0,   56,   56,   56,
   56,   56,   56,   56,    0,   56,    0,    0,    0,    0,
   56,   55,    0,   56,   56,   56,   56,    0,   55,   55,
    0,   55,    0,    0,    0,    0,   55,   55,   55,    0,
    0,   55,   55,   55,   55,   55,   55,   55,   55,    0,
    0,    0,    0,    0,    0,   55,   55,   55,   55,   55,
   55,   55,   95,   55,    0,    0,    0,    0,   55,   95,
   95,   55,   55,   55,   55,    0,    0,    0,   95,   95,
    0,   92,    0,    0,    0,  112,  113,  114,   92,   92,
  153,    0,    3,  115,    0,    0,    0,   92,   92,    0,
    0,    0,    0,    0,   95,    0,    0,   29,    0,   95,
    0,    0,    0,   95,    0,    0,    0,    0,    0,  112,
  113,  114,   30,   31,  175,    0,    3,  115,   92,    0,
    0,  116,   92,    0,   32,   33,   34,   35,  112,  113,
  114,   29,    0,  190,    0,    3,  115,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   30,   31,    0,    0,
   29,    0,    0,    0,    0,  116,    0,    0,   32,   33,
   34,   35,  112,  113,  114,   30,   31,  192,    0,    3,
  115,    0,    0,    0,  116,    0,    0,   32,   33,   34,
   35,  112,  113,  114,   29,    0,    0,    0,    3,  115,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   30,
   31,    0,    0,   29,    0,    0,    0,    0,  116,    0,
    0,   32,   33,   34,   35,    0,    0,    0,   30,   31,
    0,    0,    0,    0,    0,    0,    0,  116,    0,    0,
   32,   33,   34,   35,   25,   25,   25,   25,   25,   25,
   25,   25,    0,    0,   25,   25,   25,   25,   25,    0,
   25,   25,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   25,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         22,
    0,   82,   54,   54,   27,   60,   61,  307,   31,  126,
  127,  270,   29,   30,  292,  270,  271,  296,  297,  257,
   31,   80,  300,   82,  303,    0,  264,  265,  280,  305,
  309,  310,  299,  296,    9,  273,  274,  304,   90,   90,
  303,   93,  307,  295,  296,  304,  309,  310,    0,  304,
  277,  278,  169,  170,   71,  307,  308,  309,  310,  307,
   83,  112,  113,  297,  181,  299,  304,  126,  127,  186,
  308,  279,  280,   84,  191,  130,  287,  288,  289,  290,
  161,  162,   93,  292,   95,  280,   72,   73,   74,   75,
  292,  114,  115,  263,  298,  176,    0,  291,  292,  180,
  295,  296,  161,  162,  281,  282,  283,  188,  159,  298,
  169,  170,  307,  308,  309,  310,  167,  176,   68,   69,
   70,  180,  181,  146,  309,  310,  296,  186,  299,  188,
  309,  310,  191,  298,  304,  158,  304,  307,  308,  298,
  310,  307,  308,  300,    0,  258,  259,  260,  171,  293,
  173,  284,  265,  266,  177,  268,  269,   66,   67,  304,
  183,  296,  185,  258,  259,  260,  294,  280,  263,  304,
  265,  266,  307,  308,  297,  310,   76,   77,  299,  304,
  307,  307,  295,  296,  304,  280,  304,  297,  304,  304,
  304,  304,    0,  304,  307,  308,  309,  310,  304,  297,
  295,  296,  270,  297,  276,  304,  263,  267,  271,  304,
  257,  304,  307,  308,  309,  310,  277,  278,  279,  280,
  281,  282,  283,  284,  270,  257,  287,  288,  289,  290,
  291,  292,  293,  294,  272,  296,  297,  304,    0,  304,
    0,  263,  303,  263,    9,   62,  304,   78,  309,  310,
   79,  177,   28,   90,   -1,   -1,   -1,  257,   -1,   -1,
   -1,   -1,   -1,   -1,  264,  265,   -1,  267,   -1,   -1,
  270,  271,  272,  273,  274,   -1,  276,  277,  278,  279,
  280,  281,  282,  283,  284,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,    0,  299,
   -1,   -1,   -1,   -1,  304,  257,   -1,  307,  308,  309,
  310,   -1,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,  279,  280,  281,
  282,  283,  284,   -1,   -1,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,    0,  299,  300,   -1,
   -1,   -1,  304,  257,   -1,  307,  308,  309,  310,   -1,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,  279,  280,  281,  282,  283,
   -1,   -1,   -1,  287,  288,  289,  290,  291,  292,  293,
  294,  295,  296,  297,    0,  299,   -1,   -1,   -1,   -1,
  304,  257,   -1,  307,  308,  309,  310,   -1,  264,  265,
   -1,  267,   -1,   -1,   -1,   -1,  272,  273,  274,   -1,
   -1,  277,  278,  279,  280,  281,  282,  283,  284,   -1,
   -1,  287,  288,  289,  290,  291,  292,   -1,  294,  295,
  296,  297,    0,  299,   -1,   -1,   -1,   -1,  304,  257,
   -1,  307,  308,  309,  310,   -1,  264,  265,   -1,  267,
   -1,   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,
  278,  279,  280,  281,  282,  283,  284,   -1,   -1,  287,
  288,  289,  290,  291,  292,  293,   -1,  295,  296,  297,
    0,  299,   -1,   -1,   -1,   -1,  304,  257,   -1,  307,
  308,  309,  310,   -1,  264,  265,   -1,  267,   -1,   -1,
   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,  279,
  280,  281,  282,  283,  284,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,    0,   -1,
   -1,   -1,   -1,   -1,  304,   -1,   -1,  307,  308,  309,
  310,   -1,   -1,   -1,   -1,  257,   -1,   -1,   -1,   -1,
   -1,   -1,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,  279,  280,  281,
  282,  283,   -1,   -1,   -1,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,    0,  299,   -1,   -1,
   -1,   -1,  304,  257,   -1,  307,  308,  309,  310,   -1,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,  279,  280,  281,  282,  283,
   -1,   -1,   -1,  287,  288,  289,  290,  291,  292,  293,
  294,  295,  296,  297,    0,  299,   -1,   -1,   -1,   -1,
  304,  257,   -1,  307,  308,  309,  310,   -1,  264,  265,
   -1,  267,   -1,   -1,   -1,   -1,  272,  273,  274,   -1,
   -1,  277,  278,  279,  280,  281,  282,  283,   -1,   -1,
   -1,  287,  288,  289,  290,  291,  292,  293,  294,  295,
  296,  297,    0,  299,   -1,   -1,   -1,   -1,  304,  257,
   -1,  307,  308,  309,  310,   -1,  264,  265,   -1,  267,
   -1,   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,
  278,  279,  280,  281,  282,  283,  284,   -1,   -1,  287,
  288,  289,  290,  291,  292,   -1,  294,  295,  296,  297,
    0,  299,   -1,   -1,   -1,   -1,  304,  257,   -1,  307,
  308,  309,  310,   -1,  264,  265,   -1,  267,   -1,   -1,
   -1,   -1,  272,  273,  274,   -1,   -1,   -1,   -1,  279,
  280,  281,  282,  283,  284,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,    0,  299,
   -1,   -1,   -1,   -1,  304,  257,   -1,  307,  308,  309,
  310,   -1,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,   -1,   -1,  281,
  282,  283,  284,   -1,   -1,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,    0,  299,   -1,   -1,
   -1,   -1,  304,   -1,   -1,  307,  308,  309,  310,   -1,
   -1,   -1,   -1,  257,   -1,   -1,   -1,   -1,   -1,   -1,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,  279,  280,  281,  282,  283,
  284,   -1,   -1,  287,  288,  289,  290,   -1,   -1,  293,
  294,  295,  296,  297,    0,  299,   -1,   -1,   -1,   -1,
  304,  257,   -1,  307,  308,  309,  310,   -1,  264,  265,
   -1,  267,   -1,   -1,   -1,   -1,  272,  273,  274,   -1,
   -1,  277,  278,   -1,   -1,  281,  282,  283,  284,   -1,
   -1,  287,  288,  289,  290,  291,  292,  293,  294,  295,
  296,  297,    0,  299,   -1,   -1,   -1,   -1,  304,  257,
   -1,  307,  308,  309,  310,   -1,  264,  265,   -1,  267,
   -1,   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,
  278,   -1,   -1,  281,  282,  283,  284,   -1,   -1,  287,
  288,  289,  290,  291,  292,  293,  294,  295,  296,  297,
    0,  299,   -1,   -1,   -1,   -1,  304,  257,   -1,  307,
  308,  309,  310,   -1,  264,  265,   -1,  267,   -1,   -1,
   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,   -1,
   -1,  281,  282,  283,  284,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,    0,  299,
   -1,   -1,   -1,   -1,  304,  257,   -1,  307,  308,  309,
  310,   -1,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,   -1,   -1,  281,
  282,  283,  284,   -1,   -1,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,    0,  299,   -1,   -1,
   -1,   -1,  304,  257,   -1,  307,  308,  309,  310,   -1,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,  279,  280,  281,  282,  283,
  284,   -1,   -1,  287,  288,  289,  290,   -1,   -1,  293,
  294,  295,  296,  297,    0,  299,   -1,   -1,   -1,   -1,
  304,   -1,   -1,  307,  308,  309,  310,   -1,   -1,   -1,
   -1,  257,   -1,   -1,   -1,   -1,   -1,   -1,  264,  265,
   -1,  267,   -1,   -1,   -1,   -1,  272,  273,  274,   -1,
   -1,  277,  278,  279,  280,    0,   -1,   -1,  284,   -1,
   -1,  287,  288,  289,  290,  291,  292,  293,  294,  295,
  296,  297,   -1,  299,    0,   -1,   -1,   -1,  304,  257,
   -1,  307,  308,  309,  310,   -1,  264,  265,   -1,  267,
   -1,   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,
  278,  279,  280,   -1,   -1,   -1,  284,   -1,   -1,  287,
  288,  289,  290,  291,  292,  293,  294,  295,  296,  297,
   -1,  299,   -1,   -1,   -1,   -1,  304,  257,   -1,  307,
  308,  309,  310,   -1,  264,  265,   -1,  267,   -1,   -1,
   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,  279,
  280,   -1,   -1,   -1,  284,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,   -1,  299,
   -1,   -1,   -1,   -1,  304,  257,   -1,  307,  308,  309,
  310,   -1,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,  279,  280,  281,
  282,  283,  284,   -1,   -1,   -1,   -1,   -1,   -1,  291,
  292,  293,  294,  295,  296,  297,   -1,  299,   -1,   -1,
   -1,   -1,  304,  257,   -1,  307,  308,  309,  310,   -1,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,  279,  280,  281,  282,  283,
  284,   -1,   -1,   -1,   -1,   -1,   -1,  291,  292,  293,
  294,  295,  296,  297,   -1,  299,   -1,   -1,   -1,   -1,
  304,  257,   -1,  307,  308,  309,  310,   -1,  264,  265,
   -1,  267,   -1,   -1,   -1,   -1,  272,  273,  274,   -1,
   -1,  277,  278,  279,  280,  281,  282,  283,  284,   -1,
   -1,   -1,   -1,   -1,   -1,  291,  292,  293,  294,  295,
  296,  297,  257,  299,   -1,   -1,   -1,   -1,  304,  264,
  265,  307,  308,  309,  310,   -1,   -1,   -1,  273,  274,
   -1,  257,   -1,   -1,   -1,  258,  259,  260,  264,  265,
  263,   -1,  265,  266,   -1,   -1,   -1,  273,  274,   -1,
   -1,   -1,   -1,   -1,  299,   -1,   -1,  280,   -1,  304,
   -1,   -1,   -1,  308,   -1,   -1,   -1,   -1,   -1,  258,
  259,  260,  295,  296,  263,   -1,  265,  266,  304,   -1,
   -1,  304,  308,   -1,  307,  308,  309,  310,  258,  259,
  260,  280,   -1,  263,   -1,  265,  266,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  295,  296,   -1,   -1,
  280,   -1,   -1,   -1,   -1,  304,   -1,   -1,  307,  308,
  309,  310,  258,  259,  260,  295,  296,  263,   -1,  265,
  266,   -1,   -1,   -1,  304,   -1,   -1,  307,  308,  309,
  310,  258,  259,  260,  280,   -1,   -1,   -1,  265,  266,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  295,
  296,   -1,   -1,  280,   -1,   -1,   -1,   -1,  304,   -1,
   -1,  307,  308,  309,  310,   -1,   -1,   -1,  295,  296,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  304,   -1,   -1,
  307,  308,  309,  310,  277,  278,  279,  280,  281,  282,
  283,  284,   -1,   -1,  287,  288,  289,  290,  291,   -1,
  293,  294,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  304,
};
}
final static short YYFINAL=8;
final static short YYMAXTOKEN=310;
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
"COLON","COMMA","DOT","TRUE","FALSE","NIL","NEWLINE","EVENT_NAME_IDENTIFIER",
"RESERVED_IDENTIFIER","IDENTIFIER","SYS_IDENTIFIER","STRING","NUMERIC",
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
"expression : logical_or_expression",
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
"function_declarator : TO IDENTIFIER COLON params NEWLINE statements END",
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
"identifier_list : identifier_list commaq IDENTIFIER",
"identifier_list : IDENTIFIER",
};

//#line 270 "snow.y"

	protected Parser(Reader r) {
	    lexer = new Yylex(r, this);
	  }
	public static void main(String args[]) throws IOException {
	    Parser yyparser = new Parser(new FileReader(args[0]));
	    yyparser.yyparse();    
	  }
//#line 740 "Parser.java"
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
{ yyval = new ParserVal(val_peek(2).sval+"."+val_peek(0).sval); }
break;
case 28:
//#line 84 "snow.y"
{yyval = val_peek(0);}
break;
case 29:
//#line 87 "snow.y"
{yyval=val_peek(0);}
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
case 46:
//#line 123 "snow.y"
{yyval=val_peek(0);}
break;
case 47:
//#line 126 "snow.y"
{yyval=val_peek(0);}
break;
case 49:
//#line 131 "snow.y"
{yyval = val_peek(0);}
break;
case 54:
//#line 139 "snow.y"
{yyval = val_peek(0);}
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
{yyval=val_peek(1);}
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
{yyval=val_peek(1);}
break;
case 66:
//#line 163 "snow.y"
{yyval=val_peek(1);}
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
//#line 181 "snow.y"
{yyval=val_peek(0);}
break;
case 79:
//#line 197 "snow.y"
{ yyval = doForeach(val_peek(6),val_peek(5),val_peek(4),val_peek(3),val_peek(1)); }
break;
case 80:
//#line 201 "snow.y"
{ yyval = val_peek(0); }
break;
case 81:
//#line 202 "snow.y"
{yyval = null; }
break;
case 82:
//#line 206 "snow.y"
{ yyval = val_peek(0); }
break;
case 83:
//#line 207 "snow.y"
{yyval = null; }
break;
case 84:
//#line 211 "snow.y"
{ yyval = new ParserVal(val_peek(2).sval + ":" + val_peek(0).sval); }
break;
case 85:
//#line 212 "snow.y"
{yyval = null; }
break;
case 88:
//#line 221 "snow.y"
{ 
				yyval = createDebugHook(val_peek(5),val_peek(4),val_peek(1));
				}
break;
case 89:
//#line 227 "snow.y"
{yyval = new ParserVal("before"); }
break;
case 90:
//#line 228 "snow.y"
{yyval = new ParserVal("after"); }
break;
case 91:
//#line 232 "snow.y"
{ yyval = createFunction(val_peek(5),val_peek(3),val_peek(1)); }
break;
case 97:
//#line 250 "snow.y"
{ yyval = defineMolecule(val_peek(4),val_peek(1)); }
break;
case 98:
//#line 254 "snow.y"
{yyval = val_peek(0);}
break;
case 99:
//#line 255 "snow.y"
{ yyval= new ParserVal(val_peek(1).sval +val_peek(0).sval); }
break;
case 100:
//#line 259 "snow.y"
{ yyval = moleLazyCreate(val_peek(2),val_peek(1));}
break;
case 101:
//#line 260 "snow.y"
{ yyval = moleCreateOne(val_peek(1));  }
break;
//#line 1147 "Parser.java"
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
