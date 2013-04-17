package Mips;

import java.util.LinkedList;
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
import Tree.Exp;
import Tree.JUMP;
import Tree.LABEL;
import Tree.MEM;
import Tree.MOVE;
import Tree.NAME;
import Tree.SEQ;
import Tree.Stm;
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
		emit(new Assem.LABEL(n.label.name + ":\t", n.label));
	}

	@Override
	public void visit(JUMP n) {
		// OPER("	jal	_print" defs(t31 t4 t5 t6 t7 t8 t9 t10 t11 t12 t13 t14 t15
		// t24 t25 t2 t3 ) uses(t4 ))
		// TODO fix this!!
		if (n.exp instanceof NAME) {
			emit(OPER("b	'j0", new Temp[] { n.exp.accept(this) }, null));
		} else {
			emit(OPER("jr	'j0", new Temp[] { n.exp.accept(this) }, null));
		}
	}

	@Override
	public void visit(CJUMP n) {
		// CJUMP(op,*,*,label,*)

		String operation = "";
		Temp dest = null, source = null;

		switch (n.relop) {
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

		if (n.left instanceof CONST) {
			if (((CONST) n.left).value == 0) {
				dest = MipsFrame.zeroReg;
				source = new Temp();
			}
		} else if (n.right instanceof CONST) {
			if (((CONST) n.right).value == 0) {
				source = MipsFrame.zeroReg;
				dest = new Temp();
			}
		} else {
			dest = n.left.accept(this);
			source = n.right.accept(this);
		}
		LinkedList<Label> labels = new LinkedList<Label>();
		labels.add(n.iftrue);
		labels.add(n.iffalse);
		emit(OPER(operation + "	`s0,	`s1,	`j0", new Temp[] { dest },
				new Temp[] { source }, labels));

	}

	@Override
	public void visit(MOVE n) {
		// MOVE(MEM(+(*,CONST_16)),*) OR MOVE(MEM(+(CONST_16,*)),*) ==>
		// OPER(" sw    Rs,   I_16(Rd) ")
		/*
		 * if((n.d instanceof Tree.MEM && ((Tree.MEM) n.d).exp instanceof
		 * Tree.BINOP && ((Tree.MEM) n.d).exp.binop == Tree.BINOP.ADD) {
		 * emit(new OPER("sw", visit(n.s), visit(n.d))); } else if (n.s
		 * instanceof Tree.MEM && ((Tree.MEM) n.s).exp instanceof Tree.BINOP &&
		 * ((Tree.MEM) n.s).exp.binop == Tree.BINOP.ADD)) { emit(new OPER("sw",
		 * visit(n.s), visit(n.d))); }
		 * munchStm(MOVE(MEM(BINOP(PLUS,e1,CONST(i))),e2)) emit(new
		 * OPER("STORE M[�s0+" + i + "] <- �s1\n", null, L(munchExp(e1),
		 * L(munchExp(e2), null))));
		 * munchStm(MOVE(MEM(BINOP(PLUS,CONST(i),e1)),e2)) emit(new
		 * OPER("STORE M[�s0+" + i + "] <- �s1\n", null, L(munchExp(e1),
		 * L(munchExp(e2), null))));
		 * 
		 * 
		 * 
		 * //MOVE(MEM(*),*) else if() {
		 * 
		 * } //MOVE(*,*) else { emit(MOVE("move	`d0,\t`s0", n.dst(), n.src()); }
		 */

		if (n.dst instanceof MEM) {

			Temp retT = new Temp();

			if (((MEM) n.dst).exp instanceof BINOP
					&& ((BINOP) ((MEM) n.dst).exp).binop == BINOP.PLUS) {

				Temp l = (((BINOP) ((MEM) n.dst).exp)).left.accept(this);
				Temp r = (((BINOP) ((MEM) n.dst).exp)).right.accept(this);
				Temp[] src = { l, r };
				if ((((BINOP) ((MEM) n.dst).exp).left instanceof CONST && CONST16(((CONST) ((BINOP) ((MEM) n.dst).exp).left)))) {
					emit(OPER("sw	'd0,	"
							+ ((CONST) ((BINOP) ((MEM) n.dst).exp).left).value
							+ "('s0)", src, new Temp[] { retT }));

				} else if ((((BINOP) ((MEM) n.dst).exp).right instanceof CONST && CONST16(((CONST) ((BINOP) ((MEM) n.dst).exp).right)))) {
					emit(OPER("sw	'd0,	"
							+ ((CONST) ((BINOP) ((MEM) n.dst).exp).right).value
							+ "('s0)", src, new Temp[] { retT }));
				}
			} else {
				emit(OPER("sw	'd0,	0('Rs)",
						new Temp[] { ((MEM) n.dst).exp.accept(this) },
						new Temp[] { retT }));
			}
		} else {
			emit(OPER("move	'd0,	0('Rs)",
					new Temp[] { ((MEM) n.dst).exp.accept(this) },
					new Temp[] { ((MEM) n.src).exp.accept(this) }));
		}
	}

	@Override
	public void visit(EXP n) {
		n.exp.accept(this);

	}

	public static int CONST_k2(CONST c) {	
		int remainder = 0;
		
		int number = c.value;
		int count = 0;
		while (number > 1) {
			remainder = number % 2;
			if (remainder != 0) {
				return -1;
			} else {
				number = number / 2;
				count++;
			}
		}

		return count;
	}

	@Override
	public Temp visit(BINOP n) {
		Temp retT = new Temp();

		switch (n.binop) {

		case BINOP.ADD:
			if (n.left instanceof CONST) {
				emit(OPER("addi	'd0	's0	" + ((CONST) n.left).value,
						new Temp[] { retT },
						new Temp[] { n.right.accept(this) }));
			} else if (n.right instanceof CONST) {
				emit(OPER("addi	'd0	's0	" + ((CONST) n.right).value,
						new Temp[] { retT }, new Temp[] { n.left.accept(this) }));
			} else {
				emit(OPER("addi	'd0	's0	's1", new Temp[] { retT }, new Temp[] {
						n.left.accept(this), n.right.accept(this) }));
			}

			break;

		case BINOP.MINUS:
			if (n.right instanceof CONST) {
				emit(OPER("addi	'd0	's0	" + ((CONST) n.right).value,
						new Temp[] { retT }, new Temp[] { n.left.accept(this) }));
			} else {
				emit(OPER("sub	'd0	's0	's1", new Temp[] { retT }, new Temp[] {
						n.left.accept(this), n.right.accept(this) }));
			}
			break;

		case BINOP.MUL:
			if (n.left instanceof CONST) {
				int k = CONST_k2(((CONST)n.left));
				emit(OPER("sll	'd0	's0	" + k,
						new Temp[] { retT },
						new Temp[] { n.right.accept(this) }));
			} else if (n.right instanceof CONST) {
				int k = CONST_k2(((CONST)n.right));
				emit(OPER("sll	'd0	's0	" + k,
						new Temp[] { retT }, new Temp[] { n.left.accept(this) }));
			} else {
				emit(OPER("mulo	'd0	's0	's1", new Temp[] { retT }, new Temp[] {
						n.left.accept(this), n.right.accept(this) }));
			}

			break;

		case BINOP.DIV:
			
			if (n.right instanceof CONST) {
				int k = CONST_k2(((CONST)n.right));
				emit(OPER("sra	'd0	's0	" + k,
						new Temp[] { retT }, new Temp[] { n.left.accept(this) }));
			} else {
				emit(OPER("div	'd0	's0	's1", new Temp[] { retT }, new Temp[] {
						n.left.accept(this), n.right.accept(this) }));
			}
			
			break;

		case BINOP.AND:
			
			if (n.left instanceof CONST) {
				emit(OPER("andi	'd0	's0	" + ((CONST) n.left).value,
						new Temp[] { retT },
						new Temp[] { n.right.accept(this) }));
			} else if (n.right instanceof CONST) {
				emit(OPER("andi	'd0	's0	" + ((CONST) n.right).value,
						new Temp[] { retT }, 
						new Temp[] { n.left.accept(this) }));
			} else {
				emit(OPER("and	'd0	's0	's1", new Temp[] { retT }, new Temp[] {
						n.left.accept(this), n.right.accept(this) }));
			}
			
			break;

		case BINOP.OR:
			
			if (n.left instanceof CONST) {
				emit(OPER("ori	'd0	's0	" + ((CONST) n.left).value,
						new Temp[] { retT },
						new Temp[] { n.right.accept(this) }));
			} else if (n.right instanceof CONST) {
				emit(OPER("ori	'd0	's0	" + ((CONST) n.right).value,
						new Temp[] { retT }, 
						new Temp[] { n.left.accept(this) }));
			} else {
				emit(OPER("or	'd0	's0	's1", new Temp[] { retT }, new Temp[] {
						n.left.accept(this), n.right.accept(this) }));
			}
			
			break;

		case BINOP.LSHIFT:
			if (n.right instanceof CONST) {
				emit(OPER("sllv	'd0	's0	" + ((CONST) n.right).value,
						new Temp[] { retT }, new Temp[] { n.left.accept(this) }));
			} else {
				emit(OPER("sll	'd0	's0	's1", new Temp[] { retT }, new Temp[] {
						n.left.accept(this), n.right.accept(this) }));
			}
			break;

		case BINOP.RSHIFT:
			if (n.right instanceof CONST) {
				emit(OPER("srlv	'd0	's0	" + ((CONST) n.right).value,
						new Temp[] { retT }, new Temp[] { n.left.accept(this) }));
			} else {
				emit(OPER("srl	'd0	's0	's1", new Temp[] { retT }, new Temp[] {
						n.left.accept(this), n.right.accept(this) }));
			}
			break;

		case BINOP.ARSHIFT:
			if (n.right instanceof CONST) {
				emit(OPER("srav	'd0	's0	" + ((CONST) n.right).value,
						new Temp[] { retT }, new Temp[] { n.left.accept(this) }));
			} else {
				emit(OPER("sra	'd0	's0	's1", new Temp[] { retT }, new Temp[] {
						n.left.accept(this), n.right.accept(this) }));
			}
			break;

		case BINOP.BITXOR:
			
			if (n.left instanceof CONST) {
				emit(OPER("xori	'd0	's0	" + ((CONST) n.left).value,
						new Temp[] { retT },
						new Temp[] { n.right.accept(this) }));
			} else if (n.right instanceof CONST) {
				emit(OPER("xori	'd0	's0	" + ((CONST) n.right).value,
						new Temp[] { retT }, 
						new Temp[] { n.left.accept(this) }));
			} else {
				emit(OPER("xor	'd0	's0	's1", new Temp[] { retT }, new Temp[] {
						n.left.accept(this), n.right.accept(this) }));
			}
			
			break;

		}

		return retT;
	}

	@Override
	public Temp visit(MEM n) {
		Temp retT = new Temp();

		if (n.exp instanceof BINOP && ((BINOP) n.exp).binop == BINOP.PLUS) {

			Temp l = ((BINOP) n.exp).left.accept(this);
			Temp r = ((BINOP) n.exp).right.accept(this);
			Temp[] src = { l, r };
			if ((((BINOP) n.exp).left instanceof CONST && CONST16(((CONST) ((BINOP) n.exp).left)))) {
				emit(OPER("lw	'd0,	" + ((CONST) ((BINOP) n.exp).left).value
						+ "('s0)", src, new Temp[] { retT }));

			} else if ((((BINOP) n.exp).right instanceof CONST && CONST16(((CONST) ((BINOP) n.exp).right)))) {
				emit(OPER("lw	'd0,	" + ((CONST) ((BINOP) n.exp).right).value
						+ "('s0)", src, new Temp[] { retT }));
			}
		} else {
			emit(OPER("lw	'd0,	0('Rs)", new Temp[] { n.exp.accept(this) },
					new Temp[] { retT }));
		}

		return retT;
	}

	@Override
	public Temp visit(TEMP n) {
		// TEMP ==> t_n
		return n.temp;
	}

	@Override
	public Temp visit(ESEQ n) {
		n.stm.accept(this);
		return n.exp.accept(this);
	}

	@Override
	public Temp visit(NAME n) {
		Temp dest = new Temp();
		// NAME ==> la Rd, label (n.label)
		emit(OPER("la\t'd0" + n.label, new Temp[] { dest }, null));

		return dest;
	}

	@Override
	public Temp visit(CONST n) {
		// CONST(*) ==> li Rd, *
		Temp t = new Temp();
		if (n.value == 0) {
			return MipsFrame.zeroReg;
		} else if (CONST16(n)) {
			emit(OPER("addi	'Rd,	'zero	16", new Temp[] { MipsFrame.zeroReg },
					new Temp[] { t }));
		} else {
			emit(OPER("li\t'Rd	" + n.value, null, new Temp[] { t }));
		}
		return t;
	}

	@Override
	public Temp visit(CALL n) {
		// CALL(*,*) ==> jal label

		Temp[] arg = new Temp[n.args.size() + 17];
		Temp[] src = new Temp[n.args.size() + 17];
		int a = 0;
		for (Exp expr : n.args) {
			if (a < 4) {
				arg[a] = MipsFrame.registers[a + 4];
			} else {
				arg[a] = new Temp();
			}
			src[a] = expr.accept(this);
			++a;
		}
		/*
		 * emit(OPER("move	`d0,\t`s0", expr.accept(this), new Temp())); if
		 * (n.args.size() > 0) { for (Exp expr : n.args) {
		 * emit(MOVE("move	`d0,\t`s0", expr, new Temp())); }
		 * 
		 * emit(OPER("jal " + ((TEMP) visit(n.func)).label.toString(), n.args(),
		 * null, null)); } // CALL(*,*) ==> jalr Rs else { emit(OPER()); }
		 */

		emit(OPER("move 'd0	's0", src, arg));
		emit(OPER("jal '" + n.func.accept(this), null, null));

		return new Temp(2);
	}

	@Override
	public Temp visit(Exp n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visit(Stm stm) {
		// TODO Auto-generated method stub
		
	}

}
