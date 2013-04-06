package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class IfStmt extends Stmt implements Visitable {
	public Expr test;
	public Stmt thenStm, elseStm;

	public Types.Type checktype;

	public IfStmt(Expr test, Stmt thenStm, Stmt elseStm) {
		this.test = test;
		this.thenStm = thenStm;
		this.elseStm = elseStm;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Translate.Exp accept(Translate.Translate t){
		return t.visit(this);
	}

}

