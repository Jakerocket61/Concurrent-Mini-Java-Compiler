package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class StringLiteral extends Expr implements Visitable {

	public String value;

	public Types.Type checktype;

	public StringLiteral(String value) {
		this.value = value;
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
