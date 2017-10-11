package matte;

public class Func {
	public static void main(String[] args) {
		for (double i = -5.0; i < 5.0; i += 0.01) {
			System.out.println(func(i));
		}

	}

	static double func(double in) {
		if (in >= 0.0) {
			return in;
		} else {
			return -2 * in;
		}
	}
}
