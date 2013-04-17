package Tree;

import Temp.Label;

public class CJUMP extends Stm implements Hospitable {

	public int relop;
	public Exp left, right;
	public Label iftrue, iffalse;
	public final static int EQ = 0, GE = 1, GT = 2, LE = 3, LT = 4, NE = 5,
			UGE = 6, UGT = 7, ULE = 8, ULT = 9;

	public static int notRel(int relop) {
		switch (relop) {
		case EQ:
			return NE;
		case NE:
			return EQ;
		case LT:
			return GE;
		case GE:
			return LT;
		case GT:
			return LE;
		case LE:
			return GT;
		case ULT:
			return UGE;
		case UGE:
			return ULT;
		case UGT:
			return ULE;
		case ULE:
			return UGT;
		default:
			throw new Error("bad relop in CJUMP.notRel");
		}
	}

	public CJUMP(int rel, Exp l, Exp r, Label t, Label f) {
		relop = rel;
		left = l;
		right = r;
		iftrue = t;
		iffalse = f;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
	
	public void accept(CodeVisitor v){
		v.visit(this);
	}
}
