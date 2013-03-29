package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class WhileStmt extends Stmt implements Visitable {
	public Expr test;
	public Stmt body;

	public Types.Type checktype;

	public WhileStmt(Expr test, Stmt body) {
		this.test = test;
		this.body = body;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

}
