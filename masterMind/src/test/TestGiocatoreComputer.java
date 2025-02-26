package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import codice.Computer;
import codice.Giocatore;
import codice.Giudice;
import codice.Tentativo;

public class TestGiocatoreComputer {

	
	/*
	 * Per fare i test della classe Giocatore è necessario
	 *  avere un oggetto di una
        delle sue sottoclassi concrete!
        Testate
        costruzione
        metodo inizializza
        addTentativo e
        stringaTentativi
        di Umano e di Computer.
        I test non sono adatti a testare un’interfaccia
        utente, perchè in quel caso
        NON possono essere automatizzati per cui testerete
        la genTarget e
        genGuess solo della classe Computer!
	 * */
	@Test
	void testCostruttoreGiocatoreComputer() {
		Giocatore Aure = new Computer();
		
		assertEquals(Aure.getTarget().length(),4);
		System.out.println(Aure.getTarget());
	}
	
	@Test
	void testInizializzaGiocatoreComputer() {
		
	}
    
	@Test
	void testAddTentativoGiocatoreComputer() {
		Giocatore Target = new Computer();
		Giocatore Guess = new Computer();
		
		int bull1 = Giudice.numBulls(Guess.getTarget(), Target.getTarget());
		int maggot1 = Giudice.numMaggots(Guess.getTarget(), Target.getTarget());
		
		//Tentativo t1 = new Tentativo(Guess.getTarget(),bull1,maggot1);
		
		Target.addTentativo(Guess.getTarget(),bull1,maggot1);
		
		String a = Target.stringTentativi();
		System.out.println(a);
	}
	
	@Test
	void testStringaTentativiComputer() {
		Giocatore Target = new Computer();
		Giocatore Guess = new Computer();
		
		int bull1 = Giudice.numBulls(Guess.getTarget(), Target.getTarget());
		int maggot1 = Giudice.numMaggots(Guess.getTarget(), Target.getTarget());
		
		Tentativo t1 = new Tentativo(Guess.getTarget(),bull1,maggot1);
		
		Target.tentativi.add(t1);
		
		int bull2 = Giudice.numBulls(Guess.getTarget(), Target.getTarget());
		int maggot2 = Giudice.numMaggots(Guess.getTarget(), Target.getTarget());
	    
		Tentativo t2 = new Tentativo(Guess.getTarget(), bull2,maggot2);
		
		Target.tentativi.add(t2);
		
		assertEquals(Target.tentativi.size(),2);
		
	}
	
	@Test
	void testGenTargetComputer() {
		//String guess = Computer.genGuess
	}
	
	@Test
	void testGenGuessComputer() {
		
	}
	
	
}
