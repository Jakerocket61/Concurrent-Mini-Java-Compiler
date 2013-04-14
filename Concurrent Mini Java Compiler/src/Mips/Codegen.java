package Mips;

import java.util.List;
import java.util.ListIterator;

import Assem.Instr;
import Temp.Label;
import Temp.Temp;
import Tree.BINOP;
import Tree.CALL;
import Tree.CJUMP;
import Tree.CONST;
import Tree.CodeVisitor;
import Tree.ESEQ;
import Tree.EXP;
import Tree.JUMP;
import Tree.LABEL;
import Tree.MEM;
import Tree.MOVE;
import Tree.NAME;
import Tree.SEQ;
import Tree.TEMP;

public class Codegen implements CodeVisitor {

	private MipsFrame frame;
	private ListIterator<Instr> code;
	
	public Codegen(MipsFrame frame, ListIterator<Instr> code)
	{
		this.frame = frame;
		this.code = code;
	}
	
	public void emit(Instr inst)
	{
		code.add(inst);
	}
	
	static Assem.Instr OPER(String a, Temp[] d, Temp[] s, List<Label> j)
	{
		return new Assem.OPER("\t" + a, d, s, j);
	}
	
	static Assem.Instr OPER(String a, Temp[] d, Temp[] s)
	{
		return OPER(a, d, s, null);
	}
	
	static Instr MOVE(String a, Temp d, Temp s)
	{
		return new Assem.MOVE("\t" + a, d, s);
	}
	
	public static boolean CONST16(Tree.CONST c)
	{
		return c.value == (short)c.value;
	}
	
	@Override
	public void visit(SEQ n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(LABEL n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(JUMP n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(CJUMP n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(MOVE n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(EXP n) {
		// TODO Auto-generated method stub

	}

	@Override
	public Temp visit(BINOP n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temp visit(MEM n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temp visit(TEMP n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temp visit(ESEQ n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temp visit(NAME n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temp visit(CONST n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Temp visit(CALL n) {
		// TODO Auto-generated method stub
		return null;
	}

}