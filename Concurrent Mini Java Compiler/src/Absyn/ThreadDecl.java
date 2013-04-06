package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class ThreadDecl extends ClassDecl implements Visitable {

	/*
	 * public String name; public java.util.LinkedList<VarDecl> fields; public
	 * java.util.LinkedList<MethodDecl> methods; public String parent;
	 */

	public Types.Type checktype;

	public ThreadDecl(String name, java.util.LinkedList<VarDecl> fields,
			java.util.LinkedList<MethodDecl> methods) {
		super(name, fields, methods);
		// this.name = name;
		// this.fields = fields;
		// this.methods = methods;
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
