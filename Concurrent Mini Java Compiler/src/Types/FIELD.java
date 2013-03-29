package Types;

public class FIELD extends Type // implements Visitable
{
	public int index;
	public String name;
	public Type type;

	public FIELD(Type type, String name, int index) {
		this.type = type;
		this.name = name;
		this.index = index;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean coerceTo(Type t) {
		return (t instanceof Types.FIELD);
	}

	public String toString() {
		return "field";
	}
}
