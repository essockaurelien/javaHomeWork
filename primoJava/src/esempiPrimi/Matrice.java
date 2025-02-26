package esempiPrimi;

import jbook.util.Input;

/*
 * 3) Scrivere un programma nel quale si definisce un array bidimensionale 
di interi di dimensione 5 x 3 si riempie di valori letti da tastiera e poi la si 
stampa per righe e per colonne. (Usare costanti per le dimensioni.)
*/

public class Matrice {

	public static void main(String[] args) {
		
		int a[] []  = new int [5] [3];
        
        for(int i=0; i<5; i++) {
        	for(int j=0; j<3; j++) {
        		System.out.print("Dammi elt pos"+ "[" + i+ j +"]" +"\n");	
        		a[i][j] = Input.readInt();
            	
            }
        	System.out.print("\n");
        }
        for(int i=0; i<5; i++) {
        	for(int j=0; j<3; j++) {
        		System.out.print(a[i][j]+ "\t");
        	}
        	System.out.print("\n");
        	
        }
        
        
  
	}

}