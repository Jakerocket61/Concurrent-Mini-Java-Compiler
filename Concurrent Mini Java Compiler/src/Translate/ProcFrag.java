package Translate;

import Mips.MipsFrame;

public class ProcFrag extends Frag {

	public MipsFrame frame;
	public Tree.Stm body;
	
	public ProcFrag(Tree.Stm body, MipsFrame frame) {
		this.body = body;
		this.frame = frame;
	}
}
