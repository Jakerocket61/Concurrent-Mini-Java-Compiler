package Translate;

import java.io.PrintWriter;

import Semant.ParseException;

public class Main {
	public static void main(String args[]) {
		java.io.Reader reader = null;

		for (int i = 0; i < args.length; i++) {

			if (args[i].equals("-")) {
				java.io.InputStreamReader isr = new java.io.InputStreamReader(
						System.in);
				reader = new java.io.BufferedReader(isr);
			} else {
				try {
					reader = new java.io.FileReader(args[i]);
				} catch (java.io.FileNotFoundException fnfe) {
					System.err.println("File Not Found: " + args[i]);
					System.exit(-1);
				}
			}
		}

		if (null == reader) {
			System.err.println("Usage: Translate [-v] file.java");
			System.exit(-2);
		}

		Absyn.Program parse = null;
		try {
			parse = new Parse.ReadTypes(reader).Program();
		} catch (Exception p) {
			System.err.println(p.toString());
			System.exit(-1);
		}

		Translate translate = new Translate();
		parse.accept(translate);

		PrintWriter writer = new PrintWriter(System.out);
		/*		visitor.PrintVisitor pv = new visitor.PrintVisitor(writer);
		pv.visit(parse);*/

		for (Iterator frags = translate.results().iterator(); frags.hasNext();) {
			Frag f = (Frag) frags.next();
			if (f instanceof DataFrag) {
				writer.println("DataFrag(");
				writer.println(f);
				writer.println(")");
			} else {
				writer.println("ProcFrag(");
				ProcFrag p = (ProcFrag) f;
				p.frame.printFrame(writer);
				if (p.body != null) {
					new Tree.Print(writer, p.body);
					writer.println();
				}
				writer.println(")");
			}
		}
		writer.flush();
		 
	}
}
