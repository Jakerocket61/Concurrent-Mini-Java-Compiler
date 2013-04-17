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
		LinkedList<Exp> kids = new LinkedList<Exp>();
		if (dst instanceof MEM){
			kids.add(((MEM)dst).exp); 
			kids.add(src);
		}
		else 
			kids.add(src);
		return kids;
	}

	public Stm build(LinkedList<Exp> kids) {
		if (dst instanceof MEM)
			return new MOVE(new MEM(kids.getFirst()), kids.get(1));
		else 
			return new MOVE(dst, kids.getFirst());
	}
	
	public void accept(CodeVisitor v){
		v.visit(this);
	}
}
