 package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import rubrica.Rubrica;
import rubrica.RubricaException;

class RubricaTest {
	
	@Test 
	public void testCostruttoreCompleto() {
		Rubrica r1 = new Rubrica("Amico",4);
		
		assertEquals(r1.NOME,"Amico");
	}
	
	@Test
	void testCostruttoreSoloNome() {
		Rubrica r2 = new Rubrica("");
		
		assertEquals("",r2.NOME);
	}
	
	@Test 
	void testCostruttoreSoloMaxDim(){
		Rubrica r3 = new Rubrica(6);
		
		assertEquals(6,r3.MAXDIM);	
	} 
	/*
	@Test 
	void testUltimoSuCostruttori() {
		Rubrica r4 = new Rubrica("Aurelien",6);
		
		assertEquals(r4.NOME,"Aurelien");
		assertEquals(6,r4.MAXDIM);
		assertEquals(4,r4.getNumRubriche());
	}
	*/
	@Test
	void testAggiungi() throws RubricaException{
		
		Rubrica r1 = new Rubrica("Aurelien",6);
		Rubrica r2 = new Rubrica("Essock",5);
		Rubrica r3 = new Rubrica("Babel");
		
		String nomeR1 = r1.NOME;
		assertEquals(nomeR1,"Aurelien");
		
		int dim = r1.MAXDIM;
		assertEquals(dim,6);
		
		int numRubrica = r2.getNumRubriche();
		assertEquals(numRubrica,3);
		
		//assertEquals(r1.NOME,r2.NOME);
		assertEquals(r2.getNumRubriche(),r1.getNumRubriche());
		try {
		r3.aggiungi("Aurelien");
		r3.aggiungi("Luca");
		r3.aggiungi("Aurelien");
		}catch (RubricaException r) {
			System.out.println(r.getMessage());
		}
		//assertEquals(1,ris);
		assertEquals(2,r3.numEl() );
		
		String risult = r3.toString();
		//assertEquals("Luca,Aurelien,",risult);
		//String elenco = r
		
	}
	
	
	@Test
	void testCerca() throws RubricaException  {
		Rubrica r1 = new Rubrica("Aurelien",6);
		r1.aggiungi("Babel = 34770637731503");	
		r1.aggiungi("Babel = 3477928063773");	
		r1.aggiungi("Babel = 34770633574773");	
		
	    boolean  a = r1.elimina("B");
	    
	    assertEquals(a,true);
	  //  r1.cerca("Ba");
	
	}
	
	
	@Test 
	void testToString() {
		Rubrica r5 = new Rubrica("Marlysa",6);
		Rubrica r6 = new Rubrica("Elisabeth",5);
		
		try {
			r5.aggiungi("");
		} catch (RubricaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
