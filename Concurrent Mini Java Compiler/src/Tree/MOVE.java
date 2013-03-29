package Tree;


public class MOVE extends Stm implements Hospitable {

	public Exp dst, src;

	public MOVE(Exp d, Exp s) {
		dst = d;
		src = s;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
}
