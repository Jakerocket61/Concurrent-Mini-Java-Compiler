package Types;

public class STRING extends Type // implements Visitable
{

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean coerceTo(Type t) {
		if(t instanceof Types.STRING || t instanceof Types.NIL)
			return true;
		else
			return false;
	}

	/*public boolean coerceTo(Type t) {
		// whether (t) can be (this)
		if (t instanceof Types.STRING) {
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
	}*/

	public String toString() {
		return "OBJECT:String";
	}
}

