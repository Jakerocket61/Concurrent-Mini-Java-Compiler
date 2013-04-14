package Translate;

import Temp.Label;
import Tree.CJUMP;
import Tree.LABEL;
import Tree.Stm;

public class RelCx extends Cx {

	int op;
	Tree.Exp left, right;

	RelCx(int operation, Tree.Exp l, Tree.Exp r) {
		op = operation;
		left = l;
		right = r;
	}

	public RelCx(CJUMP cjump) {
		// TODO Auto-generated constructor stub
	}

	Tree.Stm unCx(Label t, Label f) {
		return new Tree.CJUMP(op, left, right, t, f);
	}

	@Override
	Stm unCx(LABEL t, LABEL f) {
		// TODO Auto-generated method stub
		return null;
	}

}
