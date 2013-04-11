package Tree;

public interface CodeVisitor {
	public void visit(SEQ n);
	public void visit(LABEL n);
	public void visit(JUMP n);
	public void visit(CJUMP n);
	public void visit(MOVE n);
	public void visit(EXP n);
	
	public Temp.Temp visit(BINOP n);
	public Temp.Temp visit(MEM n);
	public Temp.Temp visit(TEMP n);
	public Temp.Temp visit(ESEQ n);
	public Temp.Temp visit(NAME n);
	public Temp.Temp visit(CONST n);
	public Temp.Temp visit(CALL n);
}
