/* Copyright (C) 2007, Marquette University.  All rights reserved. */

/*
 * Modified by:
 *
 * Jacob Anderson
 * Jack Batzner
 * Paul Kaefer
 * 
 */

package visitor;// was Absyn

import java.io.PrintWriter;

import Absyn.AddExpr;
import Absyn.AndExpr;
import Absyn.ArrayExpr;
import Absyn.ArrayType;
import Absyn.AssignStmt;
import Absyn.BinOpExpr;
import Absyn.BlockStmt;
import Absyn.BooleanType;
import Absyn.CallExpr;
import Absyn.ClassDecl;
import Absyn.DivExpr;
import Absyn.EqualExpr;
import Absyn.Expr;
import Absyn.FalseExpr;
import Absyn.FieldExpr;
import Absyn.Formal;
import Absyn.GreaterExpr;
import Absyn.IdentifierExpr;
import Absyn.IdentifierType;
import Absyn.IfStmt;
import Absyn.IntegerLiteral;
import Absyn.IntegerType;
import Absyn.LesserExpr;
import Absyn.MethodDecl;
import Absyn.MulExpr;
import Absyn.NegExpr;
import Absyn.NewArrayExpr;
import Absyn.NewObjectExpr;
import Absyn.NotEqExpr;
import Absyn.NotExpr;
import Absyn.NullExpr;
import Absyn.OrExpr;
import Absyn.Program;
import Absyn.Stmt;
import Absyn.StringLiteral;
import Absyn.SubExpr;
import Absyn.ThisExpr;
import Absyn.ThreadDecl;
import Absyn.TrueExpr;
import Absyn.Type;
import Absyn.VarDecl;
import Absyn.VoidDecl;
import Absyn.WhileStmt;
import Absyn.XinuCallExpr;
import Absyn.XinuCallStmt;

//import Types.Visitor;

/**
 * Visitor prints AST in reparseable form.
 */

public class PrintVisitor implements Visitor, Types.Visitor {
	PrintWriter out;
	private int indentCount = 0;

	public PrintVisitor() {
		this.out = new PrintWriter(System.out);
	}

	public PrintVisitor(PrintWriter out) {
		this.out = out;
	}

	private void indent() {
		out.print('\n');
		for (int i = 0; i < indentCount; i++) {
			out.print(' ');
		}
	}

	public void visit(AddExpr ast) {
		visit(ast, "AddExpr");
	}

	public void visit(AndExpr ast) {
		visit(ast, "AndExpr");
	}

	public void visit(ArrayExpr ast) {
		indent();
		out.print("ArrayExpr(");
		indentCount++;
		ast.target.accept(this);
		ast.index.accept(this);
		indentCount--;
		out.print(")");
	}

	public void visit(ArrayType ast) {
		out.print("ArrayType(");
		ast.base.accept(this);
		out.print(")");
	}

	public void visit(AssignStmt ast) {
		indent();
		out.print("AssignStmt(");
		indentCount++;
		ast.lhs.accept(this);
		ast.rhs.accept(this);
		indentCount--;
		out.print(")");
	}

	public void visit(BinOpExpr ast) {
	}

	private void visit(BinOpExpr ast, String opType) {
		indent();
		out.print(opType + "(");
		indentCount++;
		ast.e1.accept(this);
		ast.e2.accept(this);
		indentCount--;
		out.print(")");

	}

	public void visit(BlockStmt ast) {
		indent();
		out.print("BlockStmt(");
		indentCount++;
		visit(ast.stmts);
		indentCount--;
		out.print(")");
	}

	public void visit(BooleanType ast) {
		out.print("BooleanType");
	}

	public void visit(CallExpr ast) {
		indent();
		out.print("CallExpr(");
		indentCount++;
		ast.target.accept(this);
		indent();
		out.print(ast.method);
		visit(ast.args);
		indentCount--;
		out.print(")");
	}

	public void visit(ClassDecl ast) {
		indent();
		out.print("ClassDecl(");
		indentCount++;
		out.print(ast.name + " " + ast.parent);
		visit(ast.fields);
		visit(ast.methods);

        indent();
		out.print("CLASS(" + ast.name);
		indentCount++;
		indent();
		out.print(ast.parent);

		// record of fields
        indent();
		out.print("RECORD(");
		indentCount++;
		visit(ast.fields);
		indentCount--;

		// record of methods
		indent();
		out.print("RECORD(");
		indentCount++;
		visit(ast.methods);
		indentCount--;

		indentCount--;// end of CLASS(
		out.print(")");

		indentCount--;// end of ClassDecl(
		out.print(")");
	}

