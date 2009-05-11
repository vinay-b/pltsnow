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
   26,   27,   27,   28,   28,   29,   29,   29,   30,   30,
   30,   30,   30,   30,   30,   30,   35,   36,   36,   34,
   31,    8,   32,   37,   37,   37,   33,   33,   33,   40,
   40,   39,   39,   41,   41,   38,   38,    6,   42,   42,
    3,    4,   43,   43,   44,   44,    5,   45,   45,   46,
   46,   46,   46,
};
final static short yylen[] = {                            2,
    1,    1,    2,    1,    1,    1,    1,    1,    1,    1,
    2,    3,    1,    1,    1,    1,    0,    5,    5,    5,
    3,    3,    1,    1,    1,    1,    3,    1,    1,    3,
    1,    1,    2,    2,    1,    3,    1,    0,    3,    1,
    1,    1,    2,    2,    1,    3,    3,    3,    3,    3,
    1,    1,    3,    1,    3,    3,    3,    3,    1,    3,
    3,    1,    3,    1,    3,    3,    3,    3,    2,    2,
    2,    2,    2,    2,    1,    2,    2,    1,    2,    1,
    1,    1,    3,    3,    5,    5,    5,   10,    8,    2,
    0,    2,    0,    4,    0,    2,    0,    6,    1,    1,
    7,    2,    1,    3,    1,    3,    6,    1,    2,    3,
    2,    2,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   10,    0,    0,   99,  100,    9,    0,    0,
    0,    2,    4,    5,    6,    7,    8,    0,   11,    0,
    0,    0,    0,  103,    0,    3,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   29,   14,   13,   12,   24,
   25,   32,   26,    0,    0,   35,   52,    0,    0,    0,
    0,    0,    0,    0,    0,   41,    0,   40,    0,  106,
  104,   43,   44,    0,    0,    0,    0,    0,   33,   34,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   16,    0,    0,    0,  113,
   31,    0,    0,    0,    0,  108,   27,    0,   21,    0,
   36,    0,   30,    0,    0,    0,    0,    0,   53,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   75,    0,   81,    0,   80,   78,    0,
    0,    0,    0,    0,    0,    0,   39,   15,    0,    0,
  112,  111,  107,  109,    0,    0,    0,   22,   76,    0,
    0,    0,   77,    0,    0,   72,    0,    0,    0,   69,
   70,   71,   73,   74,   98,   79,  101,  110,   18,   19,
   20,    0,    0,    0,    0,    0,   83,   67,    0,   66,
    0,   92,    0,    0,    0,    0,    0,   90,    0,    0,
   87,    0,    0,    0,    0,    0,    0,   86,    0,    0,
    0,    0,   96,    0,   94,   89,    0,   88,
};
final static short yydgoto[] = {                         10,
   11,   12,   13,  125,   15,   16,   17,  126,   40,   88,
   41,   66,   42,   43,   44,   45,   46,  101,   57,   58,
   47,   48,   49,   50,   51,   52,   53,   54,  128,  129,
  130,  131,  132,  133,  134,  135,  155,  200,  174,  184,
  190,   18,   23,   24,   95,   96,
};
final static short yysindex[] = {                      -230,
 -263, -259,    0, -253, -237,    0,    0,    0, -203,    0,
 -230,    0,    0,    0,    0,    0,    0, -244,    0, -169,
 -165, -188, -164,    0,  -97,    0, -154,  -97, -158,  -97,
 -237,  -97,  -97,  -97, -145,    0,    0,    0,    0,    0,
    0,    0,    0, -146, -231,    0,    0, -204, -181, -121,
 -118, -208, -128, -127, -138,    0, -267,    0, -159,    0,
    0,    0,    0, -124, -115, -277,  -97, -133,    0,    0,
  -97,  -97,  -97,  -97,  -97,  -97,  -97,  -97,  -97,  -97,
  -97,  -97,  -97,  -97, -153,    0, -153,  -97, -272,    0,
    0, -130, -119, -116, -218,    0,    0, -223,    0, -272,
    0, -115,    0, -181, -181, -121, -121, -121,    0, -204,
 -204, -204, -204, -118, -118, -208, -128, -109, -187, -187,
  -97,  -97,  -97,    0, -108,    0, -233,    0,    0,  -96,
  -89,  -86,  -85,  -84,  -56, 1310,    0,    0, -115,  -78,
    0,    0,    0,    0,  -70,  -69,  -64,    0,    0,  -47,
  -38,  -63,    0,  -24,  -21,    0,  -97,  -61,  -97,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -97, -187,  -27, -153, -153,    0,    0, -146,    0,
  -12,    0, -187,  -19, 1321,  -79,  -97,    0,  -97,  -54,
    0, -153,  -97,  -23,   -1, -153, -153,    0,  -97,  -45,
  -97, 1377,    0, -153,    0,    0, 1388,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  260,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0, 1205, 1219,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    1,    0,    0,    0,    0,    0,
    0,    0,    0,   50,  498,    0,    0,  547,  904,   99,
 1051,  603,  148,  197,    0,    0,  -74,    0,    0,    0,
    0,    0,    0,    0, 1423, -194, 1268,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  246,    0,  953, 1002,  302,  351,  400,    0,  652,
  701,  750,  799, 1100, 1149,  848,  449,    0,    0,    0,
    0,    0,    0,    0,    0,    0, 1458,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0, -280,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
 -246,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0, -256,    0,    0,    0,    0,  -43,    0,
    0,    0,    0,  -42,    0,    4,    0,    0,    0,    0,
    0,    0,    0,  -41,    0,    0,    6,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  259,    0,   18,    0,    0,    0,  -25,  -32,  -58,
  -44,    0,    0,  -55,  -66,    0,    0,    0,  204,  184,
  -20,  114,   53,   86,   58,  193,  215,    0,    0, -125,
    0,    0,    0,    0,    0,  -81,   84,    0,    0,    0,
    0,    0,    0,  272,    0,  213,
};
final static int YYTABLESIZE=1762;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         39,
   15,   65,   56,   94,   60,  136,   98,  100,   64,  166,
  166,   62,   63,   91,   93,   17,   23,   14,  127,   99,
  127,   86,   17,   93,   93,    1,    2,   17,   14,   17,
   17,   86,    3,    4,    5,  138,   87,   37,   38,   94,
   19,   56,    6,    7,  143,   69,   70,   91,   20,   28,
   93,  157,  158,  147,   21,  109,  139,   93,  159,  166,
  166,   27,   56,  150,  151,  146,   68,  148,  127,  127,
   22,  166,   89,    8,   71,   72,  166,   89,    9,  145,
   98,  166,   81,   82,  138,   90,   37,   38,   25,   91,
   36,  179,   92,  185,  186,  152,  153,  154,   51,   73,
   74,   75,  118,   30,  119,  120,  121,  122,  127,  127,
  197,    5,  123,   17,  202,   17,   17,  182,  127,  127,
   91,   36,  207,  104,  105,  127,   32,  188,   28,  127,
  127,  178,   29,  180,   31,  127,   89,  127,  114,  115,
  127,   33,   34,   55,   90,   59,  181,   64,   91,   36,
  124,   92,   67,   68,   35,   36,   37,   38,  106,  107,
  108,  194,   76,  195,   83,   85,   84,  154,   77,   78,
   79,   80,   97,  203,  103,  205,  118,  140,  119,  120,
  121,  122,   32,   86,  141,    5,  123,  142,  192,  193,
  110,  111,  112,  113,  149,  156,   82,   33,   34,  118,
   32,  119,  120,  121,  122,   17,  165,  160,    5,  123,
   35,   36,   37,   38,  161,   33,   34,  162,  163,  164,
   17,   17,  172,   32,  124,  168,  169,  170,   35,   36,
   37,   38,  171,   17,   17,   17,   17,  173,   33,   34,
  175,  177,  176,  183,  187,   37,   91,  124,  199,  196,
  189,   35,   36,   37,   38,  201,   15,   15,  204,    1,
   68,   95,   97,   15,   15,   15,   84,   15,   85,   26,
  102,  137,   15,   15,   15,  116,  198,   15,   15,   15,
   15,   15,   15,   15,   15,   31,   31,   15,   15,   15,
   15,   15,   15,   15,   15,   15,   15,   15,  117,   15,
   31,   48,   61,   15,   15,   28,   28,  144,   15,   15,
   15,   15,   28,   28,   28,    0,   28,    0,    0,   28,
   28,   28,   28,   28,    0,   28,   28,   28,   28,   28,
   28,   28,   28,   28,    0,    0,   28,   28,   28,   28,
   28,   28,   28,   28,   28,   28,   28,    0,   28,    0,
   49,    0,    0,   28,   51,   51,    0,   28,   28,   28,
   28,   51,   51,   51,    0,   51,    0,    0,    0,    0,
   51,   51,   51,    0,    0,   51,   51,   51,   51,   51,
   51,   51,    0,    0,    0,   51,   51,   51,   51,   51,
   51,   51,   51,   51,   51,   51,    0,   51,    0,   50,
    0,    0,   51,   64,   64,    0,   51,   51,   51,   51,
   64,   64,   64,    0,   64,    0,    0,    0,    0,   64,
   64,   64,    0,    0,   64,   64,   64,   64,   64,   64,
   64,   64,    0,    0,   64,   64,   64,   64,   64,   64,
    0,   64,   64,   64,   64,    0,   64,    0,   65,    0,
    0,   64,   82,   82,    0,   64,   64,   64,   64,   82,
   82,   82,    0,   82,    0,    0,    0,    0,   82,   82,
   82,    0,    0,   82,   82,   82,   82,   82,   82,   82,
   82,    0,    0,   82,   82,   82,   82,   82,   82,   82,
    0,   82,   82,   82,    0,   82,    0,   42,    0,    0,
   82,   37,   37,    0,   82,   82,   82,   82,   37,   37,
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
   63,   63,    0,    0,   63,   63,   63,   63,    0,    0,
   63,   63,   63,   63,   63,    0,   63,    0,   60,    0,
    0,   63,    0,    0,    0,   63,   63,   63,   63,   45,
   45,    0,    0,    0,    0,    0,   45,   45,   45,    0,
   45,    0,    0,    0,    0,   45,   45,   45,    0,    0,
   45,   45,   45,   45,    0,    0,    0,   45,    0,    0,
   45,   45,   45,   45,   45,   45,   45,   45,   45,   45,
   45,    0,   45,    0,  105,    0,    0,   45,   46,   46,
    0,   45,   45,   45,   45,   46,   46,   46,  102,   46,
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
   60,   60,   60,    0,    0,    0,    0,    0,    0,   60,
   60,   60,   60,   60,   60,   60,    0,   60,    0,    0,
    0,    0,   60,    0,    0,    0,   60,   60,   60,   60,
  105,  105,    0,    0,    0,    0,    0,  105,  105,  105,
    0,    0,    0,    0,  102,  102,    0,  105,  105,    0,
    0,  102,  102,  102,    0,    0,    0,    0,    0,    0,
    0,  102,  102,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  105,    0,    0,    0,    0,  105,    0,
    0,    0,    0,  105,    0,    0,    0,    0,    0,    0,
    0,    0,  102,   38,   38,    0,    0,  102,    0,    0,
   38,   38,   38,    0,   38,    0,    0,    0,    0,   38,
   38,   38,    0,    0,   38,   38,   38,    0,   38,   38,
   38,   38,    0,    0,   38,   38,   38,   38,   38,   38,
   38,   38,    0,    0,   38,  118,   38,  119,  120,  121,
  122,   38,  167,    0,    5,  123,  118,    0,  119,  120,
  121,  122,    0,  191,    0,    5,  123,    0,    0,   32,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   32,    0,    0,    0,   33,   34,    0,    0,    0,    0,
    0,    0,    0,  124,    0,   33,   34,   35,   36,   37,
   38,    0,    0,    0,  124,    0,    0,    0,   35,   36,
   37,   38,  118,    0,  119,  120,  121,  122,    0,  206,
    0,    5,  123,  118,    0,  119,  120,  121,  122,    0,
  208,    0,    5,  123,    0,    0,   32,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   32,    0,    0,
    0,   33,   34,    0,    0,    0,    0,    0,    0,    0,
  124,    0,   33,   34,   35,   36,   37,   38,    0,    0,
    0,  124,    0,    0,    0,   35,   36,   37,   38,   24,
   24,   24,   24,   24,   24,   24,   24,    0,    0,   24,
   24,   24,   24,   24,   24,   24,   24,    0,   17,   23,
    0,    0,    0,    0,    0,   17,    0,    0,    0,    0,
   17,    0,   17,   17,   28,   28,   28,   28,   28,   28,
   28,   28,    0,    0,   28,   28,   28,   28,   28,    0,
   28,   28,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   28,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         25,
    0,   34,   28,   59,   30,   87,   65,   66,   34,  135,
  136,   32,   33,  270,   59,  296,  297,    0,   85,  297,
   87,  299,  303,  270,  271,  256,  257,  308,   11,  310,
  311,  299,  263,  264,  265,  308,  304,  310,  311,   95,
  304,   67,  273,  274,  263,  277,  278,  304,  308,    0,
   95,  285,  286,   98,  308,   76,   89,  304,  292,  185,
  186,  306,   88,  119,  120,   98,  300,  100,  135,  136,
  308,  197,  296,  304,  279,  280,  202,  296,  309,  303,
  139,  207,  291,  292,  308,  304,  310,  311,  292,  308,
  309,  158,  311,  175,  176,  121,  122,  123,    0,  281,
  282,  283,  256,  292,  258,  259,  260,  261,  175,  176,
  192,  265,  266,  308,  196,  310,  311,  173,  185,  186,
  308,  309,  204,   71,   72,  192,  280,  183,  298,  196,
  197,  157,  298,  159,  299,  202,  296,  204,   81,   82,
  207,  295,  296,  298,  304,  304,  172,    0,  308,  309,
  304,  311,  298,  300,  308,  309,  310,  311,   73,   74,
   75,  187,  284,  189,  293,  304,  294,  193,  287,  288,
  289,  290,  297,  199,  308,  201,  256,  308,  258,  259,
  260,  261,  280,  299,  304,  265,  266,  304,  268,  269,
   77,   78,   79,   80,  304,  304,    0,  295,  296,  256,
  280,  258,  259,  260,  261,  280,  263,  304,  265,  266,
  308,  309,  310,  311,  304,  295,  296,  304,  304,  304,
  295,  296,  270,  280,  304,  304,  297,  297,  308,  309,
  310,  311,  297,  308,  309,  310,  311,  276,  295,  296,
  304,  263,  267,  271,  257,    0,  308,  304,  272,  304,
  270,  308,  309,  310,  311,  257,  256,  257,  304,    0,
  304,  304,  304,  263,  264,  265,  263,  267,  263,   11,
   67,   88,  272,  273,  274,   83,  193,  277,  278,  279,
  280,  281,  282,  283,  284,  285,  286,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,   84,  299,
  300,    0,   31,  303,  304,  256,  257,   95,  308,  309,
  310,  311,  263,  264,  265,   -1,  267,   -1,   -1,  270,
  271,  272,  273,  274,   -1,  276,  277,  278,  279,  280,
  281,  282,  283,  284,   -1,   -1,  287,  288,  289,  290,
  291,  292,  293,  294,  295,  296,  297,   -1,  299,   -1,
    0,   -1,   -1,  304,  256,  257,   -1,  308,  309,  310,
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
  283,  284,   -1,   -1,  287,  288,  289,  290,   -1,   -1,
  293,  294,  295,  296,  297,   -1,  299,   -1,    0,   -1,
   -1,  304,   -1,   -1,   -1,  308,  309,  310,  311,  256,
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
  282,  283,  284,   -1,   -1,   -1,   -1,   -1,   -1,  291,
  292,  293,  294,  295,  296,  297,   -1,  299,   -1,   -1,
   -1,   -1,  304,   -1,   -1,   -1,  308,  309,  310,  311,
  256,  257,   -1,   -1,   -1,   -1,   -1,  263,  264,  265,
   -1,   -1,   -1,   -1,  256,  257,   -1,  273,  274,   -1,
   -1,  263,  264,  265,   -1,   -1,   -1,   -1,   -1,   -1,
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
   -1,  265,  266,  256,   -1,  258,  259,  260,  261,   -1,
  263,   -1,  265,  266,   -1,   -1,  280,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  280,   -1,   -1,
   -1,  295,  296,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  304,   -1,  295,  296,  308,  309,  310,  311,   -1,   -1,
   -1,  304,   -1,   -1,   -1,  308,  309,  310,  311,  277,
  278,  279,  280,  281,  282,  283,  284,   -1,   -1,  287,
  288,  289,  290,  291,  292,  293,  294,   -1,  296,  297,
   -1,   -1,   -1,   -1,   -1,  303,   -1,   -1,   -1,   -1,
  308,   -1,  310,  311,  277,  278,  279,  280,  281,  282,
  283,  284,   -1,   -1,  287,  288,  289,  290,  291,   -1,
  293,  294,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  304,
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
"assignment_expression : compound_identifier LIST_OP_PUSH expression",
"assignment_expression : compound_identifier LIST_OP_POP compound_identifier",
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

