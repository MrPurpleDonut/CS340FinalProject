##
# This Makefile creates the classes necessary
# for the abstract syntax tree.
#
# Important targets:
#   make             => builds everything
#   make clean       => cleans up for a re-build
##

CLASSPATH = ".:/usr/people/classes/CS340/software/*"

JAVAC = javac
JFLAGS = -g -Werror -cp $(CLASSPATH)

SOURCES = ASTNode.java

.SUFFIXES: .java .class
.java.class:
	$(JAVAC) $(JFLAGS) $*.java

stamp: $(SOURCES:.java=.class)
	touch stamp

clean:
	rm -f *~ *.class stamp
