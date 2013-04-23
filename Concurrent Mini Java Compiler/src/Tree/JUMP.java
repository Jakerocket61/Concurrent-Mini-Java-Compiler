package Tree;

import java.util.LinkedList;

import Temp.Label;

public class JUMP extends Stm implements Hospitable {

	public Exp exp;
	public LinkedList<Label> targets;

	public JUMP(Exp e, LinkedList<Label> t) {
		exp = e;
		targets = t;
	}

	public JUMP(Label target) {
		this(new NAME(target), /* new LinkedList<Label>().add(target) */null);
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
