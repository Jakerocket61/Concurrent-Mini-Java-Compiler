package Translate;

abstract class Cx extends Exp {

	abstract Tree.Stm unCx(Tree.LABEL t, Tree.LABEL f);

	Tree.Exp unEx() {
		Temp.Temp r = new Temp.Temp();
		Temp.Label t = new Temp.Label();
		Temp.Label f = new Temp.Label();

		return new Tree.ESEQ(new Tree.SEQ(new Tree.MOVE(new Tree.TEMP(r),
				new Tree.CONST(1)), new Tree.SEQ(unCx(t, f), new Tree.SEQ(
				new Tree.LABEL(f), new Tree.SEQ(new Tree.MOVE(new Tree.TEMP(r),
						new Tree.CONST(0)), new Tree.LABEL(t))))),
				new Tree.TEMP(r));
	}

	Tree.Stm unNx() {
		return null;
	}
}
