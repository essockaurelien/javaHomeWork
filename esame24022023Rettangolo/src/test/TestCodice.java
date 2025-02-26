package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codice.Rettangolo;


class TestCodice {

	@Test
	void testCostruttoreSettersGetters() {
		
		Exception e1 = assertThrows(Exception.class, ()->
		new Rettangolo(0, 0));
		
		assertEquals(e1.getMessage(),"rettangolo ha base maggiore di zero");
		
		Exception e2 = assertThrows(Exception.class, ()->
		new Rettangolo(1, 0));
		
		assertEquals(e2.getMessage(),"rettangolo ha altezza maggiore di zero");
		
	}

	@Test
	void testAreaPerim() throws Exception {
		Rettangolo ret = new Rettangolo(4, 8);
		
		assertEquals(ret.area(),32);
		assertEquals(ret.perimetro(),24);
	}
	
	@Test
	void testConfronta() throws Exception {
		Rettangolo ret = new Rettangolo(5, 9);
		Object objO = new Object();
		Object objRet = new Rettangolo(1, 2);
		Object objRetA = new Rettangolo(22, 9);
		Object objRetUgual = new Rettangolo(5, 9);
		
		assertEquals(ret.confronta(objO), -1);
		assertEquals(ret.confronta(objRet), -1);
		assertEquals(ret.confronta(objO), -1);
		assertEquals(ret.confronta(objRetA), 1);
		assertEquals(ret.confronta(objRetUgual), 0);
	}
}
