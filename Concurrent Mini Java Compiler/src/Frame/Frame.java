package Frame;

import java.util.List;

import javax.rmi.CORBA.Util;

public abstract class Frame {

	public Label name;
	public List<Access> formals;

	public Access allocFormal() {
		return new Mips.InReg(new Temp.Temp());
	}

	public Access allocFormal() {
		return new Mips.InReg(new Temp.Temp());
	}

	public abstract Access allocLocal(boolean escape);

	public abstract Frame newFrame(Temp.Label name, Util.BoolList formals);

}
