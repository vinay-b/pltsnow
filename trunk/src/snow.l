%{
#include "y.tab.h"
%}
digit		[0-9]
ncc		[^#|]|\n
%%
\#.*\n						{return NEWLINE;}
#\|(#|{ncc})*\|\|*({ncc}(#|{ncc})*\|\|*)*#	{return NEWLINE;}
to					{	return TO;}
for					{	return FOR;}
foreach					{	return FOREACH;}
each					{	return EACH;}
while					{	return WHILE;}
return					{	return RETURN;}
do					{	return DO;}
end					{	return END;}
define					{	return DEFINE;}
var					{	return VAR;}
if					{	return IF;}
then					{	return THEN;}
else					{	return ELSE;}
elseif					{	return ELSIF;}
elsif					{	return ELSIF;}
from					{	return FROM;}
as					{	return AS;}
in					{	return IN;}
by					{	return BY;}
nil					{	return NIL;}
true					{	return TRUE;}
false					{	return FALSE;}
before					{	return BEFORE;}
after					{	return AFTER;}
"++"					{	return PLUSPLUS;}
"--"					{	return MINUSMINUS;}
"+"					{	return PLUS;}
"-"					{	return MINUS;}
"*"					{	return MUL;}
"/"					{	return DIV;}
"%"					{	return MODULO;}
"^"					{	return POWER;}	
"<<"					{	return LIST_OP_PUSH;}
">>"					{	return LIST_OP_POP;}
"<="					{	return REL_OP_LE;}
"<"					{	return REL_OP_LT;}
">="					{	return REL_OP_GE;}
">"					{	return REL_OP_GT;}
"="					{	return EQUALS;}
"!="					{	return REL_OP_NE;}
and|"&&"				{	return LOG_OP_AND;}
or|"||"					{	return LOG_OP_OR;}
not|"!"					{	return LOG_OP_NOT;}
"("					{	return LPAREN;}
")"					{	return RPAREN;}
":"					{	return COLON;}
","					{	return COMMA;}
\.					{	return DOT;}
generation|termination|mutation|mating|selection|organismConstructed|organismKilled|organismMutated|organismMatesWithOrganism|childBorn|organismFitnessChanges	{	return EVENT_NAME_IDENTIFIER;}
[a-zA-Z][a-zA-Z0-9]*			{	return IDENTIFIER;}
\~[a-zA-Z][a-zA-Z0-9]*			{	return SYS_IDENTIFIER;}
\"([^"]|\\\"|\\n)*\"|\'([^']|\\\'\\n)*\'	{	return STRING;}
-?{digit}*(\.{digit}+)?			{	return NUMERIC;}
\n					{	return NEWLINE;}
[ \t]					{}
.					{	ECHO; return yytext[0];}
