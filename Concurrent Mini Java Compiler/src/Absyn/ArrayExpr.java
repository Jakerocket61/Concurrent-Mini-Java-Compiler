package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class ArrayExpr extends AssignableExpr implements Visitable {

	public Expr target;
	public Expr index;

	public Types.Type checktype;

	public ArrayExpr(Expr target, Expr index) {
		this.target = target;
		this.index = index;
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
