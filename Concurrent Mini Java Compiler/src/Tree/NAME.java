package Tree;

import Temp.Label;

public class NAME extends Exp implements Hospitable {

	public Label label;

	public NAME(Label l) {
		label = l;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
}
