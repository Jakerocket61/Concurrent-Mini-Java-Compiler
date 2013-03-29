package Temp;

public class Temp {

	private static int count;
	private int num;

	public Temp() {
		num = count++;
	}

	public Temp(int i) {
		num = i;
	}

	public String toString() {
		return "t" + num;
	}
}
