package Types;

public class NIL extends Type // implements Visitable
{
	public NIL() {
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean coerceTo(Type t) {
		return (t instanceof Types.NIL);
	}

	public String toString() {
		return "nil";
	}
}
