package Mips;

import java.util.LinkedList;

import Temp.Label;
import Tree.Stm;

public class MipsFrame extends Frame.Frame {
	
	public Temp.Label name;
	public LinkedList<Frame.Access> formals;
	public LinkedList<Frame.Access> actuals;
	public int argc;
	
	private final Temp.Temp ZERO = new Temp.Temp();

	private static Temp.Temp registers[] = {new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp()	
												};
	public static Temp.Temp[]	calleeSaves = {	new Temp.Temp(31),new Temp.Temp(4),new Temp.Temp(5),new Temp.Temp(6),
						new Temp.Temp(7),new Temp.Temp(8),new Temp.Temp(9),new Temp.Temp(1),
						new Temp.Temp(11),new Temp.Temp(12),new Temp.Temp(13),new Temp.Temp(14),
						new Temp.Temp(15),new Temp.Temp(24),new Temp.Temp(25),new Temp.Temp(2),
						new Temp.Temp(3)
						};
	
	public Temp.Temp[] getArgumentRegisters(int numberOfArguments) {
		switch(numberOfArguments) {
			case 1:
				Temp.Temp[] arguments1 = { new Temp.Temp(4) };
				return arguments1;
			case 2:
				Temp.Temp[] arguments2 = { new Temp.Temp(4), new Temp.Temp(5) };
				return arguments2;
			case 3:		
				Temp.Temp[] arguments3 = { new Temp.Temp(4), new Temp.Temp(5), new Temp.Temp(6) };
				return arguments3;
			case 4:
				Temp.Temp[] arguments4 = { new Temp.Temp(4), new Temp.Temp(5), new Temp.Temp(6), new Temp.Temp(7) };
				return arguments4;
			default:
				break;
		}

		return null;
	}
	
	public MipsFrame() {
		this.name = null;
		this.formals = new LinkedList<Frame.Access>();
		this.actuals = new LinkedList<Frame.Access>();

		this.argc = 0;
	}

	public MipsFrame(Temp.Label name, LinkedList<Boolean> formals) {
		this.name = name;
		this.formals = new LinkedList<Frame.Access>();
		this.actuals = new LinkedList<Frame.Access>();

		this.argc = 0;
		for(boolean b : formals) {

			allocFormal(b);
			
		}
	}

	public static void initRegs(){
		for(int i = 0; i < 32; i++){
			new Temp.Temp();
		}
	}

	public Frame.Access allocFormal(boolean escape){
		if(escape){
			formals.add(new InFrame(new Temp.Temp()));
		}
		else{
			formals.add(new InReg(new Temp.Temp()));
		}

		if(this.argc < 4){
			this.argc = this.argc + 1;
			actuals.add(new InReg(new Temp.Temp(this.argc + 4)));
		}
		else{
			this.argc = this.argc + 1;
			actuals.add(new InFrame(new Temp.Temp(this.argc + 4)));
		}
		
		return actuals.getLast();
	}

	public Frame.Access allocLocal(boolean escape){
		if(escape){
			formals.add(new InFrame(new Temp.Temp()));
		}
		else{
			formals.add(new InReg(new Temp.Temp()));
		}
		
		return formals.getLast();
	}

	@Override
	public Frame.Frame newFrame(Label name, LinkedList<Boolean> formals) {
		
		return null;
	}

	public Frame.Frame newFrame(Label name) {
		
		return null;
	}

	@Override
	public Stm procEntryExit1(Stm body) {
		// TODO Auto-generated method stub
		return null;
	}
}
