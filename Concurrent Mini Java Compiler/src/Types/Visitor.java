package Types;

public interface Visitor {
	public void visit(ARRAY a);

	public void visit(BOOLEAN b);

	public void visit(CLASS c);

	public void visit(FIELD f);

	public void visit(FUNCTION f);

	public void visit(INT i);

	public void visit(NIL n);

	public void visit(OBJECT o);

	public void visit(RECORD r);

	public void visit(STRING s);

	public void visit(Type t);

	public void visit(VOID v);
}
