package Types;

public class FUNCTION extends Type // implements Visitable
{
	public RECORD formals;
	public String name;
	public Type result;
	public Type self;

	public FUNCTION(String name, Type self, RECORD formals, Type result) {
		this.name = name;
		this.self = self;
		this.formals = formals;
		this.result = result;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public FIELD addformal(Type type, String name) {
		return formals.put(type, name);
	}

	public boolean coerceTo(Type t) {
		return (t instanceof Types.FUNCTION);
	}

	public String toString() {
		return "function";
	}
}
