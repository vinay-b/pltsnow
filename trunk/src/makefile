LEXER = snow.l
PARSER = snow.y

all: yacc lex freezeit

yacc:
	byacc -J $(PARSER)

lex:
	../dep/jflex-1.4.3/bin/jflex $(LEXER)

freezeit: 
	javac Parser.java

clean:
	rm ../bin/freezeit lex.yy.c y.tab.c y.tab.h