//#line 282 "snow.y"


	protected Parser(Reader r) {
	    lexer = new Yylex(r, this);
	  }
	public static void main(String args[]) throws IOException {
	    Parser yyparser = new Parser(new FileReader(args[0]));
	    yyparser.yyparse();    
	  }
//#line 782 "Parser.java"
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
//#line 165 "snow.y"
{ yyval = Push(val_peek(2),val_peek(0)); }
break;
case 68:
//#line 166 "snow.y"
{ yyval = Pop(val_peek(2),val_peek(0)); }
break;
case 69:
//#line 171 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 70:
//#line 172 "snow.y"
{yyval=val_peek(1);}
break;
case 71:
//#line 173 "snow.y"
{yyval=val_peek(1);}
break;
case 72:
//#line 174 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 73:
//#line 175 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 74:
//#line 176 "snow.y"
{yyval=val_peek(1);}
break;
case 76:
//#line 178 "snow.y"
{ System.err.println("Line Number:" + lexer.ln + "\t Error:In Statement");}
break;
case 77:
//#line 181 "snow.y"
{yyval.sval = "return " +  val_peek(0).sval + ";\n";}
break;
case 78:
//#line 184 "snow.y"
{ yyval=val_peek(0); }
break;
case 79:
//#line 185 "snow.y"
{yyval =new ParserVal(val_peek(1).sval+val_peek(0).sval);}
break;
case 80:
//#line 189 "snow.y"
{yyval=val_peek(0);}
break;
case 81:
//#line 193 "snow.y"
{yyval=val_peek(0);}
break;
case 82:
//#line 198 "snow.y"
{yyval=val_peek(0);}
break;
case 83:
//#line 202 "snow.y"
{ yyval = makeFullIfStatement(val_peek(1)); }
break;
case 84:
//#line 206 "snow.y"
{yyval = makePartialIfElse(val_peek(2),val_peek(0), null);}
break;
case 85:
//#line 207 "snow.y"
{yyval = makePartialIfElse(val_peek(4),val_peek(2), val_peek(0));}
break;
case 86:
//#line 208 "snow.y"
{yyval = makePartialIfElseIf(val_peek(4),val_peek(2), val_peek(0));}
break;
case 87:
//#line 212 "snow.y"
{ yyval = doWhile(val_peek(3),val_peek(1)); }
break;
case 88:
//#line 213 "snow.y"
{ yyval = doFor(val_peek(8),val_peek(6),val_peek(4),val_peek(3),val_peek(1)); }
break;
case 89:
//#line 214 "snow.y"
{ yyval = doForeach(val_peek(6),val_peek(5),val_peek(4),val_peek(3),val_peek(1)); }
break;
case 90:
//#line 218 "snow.y"
{ yyval = val_peek(0); }
break;
case 91:
//#line 219 "snow.y"
{yyval = null; }
break;
case 92:
//#line 223 "snow.y"
{ yyval = val_peek(0); }
break;
case 93:
//#line 224 "snow.y"
{yyval = null; }
break;
case 94:
//#line 228 "snow.y"
{ yyval = new ParserVal(val_peek(2).sval + ":" + val_peek(0).sval); }
break;
case 95:
//#line 229 "snow.y"
{yyval = null; }
break;
case 96:
//#line 233 "snow.y"
{ yyval = val_peek(0);}
break;
case 97:
//#line 234 "snow.y"
{ yyval = null;}
break;
case 98:
//#line 238 "snow.y"
{ 
				yyval = createDebugHook(val_peek(5),val_peek(4),val_peek(1));
				}
