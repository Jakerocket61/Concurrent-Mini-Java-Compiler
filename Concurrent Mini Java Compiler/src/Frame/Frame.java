package Frame;

import java.util.LinkedList;

import javax.rmi.CORBA.Util;

public abstract class Frame {

	public Temp.Label name;
	public LinkedList<Access> formals;

	public Access allocFormal() {
		return new Mips.InReg(new Temp.Temp());
	}

	public abstract Access allocLocal(boolean escape);

	public abstract Frame newFrame(Temp.Label name, LinkedList<Boolean> formals);

}
