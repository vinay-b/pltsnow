%{
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

extern yyin;
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

program_unit		:	external_declaration
			|	program_unit external_declaration
			;

external_declaration	:
				function_declarator
			|	var_declarator
			|	molecule_declarator
			|	debug_hook_declarator
			|	assignment_statement
			|	NEWLINE
			;
				

atom			:
				NUMERIC
			|	STRING
			;

commaq			:
				COMMA
			|
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
				atom
			|	pair
			|	identifier
			|	LPAREN expression RPAREN
			;

identifier		:
				compound_identifier
			|	SYS_IDENTIFIER
			;

compound_identifier	:
				compound_identifier DOT IDENTIFIER
			|	IDENTIFIER
			;
postfix_expression	:
				primary_expression
			|	postfix_expression PLUSPLUS
			|	postfix_expression MINUSMINUS
			|	function_expression
			;

function_expression	:
				IDENTIFIER COLON params
			;

params			:
				params commaq param
			|
			;

param			:
				expression
			;

unary_expression	:
				postfix_expression
			|	MINUS unary_expression
			|	LOG_OP_NOT unary_expression
			;


additive_expression	:
				multiplicative_expression
			|	additive_expression PLUS multiplicative_expression
			|	additive_expression MINUS multiplicative_expression 
			;

multiplicative_expression:
				multiplicative_expression MUL pow_expression
			|	multiplicative_expression DIV pow_expression
			|	multiplicative_expression MODULO pow_expression
			|	pow_expression
			;
pow_expression		:
				unary_expression
			|	pow_expression POWER unary_expression
			;

relational_expression	:
				additive_expression
			|	relational_expression REL_OP_LT additive_expression
			|	relational_expression REL_OP_GT additive_expression
			|	relational_expression REL_OP_LE additive_expression
			|	relational_expression REL_OP_GE additive_expression
			;

equality_expression	:
				relational_expression
			|	equality_expression EQUALS relational_expression
			|	equality_expression REL_OP_NE relational_expression
			;

logical_and_expression:
				equality_expression
			|	logical_and_expression LOG_OP_AND equality_expression
			;

logical_or_expression	:
				logical_and_expression
			|	logical_or_expression LOG_OP_OR logical_and_expression
			;

assignment_expression	:
				identifier EQUALS expression
			;

statement		:
				expression_statement NEWLINE
			|	selection_statement NEWLINE
			|	iteration_statement NEWLINE
			|	var_declarator NEWLINE
			|	assignment_statement NEWLINE
			|	NEWLINE
			;

statements		:
				statement
			|	statements statement
			;

assignment_statement	:
				assignment_expression
			;

expression_statement	:
				expression
			;

expression		:
				logical_or_expression
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
			|	FOREACH identifier in_statement as_statement from_statement NEWLINE statements END
			;

as_statement		:
				AS identifier
			|
			;

in_statement		:
				IN identifier
			|
			;

from_statement		:
				FROM expression TO expression
			|
			;

by_statement		:
				BY expression
			|
			;

debug_hook_declarator	:
				time_seq EACH EVENT_NAME_IDENTIFIER COLON NEWLINE statements END
			;

time_seq		:
				BEFORE
			|	AFTER
			;

function_declarator	:
				TO IDENTIFIER COLON params NEWLINE statements END
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
				DEFINE IDENTIFIER COLON NEWLINE molecule_defs END
			;

molecule_defs		:
				molecule_def
			|	molecule_defs molecule_def
			;

molecule_def		:
				NUMERIC IDENTIFIER NEWLINE
			|	identifier_list NEWLINE
			|	LPAREN identifier_list RPAREN NEWLINE
			|	atom NEWLINE
			|	pair NEWLINE
			|	NEWLINE
			;

identifier_list		:
				identifier_list commaq IDENTIFIER
			|	IDENTIFIER;

%%
main(int argc, char ** argv){
	FILE * file;
	int nFiles = argc -1;
	if(argc == 2){
		file = fopen(argv[1],"r");
		if(!file){
			fprintf(stderr,"Could no open %s\n",argv[1]);
			exit(1);
		}

		yyin = file; 
		yyparse();
	}	
	else{
		
		yyparse();
		//printf("Usage: makesnowball <File Name>");
	}
}
