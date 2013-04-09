package Tree;

import java.util.LinkedList;


public abstract class Stm implements Hospitable {

	public LinkedList<Stm> kids() {
		return null;
	}
	// abstract public LinkedList<Exp> kids();
	// abstract public Stm build(LinkedList<Exp> kids);

	public Stm build(LinkedList<Stm> exps) {
		return null;
	}

	// public void accept(IntVisitor v, int d) {
	// v.visit(this, d);
	// }
}
