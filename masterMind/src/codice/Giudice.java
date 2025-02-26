
package codice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Giudice {

	public final static int LUNGHEZZA = 4;
	public final static int TENTATIVI = 10;
	public final static ArrayList<Character> CHARS = new ArrayList<Character>(
			Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
	
	
	/*public static boolean valida(String string) ritorna true se la 
	 * stringa
     è valida e false altrimenti
    */

	public static boolean valida(String string) {
		return (string.length() == LUNGHEZZA ) && caratteriGiusti(string) && 
				repeatCharater(string) == false;
	}
	
	/*ritorna true se i caratteri sono legali quindi appartengono a CHAR
	 * */

	private static boolean caratteriGiusti(String string) {
		
		for(int i=0; i<string.length(); i++) {
			if(!CHARS.contains(string.charAt(i))) {
		      return false;
			}
		}
	  return true;
	}

	/*ritorna true se un solo carattere viene ripettuto
	 *  altrimenti ritorna false
	 * */
	
	public static boolean repeatCharater(String string) {
		
		for(int i=0; i<string.length(); i++) {
			int cnt=0;
			char app = string.charAt(i);
		  
		  for(int j=0; j<string.length(); j++) {
			  if(string.charAt(j) == app){
				  cnt++;
				  }  
		  }
		  if(cnt>1) return true;
		}
		return false;
	}
    
	/*
	public static int numBulls(String guess, String target) ritorna il
	numero di bulls di guess rispetto a target
	*/
	
	public static  int numBulls(String guess, String target) {
		
		int cnt=0;
		
			  for(int i=0; i<guess.length(); i++) {
			    if(guess.charAt(i) == target.charAt(i)){
				   cnt++;
			    }
		      }
			  return cnt;
	}
	
	/*public static int numMaggots(String guess, String target) 
	 * ritorna il
    numero di maggots di guess rispetto a target*/
	
	public static int numMaggots(String guess, String target) {
		
		        int cnt=0;
		
				 for(int i=0;i<target.length();i++){					 
					if(target.charAt(i) != guess.charAt(i)) {
					  	for(int j=0;j<guess.length();j++) {
					  		if(guess.charAt(j) == target.charAt(i))
					  			cnt++;
					  	}
					}
				}
		
		return cnt;	
    }
	
	
	public static  ArrayList<String> comb(int LUNGHEZZA, ArrayList<Character> CHARS){
		
		ArrayList<String> temp = new ArrayList<String>();
		
		if(LUNGHEZZA <= 0) {
			temp.add("");
			return temp;
		}else {
			ArrayList<String> listStr = comb(LUNGHEZZA-1,CHARS);
		  for(String s : listStr) {
			  for(char c: CHARS) {
				  temp.add(s+c);
			  }
		  }
		}
		
		return temp;
	}
	
	/* public ArrayList<String> combValide(ArrayList<String> strs)
ritorna un ArrayList<String> che contiene tutte le stringhe di strs che sono
valide
    */
	
	public static ArrayList<String> combValide(ArrayList<String> strs){
		ArrayList<String> strValid = new ArrayList<String>();
		
		for(String y: strs) {
			if(valida(y) == true) {
				strValid.add(y);
			}
		}
		return strValid;
	}
	
	
	/*
	 * 1) Il metodo
    boolean ckTargetTnt(String target,Tentativo t)
    deve ritornare true se
    Giudice.numBulls(t.getGuess(), target)== t.getNumBulls()
                           &&
    Giudice.numMaggots(t.getGuess(), target)=t.getNumMaggots()
 
    2) Il metodo
boolean ckTargetTnts(String target)
deve ritornare true se per tutti i t in tentativi abbiamo
ckTargetTnt(target,t) ritorna true
	 * */
    
	public static boolean ckTargetTnt(String target, Tentativo t) {
       		
		
		
		
		
		return true;
	}
	
	
}

     
