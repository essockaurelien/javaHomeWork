package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import rubrica.Contatto;
import rubrica.ContattoException;
import rubrica.Contatto.ContattoIterator;

class ContattoTest {

	@Test
	public void testCostruttore() throws ContattoException {
		
		Contatto C1 = new Contatto("Aurelien","20027012@uniupo.it");
		
		assertEquals(C1.getNome(),"Aurelien");
	}	
	/*	
   @Test
   void testScriviLeggi() throws FileNotFoundException, IOException, ContattoException {
			
	Contatto C1 = new Contatto("Aurelien","20027012@uniupo.it");
	Boolean bool = C1.scriviContatto("src\\test\\fileName");		
	assertEquals(true, bool);
		}
		
	/*	
	@Test
	void testIterator() throws ContattoException {
		Contatto C1 = new Contatto("Aurelien","20022462@uniupo.it");
		Contatto C2 = new Contatto("elien","22227012@uniupo.it");
		Contatto C3 = new Contatto("lien","28957012@uniupo.it");
		
		for(Contatto y: Contatto.ContattoIterator<Contatto>) {
				System.out.println("jg");
		}
		
	}
	*/	
		//assertEquals(C1.getEmail(),"essock.aurelien@yah@o.com");
		//C1.setNome("Babel");
		//assertEquals(C1.getNome(),"Babel");
		//int a = C1.numElTels();
		//assertEquals(a,0);	
	/*
	@Test
	void testItarate() {
	  Iterator it = new ContattoIterator<Contatto>(null);
	  
	}
	*/

	
	
	
	
 /*
	@Test 
	public void testInserimento() throws ContattoException {
		Contatto C2 = new Contatto("Essock","25547678@uniupo.it");
		
		C2.inserisciNumTel("55254555522");
		boolean a = C2.inserisciNumTel("55254555522");
		assertEquals(a,false);
	}
	
	
	@Test
    public void testNumTels() throws ContattoException {
    	
    	Contatto C3 = new Contatto("Elisa","47582569@uniupo.it");
    	
    	C3.inserisciNumTel("658");
    	C3.inserisciNumTel("2588");
    	C3.inserisciNumTel("6594");
    	
    	assertEquals(C3.numTels(),"658;2588;6594;");
    	
    }
	
	@Test
	public void testNumElTels() throws ContattoException {
	
		Contatto C4 = new Contatto("Sisko","sis@ios.it");
		
		C4.inserisciNumTel("6068858");
    	C4.inserisciNumTel("001942");
    	C4.inserisciNumTel("00258");
    		  	
	assertEquals(C4.numElTels(),3);	
	}
	
	@Test
	public void testElimina() throws ContattoException {
		
		Contatto C5 = new Contatto("JeanP", "20027012@uniupo.it");
		
		C5.inserisciNumTel("6068858");
    	C5.inserisciNumTel("001942");
    	C5.inserisciNumTel("00258");
	  
    boolean b = C5.eliminaTel("6068858");	
    	
    assertEquals(b,true);
    
    assertEquals(C5.numElTels(),2);
    assertEquals(C5.numTels(),"001942;00258;");
	}
	
	@Test
	public void matchNome() throws ContattoException {
		
        Contatto C6 = new Contatto("Ale", "ale@gmail.com");		
	
	  boolean q = C6.matchNome("Al");
	  
	  assertEquals(q,true);
	}
	
	@Test
	public void matchEmail() throws ContattoException {

		Contatto C7 = new Contatto("Henrry", "henrry@gmail.com");
		
		boolean w = C7.matchEmail("rry");
		
		assertEquals(w,true);	
	}	
*/	






}