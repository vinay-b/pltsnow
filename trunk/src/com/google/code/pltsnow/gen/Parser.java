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
    2,    7,    9,    9,   10,   10,   11,   11,   11,   11,
   12,   12,   13,   13,   13,   13,   14,   14,   15,   15,
   16,   16,   16,   16,   17,   18,   18,   19,   19,   20,
   21,   21,   21,   22,   22,   22,   23,   23,   23,   23,
   24,   24,   25,   25,   25,   25,   25,   26,   26,   26,
   27,   27,   28,   28,   29,   29,   29,   30,   30,   30,
   30,   30,   30,   30,   30,   35,   36,   36,   34,   31,
    8,   32,   37,   37,   37,   33,   33,   33,   40,   40,
   39,   39,   41,   41,   38,   38,    6,   42,   42,    3,
    4,   43,   43,   44,   44,    5,   45,   45,   46,   46,
   46,   46,   48,   47,   47,   47,   47,   49,   49,
};
final static short yylen[] = {                            2,
    1,    1,    2,    1,    1,    1,    1,    1,    1,    1,
    2,    3,    1,    1,    1,    0,    5,    5,    5,    3,
    3,    1,    1,    1,    1,    3,    1,    1,    3,    1,
    1,    2,    2,    1,    3,    1,    0,    3,    1,    1,
    1,    2,    2,    1,    3,    3,    3,    3,    3,    1,
    1,    3,    1,    3,    3,    3,    3,    1,    3,    3,
    1,    3,    1,    3,    3,    3,    3,    2,    2,    2,
    2,    2,    2,    1,    2,    2,    1,    2,    1,    1,
    1,    3,    3,    5,    5,    5,   10,    8,    2,    0,
    2,    0,    4,    0,    2,    0,    6,    1,    1,    7,
    2,    1,    3,    1,    3,    6,    1,    2,    3,    2,
    2,    1,    1,    5,    5,    5,    3,    3,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   10,    0,    0,   98,   99,    9,    0,    0,
    0,    2,    4,    5,    6,    7,    8,    0,   11,    0,
    0,    0,    0,  102,    0,    3,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   28,   14,   13,   12,   23,
   24,   31,   25,    0,    0,   34,   51,    0,    0,    0,
    0,    0,    0,    0,    0,   40,    0,   39,    0,  105,
  103,   42,   43,    0,    0,    0,    0,    0,   32,   33,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   15,    0,    0,    0,  112,
   30,    0,    0,    0,  107,    0,   26,    0,   20,   35,
    0,   29,    0,    0,    0,    0,    0,   52,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   74,    0,   80,    0,    0,   79,   77,    0,
    0,    0,    0,    0,    0,    0,   38,  113,    0,    0,
    0,  110,  106,  108,  111,    0,    0,    0,    0,   21,
   75,    0,    0,    0,   76,    0,    0,   71,    0,    0,
    0,   68,   69,   70,   72,   73,   97,   78,  100,    0,
  117,  109,    0,   17,   18,    0,   19,    0,    0,    0,
    0,    0,   82,   66,   67,   65,    0,    0,    0,  118,
    0,    0,   91,    0,    0,    0,    0,  114,  116,  115,
    0,    0,   89,    0,    0,   86,    0,    0,    0,    0,
    0,    0,    0,   85,    0,    0,    0,    0,   95,    0,
   93,   88,    0,   87,
};
final static short yydgoto[] = {                         10,
   11,   12,   13,  124,   15,   16,   17,  125,   40,   88,
   41,   66,   42,   43,   44,   45,   46,  100,   57,   58,
   47,   48,   49,   50,   51,   52,   53,   54,  128,  129,
  130,  131,  132,  133,  134,  135,  157,  216,  180,  195,
  205,   18,   23,   24,   94,   95,   96,  139,  190,
};
final static short yysindex[] = {                      -218,
 -296, -277,    0, -268, -250,    0,    0,    0, -203,    0,
 -218,    0,    0,    0,    0,    0,    0, -237,    0, -181,
 -175, -172, -164,    0, -108,    0, -160, -108, -155, -108,
 -250, -108, -108, -108, -146,    0,    0,    0,    0,    0,
    0,    0,    0, -136, -151,    0,    0, -138, -206, -122,
 -178, -134, -111, -105, -118,    0, -191,    0, -190,    0,
    0,    0,    0, -104, -101,  -79, -108,  -88,    0,    0,
 -108, -108, -108, -108, -108, -108, -108, -108, -108, -108,
 -108, -108, -108, -108, 1444,    0, 1444, -108,  -86,    0,
    0,  -81,  -41, -204,    0,  -37,    0, -209,    0,    0,
 -101,    0, -206, -206, -122, -122, -122,    0, -138, -138,
 -138, -138, -178, -178, -134, -111,  -28, -100, -100, -108,
 -108, -108,    0,  -27,    0,  -69, -259,    0,    0,   -5,
   -1,    4,   12,   14,  -85, 1310,    0,    0, -101,  -44,
   15,    0,    0,    0,    0,  -55,    7, -167,   28,    0,
    0,   65,   60,   44,    0,   83,   89,    0, -108, -100,
 -108,    0,    0,    0,    0,    0,    0,    0,    0, -223,
    0,    0, -101,    0,    0,  -55,    0, -108, -100,   82,
 1444, 1444,    0,    0,    0,    0,   68,   70, -152,    0,
 -101,  100,    0, -100,   98, 1321, -244,    0,    0,    0,
  -86, -108,    0, -108,   66,    0, 1444, -108, -101,   97,
  117, 1444, 1444,    0, -108,   71, -108, 1377,    0, 1444,
    0,    0, 1388,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  383,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0, 1205, 1219,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    1,    0,    0,    0,    0,    0,
    0,    0,    0,   50,  498,    0,    0,  547,  904,   99,
 1051,  603,  148,  197,    0,    0,  -59,    0,    0,    0,
    0,    0,    0,    0,  -49,    0, 1268,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  246,    0,  953, 1002,  302,  351,  400,    0,  652,  701,
  750,  799, 1100, 1149,  848,  449,    0,    0,    0,    0,
    0,    0,    0,    0,    0, 1438, 1479,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0, -112,    0,
    0,    0,    0,    0,    0,    0,    0,  -51,    0,    0,
    0,    0, -251,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  267,    0,    0,    0,    0,    0,    0, -247,
    0,    0,    0,    0,    0,    0,    0,    0,   76,    0,
 -262,    0,    0,    0,   81,    0,  134,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0, -279,   95,
    0,    0,  138,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  391,    0,   43,    0,    0,    0,  -25,  -30,  -58,
  308,  -92,    0,  -57,  -53,    0,    0,    0,  347,  328,
   -6,  135,  198,  131,  190,  334,  335,    0,    0, -125,
    0,    0,    0,    0,    0,  -13,  210,    0,    0,    0,
    0,    0,    0,  392,    0,  330,  263, -157,  345,
};
final static int YYTABLESIZE=1783;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         39,
   30,   93,   56,   65,   60,  150,   98,   19,   64,  168,
  168,  117,  189,  118,  119,  120,  121,  119,   92,   92,
    5,  122,   90,  207,  208,   62,   63,  126,   16,  126,
   20,  127,  161,  127,   22,   32,   93,    1,    2,   21,
   68,   56,   14,  209,    3,    4,    5,   16,   16,   27,
   33,   34,   92,   14,    6,    7,   90,   22,  143,  123,
  152,  153,   56,   35,   36,   37,   38,  148,   27,  108,
  168,  168,   89,  136,   73,   74,   75,  126,  126,  187,
  170,  127,  127,  150,  138,    8,  146,  168,   25,  176,
    9,   89,  168,  147,  154,  155,  156,  168,   50,   90,
   37,   38,  185,   91,   36,   89,   92,   86,   77,   78,
   79,   80,   87,   90,   98,  173,   28,   91,   36,   30,
   92,  193,   29,  126,  126,   69,   70,  127,  127,  175,
  201,   86,  176,  184,   31,  186,  203,   55,  126,  126,
   71,   72,  127,  127,  200,  191,   86,   63,   59,  126,
  201,   67,  192,  127,  126,  126,   81,   82,  127,  127,
  126,   76,  126,   68,  127,  126,  127,  196,  197,  127,
  117,   32,  118,  119,  120,  121,  210,  167,  211,    5,
  122,   83,  156,   16,  119,   85,   33,   34,   84,  219,
   16,  221,   97,  213,   32,   16,   81,   86,  218,   35,
   36,   37,   38,  105,  106,  107,  223,   91,   36,   33,
   34,  109,  110,  111,  112,  159,  160,   99,  123,  102,
   16,  138,   35,   36,   37,   38,  141,   23,   23,   23,
   23,   23,   23,   23,   23,   16,   16,   23,   23,   23,
   23,   23,   23,   23,   23,   36,   16,   22,   16,   16,
   16,   16,  171,   16,   37,   38,   30,   30,   16,   16,
   16,   16,  142,   30,   30,   30,  145,   30,  103,  104,
  113,  114,   30,   30,   30,  151,  158,   30,   30,   30,
   30,   30,   30,   30,   30,   30,   30,   30,   30,   30,
   30,   30,   30,   30,   30,   30,   30,   30,  162,   30,
   30,   47,  163,  174,   30,   27,   27,  164,   30,   30,
   30,   30,   27,   27,   27,  165,   27,  166,  172,   27,
   27,   27,   27,   27,  177,   27,   27,   27,   27,   27,
   27,   27,   27,   27,  178,  179,   27,   27,   27,   27,
   27,   27,   27,   27,   27,   27,   27,  181,   27,  182,
   48,  183,  194,   27,   50,   50,  202,   27,   27,   27,
   27,   50,   50,   50,  198,   50,  199,  204,  215,  212,
   50,   50,   50,  217,  220,   50,   50,   50,   50,   50,
   50,   50,    1,   16,   94,   50,   50,   50,   50,   50,
   50,   50,   50,   50,   50,   50,   83,   50,   96,   49,
   84,   26,   50,   63,   63,  149,   50,   50,   50,   50,
   63,   63,   63,  101,   63,  137,  115,  214,  116,   63,
   63,   63,   61,  144,   63,   63,   63,   63,   63,   63,
   63,   63,  188,  140,   63,   63,   63,   63,   63,   63,
    0,   63,   63,   63,   63,    0,   63,    0,   64,    0,
    0,   63,   81,   81,    0,   63,   63,   63,   63,   81,
   81,   81,    0,   81,    0,    0,    0,    0,   81,   81,
   81,    0,    0,   81,   81,   81,   81,   81,   81,   81,
   81,    0,    0,   81,   81,   81,   81,   81,   81,   81,
    0,   81,   81,   81,    0,   81,    0,   41,    0,    0,
   81,   36,   36,    0,   81,   81,   81,   81,   36,   36,
   36,    0,   36,    0,    0,    0,    0,   36,   36,   36,
    0,    0,   36,   36,   36,   16,   36,   36,   36,   36,
    0,    0,   36,   36,   36,   36,   36,   36,   36,   36,
   16,   16,   36,    0,    0,    0,   53,    0,    0,   36,
    0,    0,    0,   16,   16,   16,   16,   47,   47,    0,
    0,    0,   16,   22,   47,   47,   47,    0,   47,   16,
    0,    0,    0,   47,   47,   47,   16,   16,   47,   47,
   47,   47,   47,   47,   47,    0,    0,    0,   47,   47,
   47,   47,   47,   47,   47,   47,   47,   47,   47,    0,
   47,    0,   61,    0,    0,   47,   48,   48,    0,   47,
   47,   47,   47,   48,   48,   48,    0,   48,    0,    0,
    0,    0,   48,   48,   48,    0,    0,   48,   48,   48,
   48,   48,   48,   48,    0,    0,    0,   48,   48,   48,
   48,   48,   48,   48,   48,   48,   48,   48,    0,   48,
    0,   56,    0,    0,   48,   49,   49,    0,   48,   48,
   48,   48,   49,   49,   49,    0,   49,    0,    0,    0,
    0,   49,   49,   49,    0,    0,   49,   49,   49,   49,
   49,   49,   49,    0,    0,    0,   49,   49,   49,   49,
   49,   49,   49,   49,   49,   49,   49,    0,   49,    0,
   57,    0,    0,   49,   64,   64,    0,   49,   49,   49,
   49,   64,   64,   64,    0,   64,    0,    0,    0,    0,
   64,   64,   64,    0,    0,   64,   64,   64,   64,   64,
   64,   64,   64,    0,    0,   64,   64,   64,   64,   64,
   64,    0,   64,   64,   64,   64,    0,   64,    0,   54,
    0,    0,   64,   41,   41,    0,   64,   64,   64,   64,
   41,   41,   41,    0,   41,    0,    0,    0,    0,   41,
   41,   41,    0,    0,    0,    0,   41,   41,   41,   41,
   41,   41,    0,    0,   41,   41,   41,   41,   41,   41,
   41,   41,   41,   41,   41,    0,   41,    0,   55,    0,
    0,   41,   53,   53,    0,   41,   41,   41,   41,   53,
   53,   53,    0,   53,    0,    0,    0,    0,   53,   53,
   53,    0,    0,   53,   53,    0,    0,   53,   53,   53,
   53,    0,    0,   53,   53,   53,   53,   53,   53,   53,
   53,   53,   53,   53,    0,   53,    0,   62,    0,    0,
   53,    0,    0,    0,   53,   53,   53,   53,   61,   61,
    0,    0,    0,    0,    0,   61,   61,   61,    0,   61,
    0,    0,    0,    0,   61,   61,   61,    0,    0,   61,
   61,   61,   61,   61,   61,   61,   61,    0,    0,   61,
   61,   61,   61,    0,    0,   61,   61,   61,   61,   61,
    0,   61,    0,   44,    0,    0,   61,   56,   56,    0,
   61,   61,   61,   61,   56,   56,   56,    0,   56,    0,
    0,    0,    0,   56,   56,   56,    0,    0,   56,   56,
    0,    0,   56,   56,   56,   56,    0,    0,   56,   56,
   56,   56,   56,   56,   56,   56,   56,   56,   56,    0,
   56,    0,   45,    0,    0,   56,   57,   57,    0,   56,
   56,   56,   56,   57,   57,   57,    0,   57,    0,    0,
    0,    0,   57,   57,   57,    0,    0,   57,   57,    0,
    0,   57,   57,   57,   57,    0,    0,   57,   57,   57,
   57,   57,   57,   57,   57,   57,   57,   57,    0,   57,
    0,   46,    0,    0,   57,   54,   54,    0,   57,   57,
   57,   57,   54,   54,   54,    0,   54,    0,    0,    0,
    0,   54,   54,   54,    0,    0,   54,   54,    0,    0,
   54,   54,   54,   54,    0,    0,   54,   54,   54,   54,
   54,   54,   54,   54,   54,   54,   54,    0,   54,    0,
   58,    0,    0,   54,   55,   55,    0,   54,   54,   54,
   54,   55,   55,   55,    0,   55,    0,    0,    0,    0,
   55,   55,   55,    0,    0,   55,   55,    0,    0,   55,
   55,   55,   55,    0,    0,   55,   55,   55,   55,   55,
   55,   55,   55,   55,   55,   55,    0,   55,    0,   60,
    0,    0,   55,   62,   62,    0,   55,   55,   55,   55,
   62,   62,   62,    0,   62,    0,    0,    0,    0,   62,
   62,   62,    0,    0,   62,   62,   62,   62,   62,   62,
   62,   62,    0,    0,   62,   62,   62,   62,    0,    0,
   62,   62,   62,   62,   62,    0,   62,    0,   59,    0,
    0,   62,    0,    0,    0,   62,   62,   62,   62,   44,
   44,    0,    0,    0,    0,    0,   44,   44,   44,    0,
   44,    0,    0,    0,    0,   44,   44,   44,    0,    0,
   44,   44,   44,   44,    0,    0,    0,   44,    0,    0,
   44,   44,   44,   44,   44,   44,   44,   44,   44,   44,
   44,    0,   44,    0,  104,    0,    0,   44,   45,   45,
    0,   44,   44,   44,   44,   45,   45,   45,  101,   45,
    0,    0,    0,    0,   45,   45,   45,    0,    0,   45,
   45,   45,   45,    0,    0,    0,   45,    0,    0,   45,
   45,   45,   45,   45,   45,   45,   45,   45,   45,   45,
    0,   45,    0,    0,    0,    0,   45,   46,   46,    0,
   45,   45,   45,   45,   46,   46,   46,   37,   46,    0,
    0,    0,    0,   46,   46,   46,    0,    0,   46,   46,
   46,   46,    0,    0,    0,   46,    0,    0,   46,   46,
   46,   46,   46,   46,   46,   46,   46,   46,   46,    0,
   46,    0,    0,    0,    0,   46,   58,   58,    0,   46,
   46,   46,   46,   58,   58,   58,    0,   58,    0,    0,
    0,    0,   58,   58,   58,    0,    0,   58,   58,   58,
   58,   58,   58,   58,   58,    0,    0,    0,    0,    0,
    0,   58,   58,   58,   58,   58,   58,   58,    0,   58,
    0,    0,    0,    0,   58,   60,   60,    0,   58,   58,
   58,   58,   60,   60,   60,    0,   60,    0,    0,    0,
    0,   60,   60,   60,    0,    0,   60,   60,   60,   60,
   60,   60,   60,   60,    0,    0,    0,    0,    0,    0,
   60,   60,   60,   60,   60,   60,   60,    0,   60,    0,
    0,    0,    0,   60,   59,   59,    0,   60,   60,   60,
   60,   59,   59,   59,    0,   59,    0,    0,    0,    0,
   59,   59,   59,    0,    0,   59,   59,   59,   59,   59,
   59,   59,   59,    0,    0,    0,    0,    0,    0,   59,
   59,   59,   59,   59,   59,   59,    0,   59,    0,    0,
    0,    0,   59,    0,    0,    0,   59,   59,   59,   59,
  104,  104,    0,    0,    0,    0,    0,  104,  104,  104,
    0,    0,    0,    0,  101,  101,    0,  104,  104,    0,
    0,  101,  101,  101,    0,    0,    0,    0,    0,    0,
    0,  101,  101,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  104,    0,    0,    0,    0,  104,    0,
    0,    0,    0,  104,    0,    0,    0,    0,    0,    0,
    0,    0,  101,   37,   37,    0,    0,  101,    0,    0,
   37,   37,   37,    0,   37,    0,    0,    0,    0,   37,
   37,   37,    0,    0,   37,   37,   37,    0,   37,   37,
   37,   37,    0,    0,   37,   37,   37,   37,   37,   37,
   37,   37,    0,    0,   37,  117,   37,  118,  119,  120,
  121,   37,  169,    0,    5,  122,  117,    0,  118,  119,
  120,  121,    0,  206,    0,    5,  122,    0,    0,   32,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   32,    0,    0,    0,   33,   34,    0,    0,    0,    0,
    0,    0,    0,  123,    0,   33,   34,   35,   36,   37,
   38,    0,    0,    0,  123,    0,    0,    0,   35,   36,
   37,   38,  117,    0,  118,  119,  120,  121,    0,  222,
    0,    5,  122,  117,    0,  118,  119,  120,  121,    0,
  224,    0,    5,  122,    0,    0,   32,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   32,    0,    0,
    0,   33,   34,    0,    0,    0,    0,    0,    0,    0,
  123,    0,   33,   34,   35,   36,   37,   38,    0,    0,
    0,  123,    0,    0,    0,   35,   36,   37,   38,  117,
    0,  118,  119,  120,  121,    0,    0,    0,    5,  122,
    0,    0,    0,    0,   25,   25,   25,   25,   25,   25,
   25,   25,    0,   32,   25,   25,   25,   25,   25,   25,
   25,   25,    0,    0,    0,    0,    0,    0,   33,   34,
    0,   25,    0,    0,    0,    0,    0,  123,    0,    0,
    0,   35,   36,   37,   38,   27,   27,   27,   27,   27,
   27,   27,   27,   27,   27,   27,   27,   27,   27,   27,
    0,   27,   27,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   27,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         25,
    0,   59,   28,   34,   30,   98,   65,  304,   34,  135,
  136,  256,  170,  258,  259,  260,  261,  297,  270,  271,
  265,  266,  270,  268,  269,   32,   33,   85,  308,   87,
  308,   85,  292,   87,  297,  280,   94,  256,  257,  308,
  300,   67,    0,  201,  263,  264,  265,  310,  311,    0,
  295,  296,  304,   11,  273,  274,  304,  308,  263,  304,
  118,  119,   88,  308,  309,  310,  311,   98,  306,   76,
  196,  197,  296,   87,  281,  282,  283,  135,  136,  303,
  139,  135,  136,  176,  308,  304,  296,  213,  292,  148,
  309,  296,  218,  303,  120,  121,  122,  223,    0,  304,
  310,  311,  160,  308,  309,  296,  311,  299,  287,  288,
  289,  290,  304,  304,  173,  146,  298,  308,  309,  292,
  311,  179,  298,  181,  182,  277,  278,  181,  182,  297,
  189,  299,  191,  159,  299,  161,  194,  298,  196,  197,
  279,  280,  196,  197,  297,  176,  299,    0,  304,  207,
  209,  298,  178,  207,  212,  213,  291,  292,  212,  213,
  218,  284,  220,  300,  218,  223,  220,  181,  182,  223,
  256,  280,  258,  259,  260,  261,  202,  263,  204,  265,
  266,  293,  208,  296,  297,  304,  295,  296,  294,  215,
  303,  217,  297,  207,  280,  308,    0,  299,  212,  308,
  309,  310,  311,   73,   74,   75,  220,  308,  309,  295,
  296,   77,   78,   79,   80,  285,  286,  297,  304,  308,
  280,  308,  308,  309,  310,  311,  308,  277,  278,  279,
  280,  281,  282,  283,  284,  295,  296,  287,  288,  289,
  290,  291,  292,  293,  294,    0,  296,  297,  308,  309,
  310,  311,  297,  303,  310,  311,  256,  257,  310,  311,
  310,  311,  304,  263,  264,  265,  304,  267,   71,   72,
   81,   82,  272,  273,  274,  304,  304,  277,  278,  279,
  280,  281,  282,  283,  284,  285,  286,  287,  288,  289,
  290,  291,  292,  293,  294,  295,  296,  297,  304,  299,
  300,    0,  304,  297,  304,  256,  257,  304,  308,  309,
  310,  311,  263,  264,  265,  304,  267,  304,  304,  270,
  271,  272,  273,  274,  297,  276,  277,  278,  279,  280,
  281,  282,  283,  284,  270,  276,  287,  288,  289,  290,
  291,  292,  293,  294,  295,  296,  297,  304,  299,  267,
    0,  263,  271,  304,  256,  257,  257,  308,  309,  310,
  311,  263,  264,  265,  297,  267,  297,  270,  272,  304,
  272,  273,  274,  257,  304,  277,  278,  279,  280,  281,
  282,  283,    0,  308,  304,  287,  288,  289,  290,  291,
  292,  293,  294,  295,  296,  297,  263,  299,  304,    0,
  263,   11,  304,  256,  257,   98,  308,  309,  310,  311,
  263,  264,  265,   67,  267,   88,   83,  208,   84,  272,
  273,  274,   31,   94,  277,  278,  279,  280,  281,  282,
  283,  284,  170,   89,  287,  288,  289,  290,  291,  292,
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
   -1,   -1,  296,  297,  263,  264,  265,   -1,  267,  303,
   -1,   -1,   -1,  272,  273,  274,  310,  311,  277,  278,
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
   -1,  304,   -1,   -1,   -1,  308,  309,  310,  311,  256,
   -1,  258,  259,  260,  261,   -1,   -1,   -1,  265,  266,
   -1,   -1,   -1,   -1,  277,  278,  279,  280,  281,  282,
  283,  284,   -1,  280,  287,  288,  289,  290,  291,  292,
  293,  294,   -1,   -1,   -1,   -1,   -1,   -1,  295,  296,
   -1,  304,   -1,   -1,   -1,   -1,   -1,  304,   -1,   -1,
   -1,  308,  309,  310,  311,  277,  278,  279,  280,  281,
  282,  283,  284,  285,  286,  287,  288,  289,  290,  291,
   -1,  293,  294,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  304,
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
"commaq : COMMA",
"commaq :",
"pair : LPAREN atom commaq NIL RPAREN",
"pair : LPAREN atom commaq atom RPAREN",
"pair : LPAREN atom commaq pair RPAREN",
"pair : LPAREN atoms RPAREN",
"atoms : atom commaq atoms",
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
"assignment_expression : identifier LIST_OP_PUSH expression",
"assignment_expression : identifier LIST_OP_POP identifier",
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
"molecule_def : pairs NEWLINE",
"molecule_def : NEWLINE",
"atomss : IDENTIFIER",
"pairs : LPAREN atomss commaq NIL RPAREN",
"pairs : LPAREN atomss commaq atomss RPAREN",
"pairs : LPAREN atomss commaq pairs RPAREN",
"pairs : LPAREN atomsss RPAREN",
"atomsss : atomss commaq atomsss",
"atomsss : atomss",
};

