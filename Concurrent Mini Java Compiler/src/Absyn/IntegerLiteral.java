package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class IntegerLiteral extends Expr implements Visitable {
	public int value;

	public Types.Type checktype;

	public IntegerLiteral(int value) {
		this.value = value;
	}

	public IntegerLiteral(Integer value) {
		this.value = (int) value;
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

