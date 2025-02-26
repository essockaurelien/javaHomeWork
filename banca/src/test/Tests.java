package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import codice.Conto;
import codice.ContoConEccezioni;
import codice.ContoConEccezioniException;

class Tests {

	@Test
	void testCostruttoreConto() {
	  Conto conto = new Conto(3000);
	 
	  assertEquals(conto.saldo(),3000); 
	}
	
	@Test
	void testDeposita() {
		Conto cnt = new Conto(3000);
		
		cnt.deposita(100);
		assertEquals(cnt.saldo(),3100);
	}
	
	@Test
	void testPrelevaPiùLaToString() throws ContoConEccezioniException {
		Conto mioConto = new Conto(3000);
	  
		mioConto.preleva(4000);
		assertEquals(mioConto.saldo(),3000);
		mioConto.preleva(250);
		assertEquals(mioConto.saldo(),2750);
		
		System.out.println(mioConto.toString());
	}
	
	@Test
	void testCostruttoreContoConE() {
		ContoConEccezioni mioConto = new ContoConEccezioni(3000);
		
		assertEquals(mioConto.saldo(),3000);
		assertEquals(mioConto.saldo(),3000);
	}
	
    @Test
    void testPrelevaCCEPiùLaToString() throws ContoConEccezioniException {
    	ContoConEccezioni mioConto = new ContoConEccezioni(300,100);
    	
    	mioConto.preleva(100);
    	assertEquals(mioConto.saldo(),200);
    	
    	ContoConEccezioniException e1 = assertThrows(ContoConEccezioniException.class, ()->
    	mioConto.preleva(150));
    	
    	assertEquals(e1.getMessage(),"contenuto andrà sotto di maxScoperto");
    	
    	System.out.println(mioConto.toString());
    }
	
	
}