	public void visit(DivExpr ast) {
		visit(ast, "DivExpr");
	}

	public void visit(EqualExpr ast) {
		visit(ast, "EqualExpr");
	}

	public void visit(Expr ast) {
	}

	public void visit(FalseExpr ast) {
		indent();
		out.print("FalseExpr");
	}

	public void visit(FieldExpr ast) {
		indent();
		out.print("FieldExpr(");
		indentCount++;
		ast.target.accept(this);
		indent();
		out.print(ast.field + ")");
		indentCount--;
	}

	public void visit(Formal ast) {
		indent();
		out.print("Formal(");
		ast.type.accept(this);
		out.print(" " + ast.name + ")");
	}

	public void visit(GreaterExpr ast) {
		visit(ast, "GreaterExpr");
	}

	public void visit(IdentifierExpr ast) {
		indent();
		out.print("IdentifierExpr(" + ast.id + ")");
	}

	public void visit(IdentifierType ast) {
		out.print("IdentifierType(" + ast.id + ")");
	}

	public void visit(IfStmt ast) {
		indent();
		out.print("IfStmt(");
		indentCount++;
		ast.test.accept(this);
		ast.thenStm.accept(this);
		if (null != ast.elseStm) {
			ast.elseStm.accept(this);
		} else {
			indent();
			out.print("null");
		}
		indentCount--;
		out.print(")");
	}

	public void visit(IntegerLiteral ast) {
		indent();
		out.print("IntegerLiteral(" + ast.value + ")");
	}

	public void visit(IntegerType ast) {
		out.print("IntegerType");
	}

	public void visit(java.util.AbstractList list) {
		if (null == list) {
			indent();
			out.print("null");
			return;
		}
		indent();
		out.print("AbstractList(");
		indentCount++;
		for (Object o : list) {
			if (null == o) {
				indent();
				out.print("null");
			} else {
				((Visitable) o).accept(this);
			}
		}
		out.print(")");
		indentCount--;
	}

	public void visit(LesserExpr ast) {
		visit(ast, "LesserExpr");
	}

	public void visit(MethodDecl ast) {
		indent();
		out.print("MethodDecl(");
		indentCount++;
		if (null != ast.returnType) {
			ast.returnType.accept(this);
		} else {
			out.print("public_static_void");
		}
		if (ast.synced) {
			out.print(" synchronized");
		}
		out.print(" " + ast.name);
		visit(ast.params);
		visit(ast.locals);
		visit(ast.stmts);
		ast.returnVal.accept(this);
		indentCount--;
		out.print(")");
		indentCount++;
		indent();
		out.print("FUNCTION(" + ast.name);
		visit(ast.checktype);
		indent();
	}

	public void visit(MulExpr ast) {
		visit(ast, "MulExpr");
	}

	public void visit(NegExpr ast) {
		indent();
		out.print("NegExpr(");
		indentCount++;
		ast.e1.accept(this);
		indentCount--;
		out.print(")");
	}

	public void visit(NewArrayExpr ast) {
		indent();
		out.print("NewArrayExpr(");
		indentCount++;
		ast.type.accept(this);
		visit(ast.dimensions);
		indentCount--;
		out.print(")");
	}

	public void visit(NewObjectExpr ast) {
		indent();
		out.print("NewObjectExpr(");
		indentCount++;
		ast.type.accept(this);
		indentCount--;
		out.print(")");
	}

	public void visit(NotEqExpr ast) {
		visit(ast, "NotEqExpr");
	}

	public void visit(NotExpr ast) {
		indent();
		out.print("NotExpr(");
		indentCount++;
		ast.e1.accept(this);
		indentCount--;
		out.print(")");
	}

	public void visit(NullExpr ast) {
		indent();
		out.print("NullExpr");
	}

	public void visit(OrExpr ast) {
		visit(ast, "OrExpr");
	}

	public void visit(Program ast) {
		out.print("Program(");
		indentCount++;
		visit(ast.classes);
		indentCount--;
		out.println(")");
		out.flush();
	}

	public void visit(Stmt ast) {
	}

	public void visit(StringLiteral ast) {
		indent();
		out.print("StringLiteral(" + ast.value + ")");
	}

	public void visit(SubExpr ast) {
		visit(ast, "SubExpr");
	}

	public void visit(ThisExpr ast) {
		indent();
		out.print("ThisExpr");
	}

