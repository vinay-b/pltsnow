LEXER = snow.l
PARSER = snow.y
BYACC = ./yacc.linux


all: yacc lex freezeit
mac: macyacc lex freezeit

macyacc:
	byacc -J -Jextends=BaseSnowParser -Jpackage=com.google.code.pltsnow.gen $(PARSER)
	mv Parser.java com/google/code/pltsnow/gen
	mv ParserVal.java com/google/code/pltsnow/gen

yacc:
	$(BYACC) -J -Jextends=BaseSnowParser -Jpackage=com.google.code.pltsnow.gen $(PARSER)
	mv Parser.java com/google/code/pltsnow/gen
	mv ParserVal.java com/google/code/pltsnow/gen

lex:
	../dep/jflex-1.4.3/bin/jflex -d com/google/code/pltsnow/gen/ $(LEXER)

freezeit: 
	javac com/google/code/pltsnow/gen/Parser.java
	
sample1:
	java com/google/code/pltsnow/gen/Parser ../sample/sample1.snow > SnowProgramImp.java

sample2:
	java com/google/code/pltsnow/gen/Parser ../sample/sample2.snow > SnowProgramImp.java
	
sample3:
	java com/google/code/pltsnow/gen/Parser ../sample/sample3.snow > SnowProgramImp.java
	
sample4:
	java com/google/code/pltsnow/gen/Parser ../sample/sample4.snow > SnowProgramImp.java
	
test:
	javac SnowProgramImp.java
	
run:
	java SnowProgramImp

clean:
	rm *.class com/google/code/pltsnow/snowfield/*.class com/google/code/pltsnow/gen/*.class
