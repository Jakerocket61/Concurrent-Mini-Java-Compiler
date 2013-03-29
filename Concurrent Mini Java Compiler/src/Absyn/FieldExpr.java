package Absyn;// syntaxtree

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class FieldExpr extends AssignableExpr implements Visitable {

	public Expr target;
	public String field;
	public Integer typeIndex;
	public Types.Type checktype;

	public FieldExpr(Expr target, String field) {
		this.target = target;
		this.field = field;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