	public void visit(ThreadDecl ast) {
		indent();
		out.print("ThreadDecl(");
		indentCount++;
		out.print(ast.name + " " + ast.parent);
		visit(ast.fields);
		visit(ast.methods);
		// indentCount--;
		// out.print(")");

		out.print("CLASS(" + ast.name);
		indentCount++;
		out.print(ast.parent);

		// record of fields
		out.print("RECORD(");
		indentCount++;
		visit(ast.fields);
		indentCount--;

		// record of methods
		out.print("RECORD(");
		indentCount++;
		visit(ast.methods);
		indentCount--;

		indentCount--;// end of CLASS(
		out.print(")");

		indentCount--;// end of ThreadDecl(
		out.print(")");
	}

	public void visit(TrueExpr ast) {
		indent();
		out.print("TrueExpr");
	}

	public void visit(Type ast) {
	}

	public void visit(Types.ARRAY ast) {
		indent();
		ast.element.accept(this);
	}

	public void visit(Types.BOOLEAN ast) {
		indent();
		out.print("BOOL");
	}

	public void visit(Types.CLASS ast) {
		indent();
		out.print("CLASS(" + ast.name);
		indentCount++;
		indent();
		out.print(ast.parent.name);

		ast.methods.accept(this);
		ast.fields.accept(this);
		ast.instance.accept(this);

		indentCount--;
		out.print(")");
	}

	public void visit(Types.FIELD ast) {
		indent();
		out.print("FIELD(" + ast.index + " " + ast.name + " ");
		indentCount++;
		ast.type.accept(this);

		indentCount--;
		out.print(")");
	}

	public void visit(Types.FUNCTION ast) {
		indent();
		out.print("FUNCTION(" + ast.name);
		indentCount++;
		indent();

		// ast.self.accept(this);
		ast.formals.accept(this);// will go to record
		ast.result.accept(this);// will handle return type

		indentCount--;
		out.print(")");
	}

	public void visit(Types.INT ast) {
		indent();
		out.print("INT");
	}

	public void visit(Types.NIL ast) {
		indent();
		out.print("NIL");
	}

	public void visit(Types.OBJECT ast) {
		indent();

		// we're in object. fields is a RECORD. RECORD.fields is a LinkedList
		if (ast.fields.fields.size() == 0 && ast.methods.fields.size() == 0) {
			out.print("OBJECT(" + ast.myClass.name + ")");
		} else {

			out.print("OBJECT(" + ast.myClass.name);

			indentCount++;
			// indent();

			ast.methods.accept(this);
			ast.fields.accept(this);
			if (ast.methods.hash.size() > 0)
				out.print("8=======D");
			if (ast.fields.hash.size() > 0)
				out.print("8=======D");
			indentCount--;
			out.print(")");
		}
	}

	public void visit(Types.RECORD ast) {
		indent();
		out.print("RECORD(");

		indentCount++;

		if (ast.hash.size() > 0)
			out.print("8=======D");

		for (Types.FIELD fieldOfRecord : ast.fields)
			fieldOfRecord.accept(this);

		indentCount--;
		out.print(")");
	}

	public void visit(Types.STRING ast) {
		indent();
		out.print("OBJECT:String");
	}

	// visit() methods for Types.*
	public void visit(Types.Type ast) {
	}

	public void visit(Types.VOID ast) {
		indent();
		out.print("VOID");
	}

	public void visit(TypeVisitor ast) {
	}

	public void visit(VarDecl ast) {
		indent();
		out.print("VarDecl(");
		ast.type.accept(this);
		out.print(" " + ast.name);
		if (null == ast.init) {
			out.print(" null");
		} else {
			ast.init.accept(this);
		}
		indentCount++;
        indent();
		ast.type.accept(this);
        //ast.checktype = new Types.INT();
        //out.print(ast.checktype.toString());
		indentCount--;
		out.print(")");
	}

	public void visit(VoidDecl ast) {
		indent();
		out.print("VoidDecl(");
		indentCount++;
		visit(ast.locals);
		visit(ast.stmts);
		indentCount--;
		out.print(")");
	}

	public void visit(WhileStmt ast) {
		indent();
		out.print("WhileStmt(");
		indentCount++;
		ast.test.accept(this);
		ast.body.accept(this);
		indentCount--;
		out.print(")");
	}

	public void visit(XinuCallExpr ast) {
		indent();
		out.print("XinuCallExpr(");
		indentCount++;
		out.print(ast.method);
		visit(ast.args);
		indentCount--;
		out.print(")");
	}

	public void visit(XinuCallStmt ast) {
		indent();
		out.print("XinuCallStmt(");
		indentCount++;
		out.print(ast.method);
		visit(ast.args);
		indentCount--;
		out.print(")");
	}

}
