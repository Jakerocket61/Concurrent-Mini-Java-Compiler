package Tree;


public class MEM extends Exp implements Hospitable {

	public Exp exp;

	public MEM(Exp e) {
		exp = e;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
}
