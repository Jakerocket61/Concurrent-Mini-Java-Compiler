package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class ClassDecl extends Absyn implements Visitable {

	public java.util.LinkedList<VarDecl> fields;
	public java.util.LinkedList<MethodDecl> methods;
	public String name;
	public String parent;

	public Types.Type checktype;

	public ClassDecl(java.util.LinkedList<VarDecl> fields,
			java.util.LinkedList<MethodDecl> methods, String name, String parent) {
		this.fields = fields;
		this.methods = methods;
		this.name = name;
		this.parent = parent;
	}

	public ClassDecl(String name, java.util.LinkedList<VarDecl> fields,
			java.util.LinkedList<MethodDecl> methods) {
		this.name = name;
		this.fields = fields;
		this.methods = methods;
		this.parent = "Thread";
	}

	// same as above; different order of arguments
	public ClassDecl(String name, String parent,
			java.util.LinkedList<VarDecl> fields,
			java.util.LinkedList<MethodDecl> methods) {
		this.fields = fields;
		this.methods = methods;
		this.name = name;
		this.parent = parent;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
