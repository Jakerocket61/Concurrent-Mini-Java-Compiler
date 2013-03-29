package visitor;

//import visitor.TypeVisitor;
import Absyn.AddExpr;
import Absyn.AndExpr;
import Absyn.ArrayExpr;
import Absyn.ArrayType;
import Absyn.AssignStmt;
import Absyn.BinOpExpr;
import Absyn.BlockStmt;
import Absyn.BooleanType;
import Absyn.CallExpr;
import Absyn.ClassDecl;
import Absyn.DivExpr;
import Absyn.EqualExpr;
import Absyn.Expr;
import Absyn.FalseExpr;
import Absyn.FieldExpr;
import Absyn.Formal;
import Absyn.GreaterExpr;
import Absyn.IdentifierExpr;
import Absyn.IdentifierType;
import Absyn.IfStmt;
import Absyn.IntegerLiteral;
import Absyn.IntegerType;
import Absyn.LesserExpr;
import Absyn.MethodDecl;
import Absyn.MulExpr;
import Absyn.NegExpr;
import Absyn.NewArrayExpr;
import Absyn.NewObjectExpr;
import Absyn.NotEqExpr;
import Absyn.NotExpr;
import Absyn.NullExpr;
import Absyn.OrExpr;
import Absyn.Program;
import Absyn.Stmt;
import Absyn.StringLiteral;
import Absyn.SubExpr;
import Absyn.ThisExpr;
import Absyn.ThreadDecl;
import Absyn.TrueExpr;
import Absyn.Type;
import Absyn.VarDecl;
import Absyn.VoidDecl;
import Absyn.WhileStmt;
import Absyn.XinuCallExpr;
import Absyn.XinuCallStmt;

public interface T_Visitor {
	Types.Type visit(AddExpr ast);

	Types.Type visit(AndExpr ast);

	Types.Type visit(ArrayExpr ast);

	Types.Type visit(ArrayType ast);

	Types.Type visit(AssignStmt ast);

	Types.Type visit(BinOpExpr ast);

	Types.Type visit(BlockStmt ast);

	Types.Type visit(BooleanType ast);

	Types.Type visit(CallExpr ast);

	Types.Type visit(ClassDecl ast);

	Types.Type visit(DivExpr ast);

	Types.Type visit(EqualExpr ast);

	Types.Type visit(Expr ast);

	Types.Type visit(FalseExpr ast);

	Types.Type visit(FieldExpr ast);

	Types.Type visit(Formal ast);

	Types.Type visit(GreaterExpr ast);

	Types.Type visit(IdentifierExpr ast);

	Types.Type visit(IdentifierType ast);

	Types.Type visit(IfStmt ast);

	Types.Type visit(IntegerLiteral ast);

	Types.Type visit(IntegerType ast);

	Types.Type visit(java.util.AbstractList<Visitable> list);

	Types.Type visit(LesserExpr ast);

	Types.Type visit(MethodDecl ast);

	Types.Type visit(MulExpr ast);

	Types.Type visit(NegExpr ast);

	Types.Type visit(NewArrayExpr ast);

	Types.Type visit(NewObjectExpr ast);

	Types.Type visit(NotEqExpr ast);

	Types.Type visit(NotExpr ast);

	Types.Type visit(NullExpr ast);

	Types.Type visit(OrExpr ast);

	Types.Type visit(Program ast);

	Types.Type visit(Stmt ast);

	Types.Type visit(StringLiteral ast);

	Types.Type visit(SubExpr ast);

	Types.Type visit(ThisExpr ast);

	Types.Type visit(ThreadDecl ast);

	Types.Type visit(TrueExpr ast);

	Types.Type visit(Type ast);

	Types.Type visit(TypeVisitor ast);

	Types.Type visit(VarDecl ast);

	Types.Type visit(VoidDecl ast);

	Types.Type visit(WhileStmt ast);

	Types.Type visit(XinuCallExpr ast);

	Types.Type visit(XinuCallStmt ast);

	// public void accept(Visitor v) { v.visit(this); }

}
