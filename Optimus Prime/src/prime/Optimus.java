package prime;

public class Optimus {

	public static void OP(int ant) {
		int hoyeste = ant;
		int x;
		int[] tab = new int[ant];
		int antall = 0;
		boolean isPrime;
		for (x = 2; x < ant; x++) {
			isPrime = true;
			for (int i = 0; i < antall; i++) {
				if (tab[i] * tab[i] > ant)
					hoyeste = i;
				if (x % tab[i] == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				if (antall < hoyeste) {
					tab[antall] = x;
					antall++;
				}
				System.out.println(x);
			}
		}
	}

	public static void main(String[] args) {
		OP(10000000);

	}
}