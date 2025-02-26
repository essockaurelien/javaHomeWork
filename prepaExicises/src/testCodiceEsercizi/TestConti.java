package testCodiceEsercizi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exo2.Conto;

public class TestConti {

	@Test
	void testCostruttoreUnoParConto() {
		Conto Essock = new Conto(685);
		
		assertEquals(Essock.saldo(),685);
	}
	
}
