package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class BlockStmt extends Stmt implements Visitable {

	public Types.Type checktype;

	public java.util.LinkedList<Stmt> stmts;

	public BlockStmt(java.util.LinkedList<Stmt> stmts) {
		this.stmts = stmts;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
