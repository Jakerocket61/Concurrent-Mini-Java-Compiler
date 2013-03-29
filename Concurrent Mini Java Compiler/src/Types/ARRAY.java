package Types;

public class ARRAY extends Type // implements Visitable
{
	public Type element;

	public ARRAY(Type element) {
		this.element = element;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean coerceTo(Type t) {
		return (t instanceof Types.ARRAY);
	}

	public String toString() {
		return "array";
	}
}
