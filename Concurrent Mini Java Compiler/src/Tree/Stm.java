package Tree;

import java.util.LinkedList;


public abstract class Stm implements Hospitable {

	public LinkedList<Stm> kids() {
		return new LinkedList<Stm>();
	}
	// abstract public LinkedList<Exp> kids();
	// abstract public Stm build(LinkedList<Exp> kids);

	public Stm build(LinkedList<Stm> exps) {
		throw new Error("Tree.Stm is abstract, so build() does not apply");
		//return null;
	}

	public void accept(CodeVisitor v) {
		v.visit(this);
		
	}

	// public void accept(IntVisitor v, int d) {
	// v.visit(this, d);
	// }
}
