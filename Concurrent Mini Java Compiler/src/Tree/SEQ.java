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
	
	public LinkedList<Stm> kids() {	
		LinkedList<Stm> kids = new LinkedList<Stm>();
		kids.add(left);
		kids.add(right);
		return kids;
	}

	public Stm build(LinkedList<Stm> kids) {
		return new SEQ(kids.getFirst(), kids.getLast());
	}
}