//#line 299 "snow.y"


	protected Parser(Reader r) {
	    lexer = new Yylex(r, this);
	  }
	public static void main(String args[]) throws IOException {
	    Parser yyparser = new Parser(new FileReader(args[0]));
	    yyparser.yyparse();    
	  }
//#line 798 "Parser.java"
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
//#line 57 "snow.y"
{yyval= new ParserVal(",");}
break;
case 16:
//#line 58 "snow.y"
{yyval=new ParserVal(",");}
break;
case 17:
//#line 62 "snow.y"
{ yyval.sval = val_peek(3).sval;}
break;
case 18:
//#line 63 "snow.y"
{ yyval.sval = val_peek(3).sval + "," + val_peek(1).sval;}
break;
case 19:
//#line 64 "snow.y"
{ yyval.sval = val_peek(3).sval + "," + val_peek(1).sval;}
break;
case 20:
//#line 65 "snow.y"
{ yyval.sval = val_peek(1).sval;}
break;
case 21:
//#line 69 "snow.y"
{ yyval.sval = val_peek(2).sval + "," + val_peek(0).sval;}
break;
case 22:
//#line 70 "snow.y"
{ yyval.sval = val_peek(0).sval;}
break;
case 23:
//#line 75 "snow.y"
{yyval=val_peek(0);}
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
{yyval.sval = "(" + val_peek(1).sval + ")";}
break;
case 27:
//#line 82 "snow.y"
{yyval= val_peek(0);}
break;
case 28:
//#line 83 "snow.y"
{ yyval = new ParserVal("symbols.get(\""+val_peek(0).sval+"\")");}
break;
case 29:
//#line 87 "snow.y"
{ yyval = buildCompoundIdentifier(val_peek(2),val_peek(0)); }
break;
case 30:
//#line 88 "snow.y"
{yyval = val_peek(0);}
break;
case 31:
//#line 91 "snow.y"
{yyval=val_peek(0);}
break;
case 32:
//#line 92 "snow.y"
{yyval = doOp("increment",val_peek(1),null); }
break;
case 33:
//#line 93 "snow.y"
{yyval = doOp("decrement",val_peek(1),null); }
break;
case 34:
//#line 94 "snow.y"
{yyval=val_peek(0);}
break;
case 35:
//#line 98 "snow.y"
{ yyval = executeFunction(val_peek(2),val_peek(0)); }
break;
case 36:
//#line 101 "snow.y"
{yyval = val_peek(0);}
break;
case 37:
//#line 102 "snow.y"
{yyval.sval = "";}
break;
case 38:
//#line 106 "snow.y"
{yyval = new ParserVal(val_peek(2).sval+","+val_peek(0).sval);}
break;
case 39:
//#line 107 "snow.y"
{yyval = val_peek(0);}
break;
case 40:
//#line 111 "snow.y"
{yyval = val_peek(0); }
break;
case 41:
//#line 115 "snow.y"
{yyval=val_peek(0);}
break;
case 42:
//#line 116 "snow.y"
{yyval = doOp("minus",new ParserVal("0"),val_peek(0));}
break;
case 43:
//#line 117 "snow.y"
{yyval = doOp("log_not",val_peek(0),null);}
break;
case 44:
//#line 122 "snow.y"
{yyval=val_peek(0);}
break;
case 45:
//#line 123 "snow.y"
{yyval = doOp("plus",val_peek(2),val_peek(0));}
break;
case 46:
//#line 124 "snow.y"
{yyval = doOp("minus",val_peek(2),val_peek(0));}
break;
case 47:
//#line 128 "snow.y"
{yyval = doOp("times",val_peek(2),val_peek(0));}
break;
case 48:
//#line 129 "snow.y"
{yyval = doOp("divide",val_peek(2),val_peek(0));}
break;
case 49:
//#line 130 "snow.y"
{yyval = doOp("modulo",val_peek(2),val_peek(0));}
break;
case 50:
//#line 131 "snow.y"
{yyval=val_peek(0);}
break;
case 51:
//#line 134 "snow.y"
{yyval=val_peek(0);}
break;
case 52:
//#line 135 "snow.y"
{yyval = doOp("power",val_peek(2),val_peek(0));}
break;
case 53:
//#line 139 "snow.y"
{yyval = val_peek(0);}
break;
case 54:
//#line 140 "snow.y"
{yyval = doOp("lt",val_peek(2),val_peek(0));}
break;
case 55:
//#line 141 "snow.y"
{yyval = doOp("gt",val_peek(2),val_peek(0));}
break;
case 56:
//#line 142 "snow.y"
{yyval = doOp("le",val_peek(2),val_peek(0));}
break;
case 57:
//#line 143 "snow.y"
{yyval = doOp("ge",val_peek(2),val_peek(0));}
break;
case 58:
//#line 147 "snow.y"
{yyval = val_peek(0);}
break;
case 59:
//#line 148 "snow.y"
{yyval = doOp("equals",val_peek(2),val_peek(0));}
break;
case 60:
//#line 149 "snow.y"
{yyval = doOp("nequals",val_peek(2),val_peek(0));}
break;
case 61:
//#line 153 "snow.y"
{yyval=val_peek(0);}
break;
case 62:
//#line 154 "snow.y"
{yyval = doOp("log_and",val_peek(2),val_peek(0));}
break;
case 63:
//#line 158 "snow.y"
{yyval=val_peek(0);}
break;
case 64:
//#line 159 "snow.y"
{yyval = doOp("log_or",val_peek(2),val_peek(0));}
break;
case 65:
//#line 163 "snow.y"
{ yyval = assignVariable(val_peek(2),val_peek(0)); }
break;
case 66:
//#line 164 "snow.y"
{ yyval = Push(val_peek(2),val_peek(0)); }
break;
case 67:
//#line 165 "snow.y"
{ yyval = Pop(val_peek(2),val_peek(0)); }
break;
case 68:
//#line 170 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 69:
//#line 171 "snow.y"
{yyval=val_peek(1);}
break;
case 70:
//#line 172 "snow.y"
{yyval=val_peek(1);}
break;
case 71:
//#line 173 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 72:
//#line 174 "snow.y"
{yyval=addLineEnding(val_peek(1));}
break;
case 73:
//#line 175 "snow.y"
{yyval=val_peek(1);}
break;
case 75:
//#line 177 "snow.y"
{ System.err.println("Line Number:" + lexer.ln + "\t Error:In Statement");}
break;
case 76:
//#line 180 "snow.y"
{yyval.sval = "return " +  val_peek(0).sval + ";\n";}
break;
case 77:
//#line 183 "snow.y"
{ yyval=val_peek(0); }
break;
case 78:
//#line 184 "snow.y"
{yyval =new ParserVal(val_peek(1).sval+val_peek(0).sval);}
break;
case 79:
//#line 188 "snow.y"
{yyval=val_peek(0);}
break;
case 80:
//#line 192 "snow.y"
{yyval=val_peek(0);}
break;
case 81:
//#line 197 "snow.y"
{yyval=val_peek(0);}
break;
case 82:
//#line 201 "snow.y"
{ yyval = makeFullIfStatement(val_peek(1)); }
break;
case 83:
//#line 205 "snow.y"
{yyval = makePartialIfElse(val_peek(2),val_peek(0), null);}
break;
case 84:
//#line 206 "snow.y"
{yyval = makePartialIfElse(val_peek(4),val_peek(2), val_peek(0));}
break;
case 85:
//#line 207 "snow.y"
{yyval = makePartialIfElseIf(val_peek(4),val_peek(2), val_peek(0));}
break;
case 86:
//#line 211 "snow.y"
{ yyval = doWhile(val_peek(3),val_peek(1)); }
break;
case 87:
//#line 212 "snow.y"
{ yyval = doFor(val_peek(8),val_peek(6),val_peek(4),val_peek(3),val_peek(1)); }
break;
case 88:
//#line 213 "snow.y"
{ yyval = doForeach(val_peek(6),val_peek(5),val_peek(4),val_peek(3),val_peek(1)); }
break;
case 89:
//#line 217 "snow.y"
{ yyval = val_peek(0); }
break;
case 90:
//#line 218 "snow.y"
{yyval = null; }
break;
case 91:
//#line 222 "snow.y"
{ yyval = val_peek(0); }
break;
case 92:
//#line 223 "snow.y"
{yyval = null; }
break;
case 93:
//#line 227 "snow.y"
{ yyval = new ParserVal(val_peek(2).sval + ":" + val_peek(0).sval); }
break;
case 94:
//#line 228 "snow.y"
{yyval = null; }
break;
case 95:
//#line 232 "snow.y"
{ yyval = val_peek(0);}
break;
case 96:
//#line 233 "snow.y"
{ yyval = null;}
break;
case 97:
//#line 237 "snow.y"
{ 
				yyval = createDebugHook(val_peek(5),val_peek(4),val_peek(1));
				}
