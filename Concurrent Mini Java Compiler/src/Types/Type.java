package Types;

public abstract class Type implements Visitable {
	public void accept(Visitor v) {
		v.visit(this);
	}

	public abstract boolean coerceTo(Type t);

	// {
	// return (t instanceof Types.Type);
	// }

	public abstract String toString();
}
