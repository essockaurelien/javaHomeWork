package mergesort;

import java.util.Arrays;

public class MTMergeSort {

	public static int[] mergeMT(int[] a, int limite) {
		if (a.length <= limite) {
			Arrays.sort(a);
			return a;
		}
		
		int[] a1 = copia(a, 0, a.length / 2);
		int[] a2 = copia(a, a.length / 2, a.length);

		WorkerTr wt1 = new WorkerTr(a1, limite);
		WorkerTr wt2 = new WorkerTr(a2, limite);
		wt1.start();
		System.out.println("INIZIO worker per " + stampa(a,0,a.length / 2));
		wt2.start();
		System.out.println("INIZIO worker per " +  stampa(a,a.length / 2,a.length));
		try {
			wt1.join();
			System.out.println("FINE worker per " + stampa(a,0,a.length / 2));
			wt2.join();
			System.out.println("FINE worker per " +  stampa(a,a.length / 2,a.length));
		} catch (InterruptedException e) {
		}
		return merge(wt1.getArraySorted(), wt2.getArraySorted());
	}

	public static String stampa(int[] a, int i, int j) {
		StringBuffer s=new StringBuffer("");
		for (int k = i; k < j; k++)
			s.append(a[k]+",");
		return s.substring(0, s.length() - 1);
	}

	private static int[] merge(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		return result;
	}

	private static int[] copia(int[] a, int inf, int sup) {
		int numEl = sup - inf;
		int[] res = new int[numEl];
		for (int i = 0; i < numEl; i++)
			res[i] = a[inf + i];
		return res;
	}
}
