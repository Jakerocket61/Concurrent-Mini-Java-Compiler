package Parse;

public class Main {
	public static void main(String[] args) {
		try {
			java.io.FileReader reader = new java.io.FileReader(args[0]);
			// System.out.println(new Parse(reader).Program().toString());
			Absyn.Program p = new Parse(reader).Program();
			visitor.PrintVisitor pv = new visitor.PrintVisitor();
			pv.visit(p);
		} catch (java.io.IOException e) {
			System.err.println(e.toString());
		} catch (ParseException p) {
			System.out.println(p.toString());
			System.exit(-1);
		}
	}
}
