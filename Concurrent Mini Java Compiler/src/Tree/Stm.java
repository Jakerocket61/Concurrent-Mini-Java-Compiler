package Tree;

import java.util.LinkedList;


public abstract class Stm implements Hospitable {

	public LinkedList<Exp> kids() {
		return new LinkedList<Exp>();
	}
	// abstract public LinkedList<Exp> kids();
	// abstract public Stm build(LinkedList<Exp> kids);

	public Stm build(LinkedList<Exp> exps) {
		return null;
	}

	public void accept(CodeVisitor v) {
		v.visit(this);
		
	}

	// public void accept(IntVisitor v, int d) {
	// v.visit(this, d);
	// }
}
