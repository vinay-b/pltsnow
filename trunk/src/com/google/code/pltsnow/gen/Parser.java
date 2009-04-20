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



//#line 1 "snow.y"

import java.lang.Math;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
//#line 23 "Parser.java"




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
   16,   16,   17,   18,   18,   19,   19,   20,   21,   21,
   21,   22,   22,   22,   23,   23,   23,   23,   24,   24,
   25,   25,   25,   25,   25,   26,   26,   26,   27,   27,
   28,   28,   29,   30,   30,   30,   30,   30,   30,   30,
   35,   36,   36,   34,   31,    8,   32,   37,   37,   37,
   33,   33,   33,   40,   40,   39,   39,   41,   41,   38,
   38,    6,   42,   42,    3,    4,   43,   43,   44,   44,
    5,   45,   45,   46,   46,   46,   46,
};
final static short yylen[] = {                            2,
    1,    1,    2,    1,    1,    1,    1,    1,    1,    3,
    1,    1,    1,    0,    5,    5,    5,    3,    3,    1,
    1,    1,    1,    3,    1,    1,    3,    1,    1,    2,
    2,    1,    3,    1,    0,    3,    1,    1,    1,    2,
    2,    1,    3,    3,    3,    3,    3,    1,    1,    3,
    1,    3,    3,    3,    3,    1,    3,    3,    1,    3,
    1,    3,    3,    2,    2,    2,    2,    2,    2,    1,
    2,    1,    2,    1,    1,    1,    3,    3,    5,    5,
    5,   10,    8,    2,    0,    2,    0,    4,    0,    2,
    0,    6,    1,    1,    7,    2,    1,    3,    1,    3,
    6,    1,    2,    3,    2,    2,    1,
};
final static short yydefred[] = {                         0,
    0,    0,    0,   93,   94,    9,    0,    0,    0,    2,
    4,    5,    6,    7,    8,    0,    0,    0,    0,    0,
   97,    0,    3,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   26,   12,   11,   10,   21,   22,   29,   23,
    0,    0,   32,   49,    0,    0,    0,    0,    0,    0,
    0,    0,   38,    0,   37,    0,  100,   98,   40,   41,
    0,    0,    0,    0,    0,   30,   31,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   13,    0,    0,    0,  107,   28,    0,    0,
    0,    0,  102,   24,    0,   18,    0,   33,    0,   27,
    0,    0,    0,    0,    0,   50,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   70,
    0,   75,    0,   74,   72,    0,    0,    0,    0,    0,
    0,    0,   36,    0,    0,  106,  105,  101,  103,    0,
    0,    0,   19,    0,    0,    0,   71,    0,    0,   67,
    0,   64,   65,   66,   68,   69,   92,   73,   95,  104,
   15,   16,   17,    0,    0,    0,    0,    0,   77,   63,
    0,   86,    0,    0,    0,    0,    0,   84,    0,    0,
   81,    0,    0,    0,    0,    0,    0,   80,    0,    0,
    0,    0,   90,    0,   88,   83,    0,   82,
};
final static short yydgoto[] = {                          8,
    9,   10,   11,  121,   13,   14,   15,  122,   37,   85,
   38,   63,   39,   40,   41,   42,   43,   98,   54,   55,
   44,   45,   46,   47,   48,   49,   50,   51,  124,  125,
  126,  127,  128,  129,  130,  131,  149,  190,  166,  174,
  180,   16,   20,   21,   92,   93,
};
final static short yysindex[] = {                      -137,
 -300, -296, -282,    0,    0,    0, -263,    0, -137,    0,
    0,    0,    0,    0,    0, -272, -223, -219, -207, -197,
    0, -170,    0, -192, -170, -196, -170, -282, -170, -170,
 -170, -187,    0,    0,    0,    0,    0,    0,    0,    0,
 -186, -239,    0,    0, -158, -139, -168, -206, -228, -175,
 -164, -172,    0, -277,    0, -276,    0,    0,    0,    0,
 -162, -152, -201, -170, -156,    0,    0, -170, -170, -170,
 -170, -170, -170, -170, -170, -170, -170, -170, -170, -170,
 -170, 1335,    0, 1335, -170, -153,    0,    0, -154, -144,
 -138, -101,    0,    0, -216,    0, -153,    0, -152,    0,
 -139, -139, -168, -168, -168,    0, -158, -158, -158, -158,
 -206, -206, -228, -175, -145, -145, -170, -170, -170,    0,
 -126,    0, -227,    0,    0, -124, -113, -112, -107,  -95,
 -110,  -84,    0, -152,  -89,    0,    0,    0,    0,  -81,
  -76,  -75,    0,  -51,  -53,  -70,    0,  -38,  -35,    0,
 -170,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0, -170, -145,  -36, 1335, 1335,    0,    0,
  -21,    0, -145,  -33, 1261, -218, -170,    0, -170,  -66,
    0, 1335, -170,  -32,   -6, 1335, 1335,    0, -170,  -65,
 -170, 1271,    0, 1335,    0,    0, 1325,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,  242,    0,
    0,    0,    0,    0,    0,    0,    0,    0, 1176, 1195,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   49,    0,    0,    0,    0,    0,    0,    0,    0,
    1,  491,    0,    0,  539,  895,   97, 1039,  597,  145,
  193,    0,    0,  -78,    0,    0,    0,    0,    0,    0,
    0, 1370, -142, 1219,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  241,    0,
  943,  991,  299,  347,  395,    0,  645,  693,  741,  789,
 1087, 1135,  837,  443,    0,    0,    0,    0,    0,    0,
    0,    0,  -34,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0, -266,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0, -247,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0, -252,    0,    0,    0,    0,
    0,    0,    0,  -52,    0,   -2,    0,    0,    0,    0,
    0,    0,    0,  -42,    0,    0,    4,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  254,    0,   16,    0,    0,    0,  -18,  -25,  -60,
  -39,    0,    0,  -56,  -63,    0,    0,    0,  200,  184,
  -15,  113,  115,  134,  135,  196,  205,    0,    0, -121,
    0,    0,    0,    0,    0,  -79,  104,    0,    0,    0,
    0,    0,    0,  273,    0,  210,
};
final static int YYTABLESIZE=1681;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         91,
   25,   95,   97,   36,  132,   62,   53,   17,   57,  158,
  158,   18,   61,   59,   60,   12,   90,   85,  123,   86,
  123,   83,   87,   87,   12,   19,   84,   87,   22,   14,
   20,   88,   33,   24,   89,   91,   14,   66,   67,  115,
  116,  117,  118,   14,   14,   53,    3,  119,   28,  182,
  183,   85,   90,  158,  158,  142,   87,  106,  144,  145,
  134,   29,   78,   79,  151,  158,   53,  123,  123,  141,
  158,  143,   65,   95,   25,  158,   30,   31,   26,   86,
   74,   75,   76,   77,   27,  120,  140,  175,  176,   32,
   33,   34,   35,   34,   35,   96,   48,   83,  146,  147,
  148,   28,  187,  123,  123,   52,  192,   56,  172,   29,
   64,  123,  123,   65,  197,   73,  178,   80,  123,    1,
   68,   69,  123,  123,   30,   31,    2,    3,  123,   81,
  123,   82,  170,  123,   94,    4,    5,   32,   33,   34,
   35,   70,   71,   72,   61,  171,   83,  115,  116,  117,
  118,  100,  157,  135,    3,  119,   34,   35,  184,  136,
  185,  138,   88,   33,  148,  137,    6,   14,   14,   29,
  193,    7,  195,  115,  116,  117,  118,  150,  159,  152,
    3,  119,  101,  102,   30,   31,  107,  108,  109,  110,
  153,  154,   76,  120,   86,   29,  155,   32,   33,   34,
   35,   14,   87,  103,  104,  105,   88,   33,  156,   89,
   30,   31,  111,  112,  160,  161,   14,   14,  164,  120,
  162,  163,  165,   32,   33,   34,   35,  169,  168,   14,
   14,   14,   14,  167,  173,  177,  179,  186,  194,  189,
   34,    1,   25,   25,   25,   25,   25,   25,   25,   25,
  191,   89,   25,   25,   25,   25,   25,   25,   25,   25,
   78,   91,   23,   99,   25,   25,   79,   25,  133,   25,
   25,   25,   25,   25,   25,  113,   25,   25,   25,   25,
   25,   25,   25,   25,   25,  114,  188,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   45,   25,
   58,  139,    0,    0,   25,   28,    0,    0,   25,   25,
   25,   25,   28,   28,    0,   28,    0,    0,    0,    0,
   28,   28,   28,    0,    0,   28,   28,   28,   28,   28,
   28,   28,   28,    0,    0,   28,   28,   28,   28,   28,
   28,   28,   28,   28,   28,   28,   46,   28,   28,    0,
    0,    0,   28,   48,    0,    0,   28,   28,   28,   28,
   48,   48,    0,   48,    0,    0,    0,    0,   48,   48,
   48,    0,    0,   48,   48,   48,   48,   48,   48,   48,
    0,    0,    0,   48,   48,   48,   48,   48,   48,   48,
   48,   48,   48,   48,   47,   48,    0,    0,    0,    0,
   48,   61,    0,    0,   48,   48,   48,   48,   61,   61,
    0,   61,    0,    0,    0,    0,   61,   61,   61,    0,
    0,   61,   61,   61,   61,   61,   61,   61,   61,    0,
    0,   61,   61,   61,   61,   61,   61,    0,   61,   61,
   61,   61,   62,   61,    0,    0,    0,    0,   61,   76,
    0,    0,   61,   61,   61,   61,   76,   76,    0,   76,
    0,    0,    0,    0,   76,   76,   76,    0,    0,   76,
   76,   76,   76,   76,   76,   76,   76,    0,    0,   76,
   76,   76,   76,   76,   76,   76,    0,   76,   76,   76,
   39,   76,    0,    0,    0,    0,   76,   34,    0,    0,
   76,   76,   76,   76,   34,   34,    0,   34,    0,    0,
    0,    0,   34,   34,   34,    0,    0,   34,   34,   34,
   14,   34,   34,   34,   34,    0,    0,   34,   34,   34,
   34,   34,   34,   34,   34,   14,   14,   34,   51,    0,
    0,    0,    0,    0,   34,    0,    0,    0,   14,   14,
   14,   14,    0,    0,    0,   45,    0,    0,    0,    0,
    0,    0,   45,   45,    0,   45,    0,    0,    0,    0,
   45,   45,   45,    0,    0,   45,   45,   45,   45,   45,
   45,   45,    0,    0,    0,   45,   45,   45,   45,   45,
   45,   45,   45,   45,   45,   45,   59,   45,    0,    0,
    0,    0,   45,   46,    0,    0,   45,   45,   45,   45,
   46,   46,    0,   46,    0,    0,    0,    0,   46,   46,
   46,    0,    0,   46,   46,   46,   46,   46,   46,   46,
    0,    0,    0,   46,   46,   46,   46,   46,   46,   46,
   46,   46,   46,   46,   54,   46,    0,    0,    0,    0,
   46,   47,    0,    0,   46,   46,   46,   46,   47,   47,
    0,   47,    0,    0,    0,    0,   47,   47,   47,    0,
    0,   47,   47,   47,   47,   47,   47,   47,    0,    0,
    0,   47,   47,   47,   47,   47,   47,   47,   47,   47,
   47,   47,   55,   47,    0,    0,    0,    0,   47,   62,
    0,    0,   47,   47,   47,   47,   62,   62,    0,   62,
    0,    0,    0,    0,   62,   62,   62,    0,    0,   62,
   62,   62,   62,   62,   62,   62,   62,    0,    0,   62,
   62,   62,   62,   62,   62,    0,   62,   62,   62,   62,
   52,   62,    0,    0,    0,    0,   62,   39,    0,    0,
   62,   62,   62,   62,   39,   39,    0,   39,    0,    0,
    0,    0,   39,   39,   39,    0,    0,    0,    0,   39,
   39,   39,   39,   39,   39,    0,    0,   39,   39,   39,
   39,   39,   39,   39,   39,   39,   39,   39,   53,   39,
    0,    0,    0,    0,   39,   51,    0,    0,   39,   39,
   39,   39,   51,   51,    0,   51,    0,    0,    0,    0,
   51,   51,   51,    0,    0,   51,   51,    0,    0,   51,
   51,   51,   51,    0,    0,   51,   51,   51,   51,   51,
   51,   51,   51,   51,   51,   51,   60,   51,    0,    0,
    0,    0,   51,    0,    0,    0,   51,   51,   51,   51,
    0,    0,    0,   59,    0,    0,    0,    0,    0,    0,
   59,   59,    0,   59,    0,    0,    0,    0,   59,   59,
   59,    0,    0,   59,   59,   59,   59,   59,   59,   59,
   59,    0,    0,   59,   59,   59,   59,    0,    0,   59,
   59,   59,   59,   59,   42,   59,    0,    0,    0,    0,
   59,   54,    0,    0,   59,   59,   59,   59,   54,   54,
    0,   54,    0,    0,    0,    0,   54,   54,   54,    0,
    0,   54,   54,    0,    0,   54,   54,   54,   54,    0,
    0,   54,   54,   54,   54,   54,   54,   54,   54,   54,
   54,   54,   43,   54,    0,    0,    0,    0,   54,   55,
    0,    0,   54,   54,   54,   54,   55,   55,    0,   55,
    0,    0,    0,    0,   55,   55,   55,    0,    0,   55,
   55,    0,    0,   55,   55,   55,   55,    0,    0,   55,
   55,   55,   55,   55,   55,   55,   55,   55,   55,   55,
   44,   55,    0,    0,    0,    0,   55,   52,    0,    0,
   55,   55,   55,   55,   52,   52,    0,   52,    0,    0,
    0,    0,   52,   52,   52,    0,    0,   52,   52,    0,
    0,   52,   52,   52,   52,    0,    0,   52,   52,   52,
   52,   52,   52,   52,   52,   52,   52,   52,   56,   52,
    0,    0,    0,    0,   52,   53,    0,    0,   52,   52,
   52,   52,   53,   53,    0,   53,    0,    0,    0,    0,
   53,   53,   53,    0,    0,   53,   53,    0,    0,   53,
   53,   53,   53,    0,    0,   53,   53,   53,   53,   53,
   53,   53,   53,   53,   53,   53,   58,   53,    0,    0,
    0,    0,   53,   60,    0,    0,   53,   53,   53,   53,
   60,   60,    0,   60,    0,    0,    0,    0,   60,   60,
   60,    0,    0,   60,   60,   60,   60,   60,   60,   60,
   60,    0,    0,   60,   60,   60,   60,    0,    0,   60,
   60,   60,   60,   60,   57,   60,    0,    0,    0,    0,
   60,    0,    0,    0,   60,   60,   60,   60,    0,    0,
    0,   42,    0,    0,    0,    0,    0,    0,   42,   42,
    0,   42,    0,    0,    0,    0,   42,   42,   42,    0,
    0,   42,   42,   42,   42,   99,    0,    0,   42,    0,
    0,   42,   42,   42,   42,   42,   42,   42,   42,   42,
   42,   42,    0,   42,   96,    0,    0,    0,   42,   43,
    0,    0,   42,   42,   42,   42,   43,   43,    0,   43,
    0,    0,    0,    0,   43,   43,   43,    0,   35,   43,
   43,   43,   43,    0,    0,    0,   43,    0,    0,   43,
   43,   43,   43,   43,   43,   43,   43,   43,   43,   43,
    0,   43,    0,    0,    0,    0,   43,   44,    0,    0,
   43,   43,   43,   43,   44,   44,    0,   44,    0,    0,
    0,    0,   44,   44,   44,    0,    0,   44,   44,   44,
   44,    0,    0,    0,   44,    0,    0,   44,   44,   44,
   44,   44,   44,   44,   44,   44,   44,   44,    0,   44,
    0,    0,    0,    0,   44,   56,    0,    0,   44,   44,
   44,   44,   56,   56,    0,   56,    0,    0,    0,    0,
   56,   56,   56,    0,    0,   56,   56,   56,   56,   56,
   56,   56,   56,    0,    0,    0,    0,    0,    0,   56,
   56,   56,   56,   56,   56,   56,    0,   56,    0,    0,
    0,    0,   56,   58,    0,    0,   56,   56,   56,   56,
   58,   58,    0,   58,    0,    0,    0,    0,   58,   58,
   58,    0,    0,   58,   58,   58,   58,   58,   58,   58,
   58,    0,    0,    0,    0,    0,    0,   58,   58,   58,
   58,   58,   58,   58,    0,   58,    0,    0,    0,    0,
   58,   57,    0,    0,   58,   58,   58,   58,   57,   57,
    0,   57,    0,    0,    0,    0,   57,   57,   57,    0,
    0,   57,   57,   57,   57,   57,   57,   57,   57,    0,
    0,    0,    0,    0,    0,   57,   57,   57,   57,   57,
   57,   57,   99,   57,    0,    0,    0,    0,   57,   99,
   99,    0,   57,   57,   57,   57,    0,    0,   99,   99,
    0,   96,    0,    0,    0,    0,    0,    0,   96,   96,
    0,    0,    0,    0,    0,    0,    0,   96,   96,    0,
    0,    0,    0,    0,   99,   35,    0,    0,    0,   99,
    0,    0,   35,   35,   99,   35,    0,    0,    0,    0,
   35,   35,   35,    0,    0,   35,   35,   35,   96,   35,
   35,   35,   35,   96,    0,   35,   35,   35,   35,   35,
   35,   35,   35,    0,    0,   35,    0,   35,  115,  116,
  117,  118,   35,  181,    0,    3,  119,    0,  115,  116,
  117,  118,    0,  196,    0,    3,  119,    0,    0,    0,
   29,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   29,    0,    0,    0,    0,   30,   31,    0,    0,    0,
    0,    0,    0,    0,  120,   30,   31,    0,   32,   33,
   34,   35,    0,    0,  120,    0,    0,    0,   32,   33,
   34,   35,  115,  116,  117,  118,    0,  198,    0,    3,
  119,    0,  115,  116,  117,  118,    0,    0,    0,    3,
  119,    0,    0,    0,   29,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   29,    0,    0,    0,    0,   30,
   31,    0,    0,    0,    0,    0,    0,    0,  120,   30,
   31,    0,   32,   33,   34,   35,    0,    0,  120,    0,
    0,    0,   32,   33,   34,   35,   21,   21,   21,   21,
   21,   21,   21,   21,    0,    0,   21,   21,   21,   21,
   21,   21,   21,   21,    0,   14,   20,    0,    0,    0,
    0,    0,   14,    0,    0,    0,    0,    0,    0,   14,
   14,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         56,
    0,   62,   63,   22,   84,   31,   25,  308,   27,  131,
  132,  308,   31,   29,   30,    0,   56,  270,   82,  296,
   84,  299,  270,  271,    9,  308,  304,  304,  292,  296,
  297,  308,  309,  306,  311,   92,  303,  277,  278,  258,
  259,  260,  261,  310,  311,   64,  265,  266,    0,  268,
  269,  304,   92,  175,  176,   95,  304,   73,  115,  116,
   86,  280,  291,  292,  292,  187,   85,  131,  132,   95,
  192,   97,  300,  134,  298,  197,  295,  296,  298,  296,
  287,  288,  289,  290,  292,  304,  303,  167,  168,  308,
  309,  310,  311,  310,  311,  297,    0,  299,  117,  118,
  119,  299,  182,  167,  168,  298,  186,  304,  165,  280,
  298,  175,  176,  300,  194,  284,  173,  293,  182,  257,
  279,  280,  186,  187,  295,  296,  264,  265,  192,  294,
  194,  304,  151,  197,  297,  273,  274,  308,  309,  310,
  311,  281,  282,  283,    0,  164,  299,  258,  259,  260,
  261,  308,  263,  308,  265,  266,  310,  311,  177,  304,
  179,  263,  308,  309,  183,  304,  304,  310,  311,  280,
  189,  309,  191,  258,  259,  260,  261,  304,  263,  304,
  265,  266,   68,   69,  295,  296,   74,   75,   76,   77,
  304,  304,    0,  304,  296,  280,  304,  308,  309,  310,
  311,  280,  304,   70,   71,   72,  308,  309,  304,  311,
  295,  296,   78,   79,  304,  297,  295,  296,  270,  304,
  297,  297,  276,  308,  309,  310,  311,  263,  267,  308,
  309,  310,  311,  304,  271,  257,  270,  304,  304,  272,
    0,    0,  277,  278,  279,  280,  281,  282,  283,  284,
  257,  304,  287,  288,  289,  290,  291,  257,  293,  294,
  263,  304,    9,   64,  264,  265,  263,  267,   85,  304,
  270,  271,  272,  273,  274,   80,  276,  277,  278,  279,
  280,  281,  282,  283,  284,   81,  183,  287,  288,  289,
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
   -1,   -1,   -1,   -1,  304,   -1,   -1,   -1,  308,  309,
  310,  311,   -1,   -1,   -1,  257,   -1,   -1,   -1,   -1,
   -1,   -1,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
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
   -1,   -1,   -1,   -1,  272,  273,  274,   -1,    0,  277,
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
   -1,  257,   -1,   -1,   -1,   -1,   -1,   -1,  264,  265,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  273,  274,   -1,
   -1,   -1,   -1,   -1,  299,  257,   -1,   -1,   -1,  304,
   -1,   -1,  264,  265,  309,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,  279,  304,  281,
  282,  283,  284,  309,   -1,  287,  288,  289,  290,  291,
  292,  293,  294,   -1,   -1,  297,   -1,  299,  258,  259,
  260,  261,  304,  263,   -1,  265,  266,   -1,  258,  259,
  260,  261,   -1,  263,   -1,  265,  266,   -1,   -1,   -1,
  280,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  280,   -1,   -1,   -1,   -1,  295,  296,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  304,  295,  296,   -1,  308,  309,
  310,  311,   -1,   -1,  304,   -1,   -1,   -1,  308,  309,
  310,  311,  258,  259,  260,  261,   -1,  263,   -1,  265,
  266,   -1,  258,  259,  260,  261,   -1,   -1,   -1,  265,
  266,   -1,   -1,   -1,  280,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  280,   -1,   -1,   -1,   -1,  295,
  296,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  304,  295,
  296,   -1,  308,  309,  310,  311,   -1,   -1,  304,   -1,
   -1,   -1,  308,  309,  310,  311,  277,  278,  279,  280,
  281,  282,  283,  284,   -1,   -1,  287,  288,  289,  290,
  291,  292,  293,  294,   -1,  296,  297,   -1,   -1,   -1,
   -1,   -1,  303,   -1,   -1,   -1,   -1,   -1,   -1,  310,
  311,
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
"function_expression : IDENTIFIER COLON params_opt",
"params_opt : params",
"params_opt :",
"params : params commaq param",
"params : param",
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
"statement : return_statement NEWLINE",
"statement : NEWLINE",
"return_statement : RETURN expression",
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
};

