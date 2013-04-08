package Tree;

import java.util.LinkedList;

public class CALL extends Exp implements Hospitable {

	public Exp func;
	public LinkedList<Exp> args;

	public CALL(Exp f, LinkedList<Exp> a) {
		func = f;
		args = a;
	}

	// public List<Exp> kids() {
	// return new LinkedList<Exp>(func,args);
	// }

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}

	public LinkedList<Exp> kids() {
		LinkedList<Exp> kids = new LinkedList<Exp>();
		kids.add(func);
		kids.addAll(args);
		return kids;
	}

	public Exp build(LinkedList<Exp> kids) {
		return new CALL(kids.remove(), kids);
	}
}
