package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;

public class XinuCallStmt extends Stmt implements Visitable {
	public String method;
	public java.util.LinkedList<Expr> args;

	public Types.Type checktype;

	public XinuCallStmt(String method, java.util.LinkedList<Expr> args) {
		this.method = method;
		this.args = args;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

}
