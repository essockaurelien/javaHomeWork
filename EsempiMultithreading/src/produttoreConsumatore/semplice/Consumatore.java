package produttoreConsumatore.semplice;



public class Consumatore extends Thread {
	private Contenitore contenitore;
	private int num;
	private int numConsumati;

	public Consumatore(Contenitore c, int num, int numConsumati) {
		contenitore = c;
		this.num = num;
		this.numConsumati = numConsumati;
	}

	public void run() {
		int val = 0;
		for (int i = 0; i < numConsumati; i++) {
			val = contenitore.get();
			System.out.println("Consumatore #" + this.num + " got: " + val);
		}
	}
}
