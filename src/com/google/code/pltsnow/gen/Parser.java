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
/*Authored by Jon, Cesar, Vinay, Sharadh*/
//#line 24 "Parser.java"




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
    0,    1,    1,    2,    2,    2,    2,    2,    2,    2,
    2,    7,    9,    9,    9,   10,   10,   11,   11,   11,
   11,   12,   12,   13,   13,   13,   13,   14,   14,   15,
   15,   16,   16,   16,   16,   17,   18,   18,   19,   19,
   20,   21,   21,   21,   22,   22,   22,   23,   23,   23,
   23,   24,   24,   25,   25,   25,   25,   25,   26,   26,
   26,   27,   27,   28,   28,   29,   30,   30,   30,   30,
   30,   30,   30,   30,   35,   36,   36,   34,   31,    8,
   32,   37,   37,   37,   33,   33,   33,   40,   40,   39,
   39,   41,   41,   38,   38,    6,   42,   42,    3,    4,
   43,   43,   44,   44,    5,   45,   45,   46,   46,   46,
   46,
};
final static short yylen[] = {                            2,
    1,    1,    2,    1,    1,    1,    1,    1,    1,    1,
    2,    3,    1,    1,    1,    1,    0,    5,    5,    5,
    3,    3,    1,    1,    1,    1,    3,    1,    1,    3,
    1,    1,    2,    2,    1,    3,    1,    0,    3,    1,
    1,    1,    2,    2,    1,    3,    3,    3,    3,    3,
    1,    1,    3,    1,    3,    3,    3,    3,    1,    3,
    3,    1,    3,    1,    3,    3,    2,    2,    2,    2,
    2,    2,    1,    2,    2,    1,    2,    1,    1,    1,
    3,    3,    5,    5,    5,   10,    8,    2,    0,    2,
    0,    4,    0,    2,    0,    6,    1,    1,    7,    2,
    1,    3,    1,    3,    6,    1,    2,    3,    2,    2,
    1,
};
final static short yydefred[] = {                         0,
    0,    0,   10,    0,    0,   97,   98,    9,    0,    0,
    0,    2,    4,    5,    6,    7,    8,    0,   11,    0,
    0,    0,    0,  101,    0,    3,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   29,   14,   13,   12,   24,
   25,   32,   26,    0,    0,   35,   52,    0,    0,    0,
    0,    0,    0,    0,    0,   41,    0,   40,    0,  104,
  102,   43,   44,    0,    0,    0,    0,    0,   33,   34,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   16,    0,    0,    0,  111,
   31,    0,    0,    0,    0,  106,   27,    0,   21,    0,
   36,    0,   30,    0,    0,    0,    0,    0,   53,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   73,    0,   79,    0,   78,   76,    0,
    0,    0,    0,    0,    0,    0,   39,   15,    0,    0,
  110,  109,  105,  107,    0,    0,    0,   22,   74,    0,
    0,    0,   75,    0,    0,   70,    0,   67,   68,   69,
   71,   72,   96,   77,   99,  108,   18,   19,   20,    0,
    0,    0,    0,    0,   81,   66,    0,   90,    0,    0,
    0,    0,    0,   88,    0,    0,   85,    0,    0,    0,
    0,    0,    0,   84,    0,    0,    0,    0,   94,    0,
   92,   87,    0,   86,
};
final static short yydgoto[] = {                         10,
   11,   12,   13,  125,   15,   16,   17,  126,   40,   88,
   41,   66,   42,   43,   44,   45,   46,  101,   57,   58,
   47,   48,   49,   50,   51,   52,   53,   54,  128,  129,
  130,  131,  132,  133,  134,  135,  155,  196,  172,  180,
  186,   18,   23,   24,   95,   96,
};
final static short yysindex[] = {                       -49,
 -302, -293,    0, -284, -282,    0,    0,    0, -257,    0,
  -49,    0,    0,    0,    0,    0,    0, -261,    0, -241,
 -231, -244, -224,    0, -142,    0, -203, -142, -191, -142,
 -282, -142, -142, -142, -179,    0,    0,    0,    0,    0,
    0,    0,    0, -190, -194,    0,    0, -175, -250, -156,
 -210, -174, -150, -144, -147,    0, -274,    0, 1143,    0,
    0,    0,    0, -138, -137, -188, -142, -145,    0,    0,
 -142, -142, -142, -142, -142, -142, -142, -142, -142, -142,
 -142, -142, -142, -142,  -78,    0,  -78, -142, -181,    0,
    0, -143, -133, -131, -255,    0,    0, 1177,    0, -181,
    0, -137,    0, -250, -250, -156, -156, -156,    0, -175,
 -175, -175, -175, -210, -210, -174, -150, -130, -186, -186,
 -142, -142, -142,    0, -129,    0, -273,    0,    0, -125,
 -120, -118, -111, -110, -119,  -60,    0,    0, -137, -109,
    0,    0,    0,    0,  -93,  -88,  -87,    0,    0,  -59,
  -63,  -85,    0,  -46,  -41,    0, -142,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0, -142,
 -186,  -48,  -78,  -78,    0,    0,  -23,    0, -186,  -33,
 1310, -222, -142,    0, -142,  -75,    0,  -78, -142,  -34,
  -18,  -78,  -78,    0, -142,  -57, -142, 1321,    0,  -78,
    0,    0, 1377,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  245,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0, 1205, 1219,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   50,    0,    0,    0,    0,    0,
    0,    0,    0,    1,  498,    0,    0,  547,  904,   99,
 1051,  603,  148,  197,    0,    0,  -68,    0,    0,    0,
    0,    0,    0,    0, 1372, -159, 1268,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  246,    0,  953, 1002,  302,  351,  400,    0,  652,
  701,  750,  799, 1100, 1149,  848,  449,    0,    0,    0,
    0,    0,    0,    0,    0,    0, 1412,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  843,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
 -242,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0, -253,    0,    0,    0,    0,    0,    0,    0,  -52,
    0,   -9,    0,    0,    0,    0,    0,    0,    0,  -51,
    0,    0,   -7,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  248,    0,   10,    0,    0,    0,  -25,  -28,  -54,
  -43,    0,    0,  -55,  -67,    0,    0,    0,  194,  174,
  -10,   23,   63,   17,   74,  180,  183,    0,    0, -122,
    0,    0,    0,    0,    0,  -80,   80,    0,    0,    0,
    0,    0,    0,  239,    0,  181,
};
final static int YYTABLESIZE=1716;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         39,
   28,   19,   56,   94,   60,   65,  136,  143,   64,   14,
   98,  100,  164,  164,   20,   93,   89,  127,  157,  127,
   14,   62,   63,   21,   86,   22,   68,   91,   91,   87,
   73,   74,   75,  118,   25,  119,  120,  121,  122,   94,
   89,   56,    5,  123,   27,  188,  189,   30,   90,   15,
   89,   93,   91,   36,  147,   92,   28,   32,  164,  164,
  139,   91,   56,  150,  151,  109,   29,  127,  127,  146,
  164,  148,   33,   34,   31,  164,   77,   78,   79,   80,
  164,  124,   69,   70,   98,   35,   36,   37,   38,  106,
  107,  108,  181,  182,   55,  152,  153,  154,   51,  110,
  111,  112,  113,   71,   72,  127,  127,  193,   99,   68,
   86,  198,   59,  127,  127,  178,   81,   82,   67,  203,
  127,   91,   36,  184,  127,  127,  138,   76,   37,   38,
  127,  176,  127,  104,  105,  127,  118,   32,  119,  120,
  121,  122,   83,  163,  177,    5,  123,   64,   17,   84,
   17,   17,   33,   34,  114,  115,   85,  190,   97,  191,
   32,   86,  103,  154,  140,   35,   36,   37,   38,  199,
  141,  201,  142,  149,  156,   33,   34,  118,  158,  119,
  120,  121,  122,  159,  124,  160,    5,  123,   35,   36,
   37,   38,  161,  162,  166,  118,   80,  119,  120,  121,
  122,   32,  165,  167,    5,  123,    1,    2,  168,  169,
  170,   17,  171,    3,    4,    5,   33,   34,  173,   32,
  174,  175,  179,    6,    7,  124,   17,   17,  192,   35,
   36,   37,   38,  183,   33,   34,  185,  195,  197,   17,
   17,   17,   17,  124,    1,   37,  200,   35,   36,   37,
   38,   93,   95,   82,    8,   83,   28,   28,   26,    9,
  102,  137,  116,   28,   28,   28,  117,   28,  194,   61,
   28,   28,   28,   28,   28,  144,   28,   28,   28,   28,
   28,   28,   28,   28,   28,    0,    0,   28,   28,   28,
   28,   28,   28,   28,   28,   28,   28,   28,    0,   28,
    0,   48,    0,    0,   28,   15,   15,    0,   28,   28,
   28,   28,   15,   15,   15,    0,   15,    0,    0,    0,
    0,   15,   15,   15,    0,    0,   15,   15,   15,   15,
   15,   15,   15,   15,    0,    0,   15,   15,   15,   15,
   15,   15,   15,   15,   15,   15,   15,    0,   15,   31,
   49,    0,   15,   15,   51,   51,    0,   15,   15,   15,
   15,   51,   51,   51,    0,   51,    0,    0,    0,    0,
   51,   51,   51,    0,    0,   51,   51,   51,   51,   51,
   51,   51,    0,    0,    0,   51,   51,   51,   51,   51,
   51,   51,   51,   51,   51,   51,    0,   51,    0,   50,
    0,    0,   51,   64,   64,    0,   51,   51,   51,   51,
   64,   64,   64,    0,   64,    0,    0,    0,    0,   64,
   64,   64,    0,    0,   64,   64,   64,   64,   64,   64,
   64,   64,    0,    0,   64,   64,   64,   64,   64,   64,
    0,   64,   64,   64,   64,    0,   64,    0,   65,    0,
    0,   64,   80,   80,    0,   64,   64,   64,   64,   80,
   80,   80,    0,   80,    0,    0,    0,    0,   80,   80,
   80,    0,    0,   80,   80,   80,   80,   80,   80,   80,
   80,    0,    0,   80,   80,   80,   80,   80,   80,   80,
    0,   80,   80,   80,    0,   80,    0,   42,    0,    0,
   80,   37,   37,    0,   80,   80,   80,   80,   37,   37,
   37,    0,   37,    0,    0,    0,    0,   37,   37,   37,
    0,    0,   37,   37,   37,   17,   37,   37,   37,   37,
    0,    0,   37,   37,   37,   37,   37,   37,   37,   37,
   17,   17,   37,    0,    0,    0,   54,    0,    0,   37,
    0,    0,    0,   17,   17,   17,   17,   48,   48,    0,
    0,    0,    0,    0,   48,   48,   48,    0,   48,    0,
    0,    0,    0,   48,   48,   48,    0,    0,   48,   48,
   48,   48,   48,   48,   48,    0,    0,    0,   48,   48,
   48,   48,   48,   48,   48,   48,   48,   48,   48,    0,
   48,    0,   62,    0,    0,   48,   49,   49,    0,   48,
   48,   48,   48,   49,   49,   49,    0,   49,    0,    0,
    0,    0,   49,   49,   49,    0,    0,   49,   49,   49,
   49,   49,   49,   49,    0,    0,    0,   49,   49,   49,
   49,   49,   49,   49,   49,   49,   49,   49,    0,   49,
    0,   57,    0,    0,   49,   50,   50,    0,   49,   49,
   49,   49,   50,   50,   50,    0,   50,    0,    0,    0,
    0,   50,   50,   50,    0,    0,   50,   50,   50,   50,
   50,   50,   50,    0,    0,    0,   50,   50,   50,   50,
   50,   50,   50,   50,   50,   50,   50,    0,   50,    0,
   58,    0,    0,   50,   65,   65,    0,   50,   50,   50,
   50,   65,   65,   65,    0,   65,    0,    0,    0,    0,
   65,   65,   65,    0,    0,   65,   65,   65,   65,   65,
   65,   65,   65,    0,    0,   65,   65,   65,   65,   65,
   65,    0,   65,   65,   65,   65,    0,   65,    0,   55,
    0,    0,   65,   42,   42,    0,   65,   65,   65,   65,
   42,   42,   42,    0,   42,    0,    0,    0,    0,   42,
   42,   42,    0,    0,    0,    0,   42,   42,   42,   42,
   42,   42,    0,    0,   42,   42,   42,   42,   42,   42,
   42,   42,   42,   42,   42,    0,   42,    0,   56,    0,
    0,   42,   54,   54,    0,   42,   42,   42,   42,   54,
   54,   54,    0,   54,    0,    0,    0,    0,   54,   54,
   54,    0,    0,   54,   54,    0,    0,   54,   54,   54,
   54,    0,    0,   54,   54,   54,   54,   54,   54,   54,
   54,   54,   54,   54,    0,   54,    0,   63,    0,    0,
   54,    0,    0,    0,   54,   54,   54,   54,   62,   62,
    0,    0,    0,    0,    0,   62,   62,   62,    0,   62,
    0,    0,    0,    0,   62,   62,   62,    0,    0,   62,
   62,   62,   62,   62,   62,   62,   62,    0,    0,   62,
   62,   62,   62,    0,    0,   62,   62,   62,   62,   62,
    0,   62,    0,   45,    0,    0,   62,   57,   57,    0,
   62,   62,   62,   62,   57,   57,   57,    0,   57,    0,
    0,    0,    0,   57,   57,   57,    0,    0,   57,   57,
    0,    0,   57,   57,   57,   57,    0,    0,   57,   57,
   57,   57,   57,   57,   57,   57,   57,   57,   57,    0,
   57,    0,   46,    0,    0,   57,   58,   58,    0,   57,
   57,   57,   57,   58,   58,   58,    0,   58,    0,    0,
    0,    0,   58,   58,   58,    0,    0,   58,   58,    0,
    0,   58,   58,   58,   58,    0,    0,   58,   58,   58,
   58,   58,   58,   58,   58,   58,   58,   58,    0,   58,
    0,   47,    0,    0,   58,   55,   55,    0,   58,   58,
   58,   58,   55,   55,   55,    0,   55,    0,    0,    0,
    0,   55,   55,   55,    0,    0,   55,   55,    0,    0,
   55,   55,   55,   55,    0,    0,   55,   55,   55,   55,
   55,   55,   55,   55,   55,   55,   55,    0,   55,    0,
   59,    0,    0,   55,   56,   56,    0,   55,   55,   55,
   55,   56,   56,   56,    0,   56,    0,    0,    0,    0,
   56,   56,   56,    0,    0,   56,   56,    0,    0,   56,
   56,   56,   56,    0,    0,   56,   56,   56,   56,   56,
   56,   56,   56,   56,   56,   56,    0,   56,    0,   61,
    0,    0,   56,   63,   63,    0,   56,   56,   56,   56,
   63,   63,   63,    0,   63,    0,    0,    0,    0,   63,
   63,   63,    0,    0,   63,   63,   63,   63,   63,   63,
   63,   63,    0,    0,   63,   63,   63,   63,   17,   23,
   63,   63,   63,   63,   63,   17,   63,    0,   60,    0,
   17,   63,   17,   17,    0,   63,   63,   63,   63,   45,
   45,    0,    0,    0,    0,    0,   45,   45,   45,    0,
   45,    0,    0,    0,    0,   45,   45,   45,    0,    0,
   45,   45,   45,   45,    0,    0,    0,   45,    0,    0,
   45,   45,   45,   45,   45,   45,   45,   45,   45,   45,
   45,    0,   45,    0,  103,    0,    0,   45,   46,   46,
    0,   45,   45,   45,   45,   46,   46,   46,  100,   46,
    0,    0,    0,    0,   46,   46,   46,    0,    0,   46,
   46,   46,   46,    0,    0,    0,   46,    0,    0,   46,
   46,   46,   46,   46,   46,   46,   46,   46,   46,   46,
    0,   46,    0,    0,    0,    0,   46,   47,   47,    0,
   46,   46,   46,   46,   47,   47,   47,   38,   47,    0,
    0,    0,    0,   47,   47,   47,    0,    0,   47,   47,
   47,   47,    0,    0,    0,   47,    0,    0,   47,   47,
   47,   47,   47,   47,   47,   47,   47,   47,   47,    0,
   47,    0,    0,    0,    0,   47,   59,   59,    0,   47,
   47,   47,   47,   59,   59,   59,    0,   59,    0,    0,
    0,    0,   59,   59,   59,    0,    0,   59,   59,   59,
   59,   59,   59,   59,   59,    0,    0,    0,    0,    0,
    0,   59,   59,   59,   59,   59,   59,   59,    0,   59,
    0,    0,    0,    0,   59,   61,   61,    0,   59,   59,
   59,   59,   61,   61,   61,    0,   61,    0,    0,    0,
    0,   61,   61,   61,    0,    0,   61,   61,   61,   61,
   61,   61,   61,   61,    0,    0,    0,    0,    0,    0,
   61,   61,   61,   61,   61,   61,   61,    0,   61,    0,
    0,    0,    0,   61,   60,   60,    0,   61,   61,   61,
   61,   60,   60,   60,    0,   60,    0,    0,    0,    0,
   60,   60,   60,    0,    0,   60,   60,   60,   60,   60,
   60,   60,   60,    0,    0,    0,    0,    0,   89,   60,
   60,   60,   60,   60,   60,   60,   90,   60,    0,    0,
   91,   36,   60,   92,    0,    0,   60,   60,   60,   60,
  103,  103,    0,    0,    0,    0,    0,  103,  103,  103,
    0,    0,   89,    0,  100,  100,    0,  103,  103,  145,
    0,  100,  100,  100,  138,    0,   37,   38,    0,    0,
    0,  100,  100,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  103,    0,    0,    0,    0,  103,    0,
    0,    0,    0,  103,    0,    0,    0,    0,    0,    0,
    0,    0,  100,   38,   38,    0,    0,  100,    0,    0,
   38,   38,   38,    0,   38,    0,    0,    0,    0,   38,
   38,   38,    0,    0,   38,   38,   38,    0,   38,   38,
   38,   38,    0,    0,   38,   38,   38,   38,   38,   38,
   38,   38,    0,    0,   38,  118,   38,  119,  120,  121,
  122,   38,  187,    0,    5,  123,  118,    0,  119,  120,
  121,  122,    0,  202,    0,    5,  123,    0,    0,   32,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   32,    0,    0,    0,   33,   34,    0,    0,    0,    0,
    0,    0,    0,  124,    0,   33,   34,   35,   36,   37,
   38,    0,    0,    0,  124,    0,    0,    0,   35,   36,
   37,   38,  118,    0,  119,  120,  121,  122,    0,  204,
    0,    5,  123,    0,    0,    0,    0,    0,   24,   24,
   24,   24,   24,   24,   24,   24,   32,    0,   24,   24,
   24,   24,   24,   24,   24,   24,    0,   17,   23,    0,
    0,   33,   34,    0,   17,    0,    0,    0,    0,   17,
  124,   17,   17,    0,   35,   36,   37,   38,   28,   28,
   28,   28,   28,   28,   28,   28,    0,    0,   28,   28,
   28,   28,   28,    0,   28,   28,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   28,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         25,
    0,  304,   28,   59,   30,   34,   87,  263,   34,    0,
   65,   66,  135,  136,  308,   59,  270,   85,  292,   87,
   11,   32,   33,  308,  299,  308,  300,  270,  271,  304,
  281,  282,  283,  256,  292,  258,  259,  260,  261,   95,
  296,   67,  265,  266,  306,  268,  269,  292,  304,    0,
  304,   95,  308,  309,   98,  311,  298,  280,  181,  182,
   89,  304,   88,  119,  120,   76,  298,  135,  136,   98,
  193,  100,  295,  296,  299,  198,  287,  288,  289,  290,
  203,  304,  277,  278,  139,  308,  309,  310,  311,   73,
   74,   75,  173,  174,  298,  121,  122,  123,    0,   77,
   78,   79,   80,  279,  280,  173,  174,  188,  297,  300,
  299,  192,  304,  181,  182,  171,  291,  292,  298,  200,
  188,  308,  309,  179,  192,  193,  308,  284,  310,  311,
  198,  157,  200,   71,   72,  203,  256,  280,  258,  259,
  260,  261,  293,  263,  170,  265,  266,    0,  308,  294,
  310,  311,  295,  296,   81,   82,  304,  183,  297,  185,
  280,  299,  308,  189,  308,  308,  309,  310,  311,  195,
  304,  197,  304,  304,  304,  295,  296,  256,  304,  258,
  259,  260,  261,  304,  304,  304,  265,  266,  308,  309,
  310,  311,  304,  304,  304,  256,    0,  258,  259,  260,
  261,  280,  263,  297,  265,  266,  256,  257,  297,  297,
  270,  280,  276,  263,  264,  265,  295,  296,  304,  280,
  267,  263,  271,  273,  274,  304,  295,  296,  304,  308,
  309,  310,  311,  257,  295,  296,  270,  272,  257,  308,
  309,  310,  311,  304,    0,    0,  304,  308,  309,  310,
  311,  304,  304,  263,  304,  263,  256,  257,   11,  309,
   67,   88,   83,  263,  264,  265,   84,  267,  189,   31,
  270,  271,  272,  273,  274,   95,  276,  277,  278,  279,
  280,  281,  282,  283,  284,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,   -1,  299,
   -1,    0,   -1,   -1,  304,  256,  257,   -1,  308,  309,
  310,  311,  263,  264,  265,   -1,  267,   -1,   -1,   -1,
   -1,  272,  273,  274,   -1,   -1,  277,  278,  279,  280,
  281,  282,  283,  284,   -1,   -1,  287,  288,  289,  290,
  291,  292,  293,  294,  295,  296,  297,   -1,  299,  300,
    0,   -1,  303,  304,  256,  257,   -1,  308,  309,  310,
  311,  263,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,  279,  280,  281,
  282,  283,   -1,   -1,   -1,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,   -1,  299,   -1,    0,
   -1,   -1,  304,  256,  257,   -1,  308,  309,  310,  311,
  263,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,
  273,  274,   -1,   -1,  277,  278,  279,  280,  281,  282,
  283,  284,   -1,   -1,  287,  288,  289,  290,  291,  292,
   -1,  294,  295,  296,  297,   -1,  299,   -1,    0,   -1,
   -1,  304,  256,  257,   -1,  308,  309,  310,  311,  263,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,  279,  280,  281,  282,  283,
  284,   -1,   -1,  287,  288,  289,  290,  291,  292,  293,
   -1,  295,  296,  297,   -1,  299,   -1,    0,   -1,   -1,
  304,  256,  257,   -1,  308,  309,  310,  311,  263,  264,
  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,  274,
   -1,   -1,  277,  278,  279,  280,  281,  282,  283,  284,
   -1,   -1,  287,  288,  289,  290,  291,  292,  293,  294,
  295,  296,  297,   -1,   -1,   -1,    0,   -1,   -1,  304,
   -1,   -1,   -1,  308,  309,  310,  311,  256,  257,   -1,
   -1,   -1,   -1,   -1,  263,  264,  265,   -1,  267,   -1,
   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,
  279,  280,  281,  282,  283,   -1,   -1,   -1,  287,  288,
  289,  290,  291,  292,  293,  294,  295,  296,  297,   -1,
  299,   -1,    0,   -1,   -1,  304,  256,  257,   -1,  308,
  309,  310,  311,  263,  264,  265,   -1,  267,   -1,   -1,
   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,  279,
  280,  281,  282,  283,   -1,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,   -1,  299,
   -1,    0,   -1,   -1,  304,  256,  257,   -1,  308,  309,
  310,  311,  263,  264,  265,   -1,  267,   -1,   -1,   -1,
   -1,  272,  273,  274,   -1,   -1,  277,  278,  279,  280,
  281,  282,  283,   -1,   -1,   -1,  287,  288,  289,  290,
  291,  292,  293,  294,  295,  296,  297,   -1,  299,   -1,
    0,   -1,   -1,  304,  256,  257,   -1,  308,  309,  310,
  311,  263,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,  279,  280,  281,
  282,  283,  284,   -1,   -1,  287,  288,  289,  290,  291,
  292,   -1,  294,  295,  296,  297,   -1,  299,   -1,    0,
   -1,   -1,  304,  256,  257,   -1,  308,  309,  310,  311,
  263,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,
  273,  274,   -1,   -1,   -1,   -1,  279,  280,  281,  282,
  283,  284,   -1,   -1,  287,  288,  289,  290,  291,  292,
  293,  294,  295,  296,  297,   -1,  299,   -1,    0,   -1,
   -1,  304,  256,  257,   -1,  308,  309,  310,  311,  263,
  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,  273,
  274,   -1,   -1,  277,  278,   -1,   -1,  281,  282,  283,
  284,   -1,   -1,  287,  288,  289,  290,  291,  292,  293,
  294,  295,  296,  297,   -1,  299,   -1,    0,   -1,   -1,
  304,   -1,   -1,   -1,  308,  309,  310,  311,  256,  257,
   -1,   -1,   -1,   -1,   -1,  263,  264,  265,   -1,  267,
   -1,   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,
  278,  279,  280,  281,  282,  283,  284,   -1,   -1,  287,
  288,  289,  290,   -1,   -1,  293,  294,  295,  296,  297,
   -1,  299,   -1,    0,   -1,   -1,  304,  256,  257,   -1,
  308,  309,  310,  311,  263,  264,  265,   -1,  267,   -1,
   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,
   -1,   -1,  281,  282,  283,  284,   -1,   -1,  287,  288,
  289,  290,  291,  292,  293,  294,  295,  296,  297,   -1,
  299,   -1,    0,   -1,   -1,  304,  256,  257,   -1,  308,
  309,  310,  311,  263,  264,  265,   -1,  267,   -1,   -1,
   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,   -1,
   -1,  281,  282,  283,  284,   -1,   -1,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,   -1,  299,
   -1,    0,   -1,   -1,  304,  256,  257,   -1,  308,  309,
  310,  311,  263,  264,  265,   -1,  267,   -1,   -1,   -1,
   -1,  272,  273,  274,   -1,   -1,  277,  278,   -1,   -1,
  281,  282,  283,  284,   -1,   -1,  287,  288,  289,  290,
  291,  292,  293,  294,  295,  296,  297,   -1,  299,   -1,
    0,   -1,   -1,  304,  256,  257,   -1,  308,  309,  310,
  311,  263,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,   -1,   -1,  281,
  282,  283,  284,   -1,   -1,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,   -1,  299,   -1,    0,
   -1,   -1,  304,  256,  257,   -1,  308,  309,  310,  311,
  263,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,
  273,  274,   -1,   -1,  277,  278,  279,  280,  281,  282,
  283,  284,   -1,   -1,  287,  288,  289,  290,  296,  297,
  293,  294,  295,  296,  297,  303,  299,   -1,    0,   -1,
  308,  304,  310,  311,   -1,  308,  309,  310,  311,  256,
  257,   -1,   -1,   -1,   -1,   -1,  263,  264,  265,   -1,
  267,   -1,   -1,   -1,   -1,  272,  273,  274,   -1,   -1,
  277,  278,  279,  280,   -1,   -1,   -1,  284,   -1,   -1,
  287,  288,  289,  290,  291,  292,  293,  294,  295,  296,
  297,   -1,  299,   -1,    0,   -1,   -1,  304,  256,  257,
   -1,  308,  309,  310,  311,  263,  264,  265,    0,  267,
   -1,   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,
  278,  279,  280,   -1,   -1,   -1,  284,   -1,   -1,  287,
  288,  289,  290,  291,  292,  293,  294,  295,  296,  297,
   -1,  299,   -1,   -1,   -1,   -1,  304,  256,  257,   -1,
  308,  309,  310,  311,  263,  264,  265,    0,  267,   -1,
   -1,   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,
  279,  280,   -1,   -1,   -1,  284,   -1,   -1,  287,  288,
  289,  290,  291,  292,  293,  294,  295,  296,  297,   -1,
  299,   -1,   -1,   -1,   -1,  304,  256,  257,   -1,  308,
  309,  310,  311,  263,  264,  265,   -1,  267,   -1,   -1,
   -1,   -1,  272,  273,  274,   -1,   -1,  277,  278,  279,
  280,  281,  282,  283,  284,   -1,   -1,   -1,   -1,   -1,
   -1,  291,  292,  293,  294,  295,  296,  297,   -1,  299,
   -1,   -1,   -1,   -1,  304,  256,  257,   -1,  308,  309,
  310,  311,  263,  264,  265,   -1,  267,   -1,   -1,   -1,
   -1,  272,  273,  274,   -1,   -1,  277,  278,  279,  280,
  281,  282,  283,  284,   -1,   -1,   -1,   -1,   -1,   -1,
  291,  292,  293,  294,  295,  296,  297,   -1,  299,   -1,
   -1,   -1,   -1,  304,  256,  257,   -1,  308,  309,  310,
  311,  263,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,
  272,  273,  274,   -1,   -1,  277,  278,  279,  280,  281,
  282,  283,  284,   -1,   -1,   -1,   -1,   -1,  296,  291,
  292,  293,  294,  295,  296,  297,  304,  299,   -1,   -1,
  308,  309,  304,  311,   -1,   -1,  308,  309,  310,  311,
  256,  257,   -1,   -1,   -1,   -1,   -1,  263,  264,  265,
   -1,   -1,  296,   -1,  256,  257,   -1,  273,  274,  303,
   -1,  263,  264,  265,  308,   -1,  310,  311,   -1,   -1,
   -1,  273,  274,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  299,   -1,   -1,   -1,   -1,  304,   -1,
   -1,   -1,   -1,  309,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  304,  256,  257,   -1,   -1,  309,   -1,   -1,
  263,  264,  265,   -1,  267,   -1,   -1,   -1,   -1,  272,
  273,  274,   -1,   -1,  277,  278,  279,   -1,  281,  282,
  283,  284,   -1,   -1,  287,  288,  289,  290,  291,  292,
  293,  294,   -1,   -1,  297,  256,  299,  258,  259,  260,
  261,  304,  263,   -1,  265,  266,  256,   -1,  258,  259,
  260,  261,   -1,  263,   -1,  265,  266,   -1,   -1,  280,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  280,   -1,   -1,   -1,  295,  296,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  304,   -1,  295,  296,  308,  309,  310,
  311,   -1,   -1,   -1,  304,   -1,   -1,   -1,  308,  309,
  310,  311,  256,   -1,  258,  259,  260,  261,   -1,  263,
   -1,  265,  266,   -1,   -1,   -1,   -1,   -1,  277,  278,
  279,  280,  281,  282,  283,  284,  280,   -1,  287,  288,
  289,  290,  291,  292,  293,  294,   -1,  296,  297,   -1,
   -1,  295,  296,   -1,  303,   -1,   -1,   -1,   -1,  308,
  304,  310,  311,   -1,  308,  309,  310,  311,  277,  278,
  279,  280,  281,  282,  283,  284,   -1,   -1,  287,  288,
  289,  290,  291,   -1,  293,  294,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  304,
};
}
final static short YYFINAL=10;
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
"external_declaration : END",
"external_declaration : error NEWLINE",
"global_variable_assignment : SYS_IDENTIFIER EQUALS expression",
"atom : NUMERIC",
"atom : STRING",
"atom : IDENTIFIER",
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
"statement : error NEWLINE",
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

