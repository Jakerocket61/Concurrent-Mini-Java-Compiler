package Absyn;

import java.util.AbstractList;
import java.util.LinkedList;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;

public class Program implements Visitable {

	public AbstractList<ClassDecl> classes;

	public Types.Type checktype;

	public Program(LinkedList<ClassDecl> classes) {
		this.classes = classes;
	}

	public Types.Type accept(TypeVisitor v) {
		return v.visit(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}