break;
case 98:
//#line 243 "snow.y"
{yyval = new ParserVal("before"); }
break;
case 99:
//#line 244 "snow.y"
{yyval = new ParserVal("after"); }
break;
case 100:
//#line 248 "snow.y"
{ yyval = createFunction(val_peek(5),val_peek(3),val_peek(1)); }
break;
case 101:
//#line 251 "snow.y"
{yyval = val_peek(0);}
break;
case 102:
//#line 255 "snow.y"
{yyval = val_peek(0);}
break;
case 103:
//#line 256 "snow.y"
{yyval.sval = val_peek(2).sval +val_peek(0).sval;}
break;
case 104:
//#line 260 "snow.y"
{ yyval = declareLocalVariable(val_peek(0)); }
break;
case 105:
//#line 261 "snow.y"
{ yyval = declareLocalVariable(val_peek(2),val_peek(0)); }
break;
case 106:
//#line 265 "snow.y"
{ yyval = defineMolecule(val_peek(4),val_peek(1)); }
break;
case 107:
//#line 269 "snow.y"
{yyval = val_peek(0);}
break;
case 108:
//#line 270 "snow.y"
{ yyval= new ParserVal(val_peek(1).sval +val_peek(0).sval); }
break;
case 109:
//#line 274 "snow.y"
{ yyval = moleLazyCreate(val_peek(2),val_peek(1));}
break;
case 110:
//#line 275 "snow.y"
{ yyval = moleCreateOne(val_peek(1));  }
break;
case 111:
//#line 276 "snow.y"
{ yyval = moleCreateFromPair(val_peek(1));  }
break;
case 113:
//#line 281 "snow.y"
{yyval.sval = val_peek(0).sval;}
break;
case 114:
//#line 285 "snow.y"
{ yyval.sval = val_peek(3).sval;}
break;
case 115:
//#line 286 "snow.y"
{ yyval.sval = val_peek(3).sval + "," + val_peek(1).sval;}
break;
case 116:
//#line 287 "snow.y"
{ yyval.sval = val_peek(3).sval + "," + val_peek(1).sval;}
break;
case 117:
//#line 288 "snow.y"
{ yyval.sval = val_peek(1).sval;}
break;
case 118:
//#line 292 "snow.y"
{ yyval.sval = val_peek(2).sval + "," + val_peek(0).sval;}
break;
case 119:
//#line 293 "snow.y"
{ yyval.sval = val_peek(0).sval;}
break;
//#line 1426 "Parser.java"
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
