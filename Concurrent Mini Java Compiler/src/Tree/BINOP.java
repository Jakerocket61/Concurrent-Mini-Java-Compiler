package Tree;


public class BINOP extends Exp implements Hospitable {

	public int binop;
	public Exp left, right;
	public final static int AND = 0, ARSHIFT = 1, BITAND = 2, BITOR = 3,
			BITXOR = 4, DIV = 5, LSHIFT = 6, MINUS = 7, MUL = 8, OR = 9,
			PLUS = 10, RSHIFT = 11;

	public BINOP(int b, Exp l, Exp r) {
		binop = b;
		left = l;
		right = r;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
}
