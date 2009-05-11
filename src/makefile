#Authored by Cesar
LEXER = snow.l
PARSER = snow.y
UNAME := $(shell uname)

BYACC = ./yacc.exe

ifeq ($(UNAME), Linux)
	BYACC = ./yacc.linux
endif

ifeq ($(UNAME), Darwin)
	BYACC = ./yacc.macosx
endif

all: yacc lex freezeit
sample1: sample11 test run
sample2: sample22 test run
sample3: sample33 test run
sample4: sample44 test run
program: compile test run

yacc:
	$(BYACC) -J -Jextends=BaseSnowParser -Jpackage=com.google.code.pltsnow.gen $(PARSER)
	mv Parser.java com/google/code/pltsnow/gen
	mv ParserVal.java com/google/code/pltsnow/gen

lex:
	../dep/jflex-1.4.3/bin/jflex -d com/google/code/pltsnow/gen/ $(LEXER)

freezeit: 
	javac com/google/code/pltsnow/gen/Parser.java
	
sample11:
	java com/google/code/pltsnow/gen/Parser ../sample/sample1.snow > SnowProgramImp.java

sample22:
	java com/google/code/pltsnow/gen/Parser ../sample/sample2.snow > SnowProgramImp.java
	
sample33:
	java com/google/code/pltsnow/gen/Parser ../sample/sample3.snow > SnowProgramImp.java
	
sample44:
	java com/google/code/pltsnow/gen/Parser ../sample/sample4.snow > SnowProgramImp.java

compile:
	java com/google/code/pltsnow/gen/Parser $(FILE) > SnowProgramImp.java
	
test:
	javac SnowProgramImp.java
	
run:
	java SnowProgramImp

clean:
	rm -f *.class com/google/code/pltsnow/snowfield/*.class com/google/code/pltsnow/gen/*.class