//#line 273 "snow.y"


	protected Parser(Reader r) {
	    lexer = new Yylex(r, this);
	  }
	public static void main(String args[]) throws IOException {
	    Parser yyparser = new Parser(new FileReader(args[0]));
	    yyparser.yyparse();    
	  }
//#line 754 "Parser.java"
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
System.out.println("public static void main(String[] args) {	SnowProgramImp this_prog = new SnowProgramImp(); this_prog.startProgram();}");
System.out.println("}");
}
break;
case 2:
//#line 31 "snow.y"
{yyval=val_peek(0);}
break;
case 3:
//#line 32 "snow.y"
{yyval = new ParserVal(val_peek(1).sval + val_peek(0).sval);}
break;
case 4:
//#line 36 "snow.y"
{yyval=val_peek(0);}
break;
case 5:
//#line 37 "snow.y"
{yyval=val_peek(0);}
break;
case 6:
//#line 38 "snow.y"
{yyval=val_peek(0);}
break;
case 7:
//#line 39 "snow.y"
{yyval=val_peek(0);}
break;
case 8:
//#line 40 "snow.y"
{yyval=val_peek(0);}
break;
case 9:
//#line 41 "snow.y"
{yyval=val_peek(0);}
break;
case 10:
//#line 45 "snow.y"
{ yyval = assignVariable(val_peek(2),val_peek(0)); }
break;
case 11:
//#line 49 "snow.y"
{yyval.sval= "new SnowAtom("+val_peek(0).sval+")";}
break;
case 12:
//#line 50 "snow.y"
{yyval.sval= "new SnowAtom("+val_peek(0).sval+")";}
break;
case 13:
//#line 54 "snow.y"
{yyval= new ParserVal(",");}
break;
case 14:
//#line 55 "snow.y"
{yyval=new ParserVal(",");}
break;
case 21:
//#line 72 "snow.y"
{yyval=val_peek(0);}
break;
case 22:
//#line 73 "snow.y"
{yyval=val_peek(0);}
break;
case 23:
//#line 74 "snow.y"
{yyval=val_peek(0);}
break;
case 24:
//#line 75 "snow.y"
{yyval.sval = "(" + val_peek(1).sval + ")";}
break;
case 25:
//#line 79 "snow.y"
{yyval= val_peek(0);}
break;
case 26:
//#line 80 "snow.y"
{ yyval = new ParserVal("symbols.get(\""+val_peek(0).sval+"\")");}
break;
case 27:
//#line 84 "snow.y"
{ yyval = buildCompoundIdentifier(val_peek(2),val_peek(0)); }
break;
case 28:
//#line 85 "snow.y"
{yyval = val_peek(0);}
break;
case 29:
//#line 88 "snow.y"
{yyval=val_peek(0);}
break;
case 30:
//#line 89 "snow.y"
{yyval = doOp("plus",val_peek(1),new ParserVal(1)); }
break;
case 31:
//#line 90 "snow.y"
{yyval = doOp("minus",val_peek(1),new ParserVal(1)); }
break;
case 32:
//#line 91 "snow.y"
{yyval=val_peek(0);}
break;
case 33:
//#line 95 "snow.y"
{ yyval = executeFunction(val_peek(2),val_peek(0)); }
break;
case 34:
//#line 98 "snow.y"
{yyval = val_peek(0);}
break;
case 35:
//#line 99 "snow.y"
{yyval.sval = "";}
break;
case 36:
//#line 103 "snow.y"
{yyval = new ParserVal(val_peek(2).sval+","+val_peek(0).sval);}
break;
case 37:
//#line 104 "snow.y"
{yyval = val_peek(0);}
break;
case 38:
//#line 108 "snow.y"
{yyval = val_peek(0); }
break;
case 39:
//#line 112 "snow.y"
{yyval=val_peek(0);}
break;
case 40:
//#line 113 "snow.y"
{yyval = doOp("minus",new ParserVal(0),val_peek(0));}
break;
case 41:
//#line 114 "snow.y"
{yyval = doOp("log_not",val_peek(0),null);}
break;
case 42:
//#line 119 "snow.y"
{yyval=val_peek(0);}
break;
case 43:
//#line 120 "snow.y"
{yyval = doOp("plus",val_peek(2),val_peek(0));}
break;
case 44:
//#line 121 "snow.y"
{yyval = doOp("minus",val_peek(2),val_peek(0));}
break;
case 45:
//#line 125 "snow.y"
{yyval = doOp("times",val_peek(2),val_peek(0));}
break;
case 46:
//#line 126 "snow.y"
{yyval = doOp("divide",val_peek(2),val_peek(0));}
break;
case 47:
//#line 127 "snow.y"
{yyval = doOp("modulo",val_peek(2),val_peek(0));}
break;
case 48:
//#line 128 "snow.y"
{yyval=val_peek(0);}
break;
case 49:
//#line 131 "snow.y"
{yyval=val_peek(0);}
break;
case 50:
//#line 132 "snow.y"
{yyval = doOp("power",val_peek(2),val_peek(0));}
break;
case 51:
//#line 136 "snow.y"
{yyval = val_peek(0);}
break;
case 52:
//#line 137 "snow.y"
{yyval = doOp("lt",val_peek(2),val_peek(0));}
break;
case 53:
//#line 138 "snow.y"
{yyval = doOp("gt",val_peek(2),val_peek(0));}
break;
case 54:
//#line 139 "snow.y"
{yyval = doOp("le",val_peek(2),val_peek(0));}
break;
case 55:
//#line 140 "snow.y"
{yyval = doOp("ge",val_peek(2),val_peek(0));}
break;
case 56:
//#line 144 "snow.y"
{yyval = val_peek(0);}
break;
case 57:
//#line 145 "snow.y"
{yyval = doOp("equals",val_peek(2),val_peek(0));}
break;
case 58:
//#line 146 "snow.y"
{yyval = doOp("nequals",val_peek(2),val_peek(0));}
break;
case 59:
//#line 150 "snow.y"
{yyval=val_peek(0);}
break;
case 60:
//#line 151 "snow.y"
{yyval = doOp("log_and",val_peek(1),null);}
break;
case 61:
//#line 155 "snow.y"
{yyval=val_peek(0);}
break;
case 62:
//#line 156 "snow.y"
{yyval = doOp("log_or",val_peek(1),null);}
break;
case 63:
//#line 160 "snow.y"
{ yyval = assignVariable(val_peek(2),val_peek(0)); }
break;
case 64:
//#line 164 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 65:
//#line 165 "snow.y"
{yyval=val_peek(1);}
break;
case 66:
//#line 166 "snow.y"
{yyval=val_peek(1);}
break;
case 67:
//#line 167 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 68:
//#line 168 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 69:
//#line 169 "snow.y"
{yyval=val_peek(1);}
break;
case 71:
//#line 173 "snow.y"
{yyval.sval = "return " +  val_peek(0).sval + ";\n";}
break;
case 72:
//#line 176 "snow.y"
{ yyval=val_peek(0); }
break;
case 73:
//#line 177 "snow.y"
{yyval =new ParserVal(val_peek(1).sval+val_peek(0).sval);}
break;
case 74:
//#line 181 "snow.y"
{yyval=val_peek(0);}
break;
case 75:
//#line 185 "snow.y"
{yyval=val_peek(0);}
break;
case 76:
//#line 189 "snow.y"
{yyval=val_peek(0);}
break;
case 77:
//#line 193 "snow.y"
{ yyval = makeFullIfStatement(val_peek(1)); }
break;
case 78:
//#line 197 "snow.y"
{yyval = makePartialIfElse(val_peek(2),val_peek(0), null);}
break;
case 79:
//#line 198 "snow.y"
{yyval = makePartialIfElse(val_peek(4),val_peek(2), val_peek(0));}
break;
case 80:
//#line 199 "snow.y"
{yyval = makePartialIfElseIf(val_peek(4),val_peek(2), val_peek(0));}
break;
case 81:
//#line 203 "snow.y"
{ yyval = doWhile(val_peek(3),val_peek(1)); }
break;
case 82:
//#line 204 "snow.y"
{ yyval = doFor(val_peek(8),val_peek(6),val_peek(4),val_peek(3),val_peek(1)); }
break;
case 83:
//#line 205 "snow.y"
{ yyval = doForeach(val_peek(6),val_peek(5),val_peek(4),val_peek(3),val_peek(1)); }
break;
case 84:
//#line 209 "snow.y"
{ yyval = val_peek(0); }
break;
case 85:
//#line 210 "snow.y"
{yyval = null; }
break;
case 86:
//#line 214 "snow.y"
{ yyval = val_peek(0); }
break;
case 87:
//#line 215 "snow.y"
{yyval = null; }
break;
case 88:
//#line 219 "snow.y"
{ yyval = new ParserVal(val_peek(2).sval + ":" + val_peek(0).sval); }
break;
case 89:
//#line 220 "snow.y"
{yyval = null; }
break;
case 90:
//#line 224 "snow.y"
{ yyval = val_peek(0);}
break;
case 91:
//#line 225 "snow.y"
{ yyval = null;}
break;
case 92:
//#line 229 "snow.y"
{ 
				yyval = createDebugHook(val_peek(5),val_peek(4),val_peek(1));
				}
