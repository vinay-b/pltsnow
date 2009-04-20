%{
import java.lang.Math;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
%}


%token TO FOR FOREACH WHILE RETURN DO END DEFINE VAR IF THEN ELSE ELSIF FROM AS BY BEFORE AFTER EACH IN
%token PLUSPLUS MINUSMINUS PLUS MINUS MUL DIV MODULO POWER LIST_OP_PUSH LIST_OP_POP REL_OP_LE REL_OP_GE REL_OP_LT REL_OP_GT REL_OP_NE EQUALS LOG_OP_AND LOG_OP_OR LOG_OP_NOT LPAREN RPAREN COLON COMMA DOT
%token TRUE FALSE NIL
%token NEWLINE SPACE
%token EVENT_NAME_IDENTIFIER
%token RESERVED_IDENTIFIER
%token IDENTIFIER
%token SYS_IDENTIFIER
%token STRING
%token NUMERIC

%%
program_program : program_unit {
System.out.println("import com.google.code.pltsnow.snowfield.*;");
System.out.println("import com.google.code.pltsnow.gen.*;");
System.out.println("import java.util.ArrayList;");

System.out.println("public class SnowProgramImp extends BaseSnowProgram {\n");
System.out.println($1.sval);
System.out.println("public static void main(String[] args) {	SnowProgramImp this_prog = new SnowProgramImp(); this_prog.startProgram();}");
System.out.println("}");
}
program_unit		:	external_declaration {$$=$1;}
			|	program_unit external_declaration {$$ = new ParserVal($1.sval + $2.sval);}
			;

external_declaration	:
				function_declarator {$$=$1;}
			|	var_declarator {$$=$1;}
			|	molecule_declarator {$$=$1;}
			|	debug_hook_declarator {$$=$1;}
			|	global_variable_assignment {$$=$1;}
			|	NEWLINE {$$=$1;}
			;
				
global_variable_assignment	:
				SYS_IDENTIFIER EQUALS expression { $$ = assignVariable($1,$3); }
			;

atom			:
				NUMERIC {$$.sval= "new SnowAtom("+$1.sval+")";}
			|	STRING {$$.sval= "new SnowAtom("+$1.sval+")";}
			;

commaq			:
					COMMA {$$= new ParserVal(",");}
			| 		{$$=new ParserVal(",");}
			;

pair			:
				LPAREN atom commaq NIL RPAREN
			|	LPAREN atom commaq atom RPAREN
			|	LPAREN atom commaq pair RPAREN
			|	LPAREN atoms RPAREN
			;

atoms			:
				atoms commaq atom
			|	atom
			;


primary_expression	:
				atom {$$=$1;}
			|	pair {$$=$1;}
			|	identifier {$$=$1;}
			|	LPAREN expression RPAREN {$$.sval = "(" + $2.sval + ")";}
			;

identifier		:
				compound_identifier {$$= $1;}
			|	SYS_IDENTIFIER { $$ = new ParserVal("symbols.get(\""+$1.sval+"\")");}
			;

compound_identifier	:
				compound_identifier DOT IDENTIFIER { $$ = buildCompoundIdentifier($1,$3); }
			|	IDENTIFIER {$$ = $1;}
			;
postfix_expression	:
				primary_expression {$$=$1;}
			|	postfix_expression PLUSPLUS {$$ = doOp("plus",$1,new ParserVal(1)); }
			|	postfix_expression MINUSMINUS {$$ = doOp("minus",$1,new ParserVal(1)); }
			|	function_expression {$$=$1;}
			;

function_expression	:
				IDENTIFIER COLON params_opt { $$ = executeFunction($1,$3); }
			;

params_opt		:	params {$$ = $1;}
			|		{$$.sval = "";}
			;

params			:
				params commaq param {$$ = new ParserVal($1.sval+","+$3.sval);}
			| 	param {$$ = $1;}
			;

param			:
				expression {$$ = $1; }
			;

unary_expression	:
				postfix_expression {$$=$1;}
			|	MINUS unary_expression {$$ = doOp("minus",new ParserVal(0),$2);}
			|	LOG_OP_NOT unary_expression {$$ = doOp("log_not",$2,null);}
			;


additive_expression	:
				multiplicative_expression {$$=$1;}
			|	additive_expression PLUS multiplicative_expression {$$ = doOp("plus",$1,$3);}
			|	additive_expression MINUS multiplicative_expression {$$ = doOp("minus",$1,$3);}
			;

multiplicative_expression:
				multiplicative_expression MUL pow_expression {$$ = doOp("times",$1,$3);}
			|	multiplicative_expression DIV pow_expression {$$ = doOp("divide",$1,$3);}
			|	multiplicative_expression MODULO pow_expression {$$ = doOp("modulo",$1,$3);}
			|	pow_expression {$$=$1;}
			;
pow_expression		:
				unary_expression {$$=$1;}
			|	pow_expression POWER unary_expression {$$ = doOp("power",$1,$3);}
			;

