package codice;

import java.util.ArrayList;


public abstract class Giocatore {

	private String target;
	public ArrayList<Tentativo> tentativi;
	
	
	public Giocatore() {
		inizializza();
	}
	
	public void inizializza() {
		this.target = genTarget();
		 this.tentativi = new ArrayList<Tentativo>();
	}
	
	
	
	
	public ArrayList<Tentativo> getTentativi() {
		return tentativi;
	}

	public String getTarget() {
		return target;
	}
	
	public boolean addTentativo(String guess,int numBulls, int numMaggots){
		if(this.tentativi.size() > Giudice.TENTATIVI) 
			return false;
		Tentativo t = new Tentativo(guess,numBulls,numMaggots);
		this.tentativi.add(t);				
		return true;
	}
	
	public String stringTentativi(){
	       String app = "";
	       
	       for(Tentativo y: tentativi) {
	    	   //ap+p += y.toString();
	    	   app += y.toString()+ "\n" + "";
	       }
		return app;
	}
	
	public abstract String genGuess();
	public abstract String genTarget();
	
}




/*if(rubrica.contains(string)) return 0;
		    if(rubrica.size()>MAXDIM) return -1;
			rubrica.add(string); return  1; 
			*/