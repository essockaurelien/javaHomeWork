package rubrica;

import java.util.ArrayList;
import java.util.Iterator;

public class Rubrica implements Iterable<Contatto>{
	
	private String NOME;
	private int MAXDIM;
	public static int numRubrica;
	private ArrayList<Contatto> rubrica;
	
	
	public Rubrica(String nome, int maxDim) {
		this.NOME = nome;
		this.MAXDIM = maxDim;
		rubrica = new ArrayList<Contatto>(); 
		numRubrica++;
	}   
	
	public Rubrica(String nome) {
		this(nome,5);
	}
	
	public String getNOME() {
		return NOME;
	}

	public int aggiungi(Contatto a) throws RubricaException{
	   	
	    if(!rubrica.contains(a) && rubrica.size()<MAXDIM) {
	    	rubrica.add(a);
	    	return 1;
	    	}
	    	throw new RubricaException("già contenuto");
	    	
	    	
	}
	
	public int aggiungi(String nome, String email) throws RubricaException, ContattoException { 
		
		Contatto nuovo = new Contatto(nome,email);
		
		if(!rubrica.contains(nuovo) && rubrica.size()<MAXDIM) {
		rubrica.add(nuovo);
		return 1;	
		}
		throw new RubricaException("già contenuto");
	}
	/* in realità il controllo va fatto sull'email */
	public int aggiungi(String nome) throws RubricaException, ContattoException{
      
		Contatto nuovo = new Contatto(nome);         
		rubrica.add(nuovo);
		return 1;
	}
	
	public ArrayList<Contatto> cercaPerNome(String name){
		
		ArrayList<Contatto> nuovo = new ArrayList<Contatto>();
		
		for(Contatto y: rubrica){
			if(y.getNome() == name){
				nuovo.add(y);
			}
		}
		return nuovo;
	}
	
    public ArrayList<Contatto> cercaPerEmail(String email){
		
		ArrayList<Contatto> nuovo = new ArrayList<Contatto>();
		
		for(Contatto y: rubrica){
			if(y.getEmail() == email){
				nuovo.add(y);
			}
		}
		return nuovo;
	}
	
    public int sizeRubrica(Rubrica rub){
    	return sizeRubrica(rub);
    }	
	
	public int contaContatti() {
	 int cnt=0;
    	for(Contatto y: rubrica) {
    		if( y.getEmail() != null ) {
    			cnt++;
    		}
    	}
    	return cnt; 
	}
	
	
//	public static boolean ripetuti(Rubrica rubrica){
//		for(int i=0; i<=rubrica.length; i++){
//		ArrayList<Contatto> res = rubrica.cercaPerEmail(i.getEmail());
//		if (res.size() > 1) return true;
//		}
//		return false;
//		}


	@Override
	public Iterator iterator() {
		
		return null;
	}
}
