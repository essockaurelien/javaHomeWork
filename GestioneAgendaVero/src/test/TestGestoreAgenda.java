package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codice.Agenda;
import codice.AgendaException;
import codice.GestorException;
import codice.GestoreAgende;

class TestGestoreAgenda {

	@Test
	void testCreaNuovaAgenda() throws GestorException{
		GestoreAgende.creaNuovaAgenda("essoc");
		assertEquals(1,GestoreAgende.getAgende().size());
		
		GestorException e = assertThrows(GestorException.class, ()->
		GestoreAgende.creaNuovaAgenda("essoc"));
		
		assertEquals(e.getMessage(),"Agenda ne creata ne inserita: una con questo nome è già stata inserita!! cambiare nome!!");
	}
	
	@Test
	void testSelezionaAgenda() throws GestorException{
	  GestoreAgende.clear();
	  
	  GestoreAgende.creaNuovaAgenda("essoc");
	  GestoreAgende.creaNuovaAgenda("essoco");
	
	  Agenda agend = GestoreAgende.selezionaAgenda("essoc"); 
	  
	  assertEquals("essoc",agend.getNomeAgenda());
	  assertEquals(2,GestoreAgende.getAgende().size());
	  
	  GestoreAgende.clear();
	}
	
	@Test
	void testCancellaStampaAgende() throws GestorException {
		GestoreAgende.creaNuovaAgenda("essoc");
		GestoreAgende.creaNuovaAgenda("esso");
		GestoreAgende.creaNuovaAgenda("essock");
		
		GestoreAgende.cancellaAgenda("essoc");
		assertEquals(2,GestoreAgende.getAgende().size());
		
		GestoreAgende.stampaAgende();
		
		GestoreAgende.clear();	
	}

}
