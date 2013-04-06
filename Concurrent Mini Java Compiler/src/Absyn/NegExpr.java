package Absyn;// syntaxtree

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class NegExpr extends Expr implements Visitable {

	public Expr e1;

	public Types.Type checktype;

	public NegExpr(Expr e1) {
		this.e1 = e1;
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
