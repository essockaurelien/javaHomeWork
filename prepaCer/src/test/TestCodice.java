package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codice.Cerchio;
import codice.CerchioException;
import codice.MainCerchio;
import codice.Punto;

class TestCodice {

	@Test
	void testCostruttoreCerchio() throws CerchioException {
		Punto p = new Punto(3,8);
     Cerchio cer = new Cerchio(p,5);
     
     CerchioException e1 = assertThrows(CerchioException.class, ()->
     cer.contenuto(2, 6));
     
     assertEquals(e1.getMessage(),"non sono contenuto nel Cerchio.");
     
     MainCerchio main = new MainCerchio();
     
     main.run();
	}

}
