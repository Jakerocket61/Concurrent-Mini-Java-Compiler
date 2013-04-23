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
	
	public void accept(CodeVisitor v){
		v.visit(this);
	}
	
	public LinkedList<Stm> kids() {
		LinkedList<Stm> kids = new LinkedList<Stm>();
		kids.add(new EXP(exp));
		return kids;
	}

	public Stm build(LinkedList<Stm> exps) {
		return new EXP(((Tree.EXP)exps.removeFirst()).exp);
	}
}
