package Types;

public class CLASS extends Type implements Visitable {
	public RECORD fields;
	public OBJECT instance;
	public RECORD methods;
	public String name;
	public CLASS parent;

	public CLASS(String name) {
		this.name = name;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean coerceTo(Type t) {
		CLASS current = this;

		while (current != null) {

			if (((CLASS) t).name.equals(current.name))
				return true;

			current = this.parent;
		}

		return false;
	}

	public String toString() {
		return "class";
	}
}
