package Types;

public class BOOLEAN extends Type // implements Visitable
{

	public BOOLEAN() {
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean coerceTo(Type t) {
		return (t instanceof Types.BOOLEAN);
	}

	public String toString() {
		return "boolean";
	}
}
