package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class XinuCallExpr extends Expr implements Visitable {
	public String method;
	public java.util.LinkedList<Expr> args;

	public Types.Type checktype;

	public XinuCallExpr(String method, java.util.LinkedList<Expr> args) {
		this.method = method;
		this.args = args;
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
