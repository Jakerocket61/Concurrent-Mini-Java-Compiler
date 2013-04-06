package Absyn;

import java.util.LinkedList;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class NewArrayExpr extends Expr implements Visitable {
	public Type type;
	public LinkedList<Expr> dimensions;

	public Types.Type checktype;

	public NewArrayExpr(Type type, LinkedList<Expr> dimensions) {
		this.type = type;
		this.dimensions = dimensions;
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
