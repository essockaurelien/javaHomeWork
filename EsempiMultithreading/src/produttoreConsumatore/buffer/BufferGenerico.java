package produttoreConsumatore.buffer;

import java.util.ArrayList;

public class  BufferGenerico <T> {
		private int dimBuffer;
		private ArrayList<T> contenitore;
		
		public BufferGenerico(int dB){
			dimBuffer=dB;
			contenitore= new ArrayList<T>();
		}

		public synchronized T get() {
			T contenuto;
			while (contenitore.size()==0) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			contenuto = contenitore.get(0);
			contenitore.remove(0);
			notifyAll();
			return contenuto;
		}

		public synchronized void put(T valore) {
			while (contenitore.size()==dimBuffer) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			contenitore.add(valore);
			notifyAll();
		}
}
