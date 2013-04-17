package Tree;

import java.util.LinkedList;


public class BINOP extends Exp implements Hospitable {

	public int binop;
	public Exp left, right;
	public final static int AND = 0, ARSHIFT = 1, BITAND = 2, BITOR = 3,
			XOR = 4, DIV = 5, LSHIFT = 6, MINUS = 7, MUL = 8, OR = 9,
			PLUS = 10, RSHIFT = 11, ADD = 10, BITXOR = 4;

	public BINOP(int b, Tree.Exp exp, Tree.Exp exp2) {
		binop = b;
		left = exp;
		right = exp2;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
	
	public LinkedList<Exp> kids() {	
		LinkedList<Exp> kids = new LinkedList<Exp>();
		kids.add(left);
		kids.add(right);
		return kids;
	}

	public Exp build(LinkedList<Exp> kids) {
		return new BINOP(binop, kids.getFirst(), kids.getLast());
	}
}

