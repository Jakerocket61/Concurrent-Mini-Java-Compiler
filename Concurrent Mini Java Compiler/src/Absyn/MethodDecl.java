package Absyn;

import java.util.LinkedList;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;
//import visitor.Visitor;
//import visitor.TypeVisitor;

public class MethodDecl extends Absyn implements Visitable {
	public Type returnType;
	public boolean synced;
	public String name;
	public LinkedList<Formal> params;
	public LinkedList<VarDecl> locals;
	public LinkedList<Stmt> stmts;
	public Expr returnVal;

	public Types.Type checktype;

	public MethodDecl(String name, boolean synced,
			java.util.LinkedList<VarDecl> locals,
			java.util.LinkedList<Stmt> stmts) {
		this.name = name;
		this.locals = locals;
		this.stmts = stmts;
	}

	public MethodDecl(String name, LinkedList<VarDecl> locals,
			LinkedList<Stmt> stmts) {
		this.name = name;
		this.locals = locals;
		this.stmts = stmts;
		this.returnVal = new IntegerLiteral(1);
	}

	public MethodDecl(Type returnType, boolean synced, String name,
			LinkedList<Formal> params, LinkedList<VarDecl> locals,
			LinkedList<Stmt> stmts, Expr returnVal) {
		this.returnType = returnType;
		this.synced = synced;
		this.name = name;
		this.params = params;
		this.locals = locals;
		this.stmts = stmts;
		this.returnVal = returnVal;
	}

	public MethodDecl(Type returnType, String name, LinkedList<Formal> params,
			LinkedList<VarDecl> locals, LinkedList<Stmt> stmts, Expr returnVal) {
		this.returnType = returnType;
		// this.synced = synced;
		this.name = name;
		this.params = params;
		this.locals = locals;
		this.stmts = stmts;
		this.returnVal = returnVal;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
