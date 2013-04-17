package Tree;

import java.util.LinkedList;

public class ESEQ extends Exp implements Hospitable {

	public Stm stm;
	public Exp exp;

	public ESEQ(Stm s, Exp e) {
		stm = s;
		exp = e;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}

	public LinkedList<Exp> kids() {
		throw new Error("kids() not applicable to ESEQ");
	}
	
	public Temp.Temp accept(CodeVisitor v){
		return v.visit(this);
	}
}
