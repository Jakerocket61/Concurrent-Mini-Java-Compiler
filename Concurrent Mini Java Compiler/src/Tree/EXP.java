package Tree;

import java.util.LinkedList;


public class EXP extends Stm implements Hospitable {

	public Exp exp;
	
	public EXP(Exp e) {
		exp = e;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
	
	public LinkedList<Exp> kids() {
		return new LinkedList<Exp>();
	}

	public Stm build(LinkedList<Exp> exps) {
		return null;
	}
	
	public void accept(CodeVisitor v){
		v.visit(this);
	}
}
