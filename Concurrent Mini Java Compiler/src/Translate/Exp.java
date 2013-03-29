package Translate;

public abstract class Exp {

	abstract Tree.Stm unCx(Temp.Label t, Temp.Label f);

	abstract Tree.Exp unEx();

	abstract Tree.Stm unNx();
}
