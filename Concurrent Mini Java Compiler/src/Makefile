PARSER   		= 	Parse
CHECKER	 		= 	Semant

JAVAC    		= 	javac
JAVA     		= 	java
JAVACC   		= 	javacc
JJDOC    		= 	jjdoc

JAVACC_FLAGS_PARSE 	= 	-OUTPUT_DIRECTORY=Parse/

JAVACC_FLAGS_SEMANT 	= 	-NOSTATIC -OUTPUT_DIRECTORY=Semant/


JAVACC_GEN_PARSE 	= 	Parse/SimpleCharStream.java 	Parse/ParseException.java 		Parse/Parse.java \
        				Parse/ParseConstants.java 		Parse/ParseTokenManager.java 	Parse/Token.java \
        				Parse/TokenMgrError.java 

JAVACC_GEN_SEMANT 	= 	Semant/SimpleCharStream.java 		Semant/ParseException.java 			Semant/ReadAbsyn.java \
        				Semant/ReadAbsynConstants.java 		Semant/ReadAbsynTokenManager.java 	Semant/Token.java \
        				Semant/TokenMgrError.java 


ABSYN    		= 	Absyn/Absyn.java 			Absyn/AddExpr.java 			Absyn/AndExpr.java \
					Absyn/ArrayExpr.java 		Absyn/ArrayType.java 		Absyn/AssignableExpr.java \
					Absyn/AssignStmt.java 		Absyn/BinOpExpr.java 		Absyn/BlockStmt.java \
					Absyn/BooleanType.java 		Absyn/CallExpr.java 		Absyn/ClassDecl.java \
					Absyn/DivExpr.java 			Absyn/EqualExpr.java 		Absyn/Expr.java \
					Absyn/FalseExpr.java 		Absyn/FieldExpr.java 		Absyn/Formal.java \
					Absyn/GreaterExpr.java 		Absyn/IdentifierExpr.java 	Absyn/IdentifierType.java \
					Absyn/IfStmt.java 			Absyn/IntegerLiteral.java 	Absyn/IntegerType.java \
					Absyn/LesserExpr.java 		Absyn/MethodDecl.java 		Absyn/MulExpr.java \
					Absyn/NegExpr.java 			Absyn/NewArrayExpr.java 	Absyn/NewObjectExpr.java \
					Absyn/NotEqExpr.java 		Absyn/NotExpr.java 			Absyn/NullExpr.java \
					Absyn/OrExpr.java 			Absyn/Program.java 			Absyn/Stmt.java \
					Absyn/StringLiteral.java 	Absyn/SubExpr.java 			Absyn/ThisExpr.java \
					Absyn/ThreadDecl.java 		Absyn/TrueExpr.java 		Absyn/Type.java \
					Absyn/VarDecl.java 			Absyn/VoidDecl.java 		Absyn/WhileStmt.java \
					Absyn/XinuCallExpr.java 	Absyn/XinuCallStmt.java 	

TYPES			= 	Types/ARRAY.java 		Types/BOOLEAN.java 		Types/CLASS.java \
					Types/FIELD.java 		Types/FUNCTION.java 	Types/INT.java \
					Types/NIL.java 			Types/OBJECT.java 		Types/RECORD.java \
					Types/STRING.java 		Types/Table.java 		Types/Type.java \
					Types/Visitable.java 	Types/Visitor.java 		Types/VOID.java 

VISIT    		= 	visitor/Visitable.java 		visitor/Visitor.java 		visitor/PrintVisitor.java \
					visitor/TypeVisitor.java 	visitor/T_Visitor.java 


SRCS     		= 	$(VISIT) $(ABSYN) $(TYPES) \
					Semant/ReadAbsyn.java		Semant/Main.java \
					Parse/Parse.java 			Parse/Main.java   \

all:  				$(SRCS:.java=.class)

Parse/Parse.java: 		Parse/Parse.jj 
				$(JAVACC) $(JAVACC_FLAGS_PARSE) $<

Semant/ReadAbsyn.java: 		Semant/ReadAbsyn.jj
				$(JAVACC) $(JAVACC_FLAGS_SEMANT) $<

%.class : 			%.java
				$(JAVAC) $<

parser: 		Parse/Parse.class 			Parse/ParseConstants.class 		Parse/ParseTokenManager.class \
				Parse/ParseException.class

checker: 		Semant/ReadAbsyn.class 			Semant/ReadAbsynConstants.class 	Semant/ReadAbsynTokenManager.class \
				Semant/ReadAbsynException.class


main: 			Semant/Main.class 		Semant/ReadAbsyn.class \
			 	Parse/Parse.class 		Parse/Main.class \

clean: 		
		rm -f 		$(SRCS:.java=.class) \
				${JAVACC_GEN_SEMANT} $(JAVACC_GEN_SEMANT:.java=.class) \
				${JAVACC_GEN_PARSE} $(JAVACC_GEN_PARSE:.java=.class) \
				Parse/Parse*.class \
				Semant/ReadAbsyn*.class \
				Parse/ReadTypes*.class \
				Assem/ReadFrags*.class \
