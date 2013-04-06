package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;

public class Absyn implements Visitable {

	public Absyn() {
	}

	public Types.Type accept(TypeVisitor v) {
		return new Types.VOID();
	}

	public void accept(Visitor v) {
	}

	public Translate.Exp accept(Translate.Translate t){
		return t.visit(this);
	}
}
