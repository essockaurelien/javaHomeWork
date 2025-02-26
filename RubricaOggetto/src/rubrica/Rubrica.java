


package rubrica;
import java.util.ArrayList;

public class Rubrica {
		
		private ArrayList<String> rubrica = new ArrayList<String>();
		public final String NOME;
		public final int MAXDIM;
		
		private static int numRubriche=0;
		

		public static int getNumRubriche() {
			return numRubriche;
		}
																																																																																																																																																										
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
		
		public static int numRubrica() {
			return Rubrica.numRubriche;
		}
		
		public int aggiungi(String string) throws RubricaException {
			
			if(!rubrica.contains(string)) throw new RubricaException("già contenuto");
		    if(rubrica.size() <= MAXDIM) throw new RubricaException("dimMax raggiunta");
			rubrica.add(string);
			return 1;
		}

		
		public String toString() {
			String toString = "";
			
			for(String i: rubrica) {
			   toString += i+","; 
			}
			return toString;
                
		}
		
		public int numEl() {
			return rubrica.size();
		}
		
		/*
		 * il metodo elimina 
		 * */
		public  boolean elimina ( String s) {
			 int r =0;
			for(int i= rubrica.size()-1; i>=0;i--) {
			       if(rubrica.get(i).startsWith(s)) {
			    	   rubrica.remove(i);
			    	   r++;
			    	   }	
			       }
			if(r==0) return false;
			return true;
			}
			
			
        /*
         * cercare data una stringa la sequenza dei contatti 
         * che iniziano per questa stringa
         * */		
		public ArrayList<String> cerca(String string){
			
			ArrayList<String> arry = new ArrayList<>();
			for(String y: rubrica) {
				
				if(y.indexOf(string) != -1) {
					arry.add(y);
				}		
		}
			return arry;
    }		
}				