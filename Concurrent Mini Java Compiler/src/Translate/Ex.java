package Translate;

import Temp.Label;

public class Ex extends Exp {

	Tree.Exp exp;

	public Ex(Tree.Exp e) {
		exp = e;
	}

	Tree.Stm unCx(Label t, Label f) {
		if (exp instanceof Tree.BINOP)
			return this.unCx((Tree.BINOP) exp, t, f);
		if (exp instanceof Tree.CALL)
			return this.unCx((Tree.CALL) exp, t, f);
		if (exp instanceof Tree.CONST)
			return this.unCx((Tree.CONST) exp, t, f);
		if (exp instanceof Tree.MEM)
			return this.unCx((Tree.MEM) exp, t, f);
		if (exp instanceof Tree.NAME)
			return this.unCx((Tree.NAME) exp, t, f);
		if (exp instanceof Tree.TEMP)
			return this.unCx((Tree.TEMP) exp, t, f);

		return null;
	}

	Tree.Stm unCx(Tree.BINOP exp, Label t, Label f) {
		return null;
	}

	Tree.Stm unCx(Tree.CALL exp, Label t, Label f) {
		return null;
	}

	Tree.Stm unCx(Tree.CONST exp, Label t, Label f) {
		return null;
	}

	Tree.Stm unCx(Tree.MEM exp, Label t, Label f) {
		return null;
	}

	Tree.Stm unCx(Tree.NAME exp, Label t, Label f) {
		return null;
	}

	Tree.Stm unCx(Tree.TEMP exp, Label t, Label f) {
		return null;
	}

	Tree.Exp unEx() {
		return exp;
	}

	Tree.Stm unNx() {
		return new Tree.EXP(exp);
	}

}
