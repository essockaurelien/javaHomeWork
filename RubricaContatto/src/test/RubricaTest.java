package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.Test;

import rubrica.Contatto;
import rubrica.ContattoException;
import rubrica.Rubrica;
import rubrica.RubricaException;

public class RubricaTest {
   
	@Test
	public void testCostruttori() {
		Rubrica r1 = new Rubrica("Aurelien");
		
		assertEquals(r1.getNOME(),"Aurelien");
	}
	
	
	@Test
	public void testAggiungi() throws RubricaException, ContattoException {
		Rubrica r2 = new Rubrica("Aurelien");
		
		Contatto C1 = new Contatto("lion","essock.aurelien@yahoo.com");
		
				//r2.aggiungi(C1);
		assertEquals(r2.aggiungi(C1),1);
	}
	
	@Test
	public void testCercaPerNome() throws RubricaException, ContattoException{
		Rubrica r1 = new Rubrica("lon");
		
		Contatto C0 = new Contatto("lhwson", "essockaurelien@yahoo.com");
		Contatto C1 = new Contatto("lbson", "esock.aurelien@yahoo.com");
		Contatto C2 = new Contatto("lon", "essock.aurelienr@yahoo.com");
		Contatto C3 = new Contatto("lon", "essock.aurelienr@yahoo.com");
		Contatto C4 = new Contatto("lon", "es.aurelienr@yahoo.com");
		assertEquals(r1.aggiungi(C0),1);
		assertEquals(r1.aggiungi(C1),1);
		assertEquals(r1.aggiungi(C2),1);
		assertEquals(r1.aggiungi(C4),1);
		//r1.aggiungi(C3).getMessage();
		//r1.aggiungi(C4);
		
		ArrayList<Contatto> ritornato;
		    int cnt=0;
	    ritornato = r1.cercaPerNome("lon");
	    for(Contatto y: ritornato) {
	    	cnt++;
	    }
	    
	    assertEquals(cnt,2);
	  //int a = sizeRubrica(ritornato);
	  //int a = ritornato.sizeRubrica(ritornato);
	  //assertEquals(a,1);
		
	}
	
}
