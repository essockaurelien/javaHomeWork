package produttoreConsumatore.semplice;



public class Produttore extends Thread {
	private Contenitore contenitore;
	private int num;
	private int numprodotti;
	
	public Produttore(Contenitore c, int num, int numprodotti) {
		contenitore = c;
		this.num = num;
		this.numprodotti = numprodotti;
	}

	public void run() {
		for (int i = 0; i < numprodotti; i++) {
			contenitore.put(i);
			System.out.println("Produttore #" + this.num + " put: " + i);
			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}

