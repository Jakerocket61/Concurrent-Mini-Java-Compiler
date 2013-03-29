// Jacob Anderson, Jack Batzner, Paul Kaefer

package visitor;

import java.util.LinkedList;

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
import Types.Table;

// scoping

public class TypeVisitor implements T_Visitor {

	// private Types.RECORD programRecord = new Types.RECORD();
	private Table<Types.Type> scopeTab = new Table<Types.Type>();

	public TypeVisitor() {
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public Types.Type visit(AddExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		Types.Type t2 = ast.e2.accept(this);

		if ((t1.coerceTo(t2)) && (t2.coerceTo(t1)))
			return t1;

		System.err.println("ERROR operator + cannot be applied to "
				+ t1.toString() + ", " + t2.toString());
		System.exit(0);

		return new Types.NIL();
	}

	public Types.Type visit(AndExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		Types.Type t2 = ast.e2.accept(this);

		if ((t1.coerceTo(t2)) && (t2.coerceTo(t1)))
			return t1;

		System.err.println("ERROR operator + cannot be applied to "
				+ t1.toString() + ", " + t2.toString());
		System.exit(0);

		return new Types.NIL();
	}

	public Types.Type visit(ArrayExpr ast) {
		Types.Type target = ast.target.accept(this);
		Types.Type index = ast.index.accept(this);

		if (index.coerceTo(new Types.INT())) {
			return target;
		} else {
			System.out.println("ERROR incompatible types: int required, but "
					+ index.toString() + " found");
			System.exit(0);
		}
		return new Types.NIL();
	}

	public Types.Type visit(ArrayType ast) {
		return new Types.ARRAY(ast.base.accept(this));
	}

	public Types.Type visit(AssignStmt ast) {
		Types.Type lhs = ast.lhs.accept(this);
		Types.Type rhs = ast.rhs.accept(this);

		if (rhs.coerceTo(lhs))
			return lhs;

		System.err.println("ERROR incompatible types: " + lhs.toString()
				+ " required, but " + rhs.toString() + " found");
		System.exit(0);
		return new Types.NIL();
	}

	public Types.Type visit(BinOpExpr ast) {
		return new Types.NIL();
	}

	public Types.Type visit(BlockStmt ast) {
		scopeTab.beginScope();
		for (Stmt statement : ast.stmts) {
			statement.accept(this);
		}
		scopeTab.endScope();
		return new Types.NIL();

	}

	public Types.Type visit(BooleanType ast) {
		return new Types.BOOLEAN();
	}

	public Types.Type visit(CallExpr ast) {
		scopeTab.beginScope();

		LinkedList<Types.Type> temp = new LinkedList<Types.Type>();

		String methodName = ast.method;

		Types.Type current = scopeTab.get(methodName);

		if (current == null || !(current instanceof Types.FUNCTION)) {
			System.err.println("ERROR cannot resolve method " + methodName);
			System.exit(0);
		}

		for (Types.FIELD f : ((Types.FUNCTION) current).formals) {
			Types.Type t1 = f.type;
			/*
			 * current.formals.get(i).accept(this); Types.Type t2 =
			 * ast.args.get(i).accept(this);
			 */

			temp.add(t1);
		}

		/*
		 * for(Field formal: current.formals.iterator()) {
		 * 
		 * Types.Type type2 = ast.args.accept(this);
		 * 
		 * scopeTab.put(param.name, type2); }
		 */

		for (Expr expression : ast.args) {
			Types.Type t1 = expression.accept(this);
			Types.Type t2 = temp.getFirst();

			if (t1.coerceTo(t2))
				;
			else {
				System.err.println("ERROR mismatch in number of arguments");
				System.exit(0);
			}
			temp.removeFirst();
		}

		// for(Stmt statement: ast.stmts) {
		// statement.accept(this);
		// }

		scopeTab.endScope();

		return ((Types.FUNCTION) current).result;
	}

	public Types.Type visit(ClassDecl ast) {
		for (VarDecl v : ast.fields) {
			v.accept(this);
		}

		for (MethodDecl m : ast.methods) {
			m.accept(this);
		}

		return new Types.NIL();
	}

	public Types.Type visit(DivExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		Types.Type t2 = ast.e2.accept(this);

		if ((t1.coerceTo(t2)) && (t2.coerceTo(t1)))
			return t1;

		System.err.println("ERROR operator / cannot be applied to "
				+ t1.toString() + ", " + t2.toString());
		System.exit(0);

		return new Types.NIL();
	}

	public Types.Type visit(EqualExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		Types.Type t2 = ast.e2.accept(this);

		if ((t1.coerceTo(t2)) && (t2.coerceTo(t1)))
			return t1;

		System.err.println("ERROR operator == cannot be applied to "
				+ t1.toString() + ", " + t2.toString());
		System.exit(0);

		return new Types.NIL();
	}

	public Types.Type visit(Expr ast) {
		return new Types.NIL();
	}

	public Types.Type visit(FalseExpr ast) {
		return new Types.BOOLEAN();
	}

	public Types.Type visit(FieldExpr ast) {
		Types.Type t = ast.target.accept(this);
		if (t instanceof Types.OBJECT) {
			for (Types.FIELD f : ((Types.OBJECT) t).fields) {
				if (f.name.equals(ast.field)) {
					return f.type;
				}
			}
		} else {
			System.err.println("ERROR cannot resolve symbol " + ast.field);
			System.exit(0);

		}
		return new Types.NIL();
	}

	public Types.Type visit(Formal ast) {
		scopeTab.put(ast.name, ast.type.accept(this));
		return ast.type.accept(this);
	}

	public Types.Type visit(GreaterExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		Types.Type t2 = ast.e2.accept(this);

		if ((t1.coerceTo(t2)) && (t2.coerceTo(t1)))
			return t1;

		System.err.println("ERROR operator > cannot be applied to "
				+ t1.toString() + ", " + t2.toString());
		System.exit(0);

		return new Types.NIL();
	}

	public Types.Type visit(IdentifierExpr ast) {
		return scopeTab.get(ast.id);
	}

	public Types.Type visit(IdentifierType ast) {
		return scopeTab.get(ast.id);
	}

	public Types.Type visit(IfStmt ast) {
		Types.Type type = ast.test.accept(this);

		if (type.coerceTo(new Types.BOOLEAN()))
			;
		else {
			System.err.println("ERROR incompatible types: BOOL required, but "
					+ type.toString() + " found");
			System.exit(0);
		}

		if (ast.thenStm != null)
			ast.thenStm.accept(this);

		if (ast.elseStm != null)
			ast.elseStm.accept(this);

		return new Types.NIL();
	}

	public Types.Type visit(IntegerLiteral ast) {
		return new Types.INT();
	}

	public Types.INT visit(IntegerType ast) {
		return new Types.INT();
	}

	public Types.Type visit(java.util.AbstractList<Visitable> list) {
		/*
		 * for (Object o : list) { o.accept(this); }
		 */
		return new Types.NIL();
	}

	public Types.Type visit(LesserExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		Types.Type t2 = ast.e2.accept(this);

		if ((t1.coerceTo(t2)) && (t2.coerceTo(t1)))
			return t1;

		System.err.println("ERROR operator < cannot be applied to "
				+ t1.toString() + ", " + t2.toString());
		System.exit(0);

		return new Types.NIL();
	}

	public Types.Type visit(MethodDecl ast) {
		scopeTab.beginScope();

		// scopeTab.put("this", target.accept(this));

		for (Formal f : ast.params) {
			f.accept(this);
		}

		for (VarDecl v : ast.locals) {
			v.accept(this);
		}
		for (Stmt statement : ast.stmts) {
			statement.accept(this);
		}
		if (ast.returnType == null) {

		}
		Types.Type t2;
		Types.Type t1;
		if (ast.returnType != null) {
			t1 = ast.returnType.accept(this);
		} else {
			t1 = new Types.INT();
		}
		t2 = ast.returnVal.accept(this);
		if (t2.coerceTo(t1)) {
		} else {
			System.err.println("ERROR incompatible types: " + t1.toString()
					+ " required, but " + t2.toString() + " found");
			System.exit(0);
		}

		scopeTab.endScope();

		return new Types.NIL();
	}

	public Types.Type visit(MulExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		Types.Type t2 = ast.e2.accept(this);

		if ((t1.coerceTo(t2)) && (t2.coerceTo(t1)))
			return t1;

		System.err.println("ERROR operator * cannot be applied to "
				+ t1.toString() + ", " + t2.toString());
		System.exit(0);

		return new Types.NIL();
	}

	public Types.Type visit(NegExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		if (t1.coerceTo(new Types.INT())) {
			return new Types.INT();
		}
		System.err.println("ERROR operator - cannot be applied to "
				+ t1.toString());
		System.exit(0);
		return new Types.NIL();
	}

	public Types.Type visit(NewArrayExpr ast) {
		for (Expr e : ast.dimensions) {
			Types.Type t = e.accept(this);
			if (t.coerceTo(new Types.INT())) {

			} else {
				System.err
						.println("ERROR incompatible types: int recquired, but "
								+ t.toString() + "found");
				System.exit(0);
			}
		}

		return ast.type.accept(this);

	}

	public Types.Type visit(NewObjectExpr ast) {
		return ast.type.accept(this);
	}

	public Types.Type visit(NotEqExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		Types.Type t2 = ast.e2.accept(this);

		if ((t1.coerceTo(t2)) && (t2.coerceTo(t1)))
			return t1;

		System.err.println("ERROR operator != cannot be applied to "
				+ t1.toString() + ", " + t2.toString());
		System.exit(0);

		return new Types.NIL();
	}

	public Types.Type visit(NotExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		if (t1.coerceTo(new Types.BOOLEAN()))
			return t1;

		System.err.println("ERROR operator ! cannot be applied to "
				+ t1.toString());
		System.exit(0);

		return new Types.NIL();
	}

	public Types.Type visit(NullExpr ast) {
		return new Types.NIL();
	}

	public Types.Type visit(OrExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		Types.Type t2 = ast.e2.accept(this);

		if ((t1.coerceTo(t2)) && (t2.coerceTo(t1)))
			return t1;

		System.err.println("ERROR operator || cannot be applied to "
				+ t1.toString() + ", " + t2.toString());
		System.exit(0);

		return new Types.NIL();
	}

	public Types.Type visit(Program ast) {

		scopeTab.beginScope();

		Types.RECORD varDecls;
		Types.RECORD methodDecls;

		// //////////////////////////////////////////////////////////////////////
		// ////// PASS 1.1 ////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////

		for (ClassDecl classDecl : ast.classes) {
			varDecls = new Types.RECORD();
			methodDecls = new Types.RECORD();

			if (scopeTab.get(classDecl.name) != null) {
				System.err.println("ERROR duplicate class");
				System.exit(0);
			}

			for (MethodDecl methodDecl : classDecl.methods) {
				// methodDecls.put(this.visit(methodDecl), methodDecl.name);
				Types.FUNCTION f = new Types.FUNCTION(methodDecl.name,
						new Types.NIL(), new Types.RECORD(), new Types.NIL());
				methodDecls.put(f, methodDecl.name);
			}

			for (VarDecl varDecl : classDecl.fields) {
				varDecls.put(null, varDecl.name);
			}

			/*
			 * classRecords.put(varDecls, "VarDecls");
			 * classRecords.put(methodDecls, "MethodDecls");
			 * programRecord.put(classRecord, classDecl.name);
			 */

			Types.CLASS temp = new Types.CLASS(classDecl.name);
			temp.methods = methodDecls;
			temp.fields = varDecls;
			scopeTab.put(classDecl.name, temp);
		}

		// //////////////////////////////////////////////////////////////////////
		// ////// PASS 1.2 ////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////

		for (ClassDecl classDecl : ast.classes) {
			Types.CLASS temp = (Types.CLASS) scopeTab.get(classDecl.name);
			varDecls = temp.fields;
			methodDecls = temp.methods;

			Types.Type p = scopeTab.get(classDecl.parent);

			if (p instanceof Types.CLASS || p == null) {
				temp.parent = (Types.CLASS) p;
			} else {
				System.err.println("ERROR cannot resolve parent class "
						+ classDecl.parent);
				System.exit(0);
			}

			for (int i = 0; i < classDecl.methods.size(); i++) {
				Types.FIELD f = methodDecls.fields.get(i);
				Types.FUNCTION curr = (Types.FUNCTION) f.type;
				curr.self = scopeTab.get(classDecl.name);
				curr.result = classDecl.methods.get(i).returnVal.accept(this);
				curr.formals = new Types.RECORD();

				for (Formal a : classDecl.methods.get(i).params)
					curr.formals.put(a.type.accept(this), a.name);
			}

			for (int i = 0; i < classDecl.fields.size(); i++) {
				varDecls.put(classDecl.fields.get(i).accept(this),
						classDecl.fields.get(i).name);
			}

		}

		// //////////////////////////////////////////////////////////////////////
		// ////// PASS 1.3 ////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////

		for (ClassDecl classDecl : ast.classes) {
			Types.CLASS myClass = (Types.CLASS) scopeTab.get(classDecl.name);
			Types.CLASS parent = myClass.parent;

			while (parent != null) {
				if (parent.name.equals(classDecl.name)) {
					System.err.println("ERROR cyclic inheritance involving "
							+ classDecl.name);
					System.exit(0);
				}
				parent = parent.parent;
			}

			Types.OBJECT temp = new Types.OBJECT(myClass);

			for (Types.FIELD f : myClass.fields) {
				temp.fields.fields.add(f);
			}

			for (Types.FIELD f : myClass.methods) {
				temp.methods.fields.add(f);
			}

			myClass.instance = temp;

		}

		// //////////////////////////////////////////////////////////////////////
		// ////// PASS 2 //////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////
		for (ClassDecl classDecl : ast.classes) {
			for (MethodDecl methodDecl : classDecl.methods)
				methodDecl.accept(this);

			// for(VarDecl varDecl: classDecl.fields)
			// visit(varDecls.get(varDecl.name));
		}

		scopeTab.endScope();
		return new Types.VOID();
	}

	public Types.Type visit(Stmt ast) {
		return new Types.NIL();
	}

	public Types.Type visit(StringLiteral ast) {
		return new Types.STRING();
	}

	public Types.Type visit(SubExpr ast) {
		Types.Type t1 = ast.e1.accept(this);
		Types.Type t2 = ast.e2.accept(this);

		if ((t1.coerceTo(t2)) && (t2.coerceTo(t1)))
			return t1;

		System.err.println("ERROR operator - cannot be applied to "
				+ t1.toString() + ", " + t2.toString());
		System.exit(0);

		return new Types.NIL();
	}

	public Types.Type visit(ThisExpr ast) {
		return scopeTab.get("this");
	}

	public Types.Type visit(ThreadDecl ast) {
		for (VarDecl v : ast.fields) {
			v.accept(this);
		}

		for (MethodDecl m : ast.methods) {
			m.accept(this);
		}
		return new Types.NIL();
	}

	public Types.Type visit(TrueExpr ast) {
		return new Types.BOOLEAN();
	}

	public Types.Type visit(Type ast) {
		return new Types.NIL();
	}

	public Types.Type visit(TypeVisitor ast) {
		return new Types.NIL();
	}

	public Types.Type visit(VarDecl ast) {
		Types.Type t1 = ast.type.accept(this);
		Types.Type t2;
		if (ast.init != null)
			t2 = ast.init.accept(this);
		else {
			t2 = new Types.NIL();
		}

		if (t2.coerceTo(t1) || t2.coerceTo(new Types.NIL())) {
			scopeTab.put(ast.name, t1);
			return t1;
		} else {
			System.err.println("ERROR incompatible types: " + t1.toString()
					+ " recquired, but " + t2.toString() + " found");
			System.exit(0);
		}

		return new Types.NIL();
	}

	public Types.Type visit(VoidDecl ast) {
		scopeTab.beginScope();

		/*
		 * for(Formal f: ast.params){ f.accept(this) }
		 */

		for (VarDecl v : ast.locals) {
			v.accept(this);
		}
		for (Stmt statement : ast.stmts) {
			statement.accept(this);
		}

		scopeTab.endScope();

		return new Types.VOID();
	}

	public Types.Type visit(WhileStmt ast) {
		Types.Type type = ast.test.accept(this);

		if (type.coerceTo(new Types.BOOLEAN()))
			;
		else {
			System.err.println("ERROR incompatible types: BOOL required, but "
					+ type.toString() + " found");
			System.exit(0);
		}

		return new Types.VOID();
	}

	public Types.Type visit(XinuCallExpr ast) {
		String method = ast.method;
		Types.Type type = new Types.NIL();

		if (method == "readint")
			type = new Types.INT();

		if (ast.args.size() > 0) {
			System.err.println("ERROR mismatch in number of arguments");
			System.exit(0);
		}

		return type;
	}

	public Types.Type visit(XinuCallStmt ast) {
		String method = ast.method;
		Types.Type type = new Types.NIL();

		if (method == "printint")
			type = new Types.INT();

		if (method == "print")
			type = new Types.STRING();

		if (method == "println")
			if (ast.args.size() > 0) {
				System.err.println("ERROR mismatch in number of arguments");
				System.exit(0);
			}

		if (method == "sleep")
			type = new Types.INT();

		if (method == "threadCreate")
			if (ast.args.size() > 0) {
				System.err.println("ERROR mismatch in number of arguments");
				System.exit(0);
			}

		for (Expr expression : ast.args) {
			Types.Type type2 = expression.accept(this);

			if (type2.coerceTo(type))
				continue;
			else {
				System.err.println("ERROR incompatible types: "
						+ type.toString() + " required, but "
						+ type2.toString() + " found");
				System.exit(0);
			}
		}

		return new Types.VOID();
	}

}
