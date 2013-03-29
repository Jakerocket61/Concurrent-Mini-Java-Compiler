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

public interface Visitor {
	void visit(AddExpr ast);

	void visit(AndExpr ast);

	void visit(ArrayExpr ast);

	void visit(ArrayType ast);

	void visit(AssignStmt ast);

	void visit(BinOpExpr ast);

	void visit(BlockStmt ast);

	void visit(BooleanType ast);

	void visit(CallExpr ast);

	void visit(ClassDecl ast);

	void visit(DivExpr ast);

	void visit(EqualExpr ast);

	void visit(Expr ast);

	void visit(FalseExpr ast);

	void visit(FieldExpr ast);

	void visit(Formal ast);

	void visit(GreaterExpr ast);

	void visit(IdentifierExpr ast);

	void visit(IdentifierType ast);

	void visit(IfStmt ast);

	void visit(IntegerLiteral ast);

	void visit(IntegerType ast);

	void visit(java.util.AbstractList<Visitable> list);

	void visit(LesserExpr ast);

	void visit(MethodDecl ast);

	void visit(MulExpr ast);

	void visit(NegExpr ast);

	void visit(NewArrayExpr ast);

	void visit(NewObjectExpr ast);

	void visit(NotEqExpr ast);

	void visit(NotExpr ast);

	void visit(NullExpr ast);

	void visit(OrExpr ast);

	void visit(Program ast);

	void visit(Stmt ast);

	void visit(StringLiteral ast);

	void visit(SubExpr ast);

	void visit(ThisExpr ast);

	void visit(ThreadDecl ast);

	void visit(TrueExpr ast);

	void visit(Type ast);

	void visit(TypeVisitor ast);

	void visit(VarDecl ast);

	void visit(VoidDecl ast);

	void visit(WhileStmt ast);

	void visit(XinuCallExpr ast);

	void visit(XinuCallStmt ast);
}
