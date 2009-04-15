LEXER = snow.l
PARSER = snow.y
BYACC = byacc


all: yacc lex freezeit

yacc:
	$(BYACC) -J -Jextends=BaseSnowParser -Jpackage=com.google.code.pltsnow.gen $(PARSER)
	mv Parser.java com/google/code/pltsnow/gen
	mv ParserVal.java com/google/code/pltsnow/gen

lex:
	../dep/jflex-1.4.3/bin/jflex -d com/google/code/pltsnow/gen/ $(LEXER)

freezeit: 
	javac com/google/code/pltsnow/gen/Parser.java

clean:
	rm ../bin/freezeit lex.yy.c y.tab.c y.tab.h
