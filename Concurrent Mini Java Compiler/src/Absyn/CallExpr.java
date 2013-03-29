package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class CallExpr extends Expr implements Visitable {

	public Expr target;
	public String method;
	public java.util.LinkedList<Expr> args;
	public Integer typeIndex;
	public Types.Type checktype;

	public CallExpr(Expr target, String method, java.util.LinkedList<Expr> args) {
		this.target = target;
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
