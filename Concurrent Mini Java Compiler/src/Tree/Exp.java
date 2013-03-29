package Tree;


public class Exp implements Hospitable {

	public Exp() {
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
}
