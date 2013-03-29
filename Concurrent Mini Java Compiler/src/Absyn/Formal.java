package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

//  extends Formal
public class Formal implements Visitable {

	public Type type;
	public String name;

	public Types.Type checktype;

	public Formal(Type type, String name) {
		this.type = type;
		this.name = name;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
