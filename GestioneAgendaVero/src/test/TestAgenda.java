package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codice.Agenda;
import codice.AgendaException;
import codice.Appuntamento;
import codice.AppuntamentoException;


class TestAgenda {
	
	    @Test
	    void testCostruttore() {
	    	Agenda agenda0 = new Agenda("aurelien");
	    	
	    	assertEquals(agenda0.getNomeAgenda(),"aurelien");
	    	assertEquals(agenda0.getAppuntamenti().size(),0);
	    }
	    
	    @Test
	    void testInsertAppuntamenti() throws AppuntamentoException, AgendaException {
	    	Agenda agend1 = new Agenda("michaele");
	    	
	    	Appuntamento apoint1= new Appuntamento("24-03-2023","20:10",40,"manu","casa"); 
			Appuntamento apoint2 = new Appuntamento("24-03-2023","20:52",90,"babel","daLaZia");
			
			agend1.inserisciAppointment(apoint1);
			agend1.inserisciAppointment(apoint2);
			assertEquals(agend1.getAppuntamenti().size(),2);
			
			AgendaException e = assertThrows(AgendaException.class, ()->
			agend1.inserisciAppointment(new Appuntamento("24-03-2023", "20:00", 55, "chi", "dove")));
			
			assertEquals("non inseribilePerGuardaOra0, sovrappone uno già presente.",e.getMessage());
	    }
	    
	    @Test 
	    void testFileReader() throws AgendaException, AppuntamentoException {
	    	Agenda agend1 = new Agenda("office");
	    	
	    	agend1.agendaFileReader("fileGestoreTestRead.txt");
	    	assertEquals(3,agend1.getAppuntamenti().size());
	    	
	    	Agenda agend2 = new Agenda("home");
	    	
	    	AgendaException e1 = assertThrows(AgendaException.class, () ->
	    	agend2.agendaFileReader("fileGestoreTestRead"));
	    	
	    	assertEquals(e1.getMessage(),"File non raggiunto");
	    }
	    
	    @Test
	    void testFileWritter() throws AppuntamentoException, AgendaException {
	    	Agenda agenda2 = new Agenda("ripetitore");
	        
	    	Appuntamento apoint1 = new Appuntamento("24-03-2023","20:10",120,"manu","torino"); 
			Appuntamento apoint2 = new Appuntamento("24-03-2023","22:30",90,"alpha","vercelli");	
	    	
			agenda2.inserisciAppointment(apoint1);
			agenda2.inserisciAppointment(apoint2);
			
			agenda2.agendaFileWritter("fileGestoreTestWrite.txt");
			
	    }
	    
	    @Test 
	    void testModificaDati() throws AppuntamentoException, AgendaException {
	    	Agenda agenda = new Agenda("ripetitore");
	    	
	    	Appuntamento apoint1 = new Appuntamento("24-03-2023","20:10",120,"manu","torino"); 
			Appuntamento apoint2 = new Appuntamento("24-03-2023","22:30",90,"alpha","vercelli");	
	    
		    agenda.inserisciAppointment(apoint1);	
		    agenda.inserisciAppointment(apoint2);
		    
		    agenda.agendaFileReader("fileGestoreTestRead.txt");
		    
		    AgendaException e2 = assertThrows(AgendaException.class, () ->
		    agenda.modificaAppuntamento(apoint2,"24-03-2023", "20:00", 90, "alpha", "vercelli"));
	        
		    assertEquals("non inseribilePerGuardaOra0, sovrappone uno già presente.",e2.getMessage());
	    }
	    
	    @Test 
	    void ordinaAppuntamenti() throws AppuntamentoException, AgendaException {
	          Agenda agend = new Agenda("uni");
	          
	        Appuntamento apointment1 = new Appuntamento("24-04-2023","10:10",240,"retiUno","8B"); 
			Appuntamento apointment2 = new Appuntamento("24-03-2023","14:20",240,"java","A1");	
			Appuntamento apointment3 = new Appuntamento("24-03-2023","20:10",240,"retiDue","D-11"); 
			Appuntamento apointment4 = new Appuntamento("24-03-2023","07:30",120,"algoDue","lab2");	 
			Appuntamento apointment6 = new Appuntamento("24-06-2023","14:30",240,"python","lab1");	

		    agend.inserisciAppointment(apointment1);
		    agend.inserisciAppointment(apointment2);
		    agend.inserisciAppointment(apointment3);
		    agend.inserisciAppointment(apointment4);
		    agend.inserisciAppointment(apointment6);
		    
		    assertEquals(agend.getAppuntamenti().size(),5);    
	        agend.ordinaAppuntamenti();
	    }
	    	    
		@Test 
		void testcercaAppointment() throws AppuntamentoException,AgendaException { 
		  
			Agenda agend1 = new Agenda("Aurelien"); 
		  
		  Appuntamento apoint1= new Appuntamento("29-07-2023","20:10",40,"baby","casa"); 
		  Appuntamento apoint2 = new Appuntamento("29-07-2023","10:20",90,"babel","daLaZia");
		  Appuntamento apoint3 = new Appuntamento("29-07-2023", "20:51",120,"hier","Camerun"); 
		 
		  agend1.inserisciAppointment(apoint1);
		  agend1.inserisciAppointment(apoint2);
		  agend1.inserisciAppointment(apoint3);
		  
		  
		  AgendaException e4 = assertThrows(AgendaException.class, ()->
		  agend1.cercaAppuntamento("10-07-2023"));
		  
		  assertEquals(e4.getMessage(),"nessun appointment trovato");
		  
		  assertEquals(agend1.getAppuntamenti().size(),3);
		  assertEquals(agend1.cercaAppuntamento("29-07-2023").size(),3);
		  assertEquals(agend1.cercaAppuntamento("baby").size(),1);
          assertEquals(agend1.cercaAppuntamento("hier").size(),1);
    	  
	}
}

