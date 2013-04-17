package Mips;

public class InFrame extends Frame.Access {
	public Temp.Temp t;
	public InFrame(Temp.Temp t){
		this.t = t;
	}
	
	public InFrame(int i){
		this.t = new Temp.Temp(i);
	}

	public Tree.Exp exp(Tree.Exp framePtr){
		return null;
	}
}
