package Tree;

import java.util.LinkedList;


public class MOVE extends Stm implements Hospitable {

	public Exp dst, src;

	public MOVE(Exp d, Exp s) {
		dst = d;
		src = s;
	}

	public void accept(IntVisitor v, int d) {
		v.visit(this, d);
	}
	
	public LinkedList<Exp> kids() {	
		
		kids.add(dst);
		kids.add(src);
		return kids;
		
		LinkedList<Exp> kids = new LinkedList<Exp>();
		
		if (dst instanceof MEM)
		{
			
		}
	}

	public Exp build(LinkedList<Exp> kids) {
		return new BINOP(binop, kids.getFirst(), kids.getLast());
	}
}
