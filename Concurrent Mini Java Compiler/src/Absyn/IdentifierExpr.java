package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class IdentifierExpr extends AssignableExpr implements Visitable {
	public String id;

	public Types.Type checktype;

	public IdentifierExpr(String id) {
		this.id = id;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
