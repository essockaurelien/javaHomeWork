package codice;

import java.util.ArrayList;

public class SmartComputer extends Computer{
    
  /*private String target;
	public ArrayList<Tentativo> tentativi;*/
	ArrayList<String> targetPossibili;
	
	
	public SmartComputer() {
		super();
		this.targetPossibili = Giudice.combValide(Giudice.comb(Giudice.LUNGHEZZA,  Giudice.CHARS));
	}
	 
	@Override
	public String genGuess() {
		String temp = "";
		for(String y: targetPossibili) {
		temp = y;
		}
		return temp;
	}
	
	public int numTargetPossibili() {
		return targetPossibili.size();
	}
	
	public boolean isTargetPossibile(String str) {
		return targetPossibili.contains(str);
	}
	
	/* che ritorna true se la stringa str è un target possibile dato il tentativo tnt 
	 * Tentativo = guess, int numBulls, int numMaggots
	 * 
	 * */
	private boolean ckTargetTnt ( String str , Tentativo tnt ) {
		return (Giudice.numBulls(tnt.getGuess(), str) == tnt.getNumBulls()) &&
			(Giudice.numMaggots(tnt.getGuess(), str)== tnt.getNumMaggots());
		}
	
	private boolean ckTargetTnts(String str) {
			for ( Tentativo t: tentativi ) {
			  if (!( ckTargetTnt (str,t))) return false;
		     }
	 return true;
	}
	
	
	
	
}
