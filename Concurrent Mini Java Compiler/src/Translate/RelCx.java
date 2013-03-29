package Translate;

public class RelCx extends Cx {

	int op;
	Tree.Exp left, right;

	RelCx(int operation, Tree.Exp l, Tree.Exp r) {
		op = operation;
		left = l;
		right = r;
	}

	Tree.Stm unCx(Label t, Label f) {
		return new Tree.CJUMP(op, left, right, t, f);
	}
}
