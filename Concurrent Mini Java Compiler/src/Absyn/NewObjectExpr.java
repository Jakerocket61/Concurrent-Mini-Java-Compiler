package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class NewObjectExpr extends Expr implements Visitable {
	public Type type;

	public Types.Type checktype;

	public NewObjectExpr(Type type) {
		this.type = type;
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
