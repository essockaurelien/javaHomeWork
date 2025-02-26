package esempiPrimi;

import jbook.util.Input;

/*
 * 4) Scrivere un programma che legge una stringa s e un carattere c e 
stampa la stringa ottenuto rimpiazzando in s tutte le occorrenze di c con '?' 
*/

public class RimpiazaCarattere {

	public static void main(String[] args) {

		System.out.println("Dammi una Stringa: ");
		String s = Input.readString();
		System.out.println("Adesso aspetto un carattere: ");
	    char car = Input.readChar();
	    
	   /* replaceAll NON FUNZIONATE
	    * 
	    String str = s.replaceAll(s, 'e');
	    System.out.println("Dopo la replaceAll: " + str);
	    */
	    
	    // la mia replace FUNZIONANTE
//	    String res = s.replace(car , '?');
//	    System.out.println("la nuova Stringa è : " + res);
	    
	   // RIMPAIZZARE USANDO LA FOR  
	    
	     char str[] = s.toCharArray(); 
	     
	     int i = 0;
	     for(char next : str) {
	    	 if(next == car ) {
		    		str[i]='?';
		    	}
	    	 i++;
	    	  
	      }
	      System.out.println(str);
	      
//	    for(int i=0 ; i < s.length(); i++) {
//	    	if(str[i] == car ) {
//	    		str[i]='?';
//	    	}
//	    }
// 
//	   // System.out.println(str);
//	}
//     
}
