package Types;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class RECORD extends Type implements Iterable<FIELD>// , Visitable
{
	public HashMap<String, FIELD> hash;
	public LinkedList<FIELD> fields = new LinkedList<FIELD>();
	public int index;

	public RECORD() {
		hash = new HashMap<String, FIELD>();
		index = 0;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean coerceTo(Type t) {
		return (t instanceof Types.RECORD);
	}

	public FIELD get(String name) {
		return hash.get(name);
	}

	public Iterator<FIELD> iterator() {
		return fields.iterator();
	}

	public FIELD put(FIELD type, String name) {
		hash.put(name, type);
		fields.add(type);
		index = index + 1;
		type.index = index - 1;
		return type;
	}

	public FIELD put(Type type, String name) {
		FIELD f = new FIELD(type, name, index);
		hash.put(name, f);
		fields.add(f);
		index = index + 1;
		return f;
	}

	public String toString() {
		return "record";
	}
}
