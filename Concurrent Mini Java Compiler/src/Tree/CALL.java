package Tree;

import java.util.List;

public class CALL extends Exp implements Hospitable {

	public Exp func;
	public List<Exp> args;

	public CALL(Exp f, List<Exp> a) {
		func = f;
		args = a;
	}

	// public List<Exp> kids() {
	// return new LinkedList<Exp>(func,args);
	// }

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
}
