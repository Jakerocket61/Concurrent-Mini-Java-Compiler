package Tree;

import Temp.Label;

public class LABEL extends Stm implements Hospitable {

	public Label label;

	public LABEL(Label l) {
		label = l;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
	
	public void accept(CodeVisitor v){
		v.visit(this);
	}
}
