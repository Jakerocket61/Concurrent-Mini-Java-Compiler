package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class VarDecl extends Absyn implements Visitable {
	public Type type;
	public String name;
	public Expr init;

	public Types.Type checktype;

	public VarDecl(Type type, String name, Expr init) {
		this.type = type;
		this.name = name;
		this.init = init;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

}
