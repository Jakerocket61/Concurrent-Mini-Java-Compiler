package Translate;

public class Nx extends Exp {

	Tree.Stm stm;

	public Nx(Tree.Stm s) {
		stm = s;
	}

	Tree.Stm unCx(Temp.Label t, Temp.Label f) {
		return null;
	}

	Tree.Exp unEx() {
		return null;
	}

	Tree.Stm unNx() {
		return stm;
	}

}
