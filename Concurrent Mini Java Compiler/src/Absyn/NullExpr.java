package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class NullExpr extends Expr implements Visitable {

	public Types.Type checktype;

	public NullExpr() {
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
