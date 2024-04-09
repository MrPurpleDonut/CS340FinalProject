##
# This Makefile creates the parser (Parser.class)
# and creates the compiler front-end (StreamerC.class)
# for the Streamer language.
#
# Important targets:
#   make              => builds everything
#   make Parser.class => builds just the Parser (but not StreamerC)
#   make clean        => cleans up for a re-build
##

CLASSPATH = ".:./ast:/usr/people/classes/CS340/software/*"

JAVAC = javac
JFLAGS = -g -Werror -cp $(CLASSPATH)

JFLEXLOC = /usr/people/classes/CS340/software
JCUPLOC = /usr/people/classes/CS340/software

all: StreamerC.class

StreamerC.class: StreamerC.java Yylex.class Parser.class ast/stamp
	$(JAVAC) $(JFLAGS) StreamerC.java

Parser.class: Parser.java Yylex.class ast/stamp
	$(JAVAC) $(JFLAGS) Parser.java

Yylex.class: Yylex.java sym.class
	$(JAVAC) $(JFLAGS) Yylex.java

Yylex.java: Streamer.flex sym.class
	java -jar $(JFLEXLOC)/jflex-full-1.7.0.jar Streamer.flex

sym.class: sym.java
	$(JAVAC) $(JFLAGS) sym.java

sym.java: Parser.java
	@echo "sym.java should be good to go!"

Parser.java: Streamer.cup
	java -jar $(JCUPLOC)/java-cup-11b.jar -interface -parser Parser Streamer.cup

ast/stamp: ast
	$(MAKE) -C ast

clean:
	rm -f *~ *.class Yylex.java sym.java Parser.java
	$(MAKE) -C ast clean
