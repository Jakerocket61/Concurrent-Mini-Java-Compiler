package Tree;

import java.util.LinkedList;


public class Exp implements Hospitable {

	public Exp() {
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
	
	public LinkedList<Exp> kids() {
		return new LinkedList<Exp>();
	}

	public Exp build(LinkedList<Exp> exps) {
		return new Tree.Exp();
	}
	
	public Temp.Temp accept(CodeVisitor v){
		return v.visit(this);
	}
}
