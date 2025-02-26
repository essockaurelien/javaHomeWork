package esempiPrimi;

import jbook.util.Input;

/*
 * 5) Scrivere un programma che legge una stringa s e  ritorna
    a) la stringa  ottenuta rimuovendo da s i caratteri di indice dispari 
        (anche il primo elemento delle stringhe ha indice 0)
          se s="beltaichkw" produce "black"
    b) la stringa  ottenuta facendo il reverse della  stringa
          se s="beltaichkw" produce "wkhciatleb"
*/

public class TolgoPerPosizioni {

	public static void main(String[] args) {
		
       System.out.println("Dammi la Stringa!!!!!!");		
		String s = Input.readString();
       /*a*/
		  int i;
          String apgio = "";
          char str[] = s.toCharArray();
          for(i=0 ; i< s.length() ; i++) {
        	  if(i%2 == 0) {
        		  apgio += str[i];
        	  } 	  
          }
          System.out.println("per posizioni pari rimane: " +apgio);
      
      /*b*/
         String app = "";
         for(i = s.length()-1 ; i >= 0 ; i--) {
        	 app += str[i];
         }
         System.out.println("Al contrario è: " +app);
          
          
	}

}
