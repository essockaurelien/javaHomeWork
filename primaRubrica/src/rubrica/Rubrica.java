package rubrica;

import java.util.ArrayList;

public class Rubrica {

	
	private static ArrayList<String> rubrica;
	public static final int MAX_DIM = 3;
	
	
	public static void crea() {
		rubrica = new  ArrayList<String>();
	}
	
	public static int numEl() {
		return rubrica.size();
	}
	
	public static void svuota() {
		rubrica.clear();
	}

	/*
	 * Aggiunge una nuova stringa alla Rubrica
	 * */

	public static int agguingi(String string) {
    if(rubrica.contains(string)) return 0;
    if(rubrica.size()>=MAX_DIM) return -1;	
		rubrica.add(string);
		return 1;
	}

	/**
	 * cerca in base ad una Stringa nella Rubrica 
	 * torna true se trova false altrimenti
	 */
	
	public static boolean ricerca(String string) {
		if(rubrica.contains(string)) return true;
		else return false;
	}
	

	/*Scrivere il metodo di cerca di uno/piu carattere nelle stringhe della Rubrica 
	 * ed appena ne trova una la salva in un altro ArrayList */	

     // trasformando in Array of Character	
	
	public static ArrayList<String> cercaPerCarattere(char iniziaPer){
		
		ArrayList<String> ary = new ArrayList<String>() ;
		
		for(String i : rubrica) {
			char str[] = i.toCharArray();
				if(str[0] == iniziaPer) {
					ary.add(i);
				}
	}
		return ary;
  }
	
	/* 
	Scrivere il metodo di eliminazione dalla Rubrica. Il metodo elimina ha il
	seguente prototipo
	public static boolean elimina ( String s )
	e deve rimuovere dalla rubrica tutte le stringhe che iniziano per s e ritornare
	true se elimina almeno una stringa e false altrimenti
	Pensare ai test da fare!
    */
	public static boolean elimina(char car) {
		
		boolean elim = false;
		//int cont = 0; 
		
		for(String i: rubrica) {
		   char str[] = i.toCharArray();
		   if(str[0] == car) {
			rubrica.remove(i);
			elim = true;
		   }
		   //	cont++;
		}
		
		return elim;
	}
	
	/*
	public static boolean eliminaEl(String string){
		  return rubrica.removeAll(ricerca(string ));
		  }
	*/
	/*Scrivere il metodo di cerca di uno/piu carattere nelle stringhe della Rubrica 
	 * ed appena ne trova una la salva in un altro ArrayList */
     
	//con la indexof();    
	
	public static ArrayList<String> cercaPerQualsiasiPos(String string){
		
		ArrayList<String> ary = new ArrayList<String>();
		
		for(String y: rubrica) {
			
			if(y.indexOf(string) != -1) {
				ary.add(y);
			}
		}
	return ary;	
	}
	
	/*
	 * package rubricaOggetto;

import java.util.ArrayList;

public class Rubrica {

	private ArrayList<String> rubrica;
	public final String NOME;
	public final int MAXDIM;
	
	private static int numRubriche=0;
	
	


	public Rubrica(String nome, int maxDim) {
		this.NOME = nome;
		this.MAXDIM = maxDim;
		numRubriche++;
	}
	
	public Rubrica(String nome) {
		this(nome,4);
	}
	
	public Rubrica(int maxDim) {
		this("ok",maxDim);
	}
	
	
	
	
}
	 * 
	 * */
	
	
	
	
	
	
	
}/*Passiamo al metodo ricerca. Deve ritornare una lista ArrayList<String>.
Come fare i test
1 Inserire un po’ di elementi
2 Poi cercare e testare che venga ritornato il numero giusto di elementi
3 Provate la ricerca nella rubrica vuota/ piena
4 Mettendo un elemento in prima/ultima posizione
IMPORTANTE: I metodi di test devono essere INDIPENDENTI perchè non è assicurato
un ordine di VALUTAZIONE. Si sa solamente che @BeforeEach è eseguito prima di ogni
metodo @Test*/
