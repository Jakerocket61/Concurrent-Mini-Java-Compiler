package Types;

public class VOID extends Type // implements Visitable
{
	public VOID() {
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean coerceTo(Type t) {
		return (t instanceof Types.VOID);
	}

	public String toString() {
		return "void";
	}
}
