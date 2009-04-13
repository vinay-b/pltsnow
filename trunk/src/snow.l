package com.google.code.pltsnow.gen;
%%

%byaccj

%{
  /* store a reference to the parser object */
  private static Parser yyparser;

  /* constructor taking an additional parser object */
  public Yylex(java.io.Reader r, Parser yyparser) {
    this(r);
    this.yyparser = yyparser;
  }
%}

digit=		[0-9]
ncc=		[^#|]|\n
%%

\#.*\n						{return yyparser.NEWLINE;}
#\|(#|{ncc})*\|\|*({ncc}(#|{ncc})*\|\|*)*#	{return yyparser.NEWLINE;}
to					{	return yyparser.TO;}
for				{	return yyparser.FOR;}
foreach				{	return yyparser.FOREACH;}
each				{	return yyparser.EACH;}
while				{	return yyparser.WHILE;}
return				{	return yyparser.RETURN;}
do				{	return yyparser.DO;}
end				{	return yyparser.END;}
define				{	return yyparser.DEFINE;}
var				{	return yyparser.VAR;}
if				{	return yyparser.IF;}
then				{	return yyparser.THEN;}
else				{	return yyparser.ELSE;}
elseif				{	return yyparser.ELSIF;}
elsif				{	return yyparser.ELSIF;}
from				{	return yyparser.FROM;}
as				{	return yyparser.AS;}
in				{	return yyparser.IN;}
by				{	return yyparser.BY;}
nil				{	return yyparser.NIL;}
true				{	return yyparser.TRUE;}
false				{	return yyparser.FALSE;}
before				{	return yyparser.BEFORE;}
after				{	return yyparser.AFTER;}
"++"					{	return yyparser.PLUSPLUS;}
"--"					{	return yyparser.MINUSMINUS;}
"+"					{	return yyparser.PLUS;}
"-"					{	return yyparser.MINUS;}
"*"					{	return yyparser.MUL;}
"/"					{	return yyparser.DIV;}
"%"					{	return yyparser.MODULO;}
"^"					{	return yyparser.POWER;}	
"<<"					{	return yyparser.LIST_OP_PUSH;}
">>"					{	return yyparser.LIST_OP_POP;}
"<="					{	return yyparser.REL_OP_LE;}
"<"					{	return yyparser.REL_OP_LT;}
">="					{	return yyparser.REL_OP_GE;}
">"					{	return yyparser.REL_OP_GT;}
"="					{	return yyparser.EQUALS;}
"!="					{	return yyparser.REL_OP_NE;}
"and"|"&&"				{	return yyparser.LOG_OP_AND;}
"or"|"||"					{	return yyparser.LOG_OP_OR;}
"not"|"!"					{	return yyparser.LOG_OP_NOT;}
"("					{	return yyparser.LPAREN;}
")"					{	return yyparser.RPAREN;}
":"					{	return yyparser.COLON;}
","					{	return yyparser.COMMA;}
\.					{	return yyparser.DOT;}
generation|termination|mutation|mating|selection|organismConstructed|organismKilled|organismMutated|organismMatesWithOrganism|childBorn|organismFitnessChanges	{	yyparser.yylval = new ParserVal(yytext()); return yyparser.EVENT_NAME_IDENTIFIER;}
[a-zA-Z][a-zA-Z0-9]*			{	yyparser.yylval = new ParserVal(yytext()); return yyparser.IDENTIFIER;}
\~[a-zA-Z][a-zA-Z0-9]*			{	yyparser.yylval = new ParserVal(yytext()); return yyparser.SYS_IDENTIFIER;}
\"([^\"]|\\\"|\\n)*\"|\'([^\']|\\\'\\n)*\'	{	yyparser.yylval = new ParserVal(yytext()); return yyparser.STRING;}
-?{digit}*(\.{digit}+)?			{	yyparser.yylval = new ParserVal(yytext()); return yyparser.NUMERIC;}
\n					{	yyparser.yylval= new ParserVal("\n"); return yyparser.NEWLINE;}
[ \t]					{}
.					{ return 0;}
