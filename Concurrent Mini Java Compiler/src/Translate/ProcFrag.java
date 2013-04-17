package Translate;

import Frame.Frame;
import Mips.MipsFrame;

public class ProcFrag extends Frag {

	public Frame frame;
	public Tree.Stm body;
	
	public ProcFrag(Tree.Stm body, MipsFrame frame) {
		this.body = body;
		this.frame = frame;
	}
	
	public ProcFrag(Tree.Stm body, Frame frame) {
		this.body = body;
		this.frame = frame;
	}
}
