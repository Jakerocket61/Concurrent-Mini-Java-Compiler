package Frame;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import Assem.Instr;
import Temp.Label;
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

	public static Label badPtr() {
		
		return null;
	}
	
	public static Label badSub() {
		
		return null;
	}

	public List<Instr> codeGen(List<Stm> traced) {
		
		return null;
	}

	public void printFrame(PrintWriter writer) {
		
		
	}

}
