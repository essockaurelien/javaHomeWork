package produttoreConsumatore.classiAnonime;

public class Contenitore {
	private int contenuto;
	private boolean available = false;

	public synchronized int get() {
		while (!available) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		available = false;
		notifyAll();
		return contenuto;
	}

	public synchronized void put(int valore) {
		while (available) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		contenuto = valore;
		available = true;
		notifyAll();
	}
}


