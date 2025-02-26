package codice;

public class BufferLimitato extends Buffer {
	public final int limite;
   
   public BufferLimitato(int limit) {
	   super();
	   this.limite = limit;
   }
   
   public BufferLimitato() {
	   
	   super();
	   this.limite = 3;
   }
   
   @Override
   public void put(String str) throws EccezioneBuffer {
	if(super.nunEl() >= limite) {
		throw new EccezioneBuffer("buffer pieno");	
	}
	super.put(str);
   }
   
   @Override
   public String toString() {
	  return  super.toString() +"limite :" +limite;
   }
}
