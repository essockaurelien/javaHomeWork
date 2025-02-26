package codice;


public class Umano extends Giocatore{

	public Umano() {
		super();
	}
	
	
	@Override
	public String genGuess() {
		String guess = Input.readString();
	  if(Giudice.valida(guess) == true) {
	     return guess;
	  }else return genGuess();
	}

	@Override
	public String genTarget() {
		String target = Input.readString();
		if(Giudice.valida(target) == true){
		return target;
		}else return genTarget();
	}
	

}