relational_expression	:
				additive_expression {$$ = $1;}
			|	relational_expression REL_OP_LT additive_expression {$$ = doOp("lt",$1,$3);}
			|	relational_expression REL_OP_GT additive_expression {$$ = doOp("gt",$1,$3);}
			|	relational_expression REL_OP_LE additive_expression {$$ = doOp("le",$1,$3);}
			|	relational_expression REL_OP_GE additive_expression {$$ = doOp("ge",$1,$3);}
			;

equality_expression	:
				relational_expression {$$ = $1;}
			|	equality_expression EQUALS relational_expression {$$ = doOp("equals",$1,$3);}
			|	equality_expression REL_OP_NE relational_expression {$$ = doOp("nequals",$1,$3);}
			;

logical_and_expression:
				equality_expression {$$=$1;}
			|	logical_and_expression LOG_OP_AND equality_expression  {$$ = doOp("log_and",$2,null);}
			;

logical_or_expression	:
				logical_and_expression {$$=$1;}
			|	logical_or_expression LOG_OP_OR logical_and_expression {$$ = doOp("log_or",$2,null);}
			;

assignment_expression	:
				compound_identifier EQUALS expression { $$ = assignVariable($1,$3); }
			;

statement		: 
				expression_statement NEWLINE {$$=addLineEnding($1);}
			|	selection_statement NEWLINE {$$=$1;}
			|	iteration_statement NEWLINE {$$=$1;}
			|	var_declarator NEWLINE {$$=addLineEnding($1);}
			|	assignment_statement NEWLINE {$$=addLineEnding($1);}
			|	return_statement NEWLINE {$$=$1;}
			|	NEWLINE
			;
return_statement:
					RETURN expression {$$.sval = "return " +  $2.sval + ";\n";}
			;
statements		:
				statement { $$=$1; }
			|	statements statement {$$ =new ParserVal($1.sval+$2.sval);} 
			;

assignment_statement	:
				assignment_expression {$$=$1;}
			;

expression_statement	:
				expression {$$=$1;}
			;

expression		:
				logical_or_expression {$$=$1;}
			;

selection_statement	:
				IF partial_selection_statement END { $$ = makeFullIfStatement($2); }
			;

partial_selection_statement:
				expression THEN statements {$$ = makePartialIfElse($1,$3, null);}
			|	expression THEN statements ELSE statements {$$ = makePartialIfElse($1,$3, $5);}
			|	expression THEN statements ELSIF partial_selection_statement {$$ = makePartialIfElseIf($1,$3, $5);}
			;

iteration_statement	:
				WHILE expression NEWLINE statements END { $$ = doWhile($2,$4); }
			|	FOR identifier FROM expression TO expression by_statement NEWLINE statements END { $$ = doFor($2,$4,$6,$7,$9); }
			|	FOREACH identifier in_statement as_statement from_statement NEWLINE statements END { $$ = doForeach($2,$3,$4,$5,$7); }
			;

as_statement		:
				AS identifier 	{ $$ = $2; }
			| 			{$$ = null; }
			;

in_statement		:
				IN identifier { $$ = $2; }
			| {$$ = null; }
			;

from_statement		:
				FROM expression TO expression { $$ = new ParserVal($2.sval + ":" + $4.sval); }
			| {$$ = null; }
			;

by_statement		:
				BY expression	{ $$ = $2;}
			|	{ $$ = null;}
			;

debug_hook_declarator	:
				time_seq EVENT_NAME_IDENTIFIER COLON NEWLINE statements END { 
				$$ = createDebugHook($1,$2,$5);
				}
			;

time_seq		:
				BEFORE {$$ = new ParserVal("before"); }
			|	AFTER {$$ = new ParserVal("after"); }
			;

function_declarator	:
				TO IDENTIFIER COLON params NEWLINE statements END { $$ = createFunction($2,$4,$6); }
			;
var_declarator		:
				VAR declaration_list {$$ = $2;}
			;

declaration_list	:
				declarator {$$ = $1;}
			|	declaration_list COMMA declarator {$$.sval = $1.sval + ";\n"+$2.sval;}
			;

declarator		:	
				IDENTIFIER { $$ = declareLocalVariable($1); }
			|	IDENTIFIER EQUALS expression { $$ = declareLocalVariable($1,$3); }
			;

molecule_declarator	:
				DEFINE IDENTIFIER COLON NEWLINE molecule_defs END { $$ = defineMolecule($2,$5); }
			;

molecule_defs		:
				molecule_def {$$ = $1;}
			|	molecule_defs molecule_def { $$= new ParserVal($1.sval +$2.sval); }
			;

molecule_def		:
				NUMERIC IDENTIFIER NEWLINE { $$ = moleLazyCreate($1,$2);}
			|	identifier NEWLINE { $$ = moleCreateOne($1);  }
			|	pair NEWLINE 
			|	NEWLINE
			;


%%

	protected Parser(Reader r) {
	    lexer = new Yylex(r, this);
	  }
	public static void main(String args[]) throws IOException {
	    Parser yyparser = new Parser(new FileReader(args[0]));
	    yyparser.yyparse();    
	  }
