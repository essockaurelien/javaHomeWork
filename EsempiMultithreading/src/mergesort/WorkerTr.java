package mergesort;

public class WorkerTr extends Thread{
	
	private int[] arrayToSort;
	private int[] arraySorted;
	private int limite;

	@Override
	public void run() {
		arraySorted=MTMergeSort.mergeMT(arrayToSort, limite);		
	}
	
	public WorkerTr(int[] a,int limite){
		arrayToSort=a;
		this.limite=limite;
	}
	
	public int[] getArraySorted(){
		return arraySorted;
	}

}
