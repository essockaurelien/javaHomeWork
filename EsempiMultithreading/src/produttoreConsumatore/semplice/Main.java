package produttoreConsumatore.semplice;



public class Main {
	public static void main(String[] args) {
		Contenitore c = new Contenitore();
		System.out.println("Produttore-Consumatore con classi standard");
		Produttore p1 = new Produttore(c, 1, 10);
		Produttore p2 = new Produttore(c, 2, 10); 
		Consumatore c1 = new Consumatore(c,1, 10);
		Consumatore c2 = new Consumatore(c,2, 10);
		p1.start();
		p2.start();
		c1.start();
		c2.start();
	}
}
