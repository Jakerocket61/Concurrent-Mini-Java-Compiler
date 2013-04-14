package Tree;

import java.io.PrintWriter;
import java.util.LinkedList;

import Temp.DefaultMap;
import Temp.TempMap;

public class Print implements IntVisitor {

	java.io.PrintStream out;
	Stm st = null;

	public Print(java.io.PrintStream o) {
		out = o;
		//st = new Stm();
	}

	public Print(PrintWriter writer, Stm s) {
		out = writer;
		st = s;
	}

	void indent(int d) {
		for (int i = 0; i < d; i++)
			out.print(' ');
	}

	public void prExp(Exp e) {
		visit(e, 0);
		say("\n");
	}

	void say(String s) {
		out.print(s);
	}

	void sayln(String s) {
		say(s);
		say("\n");
	}

	public void visit(BINOP e, int d) {
		indent(d);
		say("BINOP(");

		switch (e.binop) {
		case BINOP.PLUS:
			say("PLUS");
			break;
		case BINOP.MINUS:
			say("MINUS");
			break;
		case BINOP.MUL:
			say("MUL");
			break;
		case BINOP.DIV:
			say("DIV");
			break;
		case BINOP.AND:
			say("AND");
			break;
		case BINOP.OR:
			say("OR");
			break;
		case BINOP.LSHIFT:
			say("LSHIFT");
			break;
		case BINOP.RSHIFT:
			say("RSHIFT");
			break;
		case BINOP.ARSHIFT:
			say("ARSHIFT");
			break;
		case BINOP.XOR:
			say("XOR");
			break;
		default:
			throw new Error("Print.prExp.BINOP");
		}

		sayln(",");
		visit(e.left, d + 1);
		sayln(",");
		visit(e.right, d + 1);
		say(")");
	}

	public void visit(CALL e, int d) {
		indent(d);
		sayln("CALL(");
		visit(e.func, d + 1);

		//for (LinkedList<Exp> a = e.args; a != null; a = a.getLast()) {
		for (Exp a : e.args)
		{
			sayln(",");
			//visit(a.head, d + 2);
			visit(a, d + 2);
		}

		say(")");
	}

	public void visit(CJUMP s, int d) {
		indent(d);
		say("CJUMP(");

		switch (s.relop) {
		case CJUMP.EQ:
			say("EQ");
			break;
		case CJUMP.NE:
			say("NE");
			break;
		case CJUMP.LT:
			say("LT");
			break;
		case CJUMP.GT:
			say("GT");
			break;
		case CJUMP.LE:
			say("LE");
			break;
		case CJUMP.GE:
			say("GE");
			break;
		case CJUMP.ULT:
			say("ULT");
			break;
		case CJUMP.ULE:
			say("ULE");
			break;
		case CJUMP.UGT:
			say("UGT");
			break;
		case CJUMP.UGE:
			say("UGE");
			break;
		default:
			throw new Error("Print.prStm.CJUMP");
		}

		sayln(",");
		visit(s.left, d + 1);
		sayln(",");
		visit(s.right, d + 1);
		sayln(",");
		indent(d + 1);
		say(s.iftrue.toString());
		say(",");
		say(s.iffalse.toString());
		say(")");
	}

	public void visit(CONST e, int d) {
		indent(d);
		say("CONST ");
		say(String.valueOf(e.value));
	}

	public void visit(ESEQ e, int d) {
		indent(d);
		sayln("ESEQ(");
		visit(e.stm, d + 1);
		sayln(",");
		visit(e.exp, d + 1);
		say(")");
	}

	public void visit(Exp e, int d) {
		if (e instanceof BINOP)
			visit((BINOP) e, d);
		else if (e instanceof MEM)
			visit((MEM) e, d);
		else if (e instanceof TEMP)
			visit((TEMP) e, d);
		else if (e instanceof ESEQ)
			visit((ESEQ) e, d);
		else if (e instanceof NAME)
			visit((NAME) e, d);
		else if (e instanceof CONST)
			visit((CONST) e, d);
		else if (e instanceof CALL)
			visit((CALL) e, d);
		else
			throw new Error("Print.prExp");
	}

	public void visit(EXP s, int d) {
		indent(d);
		sayln("EXP(");
		visit(s.exp, d + 1);
		say(")");
	}

	public void visit(JUMP s, int d) {
		indent(d);
		sayln("JUMP(");
		visit(s.exp, d + 1);
		say(")");
	}

	public void visit(LABEL s, int d) {
		indent(d);
		say("LABEL ");
		say(s.label.toString());
	}

	public void visit(MEM e, int d) {
		indent(d);
		sayln("MEM(");
		visit(e.exp, d + 1);
		say(")");
	}

	public void visit(MOVE s, int d) {
		indent(d);
		sayln("MOVE(");
		visit(s.dst, d + 1);
		sayln(",");
		visit(s.src, d + 1);
		say(")");
	}

	public void visit(NAME e, int d) {
		indent(d);
		say("NAME ");
		say(e.label.toString());
	}

	public void visit(SEQ s, int d) {
		indent(d);
		sayln("SEQ(");
		visit(s.left, d + 1);
		sayln(",");
		visit(s.right, d + 1);
		say(")");
	}

	public void visit(Stm s) {
		visit(s, 0);
		say("\n");
	}

	void visit(Stm s, int d) {
		if (s instanceof SEQ)
			visit((SEQ) s, d);
		else if (s instanceof LABEL)
			visit((LABEL) s, d);
		else if (s instanceof JUMP)
			visit((JUMP) s, d);
		else if (s instanceof CJUMP)
			visit((CJUMP) s, d);
		else if (s instanceof MOVE)
			visit((MOVE) s, d);
		else if (s instanceof EXP)
			visit((EXP) s, d);
		else
			throw new Error("Print.prStm");
	}

	public void visit(TEMP e, int d) {
		indent(d);
		say("TEMP ");
		DefaultMap tmap = new DefaultMap();
		say(tmap.tempMap(e.temp));
	}
}
