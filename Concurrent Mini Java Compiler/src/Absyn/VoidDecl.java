package Absyn;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class VoidDecl extends MethodDecl implements Visitable {
	// public String name;
	// public java.util.LinkedList<VarDecl> locals;
	// public java.util.LinkedList<Stmt> stmts;

	public Types.Type checktype;

	public VoidDecl(String name, java.util.LinkedList<VarDecl> locals,
			java.util.LinkedList<Stmt> stmts) {
		super(name, locals, stmts);
		// this.name = name;
		// this.locals = locals;
		// this.stmts = stmts;
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
