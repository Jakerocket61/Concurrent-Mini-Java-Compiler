package Types;

public class INT extends Type // implements Visitable
{
	public INT() {
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean coerceTo(Type t) {
		return (t instanceof Types.INT || t instanceof Types.NIL);
	}

	public String toString() {
		return "int";
	}
}
