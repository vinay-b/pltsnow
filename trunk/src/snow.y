%{
import java.lang.Math;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
%}


%token TO FOR FOREACH WHILE RETURN DO END DEFINE VAR IF THEN ELSE ELSIF FROM AS BY BEFORE AFTER EACH IN
%token PLUSPLUS MINUSMINUS PLUS MINUS MUL DIV MODULO POWER LIST_OP_PUSH LIST_OP_POP REL_OP_LE REL_OP_GE REL_OP_LT REL_OP_GT REL_OP_NE EQUALS LOG_OP_AND LOG_OP_OR LOG_OP_NOT LPAREN RPAREN COLON COMMA DOT
%token TRUE FALSE NIL
%token NEWLINE
%token EVENT_NAME_IDENTIFIER
%token RESERVED_IDENTIFIER
%token IDENTIFIER
%token SYS_IDENTIFIER
%token STRING
%token NUMERIC

%%
program_program : program_unit {
System.out.println("public class SnowProgramImp extends BaseSnowProgram {\n");
System.out.println($1.sval);
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
				NUMERIC {$$=$1;}
			|	STRING {$$=$1;}
			;

commaq			:
				COMMA {$$= new ParserVal(",");}
			| {$$=new ParserVal("");}
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
			|	LPAREN expression RPAREN 
			;

identifier		:
				compound_identifier {$$= $1;}
			|	SYS_IDENTIFIER { $$ = new ParserVal("symbols.get(\""+$1.sval+"\")");}
			;

compound_identifier	:
				compound_identifier DOT IDENTIFIER { $$ = new ParserVal($1.sval+"."+$3.sval); }
			|	IDENTIFIER {$$ = $1;}
			;
postfix_expression	:
				primary_expression {$$=$1;}
			|	postfix_expression PLUSPLUS
			|	postfix_expression MINUSMINUS
			|	function_expression {$$=$1;}
			;

function_expression	:
				IDENTIFIER COLON params { $$ = executeFunction($1,$3); }
			;

params			:
				params commaq param {$$ = new ParserVal($1.sval+$2.sval+$3.sval);}
			| {$$ = new ParserVal("");}
			;

param			:
				expression {$$ = $1; }
			;

unary_expression	:
				postfix_expression {$$=$1;}
			|	MINUS unary_expression
			|	LOG_OP_NOT unary_expression
			;


additive_expression	:
				multiplicative_expression {$$=$1;}
			|	additive_expression PLUS multiplicative_expression
			|	additive_expression MINUS multiplicative_expression 
			;

multiplicative_expression:
				multiplicative_expression MUL pow_expression
			|	multiplicative_expression DIV pow_expression
			|	multiplicative_expression MODULO pow_expression
			|	pow_expression {$$=$1;}
			;
pow_expression		:
				unary_expression {$$=$1;}
			|	pow_expression POWER unary_expression
			;

relational_expression	:
				additive_expression {$$ = $1;}
			|	relational_expression REL_OP_LT additive_expression
			|	relational_expression REL_OP_GT additive_expression
			|	relational_expression REL_OP_LE additive_expression
			|	relational_expression REL_OP_GE additive_expression
			;

equality_expression	:
				relational_expression {$$ = $1;}
			|	equality_expression EQUALS relational_expression
			|	equality_expression REL_OP_NE relational_expression
			;

logical_and_expression:
				equality_expression {$$=$1;}
			|	logical_and_expression LOG_OP_AND equality_expression 
			;

logical_or_expression	:
				logical_and_expression {$$=$1;}
			|	logical_or_expression LOG_OP_OR logical_and_expression
			;

assignment_expression	:
				compound_identifier EQUALS expression { $$ = assignVariable($1,$3); }
			;

statement		: 
				expression_statement NEWLINE {$$=$1;}
			|	selection_statement NEWLINE {$$=$1;}
			|	iteration_statement NEWLINE {$$=$1;}
			|	var_declarator NEWLINE {$$=$1;}
			|	assignment_statement NEWLINE {$$=$1;}
			|	NEWLINE
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
				IF partial_selection_statement END
			;

partial_selection_statement:
				expression THEN statements
			|	expression THEN statements ELSE statements
			|	expression THEN statements ELSIF partial_selection_statement
			;

iteration_statement	:
				WHILE expression NEWLINE statements END
			|	FOR identifier FROM expression TO expression by_statement NEWLINE statements END
			|	FOREACH identifier in_statement as_statement from_statement NEWLINE statements END { $$ = doForeach($2,$3,$4,$5,$7); }
			;

as_statement		:
				AS identifier { $$ = $2; }
			| {$$ = null; }
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
				BY expression
			|
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
				VAR declaration_list
			;

declaration_list	:
				declarator
			|	declaration_list COMMA declarator
			;

declarator		:	
				IDENTIFIER
			|	IDENTIFIER EQUALS expression
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

identifier_list		:
				identifier_list commaq IDENTIFIER
			|	IDENTIFIER;

%%

String ins;
StringTokenizer st;
			
			
ParserVal doForeach(ParserVal id,ParserVal in, ParserVal as, ParserVal from, ParserVal stmt)
{
	String r = "";
	String type = "Object";
	r = " for(" + type +" " + as.sval + " : " + in.sval + "){\n";
	r += stmt.sval;
	r += "}\n";
	return new ParserVal(r);
}

ParserVal moleLazyCreate(ParserVal num, ParserVal ofWhat)
{
	String r = "";
	r += "\tpublic ArrayList "+ofWhat.sval+";\n";
	return new ParserVal(r);
}

ParserVal moleCreateOne(ParserVal thingToMake)
{
	return new ParserVal("\tpublic Object "+thingToMake.sval+";\n");
}
ParserVal assignVariable(ParserVal id, ParserVal val)
{
	if(id.sval.charAt(0) == '~')
		return new ParserVal("protected void set_" + id.sval.substring(1) + "(){\n\tsymbols.put(\"" + id.sval + "\",\"" + val.sval + "\");\n}\n");
	else if(id.sval.contains("symbols.get("))
		return new ParserVal("symbols.put(" + id.sval.substring(12,id.sval.lastIndexOf("\"") + 1) + ",\"" + val.sval + "\");");
	else
		return new ParserVal(id.sval + "=" + val.sval + ";");
}
ParserVal createFunction(ParserVal functionName,ParserVal params, ParserVal statements)
{
	String r = "";
	String parsedParams = params.sval;
	if(parsedParams != "")
	{
		parsedParams = "Object " + parsedParams;
		parsedParams.replace(",",", Object ");
	}
	r += "protected Object snw" + functionName.sval + " (" + parsedParams + "){\n";
	r += statements.sval.replace(functionName.sval+"=","return ");
	
	//TODO - implement something to make sure there is a return!
	r += "\n}";
	return new ParserVal(r);
}
ParserVal createDebugHook(ParserVal timeSeq,ParserVal event,ParserVal statements)
{
	String r = new String();
	r += ("protected void " + timeSeq.sval.toLowerCase() + event.sval.toUpperCase() + "{" + "\n");
	r += (statements.sval);
	r += ("}\n");
	return new ParserVal(r);
}

ParserVal executeFunction(ParserVal fname,ParserVal params)
{
	return new ParserVal("snw"+fname.sval+"("+params.sval+");\n");
}

ParserVal defineMolecule(ParserVal name, ParserVal def)
{
	String r = "";
	r+="class " + name.sval + "{\n";
	r+=def.sval;
	r+= "}";
	return new ParserVal(r );
}
private Yylex lexer;

  /* interface to the lexer */
  private int yylex () {
    int yyl_return = -1;
    try {
      yyl_return = lexer.yylex();
    }
    catch (IOException e) {
      System.err.println("IO error :"+e);
    }
    return yyl_return;
  }

void yyerror(String s)
{
 System.out.println("par:"+s);
}

boolean newline;

 public Parser(Reader r) {
    lexer = new Yylex(r, this);
  }
public static void main(String args[]) throws IOException {
    Parser yyparser = new Parser(new FileReader(args[0]));
    yyparser.yyparse();    
  }
