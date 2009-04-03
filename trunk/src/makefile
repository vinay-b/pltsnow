LEXER = snow.l
PARSER = snow.y

SOURCES = y.tab.c lex.yy.c
LIB = -ll -ly

gccw = gcc -Wall

all: yacc lex freezeit

yacc:
	yacc -d $(PARSER)

lex:
	lex $(LEXER)

freezeit: $(SOURCES)
	cc -o ../bin/freezeit $(SOURCES) $(LIB)
