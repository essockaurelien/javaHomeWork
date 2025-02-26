package elefanti;

import jbook.util.Input;

class ElefanteThread extends Thread {
	public void run() {
		int i = 2;
		try {
		while (!Thread.interrupted()) {
			System.out.println(i + " elefanti si dondolavano... in Thread");
			Thread.sleep(1000);
			i++;
 		}
		}catch (InterruptedException e) {
		}
	}
}

class Elefante {
	/* campi e metodi della classe */}

class ElefanteRunnable extends Elefante implements Runnable {
	public void run() {
		int i = 2;
		try {
		while (!Thread.interrupted()) {
			System.out.println(i + " elefanti si dondolavano... in Runnable");
			Thread.sleep(1000);
			i++;
		}
		}catch (InterruptedException e) {
		}
	}
}
 
public class DondolaElefanti {
	public static void main(String[] args) {
		Thread tET = new ElefanteThread();
		Thread tER = new Thread(new ElefanteRunnable());
		Thread tEA = new Thread(new Runnable() {
			public void run() {
				int i = 2;
				try {
				while (!Thread.interrupted()) {
					
					
					
					System.out.println(i + " elefanti si dondolavano...in Classe Anonima");
						Thread.sleep(1000);
					i++;
				}
				} catch (InterruptedException e) {
				}
	
			}
		});
		Thread tEL = new Thread(() -> {
			int i = 2;
			try {
			while (!Thread.interrupted()) {
				System.out.println(i + " elefanti si dondolavano...in Lambda");
				Thread.sleep(1000);
			i++;
			}
			}catch (InterruptedException e) {}
		});
		
		System.out.println("Premi Invio per terminare");
		tEA.start();
		tEL.start();
		tET.start();
		tER.start();
	//Input.readString();
		tEL.interrupt();
		tER.interrupt();
		tEA.interrupt();
		tET.interrupt();
		}
}
