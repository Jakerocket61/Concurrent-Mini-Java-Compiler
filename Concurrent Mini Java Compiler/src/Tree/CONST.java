package Tree;

import java.util.LinkedList;

public class CONST extends Exp implements Hospitable {

	public int value;

	public CONST(int v) {
		value = v;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}

	public LinkedList<Exp> kids() {
		return null;
	}
	
	public Temp.Temp accept(CodeVisitor v){
		return v.visit(this);
	}
}
