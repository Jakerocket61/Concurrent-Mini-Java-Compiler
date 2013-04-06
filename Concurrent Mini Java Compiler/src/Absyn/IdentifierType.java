package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class IdentifierType extends Type implements Visitable {
	public String id;

	public Types.Type checktype;

	public IdentifierType(String id) {
		this.id = id;
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

