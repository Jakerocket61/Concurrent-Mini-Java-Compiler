package Mips;

public class InReg extends Frame.Access {
	public Temp.Temp t;
	public InReg(Temp.Temp t){
		this.t = t;
	}

	public Tree.Exp exp(Tree.Exp framePtr){
		return null;
	}
}