//#line 278 "snow.y"


	protected Parser(Reader r) {
	    lexer = new Yylex(r, this);
	  }
	public static void main(String args[]) throws IOException {
	    Parser yyparser = new Parser(new FileReader(args[0]));
	    yyparser.yyparse();    
	  }
//#line 770 "Parser.java"
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
//#line 22 "snow.y"
{
System.out.println("import com.google.code.pltsnow.snowfield.*;");
System.out.println("import com.google.code.pltsnow.gen.*;");
System.out.println("import java.util.ArrayList;");

System.out.println("public class SnowProgramImp extends BaseSnowProgram {\n");
System.out.println(val_peek(0).sval);
System.out.println("public static void main(String[] args) {\n\tSnowProgramImp this_prog = new SnowProgramImp(); \n\tthis_prog.startProgram();\n}");
System.out.println("\n}");
}
break;
case 2:
//#line 32 "snow.y"
{yyval=val_peek(0);}
break;
case 3:
//#line 33 "snow.y"
{yyval = new ParserVal(val_peek(1).sval + val_peek(0).sval);}
break;
case 4:
//#line 37 "snow.y"
{yyval=val_peek(0);}
break;
case 5:
//#line 38 "snow.y"
{yyval=val_peek(0);}
break;
case 6:
//#line 39 "snow.y"
{yyval=val_peek(0);}
break;
case 7:
//#line 40 "snow.y"
{yyval=val_peek(0);}
break;
case 8:
//#line 41 "snow.y"
{yyval=val_peek(0);}
break;
case 9:
//#line 42 "snow.y"
{yyval=val_peek(0);}
break;
case 10:
//#line 43 "snow.y"
{}
break;
case 11:
//#line 44 "snow.y"
{ System.err.println("Line Number:" + lexer.ln + "\t Error:Error in External Definition");}
break;
case 12:
//#line 48 "snow.y"
{ yyval = assignVariable(val_peek(2),val_peek(0)); }
break;
case 13:
//#line 52 "snow.y"
{yyval.sval= "new SnowAtom("+val_peek(0).sval+")";}
break;
case 14:
//#line 53 "snow.y"
{yyval.sval= "new SnowAtom("+val_peek(0).sval+")";}
break;
case 15:
//#line 54 "snow.y"
{yyval.sval = val_peek(0).sval;}
break;
case 16:
//#line 58 "snow.y"
{yyval= new ParserVal(",");}
break;
case 17:
//#line 59 "snow.y"
{yyval=new ParserVal(",");}
break;
case 18:
//#line 63 "snow.y"
{ yyval.sval = val_peek(3).sval;}
break;
case 19:
//#line 64 "snow.y"
{ yyval.sval = val_peek(3).sval + "," + val_peek(1).sval;}
break;
case 20:
//#line 65 "snow.y"
{ yyval.sval = val_peek(3).sval + "," + val_peek(1).sval;}
break;
case 21:
//#line 66 "snow.y"
{ yyval.sval = val_peek(1).sval;}
break;
case 22:
//#line 70 "snow.y"
{ yyval.sval = val_peek(2).sval + "," + val_peek(0).sval;}
break;
case 23:
//#line 71 "snow.y"
{ yyval.sval = val_peek(0).sval;}
break;
case 24:
//#line 76 "snow.y"
{yyval=val_peek(0);}
break;
case 25:
//#line 77 "snow.y"
{yyval=val_peek(0);}
break;
case 26:
//#line 78 "snow.y"
{yyval=val_peek(0);}
break;
case 27:
//#line 79 "snow.y"
{yyval.sval = "(" + val_peek(1).sval + ")";}
break;
case 28:
//#line 83 "snow.y"
{yyval= val_peek(0);}
break;
case 29:
//#line 84 "snow.y"
{ yyval = new ParserVal("symbols.get(\""+val_peek(0).sval+"\")");}
break;
case 30:
//#line 88 "snow.y"
{ yyval = buildCompoundIdentifier(val_peek(2),val_peek(0)); }
break;
case 31:
//#line 89 "snow.y"
{yyval = val_peek(0);}
break;
case 32:
//#line 92 "snow.y"
{yyval=val_peek(0);}
break;
case 33:
//#line 93 "snow.y"
{yyval = doOp("increment",val_peek(1),null); }
break;
case 34:
//#line 94 "snow.y"
{yyval = doOp("decrement",val_peek(1),null); }
break;
case 35:
//#line 95 "snow.y"
{yyval=val_peek(0);}
break;
case 36:
//#line 99 "snow.y"
{ yyval = executeFunction(val_peek(2),val_peek(0)); }
break;
case 37:
//#line 102 "snow.y"
{yyval = val_peek(0);}
break;
case 38:
//#line 103 "snow.y"
{yyval.sval = "";}
break;
case 39:
//#line 107 "snow.y"
{yyval = new ParserVal(val_peek(2).sval+","+val_peek(0).sval);}
break;
case 40:
//#line 108 "snow.y"
{yyval = val_peek(0);}
break;
case 41:
//#line 112 "snow.y"
{yyval = val_peek(0); }
break;
case 42:
//#line 116 "snow.y"
{yyval=val_peek(0);}
break;
case 43:
//#line 117 "snow.y"
{yyval = doOp("minus",new ParserVal("0"),val_peek(0));}
break;
case 44:
//#line 118 "snow.y"
{yyval = doOp("log_not",val_peek(0),null);}
break;
case 45:
//#line 123 "snow.y"
{yyval=val_peek(0);}
break;
case 46:
//#line 124 "snow.y"
{yyval = doOp("plus",val_peek(2),val_peek(0));}
break;
case 47:
//#line 125 "snow.y"
{yyval = doOp("minus",val_peek(2),val_peek(0));}
break;
case 48:
//#line 129 "snow.y"
{yyval = doOp("times",val_peek(2),val_peek(0));}
break;
case 49:
//#line 130 "snow.y"
{yyval = doOp("divide",val_peek(2),val_peek(0));}
break;
case 50:
//#line 131 "snow.y"
{yyval = doOp("modulo",val_peek(2),val_peek(0));}
break;
case 51:
//#line 132 "snow.y"
{yyval=val_peek(0);}
break;
case 52:
//#line 135 "snow.y"
{yyval=val_peek(0);}
break;
case 53:
//#line 136 "snow.y"
{yyval = doOp("power",val_peek(2),val_peek(0));}
break;
case 54:
//#line 140 "snow.y"
{yyval = val_peek(0);}
break;
case 55:
//#line 141 "snow.y"
{yyval = doOp("lt",val_peek(2),val_peek(0));}
break;
case 56:
//#line 142 "snow.y"
{yyval = doOp("gt",val_peek(2),val_peek(0));}
break;
case 57:
//#line 143 "snow.y"
{yyval = doOp("le",val_peek(2),val_peek(0));}
break;
case 58:
//#line 144 "snow.y"
{yyval = doOp("ge",val_peek(2),val_peek(0));}
break;
case 59:
//#line 148 "snow.y"
{yyval = val_peek(0);}
break;
case 60:
//#line 149 "snow.y"
{yyval = doOp("equals",val_peek(2),val_peek(0));}
break;
case 61:
//#line 150 "snow.y"
{yyval = doOp("nequals",val_peek(2),val_peek(0));}
break;
case 62:
//#line 154 "snow.y"
{yyval=val_peek(0);}
break;
case 63:
//#line 155 "snow.y"
{yyval = doOp("log_and",val_peek(2),val_peek(0));}
break;
case 64:
//#line 159 "snow.y"
{yyval=val_peek(0);}
break;
case 65:
//#line 160 "snow.y"
{yyval = doOp("log_or",val_peek(2),val_peek(0));}
break;
case 66:
//#line 164 "snow.y"
{ yyval = assignVariable(val_peek(2),val_peek(0)); }
break;
case 67:
//#line 168 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 68:
//#line 169 "snow.y"
{yyval=val_peek(1);}
break;
case 69:
//#line 170 "snow.y"
{yyval=val_peek(1);}
break;
case 70:
//#line 171 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 71:
//#line 172 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 72:
//#line 173 "snow.y"
{yyval=val_peek(1);}
break;
case 74:
//#line 175 "snow.y"
{ System.err.println("Line Number:" + lexer.ln + "\t Error:In Statement");}
break;
case 75:
//#line 178 "snow.y"
{yyval.sval = "return " +  val_peek(0).sval + ";\n";}
break;
case 76:
//#line 181 "snow.y"
{ yyval=val_peek(0); }
break;
case 77:
//#line 182 "snow.y"
{yyval =new ParserVal(val_peek(1).sval+val_peek(0).sval);}
break;
case 78:
//#line 186 "snow.y"
{yyval=val_peek(0);}
break;
case 79:
//#line 190 "snow.y"
{yyval=val_peek(0);}
break;
case 80:
//#line 194 "snow.y"
{yyval=val_peek(0);}
break;
case 81:
//#line 198 "snow.y"
{ yyval = makeFullIfStatement(val_peek(1)); }
break;
case 82:
//#line 202 "snow.y"
{yyval = makePartialIfElse(val_peek(2),val_peek(0), null);}
break;
case 83:
//#line 203 "snow.y"
{yyval = makePartialIfElse(val_peek(4),val_peek(2), val_peek(0));}
break;
case 84:
//#line 204 "snow.y"
{yyval = makePartialIfElseIf(val_peek(4),val_peek(2), val_peek(0));}
break;
case 85:
//#line 208 "snow.y"
{ yyval = doWhile(val_peek(3),val_peek(1)); }
break;
case 86:
//#line 209 "snow.y"
{ yyval = doFor(val_peek(8),val_peek(6),val_peek(4),val_peek(3),val_peek(1)); }
break;
case 87:
//#line 210 "snow.y"
{ yyval = doForeach(val_peek(6),val_peek(5),val_peek(4),val_peek(3),val_peek(1)); }
break;
case 88:
//#line 214 "snow.y"
{ yyval = val_peek(0); }
break;
case 89:
//#line 215 "snow.y"
{yyval = null; }
break;
case 90:
//#line 219 "snow.y"
{ yyval = val_peek(0); }
break;
case 91:
//#line 220 "snow.y"
{yyval = null; }
break;
case 92:
//#line 224 "snow.y"
{ yyval = new ParserVal(val_peek(2).sval + ":" + val_peek(0).sval); }
break;
case 93:
//#line 225 "snow.y"
{yyval = null; }
break;
case 94:
//#line 229 "snow.y"
{ yyval = val_peek(0);}
break;
case 95:
//#line 230 "snow.y"
{ yyval = null;}
break;
case 96:
//#line 234 "snow.y"
{ 
				yyval = createDebugHook(val_peek(5),val_peek(4),val_peek(1));
				}
