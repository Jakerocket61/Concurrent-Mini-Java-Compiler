package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class AssignStmt extends Stmt implements Visitable {

	public AssignableExpr lhs;
	public Expr rhs;

	public Types.Type checktype;

	public AssignStmt(AssignableExpr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
