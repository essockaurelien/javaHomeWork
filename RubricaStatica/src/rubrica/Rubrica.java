package rubrica;

import java.util.ArrayList;

public class Rubrica {
	private static ArrayList<String> rubrica;
	public static final int MAX_DIM = 6;
	
	public static void crea() {
		rubrica = new ArrayList<String>();		
	}

	public static int numEls() {
		return rubrica.size();
	}

	public static void svuota() {
		rubrica.clear();		
	}

	public static int aggiungi(String contatto) {
		if(rubrica.size() >= MAX_DIM)
			return -1;
		if(rubrica.contains(contatto)) 
			return 0;
		rubrica.add(contatto);
		return 1;
	}
	
	public static ArrayList<String> ricerca(String prefisso) {
		ArrayList<String> ris = new ArrayList<String>();
		for(String next: rubrica) 
			if(next.startsWith(prefisso))
				ris.add(next);
		return ris;		
	}
	
	//true se è stato eliminato qualcosa; false altrimenti
	public static boolean elimina(String prefisso) {
		return rubrica.removeAll(ricerca(prefisso));
	}
	
}