break;
case 93:
//#line 235 "snow.y"
{yyval = new ParserVal("before"); }
break;
case 94:
//#line 236 "snow.y"
{yyval = new ParserVal("after"); }
break;
case 95:
//#line 240 "snow.y"
{ yyval = createFunction(val_peek(5),val_peek(3),val_peek(1)); }
break;
case 96:
//#line 243 "snow.y"
{yyval = val_peek(0);}
break;
case 97:
//#line 247 "snow.y"
{yyval = val_peek(0);}
break;
case 98:
//#line 248 "snow.y"
{yyval.sval = val_peek(2).sval +val_peek(0).sval;}
break;
case 99:
//#line 252 "snow.y"
{ yyval = declareLocalVariable(val_peek(0)); }
break;
case 100:
//#line 253 "snow.y"
{ yyval = declareLocalVariable(val_peek(2),val_peek(0)); }
break;
case 101:
//#line 257 "snow.y"
{ yyval = defineMolecule(val_peek(4),val_peek(1)); }
break;
case 102:
//#line 261 "snow.y"
{yyval = val_peek(0);}
break;
case 103:
//#line 262 "snow.y"
{ yyval= new ParserVal(val_peek(1).sval +val_peek(0).sval); }
break;
case 104:
//#line 266 "snow.y"
{ yyval = moleLazyCreate(val_peek(2),val_peek(1));}
break;
case 105:
//#line 267 "snow.y"
{ yyval = moleCreateOne(val_peek(1));  }
break;
//#line 1306 "Parser.java"
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
