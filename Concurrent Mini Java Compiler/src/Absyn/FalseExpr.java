package Absyn;

import visitor.TypeVisitor;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class FalseExpr extends Expr {

	public Types.Type checktype;

	public FalseExpr() {
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
