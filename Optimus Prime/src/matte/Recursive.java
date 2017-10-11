package matte;

public class Recursive {

	public static int factor(int i) {
		if (i == 1) {
			return 1;
		} else {
			return i * factor(i - 1);
		}

	}

	public static int sum(int i) {
		if (i == 1) {
			return 1;
		} else {
			return i + sum(i - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(sum(100));
		System.out.println(factor(7));
	}

}