break;
case 97:
//#line 240 "snow.y"
{yyval = new ParserVal("before"); }
break;
case 98:
//#line 241 "snow.y"
{yyval = new ParserVal("after"); }
break;
case 99:
//#line 245 "snow.y"
{ yyval = createFunction(val_peek(5),val_peek(3),val_peek(1)); }
break;
case 100:
//#line 248 "snow.y"
{yyval = val_peek(0);}
break;
case 101:
//#line 252 "snow.y"
{yyval = val_peek(0);}
break;
case 102:
//#line 253 "snow.y"
{yyval.sval = val_peek(2).sval +val_peek(0).sval;}
break;
case 103:
//#line 257 "snow.y"
{ yyval = declareLocalVariable(val_peek(0)); }
break;
case 104:
//#line 258 "snow.y"
{ yyval = declareLocalVariable(val_peek(2),val_peek(0)); }
break;
case 105:
//#line 262 "snow.y"
{ yyval = defineMolecule(val_peek(4),val_peek(1)); }
break;
case 106:
//#line 266 "snow.y"
{yyval = val_peek(0);}
break;
case 107:
//#line 267 "snow.y"
{ yyval= new ParserVal(val_peek(1).sval +val_peek(0).sval); }
break;
case 108:
//#line 271 "snow.y"
{ yyval = moleLazyCreate(val_peek(2),val_peek(1));}
break;
case 109:
//#line 272 "snow.y"
{ yyval = moleCreateOne(val_peek(1));  }
break;
case 110:
//#line 273 "snow.y"
{ yyval = moleCreateFromPair(val_peek(1));  }
break;
//#line 1366 "Parser.java"
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