break;
case 99:
//#line 244 "snow.y"
{yyval = new ParserVal("before"); }
break;
case 100:
//#line 245 "snow.y"
{yyval = new ParserVal("after"); }
break;
case 101:
//#line 249 "snow.y"
{ yyval = createFunction(val_peek(5),val_peek(3),val_peek(1)); }
break;
case 102:
//#line 252 "snow.y"
{yyval = val_peek(0);}
break;
case 103:
//#line 256 "snow.y"
{yyval = val_peek(0);}
break;
case 104:
//#line 257 "snow.y"
{yyval.sval = val_peek(2).sval +val_peek(0).sval;}
break;
case 105:
//#line 261 "snow.y"
{ yyval = declareLocalVariable(val_peek(0)); }
break;
case 106:
//#line 262 "snow.y"
{ yyval = declareLocalVariable(val_peek(2),val_peek(0)); }
break;
case 107:
//#line 266 "snow.y"
{ yyval = defineMolecule(val_peek(4),val_peek(1)); }
break;
case 108:
//#line 270 "snow.y"
{yyval = val_peek(0);}
break;
case 109:
//#line 271 "snow.y"
{ yyval= new ParserVal(val_peek(1).sval +val_peek(0).sval); }
break;
case 110:
//#line 275 "snow.y"
{ yyval = moleLazyCreate(val_peek(2),val_peek(1));}
break;
case 111:
//#line 276 "snow.y"
{ yyval = moleCreateOne(val_peek(1));  }
break;
case 112:
//#line 277 "snow.y"
{ yyval = moleCreateFromPair(val_peek(1));  }
break;
//#line 1386 "Parser.java"
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
