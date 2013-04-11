package Tree;

import java.util.LinkedList;


public class SEQ extends Stm implements Hospitable {

	public Stm left, right;

	public SEQ(Stm l, Stm r) {
		left = l;
		right = r;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
	
	public LinkedList<Exp> kids() {	
		throw new Error("kids() not applicable to SEQ");
	}

	public Stm build(LinkedList<Exp> kids) {
		throw new Error("build() not applicable to SEQ");
	}
}
