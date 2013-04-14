package Translate;

import Frame.Frame;

public class ProcFrag extends Frag {

	public Frame frame;
	public Tree.Stm body;
	
	public ProcFrag(Tree.Stm body, Frame frame) {
		this.body = body;
		this.frame = frame;
	}
}
