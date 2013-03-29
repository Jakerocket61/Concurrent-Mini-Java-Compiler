package Types;

public class OBJECT extends Type implements Visitable {
	public RECORD fields;
	public RECORD methods;
	public CLASS myClass;

	public OBJECT(CLASS myClass) {
		this.myClass = myClass;
		this.methods = new RECORD();
		this.fields = new RECORD();
	}

	public OBJECT(CLASS myClass, RECORD methods, RECORD fields) {
		this.myClass = myClass;
		this.methods = methods;
		this.fields = fields;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean coerceTo(Type t) {
		// whether (t) can be (this)
		if (t instanceof Types.OBJECT) {
			CLASS current = this.myClass;

			while (current != null) {

				if (((OBJECT) t).myClass.name.equals(current.name))
					return true;

				current = myClass.parent;
			}

		} else {
			return false;
		}

		return false;
	}

	public String toString() {
		return "object";
	}
}
