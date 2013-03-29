package Temp;

public class Label {

	private String name;
	private static int count;

	public Label() {
		this("L" + count++);
	}

	public Label(String n) {
		name = n;
	}

	public String toString() {
		return name;
	}

	// public Label(Symbol s) {
	// this(s.toString());
	// }
}
