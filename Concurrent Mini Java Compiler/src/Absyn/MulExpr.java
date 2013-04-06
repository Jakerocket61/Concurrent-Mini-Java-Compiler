package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class MulExpr extends BinOpExpr implements Visitable {
	public Expr e1, e2;

	public Types.Type checktype;

	public MulExpr(Expr e1, Expr e2) {
		super(e1, e2);
		this.e1 = e1;
		this.e2 = e2;
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
