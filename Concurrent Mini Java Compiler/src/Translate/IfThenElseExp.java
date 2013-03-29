package Translate;

import Temp.Label;

public class IfThenElseExp extends Exp {

	Exp cond, a, b;
	Label t = new Label();
	Label f = new Label();
	Label join = new Label();

	public IfThenElseExp(Exp cc, Exp aa, Exp bb) {
		cond = cc;
		a = aa;
		b = bb;
	}

	Tree.Stm unCx(Label tt, Label ff) {

		Tree.Stm aStatement = a.unCx(tt, ff);
		Tree.Stm bStatement = b.unCx(tt, ff);

		// If the statements are JUMPS, get these labels and store them as t/f
		if (aStatement instanceof Tree.JUMP) {
			Tree.JUMP temp = (Tree.JUMP) aStatement;
			// If the temp.Exp is a NAME...it is a label we are jumping to and
			// will jump to it
			if (temp.exp instanceof Tree.NAME) {
				Tree.NAME nameA = (Tree.NAME) temp.exp;
				t = nameA.label;
				aStatement = null;
			}
		}
		if (bStatement instanceof Tree.JUMP) {
			Tree.JUMP temp = (Tree.JUMP) aStatement;

			if (temp.exp instanceof Tree.NAME) {
				Tree.NAME nameB = (Tree.NAME) temp.exp;
				f = nameB.label;
				bStatement = null;
			}
		}

		Tree.Stm conditional = cond.unCx(t, f);

		if (aStatement == null && bStatement == null) {
			return conditional;
		} else if (aStatement == null) {
			return new Tree.SEQ(conditional, new Tree.SEQ(new Tree.LABEL(f),
					bStatement));
		} else if (bStatement == null) {
			return new Tree.SEQ(conditional, new Tree.SEQ(new Tree.LABEL(t),
					aStatement));
		} else
			return new Tree.SEQ(conditional, new Tree.SEQ(new Tree.SEQ(
					new Tree.LABEL(t), aStatement), new Tree.SEQ(
					new Tree.LABEL(f), bStatement)));

	}

	Tree.Exp unEx() {
		Tree.Exp aExpression = a.unEx();
		Tree.Exp bExpression = b.unEx();
		Temp.Temp r = new Temp.Temp();

		if (aExpression == null)
			return null;
		if (bExpression == null)
			return null;

		return new Tree.ESEQ(new Tree.SEQ(new Tree.SEQ(cond.unCx(t, f),
				new Tree.SEQ(new Tree.SEQ(new Tree.LABEL(t), new Tree.SEQ(
						new Tree.MOVE(new Tree.TEMP(r), aExpression),
						new Tree.JUMP(join))), new Tree.SEQ(new Tree.LABEL(f),
						new Tree.SEQ(new Tree.MOVE(new Tree.TEMP(r),
								bExpression), new Tree.JUMP(join))))),
				new Tree.LABEL(join)), new Tree.TEMP(r));
	}

	Tree.Stm unNx() {
		Tree.Stm aStatement = a.unNx();
		Tree.Stm bStatement = b.unNx();

		if (aStatement == null)
			t = join;
		else
			aStatement = new Tree.SEQ(new Tree.SEQ(new Tree.LABEL(t),
					aStatement), new Tree.JUMP(join));
		if (bStatement == null)
			f = join;
		else
			bStatement = new Tree.SEQ(new Tree.SEQ(new Tree.LABEL(f),
					bStatement), new Tree.JUMP(join));

		if (aStatement == null && bStatement == null)
			return cond.unNx();

		Tree.Stm conditional = cond.unCx(t, f);

		if (aStatement == null)
			return new Tree.SEQ(new Tree.SEQ(conditional, bStatement),
					new Tree.LABEL(join));

		if (bStatement == null)
			return new Tree.SEQ(new Tree.SEQ(conditional, aStatement),
					new Tree.LABEL(join));

		return new Tree.SEQ(new Tree.SEQ(conditional, new Tree.SEQ(aStatement,
				bStatement)), new Tree.LABEL(join));
	}
}
