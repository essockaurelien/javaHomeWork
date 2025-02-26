package codice;

public class Tentativo {
	
	private String guess;
	private int numBulls;
	private int numMaggots;
	
	public Tentativo(String guess, int numBulls, int numMaggots) {
		
		this.guess = guess;
		this.numBulls = numBulls;
		this.numMaggots = numMaggots;
	}

	@Override
	public String toString() {
		return "Tentativo [guess=" + guess + ", numBulls=" + numBulls + ", numMaggots=" + numMaggots + "]";
	}

	public String getGuess() {
		return guess;
	}

	public int getNumBulls() {
		return numBulls;
	}

	public int getNumMaggots() {
		return numMaggots;
	}
	
	    
           	
	
}
