package esempiPrimi;

import jbook.util.Input;

/*
 * 4) Scrivere un programma che legge una stringa s e un carattere c e 
stampa la stringa ottenuto rimpiazzando in s tutte le occorrenze di c con '?' 
*/

public class RimpiazaCarattere {

	public static void main(String[] args) {

		System.out.println("Dammi una Stringa:");
		String s = Input.readString();
		System.out.println("Adesso aspetto un carattere:");
	    char car = Input.readChar();
	    
	    
	      char str[] = s.toCharArray();     

	    for(int i=0 ; i < str.length(); i++) {
	    	if(str[i] == car ) {
	    		str[i]='?';
	    	}
	    }
	    
	    System.out.println(str);
	}

}
