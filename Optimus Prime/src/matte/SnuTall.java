package matte;

public class SnuTall {

	public static void main(String[] args) {
		int tall = 7331;
		Integer[] tab = {3, 2, 1};
		snu(tall);
		snuTabell(tab, 0 ,tab.length-1);
		
		}

	

static void snu(int tall){
	if (tall == 0){
		System.out.println();
		return;
	}
	int last = tall % 10;
	System.out.print(last);
	snu((tall-last)/10);
}


static void snuTabell(Object[] tab, int f, int l){
	for (Object a : tab){
		System.out.print(a);
	}
	System.out.println();
	if (f >=l){
		return;
	}
	Object temp = tab[f];
	tab[f]= tab[l];
	tab[l]= temp;
	f++;
	l--;
	snuTabell(tab, f, l);
}

}
