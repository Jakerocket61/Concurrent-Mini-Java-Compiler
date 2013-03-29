package Types;

public class STRING extends Type // implements Visitable
{

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean coerceTo(Type t) {
		return (t instanceof Types.STRING);
	}

	public String toString() {
		return "OBJECT:String";
	}
}
