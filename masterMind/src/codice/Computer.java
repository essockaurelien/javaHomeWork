
package codice;

import java.util.ArrayList;
import java.util.Random;

public class Computer extends Giocatore{

	public Computer() {
		super();
	}
	
	
	@Override
	public String genGuess() {
		return genValidCombination();
	}

	@Override
	public String genTarget(){
		return genValidCombination();
	}
	
	private String genValidCombination() {
          String app = "";
		
		Random random = new Random();
		
		while(app.length() != Giudice.LUNGHEZZA) {
			int index = random.nextInt(9+1);
			if(!(app.contains(Integer.toString(index))))
				app += Integer.toString(index);
		}
		return app;
	}
}
