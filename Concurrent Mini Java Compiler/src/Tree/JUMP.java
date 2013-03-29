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
}
