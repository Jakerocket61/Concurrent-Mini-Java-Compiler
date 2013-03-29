package Translate;

import Frame.Frame;
import Tree.Stm;

public class ProcFrag extends Frag {

	Stm statement;
	Frame frame;

	public ProcFrag(Stm s, Frame f) {
		statement = s;
		frame = f;
	}
}
