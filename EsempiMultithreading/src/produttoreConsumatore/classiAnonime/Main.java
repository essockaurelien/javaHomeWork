package produttoreConsumatore.classiAnonime;


public class Main {
	
	public static void main(String[] args) {
		Contenitore contenitore = new Contenitore();
		System.out.println("Produttore-Consumatore con classi anonime");
		Thread p1=new Thread(){
			public void run() {
				for (int i = 0; i < 10; i++) {
					contenitore.put(i);
					System.out.println("Produttore # 1 put: " + i);
					try {
						sleep((int) (Math.random() * 100));
					} catch (InterruptedException e) {
					}
				}
			}			
		};
		Thread c1=new Thread(){
			public void run() {
				int val = 0;
				for (int i = 0; i < 10; i++) {
					val = contenitore.get();
					System.out.println("Consumatore # 1 got: " + val);
				}
			}		
		};
		p1.start();
		c1.start();
	}

}
