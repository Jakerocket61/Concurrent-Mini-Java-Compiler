package Translate;
import Absyn.*;
import visitor.*;
import java.util.LinkedList;

public interface Visitor {
     Exp visit(java.util.AbstractList<Visitable> list); 
     Exp visit(AddExpr ast); 
     Exp visit(AndExpr ast); 
     Exp visit(ArrayExpr ast); 
     Exp visit(ArrayType ast); 
     Exp visit(AssignStmt ast); 
     Exp visit(BinOpExpr ast);
     Exp visit(BlockStmt ast); 
     Exp visit(BooleanType ast); 
     Exp visit(CallExpr ast); 
     Exp visit(ClassDecl ast); 
     Exp visit(DivExpr ast); 
     Exp visit(Expr ast);
     Exp visit(EqualExpr ast); 
     Exp visit(FalseExpr ast); 
     Exp visit(FieldExpr ast); 
     Exp visit(Formal ast); 
     Exp visit(GreaterExpr ast); 
     Exp visit(IdentifierExpr ast); 
     Exp visit(IdentifierType ast); 
     Exp visit(IfStmt ast); 
     Exp visit(IntegerLiteral ast); 
     Exp visit(IntegerType ast); 
     Exp visit(LesserExpr ast); 
     Exp visit(MethodDecl ast); 
     Exp visit(MulExpr ast); 
     Exp visit(NegExpr ast); 
     Exp visit(NewArrayExpr ast); 
     Exp visit(NewObjectExpr ast); 
     Exp visit(NotEqExpr ast); 
     Exp visit(NotExpr ast); 
     Exp visit(NullExpr ast); 
     Exp visit(OrExpr ast); 
     LinkedList<Exp> visit(Program ast); 
     Exp visit(StringLiteral ast); 
     Exp visit(Stmt ast);
     Exp visit(SubExpr ast); 
     Exp visit(ThisExpr ast); 
     Exp visit(ThreadDecl ast); 
     Exp visit(TrueExpr ast); 
     Exp visit(Type ast);
     Exp visit(TypeVisitor ast);
     Exp visit(VarDecl ast); 
     Exp visit(VoidDecl ast); 
     Exp visit(WhileStmt ast); 
     Exp visit(XinuCallExpr ast); 
     Exp visit(XinuCallStmt ast);

    //public void accept(Visitor v) { v.visit(this); }

}

