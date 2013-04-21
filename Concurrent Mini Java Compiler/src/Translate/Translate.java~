package Translate;

import java.util.LinkedList;

//import Temp.Temp;

import Absyn.*;

public class Translate implements Visitor {
	
	public Types.Table<Temp.Temp> table;

	public Translate() {
		table = new Types.Table<Temp.Temp>();
	}

    public Exp visit(java.util.AbstractList<visitor.Visitable> list) 
    {
    	return null;
    }
	
	public Exp visit(AddExpr ast) {
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
	
		return new Ex(new Tree.BINOP(Tree.BINOP.PLUS, new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t1), e1), new Tree.TEMP(t1)), new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t2), e2), new Tree.TEMP(t2))));
	}

     public Exp visit(AndExpr ast) {
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
		
		//return new Ex(new Tree.BINOP(Tree.BINOP.AND, new Tree.TEMP(t1), new Tree.TEMP(t2)));
		return new Ex(new Tree.BINOP(Tree.BINOP.AND, new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t1), e1), new Tree.TEMP(t1)), new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t2), e2), new Tree.TEMP(t2))));
	}

    public Exp visit(ArrayExpr ast) {
		return new Ex(new Tree.MEM(new Tree.BINOP(Tree.BINOP.PLUS, ast.target.accept(this).unEx(), ast.index.accept(this).unEx())));
	} 

	public Exp visit(ArrayType ast) { 
		return null; 
	}

	public Exp visit(AssignStmt ast) {
		return null;
	}
	
    public Exp visit(BinOpExpr ast) {
    	//return new Ex();
    	return null;
    }
     
	public Exp visit(BlockStmt ast) {
		for(Stmt s : ast.stmts) {
			
		}
		return null;
	} 
     
	public Exp visit(BooleanType ast) { 
		return null;
	}
    
	public Exp visit(CallExpr ast) {
		LinkedList<Tree.Exp> e = new LinkedList<Tree.Exp>();

		for(Expr temp : ast.args) {
			e.add(temp.accept(this).unEx());
		}

		return new Ex(new Tree.CALL(new Tree.NAME(new Temp.Label(ast.method)), e));
	}

    public Exp visit(ClassDecl ast ){
		Exp out = new Nx(null);
		for(MethodDecl m : ast.methods){
			out = new Nx(new Tree.SEQ(out.unNx(), m.accept(this).unNx()));
		}

		return out;
	} 
	
	public Exp visit(DivExpr ast){
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
	
		return new Ex(new Tree.BINOP(Tree.BINOP.DIV, new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t1), e1), new Tree.TEMP(t1)), new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t2), e2), new Tree.TEMP(t2))));
	}
	
    public Exp visit(Expr ast){ 
    	return null; 
    }
    
    public Exp visit(EqualExpr ast){
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
		
		return new RelCx(new Tree.CJUMP(Tree.CJUMP.EQ, new Tree.TEMP(t1), new Tree.TEMP(t2), new Temp.Label(), new Temp.Label()));
	} 
     
    public Exp visit(FalseExpr ast){
		return new Ex(new Tree.CONST(0));
	}
 
	public Exp visit(FieldExpr ast){
		int index = ast.typeIndex;
		Tree.Exp e = ast.target.accept(this).unEx();
		Temp.Label bad = Frame.Frame.badPtr();
		Temp.Label ok = new Temp.Label();
		Temp.Temp result = new Temp.Temp();
		return new Ex(new Tree.ESEQ(new Tree.SEQ(new Tree.MOVE(new Tree.TEMP(result), e),
						new Tree.CJUMP(Tree.CJUMP.EQ , new Tree.TEMP(result), new Tree.CONST(0), bad, ok)),
						new Tree.ESEQ(new Tree.LABEL(ok), new Tree.MEM(new Tree.BINOP(Tree.BINOP.PLUS, new Tree.TEMP(result), new Tree.CONST(index))))));
	}

    public Exp visit(Formal ast){return null;} 

    public Exp visit(GreaterExpr ast) {
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
		
		Temp.Label l1 = new Temp.Label();
		Temp.Label l2 = new Temp.Label();
		
		return new RelCx(new Tree.CJUMP(Tree.CJUMP.GT, new Tree.TEMP(t1), new Tree.TEMP(t2), l1, l2));
	}
     	
	public Exp visit(IdentifierExpr ast){
		Frame.Access a = new Mips.InReg(table.get(ast.id));
		
		if(a instanceof Mips.InReg){
			return new Ex(new Tree.TEMP(((Mips.InReg) a).t));
		}
		else{
			return new Ex(new Tree.MEM(new Tree.BINOP(Tree.BINOP.PLUS, new Tree.TEMP(((Mips.InFrame)a).t), new Tree.TEMP(new Temp.Temp()))));
		}
	}

	public Exp visit(IdentifierType ast){
		return null;
	}
	
	public Exp visit(IfStmt ast){
		return new IfThenElseExp(ast.test.accept(this), ast.thenStm.accept(this), ast.elseStm.accept(this));
	}
	
	public Exp visit(IntegerLiteral ast){
		return new Ex(new Tree.CONST(ast.value));
	}

    public Exp visit(IntegerType ast)
    {
    	return null;
    }
	
    public Exp visit(LesserExpr ast){
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
		
		Temp.Label l1 = new Temp.Label();
		Temp.Label l2 = new Temp.Label();
		
		return new RelCx(new Tree.CJUMP(Tree.CJUMP.LT, new Tree.TEMP(t1), new Tree.TEMP(t2), l1, l2));
	} 

	public Exp visit(MethodDecl ast){
		table.beginScope();
		LinkedList<Boolean> bools = new LinkedList<Boolean>();
		
		for(Formal f : ast.params){
			bools.add(false);
		}

		Mips.MipsFrame m = new Mips.MipsFrame(new Temp.Label(ast.name), bools);

		for(VarDecl v : ast.locals){
			v.init.accept(this);
			table.put(v.name, new Temp.Temp());
			m.allocLocal(false);
		}

		Nx ret = null;

		for(Stmt s : ast.stmts){
			ret = new Nx(new Tree.SEQ(ret.unNx(), s.accept(this).unNx()));
		}

		ret = new Nx(new Tree.SEQ(ret.unNx(), new Tree.MOVE(new Tree.TEMP(new Temp.Temp(2)), ast.returnVal.accept(this).unEx())));
		

		//return new Nx(new ProcFrag(ret.unNx(), m));
		return ret;
	}
	
	public Exp visit(MulExpr ast){
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
	
		return new Ex(new Tree.BINOP(Tree.BINOP.MUL, new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t1), e1), new Tree.TEMP(t1)), new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t2), e2), new Tree.TEMP(t2))));
	}

    public Exp visit(NegExpr ast) {
		return null;
    }
    
    public Exp visit(NewArrayExpr ast) {
    	return null;
    }
     
    public Exp visit(NewObjectExpr ast) {
    	return null;
    } 
     
     
    public Exp visit(NotEqExpr ast){
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();

		Temp.Label l1 = new Temp.Label();
		Temp.Label l2 = new Temp.Label();
		
		return new RelCx(new Tree.CJUMP(Tree.CJUMP.NE, new Tree.TEMP(t1), new Tree.TEMP(t2), l1, l2));
	}
     
    public Exp visit(NotExpr ast){
    	return null;
	} 
     
	public Exp visit(NullExpr ast){
		return new Ex(new Tree.CONST(0));
	}

    public Exp visit(OrExpr ast)
    {
    	Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
		
		return new Ex(new Tree.BINOP(Tree.BINOP.OR, new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t1), e1), new Tree.TEMP(t1)), new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t2), e2), new Tree.TEMP(t2))));
    }
    
    public LinkedList<Exp> visit(Program ast){
		LinkedList<Exp> out = new LinkedList<Exp>();

		for(ClassDecl c : ast.classes){
			Exp f = c.accept(this);
			out.add(f);
		}

		return out;
	}

    public Exp visit(StringLiteral ast){
		//return new Ex(new Tree.LABEL(new Temp.Label()));
    	return null;
	} 
     
    public Exp visit(Stmt ast){
		return null;
	}
     
	public Exp visit(SubExpr ast){
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
	
		return new Ex(new Tree.BINOP(Tree.BINOP.MINUS, new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t1), e1), new Tree.TEMP(t1)), new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t2), e2), new Tree.TEMP(t2))));
	}

    public Exp visit(ThisExpr ast){
    	return new Ex(new Tree.TEMP(new Temp.Temp(4)));
	}

    public Exp visit(ThreadDecl ast){
		LinkedList<Exp> out = new LinkedList<Exp>();
		for(MethodDecl m : ast.methods){
			out.add(m.accept(this));
		}

		return out.getFirst();
	} 

	public Exp visit(TrueExpr ast){
		return new Ex(new Tree.CONST(1));
	} 

    public Exp visit(Type ast){
    	 return null;
    }
     
    public Exp visit(visitor.TypeVisitor ast){ 
    	 return null;
    }
    
    public Exp visit(VarDecl ast){
    	return null;
    }
    
    public Exp visit(VoidDecl ast){
		table.beginScope();
		LinkedList<Boolean> bools = new LinkedList<Boolean>();
		
		for(Formal f : ast.params){
			bools.add(false);
		}

		Mips.MipsFrame m = new Mips.MipsFrame(new Temp.Label(ast.name), bools);

		for(VarDecl v : ast.locals){
			//table.put(v.name, v.init.accept(this));
			Temp.Temp temp = ((Mips.InReg)m.allocLocal(false)).t;
			table.put(v.name, temp);
		}

		Tree.SEQ ret = null;

		for(Stmt s : ast.stmts) {
			ret = (new Tree.SEQ(ret, s.accept(this).unNx()));
		}
		
		//return new ProcFrag(ret.unNx(), m);
		return new Nx(ret);
	}
     
    public Exp visit(WhileStmt ast) {
		return null;
	}
     
    public Exp visit(XinuCallExpr ast){
		LinkedList<Tree.Exp> e = new LinkedList<Tree.Exp>();

		for(Expr temp : ast.args){
			e.add(temp.accept(this).unEx());
		}

		return new Ex(new Tree.CALL(new Tree.TEMP(table.get(ast.method)), e));
	} 
     
    public Exp visit(XinuCallStmt ast){
		LinkedList<Tree.Exp> e = new LinkedList<Tree.Exp>();

		for(Expr temp : ast.args){
			e.add(temp.accept(this).unEx());
		}

		return new Ex(new Tree.CALL(new Tree.TEMP(table.get(ast.method)), e));
	}


	public Exp visit(Absyn absyn) {
		// TODO Auto-generated method stub
		return null;
	}
}
