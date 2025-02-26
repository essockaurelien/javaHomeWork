package testCodiceEsercizi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exo2.Conto;
import exo2.ContoException;

class TestContiEContiExcp {

	@Test
	void testCostruttore() {	
		Conto Essock = new Conto(685);
      assertEquals(Essock.saldo(),685);
	}
	
	@Test
	void testPreleva() throws ContoException {
	  Conto Aurelien = new Conto(7512);
	  Aurelien.preleva(124);
	  
	  assertEquals(Aurelien.saldo(),(7512-124));
	}
	
  @Test
  void testExceptionPreleva() throws ContoException {
    Conto Elisbeth = new Conto(25878); 
		
    ContoException e = assertThrows(ContoException.class, () ->
	Elisbeth.preleva(57869));
	String message = e.getMessage();
	assertEquals(message,"insufficente per prelevare");
	Elisbeth.preleva(257);
	assertEquals(Elisbeth.saldo(),(25878-257));
  }
	
  @Test
  void testToString() {
	  Conto ok = new Conto(568);
	  String string = ok.toString();
	  assertEquals(ok.toString(), string);   	  
  }	 
}
