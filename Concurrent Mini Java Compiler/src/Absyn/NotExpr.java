package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class NotExpr extends Expr implements Visitable {
	public Expr e1;

	public Types.Type checktype;

	public NotExpr(Expr e1) {
		this.e1 = e1;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
