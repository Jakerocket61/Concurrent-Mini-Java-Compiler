package Frame;

import java.util.LinkedList;
import java.util.List;

import Tree.Stm;

public abstract class Frame {

	public Temp.Label name;
	public LinkedList<Access> formals;

	public Access allocFormal() {
		return new Mips.InReg(new Temp.Temp());
	}

	public abstract Access allocLocal(boolean escape);

	public abstract Frame newFrame(Temp.Label name, LinkedList<Boolean> formals);

	public void procEntryExit1(List<Stm> traced) {
		// TODO Auto-generated method stub
		
	}
	
	abstract public Tree.Stm procEntryExit1(Tree.Stm body);

}
