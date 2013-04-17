/* Generated By:JavaCC: Do not edit this line. ReadFrags.java */
package Parse;
import java.util.HashMap;
import java.util.Vector;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

    public class ReadFrags implements ReadFragsConstants {
        static private Mips.MipsFrame masterFrame = new Mips.MipsFrame();

        static Vector<Temp.Temp>  tempVector = null;
        static Vector<Temp.Label> labelVector = null;

        static Temp.Temp getTemp(int num)
        {
            if (num < 0)
                {
                    System.err.println("ERROR: getTemp(" + num + ")");
                    return null;
                }
            if (null == tempVector)
                {
                    tempVector = new Vector<Temp.Temp>();
                    Temp.Temp[] regs = Mips.MipsFrame.registers;
                    for (int i = 0; i < regs.length; i++)
                        { tempVector.add(regs[i]); }
                }

            for (int i = tempVector.size(); i <= num; i++)
                tempVector.add(new Temp.Temp());
            return tempVector.elementAt(num);
        }

        static Temp.Label getLabel(String s)
        {
            if (null == labelVector) labelVector = new Vector<Temp.Label>();

            int num = Integer.MIN_VALUE;
            if (s.startsWith("L"))
                num = parseInt(s.substring(1));
            if (num == Integer.MIN_VALUE) return new Temp.Label(s);

            for (int i = labelVector.size(); i <= num; i++)
                labelVector.add(new Temp.Label());
            return labelVector.elementAt(num);
        }

        static int parseInt(String s)
        {
            try
                {
                    return Integer.parseInt(s);
                }
            catch (Exception e)
                {
                    // System.err.println("ERROR: parseInt(" + s + ")");
                    return Integer.MIN_VALUE;
                }
        }

/********************************
 * Language grammar starts here *
 ********************************/
  static final public LinkedList<Translate.Frag> Program() throws ParseException {
    LinkedList<Translate.Frag> frags = new LinkedList<Translate.Frag>();
    Translate.Frag frag = null;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DATAFRAG:
      case PROCFRAG:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DATAFRAG:
        frag = DataFrag();
                          frags.add(frag);
        break;
      case PROCFRAG:
        frag = ProcFrag();
                          frags.add(frag);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
      {if (true) return frags;}
    throw new Error("Missing return statement in function");
  }

  static final public Translate.Frag DataFrag() throws ParseException {
    Token name = null;
    Token num = null;
    String s = new String();
    jj_consume_token(DATAFRAG);
    jj_consume_token(LPAREN);
    jj_consume_token(DOT);
    jj_consume_token(DATA);
                   s = s + "\u005ct.data\u005cn";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DOT:
      jj_consume_token(DOT);
      jj_consume_token(ALIGN);
                          s = s + "\u005ct.align";
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUM:
        num = jj_consume_token(NUM);
        break;
      default:
        jj_la1[2] = jj_gen;
        ;
      }
            if (null == num) s = s + "\u005cn"; else s = s + " " + num.image + "\u005cn";
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    name = jj_consume_token(ID);
    jj_consume_token(COLON);
                          s = s + name.image + ":\u005cn";
    if (jj_2_2(2)) {
      jj_consume_token(DOT);
      jj_consume_token(ASCIZ);
      name = jj_consume_token(STRINGVAL);
          s = s.substring(0,s.length() - 1)
          + "\u005ct.asciiz\u005ct" + name.image;
    } else {
      label_2:
      while (true) {
        if (jj_2_1(2)) {
          ;
        } else {
          break label_2;
        }
        jj_consume_token(DOT);
        jj_consume_token(WORD);
        name = jj_consume_token(ID);
           s = s + "\u005ct.word " + name.image + "\u005cn";
      }
    }
    jj_consume_token(RPAREN);
      {if (true) return new Translate.DataFrag(s);}
    throw new Error("Missing return statement in function");
  }

  static final public Translate.Frag ProcFrag() throws ParseException {
    Tree.Stm body = null;
    Frame.Frame frame = null;
    jj_consume_token(PROCFRAG);
    jj_consume_token(LPAREN);
    frame = Frame();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EXP:
    case JUMP:
    case MOVE:
    case SEQ:
    case CJUMP:
    case LABEL:
      body = Stm();
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
      {if (true) return new Translate.ProcFrag(body, frame);}
    throw new Error("Missing return statement in function");
  }

  static final public Frame.Frame Frame() throws ParseException {
    Token name;
    Mips.MipsFrame frame = null;

    LinkedList formals = null;
    LinkedList actuals = null;
    jj_consume_token(MIPSFRAME);
    jj_consume_token(LPAREN);
    name = jj_consume_token(ID);
    jj_consume_token(COLON);
                          frame = (Mips.MipsFrame)(masterFrame.newFrame(new Temp.Label(name.image)));
    formals = FormalList();
                             frame.formals = formals;
    actuals = FormalList();
                             frame.actuals = actuals;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BADPTR:
      jj_consume_token(BADPTR);
      jj_consume_token(LPAREN);
      name = jj_consume_token(ID);
      jj_consume_token(RPAREN);
        if (!(frame.badPtr().toString().equals(name.image)))
                   System.err.println("badPtr name does not match! " + name.image);
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BADSUB:
      jj_consume_token(BADSUB);
      jj_consume_token(LPAREN);
      name = jj_consume_token(ID);
      jj_consume_token(RPAREN);
        if (!(frame.badSub().toString().equals(name.image)))
                   System.err.println("badSub name does not match! " + name.image);
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    jj_consume_token(RPAREN);
          {if (true) return frame;}
    throw new Error("Missing return statement in function");
  }

  static final public LinkedList FormalList() throws ParseException {
    LinkedList list = new LinkedList();
    Token t = null;
    String s;
    int tempNum = 0;
    Frame.Access access = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FORMALS:
      jj_consume_token(FORMALS);
      break;
    case ACTUALS:
      jj_consume_token(ACTUALS);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(LPAREN);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INREG:
      case INFRAME:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INREG:
        access = InReg();
                             list.add(access);
        break;
      case INFRAME:
        access = InFrame();
                               list.add(access);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(RPAREN);
          {if (true) return list;}
    throw new Error("Missing return statement in function");
  }

  static final public Frame.Access InReg() throws ParseException {
    Token t;
    String s;
    int tempNum;
    jj_consume_token(INREG);
    jj_consume_token(LPAREN);
    t = jj_consume_token(ID);
    jj_consume_token(RPAREN);
                 s = t.image.substring(1);
                 tempNum = parseInt(s);
                 {if (true) return new Mips.InReg(getTemp(tempNum));}
    throw new Error("Missing return statement in function");
  }

  static final public Frame.Access InFrame() throws ParseException {
    Token t;
    jj_consume_token(INFRAME);
    jj_consume_token(LPAREN);
    t = jj_consume_token(NUM);
    jj_consume_token(RPAREN);
            {if (true) return new Mips.InFrame(parseInt(t.image));}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.Stm Stm() throws ParseException {
    Tree.Stm stm;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MOVE:
      stm = MOVE();
      break;
    case EXP:
      stm = EXP();
      break;
    case JUMP:
      stm = JUMP();
      break;
    case CJUMP:
      stm = CJUMP();
      break;
    case SEQ:
      stm = SEQ();
      break;
    case LABEL:
      stm = LABEL();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      {if (true) return stm;}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.Exp Exp() throws ParseException {
    Tree.Exp exp;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONST:
      exp = CONST();
      break;
    case NAME:
      exp = NAME();
      break;
    case TEMP:
      exp = TEMP();
      break;
    case BINOP:
      exp = BINOP();
      break;
    case MEM:
      exp = MEM();
      break;
    case CALL:
      exp = CALL();
      break;
    case ESEQ:
      exp = ESEQ();
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return exp;}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.BINOP BINOP() throws ParseException {
    int binop;
    Tree.Exp left, right;
    jj_consume_token(BINOP);
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
                     binop = Tree.BINOP.PLUS;
      break;
    case MINUS:
      jj_consume_token(MINUS);
                     binop = Tree.BINOP.MINUS;
      break;
    case MUL:
      jj_consume_token(MUL);
                     binop = Tree.BINOP.MUL;
      break;
    case DIV:
      jj_consume_token(DIV);
                     binop = Tree.BINOP.DIV;
      break;
    case AND:
      jj_consume_token(AND);
                     binop = Tree.BINOP.AND;
      break;
    case OR:
      jj_consume_token(OR);
                     binop = Tree.BINOP.OR;
      break;
    case SLL:
      jj_consume_token(SLL);
                     binop = Tree.BINOP.LSHIFT;
      break;
    case SRL:
      jj_consume_token(SRL);
                     binop = Tree.BINOP.RSHIFT;
      break;
    case SRA:
      jj_consume_token(SRA);
                     binop = Tree.BINOP.ARSHIFT;
      break;
    case BITAND:
      jj_consume_token(BITAND);
                     binop = Tree.BINOP.BITAND;
      break;
    case BITOR:
      jj_consume_token(BITOR);
                     binop = Tree.BINOP.BITOR;
      break;
    case BITXOR:
      jj_consume_token(BITXOR);
                     binop = Tree.BINOP.BITXOR;
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    left = Exp();
    right = Exp();
    jj_consume_token(RPAREN);
       {if (true) return new Tree.BINOP(binop, left, right);}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.CALL CALL() throws ParseException {
    Tree.Exp target, arg;
    LinkedList args = new LinkedList();
    jj_consume_token(CALL);
    jj_consume_token(LPAREN);
    target = Exp();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BINOP:
      case MEM:
      case TEMP:
      case CALL:
      case CONST:
      case ESEQ:
      case NAME:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_4;
      }
      arg = Exp();
                        args.add(arg);
    }
    jj_consume_token(RPAREN);
          {if (true) return new Tree.CALL(target, args);}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.CJUMP CJUMP() throws ParseException {
    int relop;
    Tree.Exp left, right;
    Token tLabel, fLabel;
    jj_consume_token(CJUMP);
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQ:
      jj_consume_token(EQ);
                 relop = Tree.CJUMP.EQ;
      break;
    case NE:
      jj_consume_token(NE);
                 relop = Tree.CJUMP.NE;
      break;
    case LT:
      jj_consume_token(LT);
                 relop = Tree.CJUMP.LT;
      break;
    case GT:
      jj_consume_token(GT);
                 relop = Tree.CJUMP.GT;
      break;
    case LE:
      jj_consume_token(LE);
                 relop = Tree.CJUMP.LE;
      break;
    case GE:
      jj_consume_token(GE);
                 relop = Tree.CJUMP.GE;
      break;
    case ULT:
      jj_consume_token(ULT);
                 relop = Tree.CJUMP.ULT;
      break;
    case ULE:
      jj_consume_token(ULE);
                 relop = Tree.CJUMP.ULE;
      break;
    case UGT:
      jj_consume_token(UGT);
                 relop = Tree.CJUMP.UGT;
      break;
    case UGE:
      jj_consume_token(UGE);
                 relop = Tree.CJUMP.UGE;
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    left = Exp();
    right = Exp();
    tLabel = jj_consume_token(ID);
    fLabel = jj_consume_token(ID);
    jj_consume_token(RPAREN);
       {if (true) return new Tree.CJUMP(relop, left, right,
                             getLabel(tLabel.image),
                             getLabel(fLabel.image));}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.CONST CONST() throws ParseException {
    Token t;
    jj_consume_token(CONST);
    jj_consume_token(LPAREN);
    t = jj_consume_token(NUM);
    jj_consume_token(RPAREN);
          {if (true) return new Tree.CONST(parseInt(t.image));}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.ESEQ ESEQ() throws ParseException {
    Tree.Stm stm; Tree.Exp exp;
    jj_consume_token(ESEQ);
    jj_consume_token(LPAREN);
    stm = Stm();
    exp = Exp();
    jj_consume_token(RPAREN);
          {if (true) return new Tree.ESEQ(stm,exp);}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.EXP EXP() throws ParseException {
    Tree.Exp exp = null;
    jj_consume_token(EXP);
    jj_consume_token(LPAREN);
    exp = Exp();
    jj_consume_token(RPAREN);
          {if (true) return new Tree.EXP(exp);}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.JUMP JUMP() throws ParseException {
    Tree.NAME name;
    jj_consume_token(JUMP);
    jj_consume_token(LPAREN);
    name = NAME();
    jj_consume_token(RPAREN);
          {if (true) return new Tree.JUMP(name.label);}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.LABEL LABEL() throws ParseException {
    Token t;
    jj_consume_token(LABEL);
    jj_consume_token(LPAREN);
    t = jj_consume_token(ID);
    jj_consume_token(RPAREN);
          {if (true) return new Tree.LABEL(getLabel(t.image));}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.MEM MEM() throws ParseException {
    Tree.Exp exp;
    jj_consume_token(MEM);
    jj_consume_token(LPAREN);
    exp = Exp();
    jj_consume_token(RPAREN);
          {if (true) return new Tree.MEM(exp);}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.MOVE MOVE() throws ParseException {
    Tree.Exp dst, src;
    jj_consume_token(MOVE);
    jj_consume_token(LPAREN);
    dst = Exp();
    src = Exp();
    jj_consume_token(RPAREN);
          {if (true) return new Tree.MOVE(dst,src);}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.NAME NAME() throws ParseException {
    Token t;
    jj_consume_token(NAME);
    jj_consume_token(LPAREN);
    t = jj_consume_token(ID);
    jj_consume_token(RPAREN);
          {if (true) return new Tree.NAME(getLabel(t.image));}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.SEQ SEQ() throws ParseException {
    Tree.Stm stm1, stm2;
    jj_consume_token(SEQ);
    jj_consume_token(LPAREN);
    stm1 = Stm();
    stm2 = Stm();
    jj_consume_token(RPAREN);
          {if (true) return new Tree.SEQ(stm1,stm2);}
    throw new Error("Missing return statement in function");
  }

  static final public Tree.TEMP TEMP() throws ParseException {
    Token t;
    jj_consume_token(TEMP);
    jj_consume_token(LPAREN);
    t = jj_consume_token(ID);
    jj_consume_token(RPAREN);
          {if (true) return new Tree.TEMP(
                             getTemp(parseInt(t.image.substring(1))));}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_3_1() {
    if (jj_scan_token(DOT)) return true;
    if (jj_scan_token(WORD)) return true;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_scan_token(DOT)) return true;
    if (jj_scan_token(ASCIZ)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ReadFragsTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xc0000,0xc0000,0x0,0x40,0x0,0x800000,0x1000000,0x600000,0x6000000,0x6000000,0x0,0xf8000000,0x0,0xf8000000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x40000000,0x0,0x5f,0x0,0x0,0x0,0x0,0x0,0x5f,0xa0,0x3ffc0000,0xa0,0x3ff00,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[2];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public ReadFrags(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ReadFrags(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ReadFragsTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public ReadFrags(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ReadFragsTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public ReadFrags(ReadFragsTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ReadFragsTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[65];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 65; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 2; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

    }
