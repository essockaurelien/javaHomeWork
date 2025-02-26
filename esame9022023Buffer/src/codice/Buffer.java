package codice;

import java.util.ArrayList;

public class Buffer {

   private ArrayList<String> buffer;
   
   public Buffer() {
	   this.buffer = new ArrayList<>();
   }
   
   public String get() throws EccezioneBuffer {
	  
	   if(this.buffer.isEmpty() == true) {
		   throw new EccezioneBuffer("buffer vuoto");   
	   }
	return buffer.get(0);
   }
   
   public void put(String str) throws EccezioneBuffer {
	   buffer.add(str);
   }
    
   public int nunEl() {
	   return buffer.size();
   }
   
   public String  toString() {
	   String app = "";
	   for(String y: buffer) {
         app += y.toString()+"\n";		   
	   }
	   return app;
   }
}