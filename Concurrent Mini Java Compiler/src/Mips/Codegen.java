package Mips;

import java.util.List;
import java.util.ListIterator;

import Assem.Instr;
import Temp.Label;
import Temp.Temp;
import Tree.BINOP;
import Tree.CALL;
import Tree.CJUMP;
import Tree.CONST;
import Tree.CodeVisitor;
import Tree.ESEQ;
import Tree.EXP;
import Tree.JUMP;
import Tree.LABEL;
import Tree.MEM;
import Tree.MOVE;
import Tree.NAME;
import Tree.SEQ;
import Tree.TEMP;

public class Codegen implements CodeVisitor {

	private MipsFrame frame;
	private ListIterator<Instr> code;

	public Codegen(MipsFrame frame, ListIterator<Instr> code) {
		this.frame = frame;
		this.code = code;
	}

	public void emit(Instr inst) {
		code.add(inst);
	}

	static Assem.Instr OPER(String a, Temp[] d, Temp[] s, List<Label> j) {
		return new Assem.OPER("\t" + a, d, s, j);
	}

	static Assem.Instr OPER(String a, Temp[] d, Temp[] s) {
		return OPER(a, d, s, null);
	}

	static Instr MOVE(String a, Temp d, Temp s) {
		return new Assem.MOVE("\t" + a, d, s);
	}

	public static boolean CONST16(Tree.CONST c) {
		return c.value == (short) c.value;
	}

	@Override
	public void visit(SEQ n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(LABEL n) {
		emit(new Assem.LABEL(n.label.name + ":\t", n));
	}

	@Override
	public void visit(JUMP n) {
		// OPER("	jal	_print" defs(t31 t4 t5 t6 t7 t8 t9 t10 t11 t12 t13 t14 t15
		// t24 t25 t2 t3 ) uses(t4 ))
		// TODO fix this!!
		emit(OPER("jal", MipsFrame.registers, n.actuals));
	}

	@Override
	public void visit(CJUMP n) {
		//CJUMP(op,*,*,label,*)	
		
		String operation = "";
		
		switch(n.relop) {
		case 0:
			operation = "beq";
			break;
		case 1:
			operation = "bge";
			break;
		case 2:
			operation = "bgt";
			break;
		case 3:
			operation = "ble";
			break;
		case 4:
			operation = "blt";
			break;
		case 5:
			operation = "bne";
			break;
		case 6:
			operation = "bge";
			break;
		case 7:
			operation = "bgt";
			break;
		case 8:
			operation = "ble";
			break;
		case 9:
			operation = "blt";
			break;
		default:
				break;
		}
		
		emit(OPER(operation + "`s0,	`s1,	`j0", ));
		

	}

	@Override
	public void visit(MOVE n) {
		//MOVE(MEM(+(*,CONST_16)),*) OR MOVE(MEM(+(CONST_16,*)),*) ==> OPER(" sw    Rs,   I_16(Rd) ")
		/*if((n.d instanceof Tree.MEM && ((Tree.MEM) n.d).exp instanceof Tree.BINOP && ((Tree.MEM) n.d).exp.binop == Tree.BINOP.ADD) {
			emit(new OPER("sw", visit(n.s), visit(n.d)));
		} else if (n.s instanceof Tree.MEM && ((Tree.MEM) n.s).exp instanceof Tree.BINOP && ((Tree.MEM) n.s).exp.binop == Tree.BINOP.ADD)) {
			emit(new OPER("sw", visit(n.s), visit(n.d)));
		}
		munchStm(MOVE(MEM(BINOP(PLUS,e1,CONST(i))),e2))
			emit(new OPER("STORE M[�s0+" + i + "] <- �s1\n", null, L(munchExp(e1), L(munchExp(e2), null)))); 
		munchStm(MOVE(MEM(BINOP(PLUS,CONST(i),e1)),e2))
				emit(new OPER("STORE M[�s0+" + i + "] <- �s1\n", null, L(munchExp(e1), L(munchExp(e2), null))));
		
		
		
		//MOVE(MEM(*),*)
		else if() {
		
		}
		//MOVE(*,*)
		else {
			emit(MOVE("move	`d0,\t`s0", n.dst(), n.src());
		}*/
	}

	@Override
	public void visit(EXP n) {
		// TODO Auto-generated method stub

	}

	@Override
	public Temp visit(BINOP n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temp visit(MEM n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temp visit(TEMP n) {
		//TEMP	==> t_n
		return n.temp;
	}

	@Override
	public Temp visit(ESEQ n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temp visit(NAME n) {
		// NAME	==> la    Rd,   label (n.label)
		emit(OPER("la", new Temp[]{ n.label }, null));
		
		return n.label;
	}

	@Override
	public Temp visit(CONST n) {
		// CONST(*) ==> li    Rd,   *
		emit(OPER("li\tRd " + n.value, null, null));
		
		return new Temp();
	}

	@Override
	public Temp visit(CALL n) {
		// CALL(*,*) ==> jal label
		if(n.args.size() > 0) {
			for(Exp expr: n.args) {
				emit(MOVE("move	`d0,\t`s0",expr, new Temp()));
			}
			
			emit(OPER("jal " + ((TEMP) visit(n.func)).label.toString(), n.args(), )));
		}
		// CALL(*,*) ==> jalr Rs
		else {
			emit(OPER());
		}
		
		return new Temp();
	}

}
