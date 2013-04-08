package Tree;

public class EXP extends Stm implements Hospitable {

	public Exp exp;
	
	public EXP(Tree.Exp exp) {
		this.exp = exp;
	}

	@Override
	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}

}
