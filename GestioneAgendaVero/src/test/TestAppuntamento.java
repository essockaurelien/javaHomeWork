package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

import codice.Appuntamento;
import codice.AppuntamentoException;

class TestAppuntamento {

	  @Test 
	  void testCostruttoreExceptionCostruttoreParseData() throws AppuntamentoException {
	  AppuntamentoException e1 = assertThrows(AppuntamentoException.class, () -> new
	  Appuntamento("30/02/2023","10:10",30,"algo","uni"));
	  
	  assertEquals("non istanziabile: " +"data sblagliata: (int)gg-(int)mm-(int)yr",e1.getMessage().toString()); 
	  
	  AppuntamentoException r = assertThrows(AppuntamentoException.class, ()-> new 
      Appuntamento("30-02-2023", "10:10", 30, "algo", "Uni"));
	  
	  assertEquals("non istanziabile: Invalid date think about leap year or not.",r.getMessage());
	  
	  AppuntamentoException y = assertThrows(AppuntamentoException.class, ()-> new 
	  Appuntamento("30-12-2022", "10:10", 30, "algo", "Uni"));
			  
	  assertEquals("non istanziabile: appointment con data precedente a quella di oggi impossible",y.getMessage());
	  
	  AppuntamentoException p = assertThrows(AppuntamentoException.class, ()-> new 
	  Appuntamento("30-12-2023", "10:s", 30, "algo", "Uni"));
	  
	  assertEquals("non istanziabile: ora sblagliata: (int)hh:(int)mm",p.getMessage());
	  
	  Appuntamento tmp = new Appuntamento("30-12-2023", "10:10", 50, "algo", "labInfo");
	  assertTrue(tmp!=null);
	  }
	  
	  @Test 
	  void testGetterSertter() throws AppuntamentoException {
		 Appuntamento appointment1 = new Appuntamento("30-12-2023","10:10",30,"algo","uni");
		 
		 assertEquals(appointment1.getDataAppuntamento(),"30-12-2023");
		 appointment1.setNomeCliente("java");
		 
		 assertFalse(appointment1.getNomePersona().equals("algo"));
	  }
	  
	  @Test
	  void testNonSovrapposti() throws AppuntamentoException {
		  Appuntamento appointment1 = new Appuntamento("20-05-2023","10:10",30,"algo","uni");
		  Appuntamento appointment2 = new Appuntamento("20-03-2023","10:35",30,"java","uni");
		  Appuntamento appointment3 = new Appuntamento("20-05-2023","10:35",30,"rete","uni");
		  
         
         AppuntamentoException m = assertThrows(AppuntamentoException.class, ()->
         appointment1.nonSovrapposto(appointment3));
         
         assertTrue(appointment1.nonSovrapposto(appointment2));
         assertEquals("non inseribilePerGuardaOra1, sovrappone uno già presente.",m.getMessage());
	  }
}
