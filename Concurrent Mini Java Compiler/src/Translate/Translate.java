package Translate;

import java.util.LinkedList;

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
		return new Ex(new Tree.MEM(new Tree.BINOP(Tree.BINOP.ADD, ast.target.accept(this).unEx(), ast.index.accept(this).unEx())));
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
		LinkedList<Exp> e = new LinkedList<Exp>();

		for(Expr temp : ast.args) {
			e.add(temp.accept(this));
		}

		return new Ex(new Tree.CALL(new Ex(Tree.NAME(ast.name)), e));
	}

     public LinkedList<Frag> visit(ClassDecl ast ){
		LinkedList<Frag> out = new LinkedList<Frag>();
		for(MethodDecl m : ast.methods){
			out.add(m.accept(this));
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
     public Exp visit(Expr ast){ return null; }
     public Exp visit(EqualExpr ast){
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
		
		return new Cx(new Tree.CJUMP(Tree.CJUMP.EQ, new Tree.TEMP(t1), new Tree.TEMP(t2), ));
	} 
     public Exp visit(FalseExpr ast){
		return new Ex(new CONST(0));
	}
 
	public Exp visit(Absyn.FieldExpr ast){
		int index = ast.typeIndex;
		Tree.Exp e = ast.target.accept(this).unEx();
		Temp.Label bad = Frame.badPtr();
		Temp.Label ok = new Temp.Label();
		Temp.Temp result = new Temp.Temp();
		return new Ex(new Tree.ESEQ(new Tree.SEQ(new Tree.MOVE(Tree.TEMP(result), e)
						new JUMP(Tree.CJUMP(Tree.CJUMP.EQ , new Tree.TEMP(result), new Tree.CONST(0), bad, ok)),
						new ESEQ(new Tree.LABEL(ok), new Tree.MEM(new Tree.BINOP(Tree.BINOP.PLUS, new Tree.TEMP(result), new Tree.CONST(index))));
	}

     public Exp visit(Formal ast){return null;} 

     public Exp visit(GreaterExpr ast) {
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Tree.Temp t1 = new Temp.Temp();
		Tree.Temp t2 = new Temp.Temp();
		
		return new Cx(new Tree.CJUMP(Tree.CJUMP.GT, new Tree.TEMP(t1), new Tree.TEMP(t2), ));
	}
     	
	public Exp visit(Absyn.IdentifierExp ast){
		Frame.Access a = table.get(ast.id);
		
		if(a instanceof Mips.InReg){
			return new Ex(a);
		}
		else{
			return new Ex(new Tree.MEM(new Tree.BINOP(Tree.BINOP.PLUS, new Tree.TEMP(t1), new Tree)));
		}
	}

	public Exp visit(IdentifierType ast){
		return null;
	}
	public Exp visit(IfStmt ast){
		return new IfThenElseExp(ast.test.accept(this), ast.thenStm.accept(this), ast.elseStm(this));
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
		
		return new Cx(new Tree.CJUMP(Tree.CJUMP.LT, new Tree.TEMP(t1), new Tree.TEMP(t2), ));
	} 

	public Frag visit(MethodDecl ast){
		table.beginScope();
		LinkedList<Boolean> bools = new LinkedList<Boolean>();
		
		for(Formal f : ast.params){
			bools.add(false);
		}

		Mips.MipsFrame m = new Mips.MipsFrame(ast.name, bools);

		for(VarDecl v : ast.locals){
			table.put(v.name, v.init.accept(this));
			m.allocLocal(false);
		}

		Tree.Stm ret = null;

		for(Stmt s : ast.stmts){
			ret = new Nx(new Tree.SEQ(ret.unNx(), s.accept(this));
		}

		ret = new Nx(new Tree.SEQ(ret.unNx(), new Tree.MOVE(new Tree.Temp(new Temp.Temp(2)), ast.returnVal.accept(this))));
		

		return new ProcFrag(ret.unNx(), m);
	}
	
	public Exp visit(MulExpr ast){
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
	
		return new Ex(new Tree.BINOP(Tree.BINOP.MUL, new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t1), e1), new Tree.TEMP(t1)), new Tree.ESEQ(new Tree.MOVE(new Tree.TEMP(t2), e2), new Tree.TEMP(t2))));
	}

    public Exp visit(NegExpr ast){}
    
    public Exp visit(NewArrayExpr ast){}
     
    public Exp visit(NewObjectExpr ast){} 
     
     
    public Exp visit(NotEqExpr ast){
		Tree.Exp e1 = ast.e1.accept(this).unEx();
		Tree.Exp e2 = ast.e2.accept(this).unEx();
		Temp.Temp t1 = new Temp.Temp();
		Temp.Temp t2 = new Temp.Temp();
		
		return new Cx(new Tree.CJUMP(Tree.CJUMP.NQ, new Tree.TEMP(t1), new Tree.TEMP(t2), ));

	}
     
    public Exp visit(NotExpr ast){
		
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
    
    public LinkedList<Frag> visit(Program ast){
		LinkedList<Frag> out = new LinkedList<Frag>();

		for(ClassDecl c : ast.classes){
			for(Frag f : c.accept(this)){
				out.add(f);
			}
		}

		return out;
	}

    public Exp visit(StringLiteral ast){
		return new Ex(new Tree.LABEL(new Temp.Label()));
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
		LinkedList<Frag> out = new LinkedList<Frag>();
		for(MethodDecl m : ast.methods){
			out.add(m.accept(this));
		}

		return out;
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

		Tree.Stm ret = null;

		for(Stmt s : ast.stmts){
			ret = new Nx(new Tree.SEQ(ret.unNx(), s.accept(this)));
		}
		
		return new ProcFrag(ret.unNx(), m);
	}
     
    public Exp visit(WhileStmt ast){
		
	}
     
    public Exp visit(XinuCallExpr ast){
		LinkedList<Exp> e = new LinkedList<Exp>();

		for(Expr temp : ast.args){
			e.add(temp.accept(this));
		}

		return new Ex(new Tree.CALL(new Tree.NAME(ast.name), e));
	} 
     
    public Exp visit(XinuCallStmt ast){
		LinkedList<Exp> e = new LinkedList<Exp>();

		for(Expr temp : ast.args){
			e.add(temp.accept(this));
		}

		return new Nx(new Tree.CALL(new Tree.NAME(ast.name), e));
	}

	@Override
	public Exp visit(FieldExpr ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exp visit(IdentifierExpr ast) {
		// TODO Auto-generated method stub
		return null;
	}
}
