package Mips;

import java.util.LinkedList;

import Temp.Label;
import Tree.Stm;

public class MipsFrame extends Frame.Frame {
	
	public Temp.Label name;
	public LinkedList<Frame.Access> formals;
	public LinkedList<Frame.Access> actuals;
	public int argc;
	
	public static Temp.Temp registers[] = {new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),
											new Temp.Temp(),new Temp.Temp(),new Temp.Temp(),new Temp.Temp()
											};

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

	@Override
	public Stm procEntryExit1(Stm body) {
		// TODO Auto-generated method stub
		return null;
	}
}
