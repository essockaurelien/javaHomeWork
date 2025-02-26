package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codice.Buffer;
import codice.BufferLimitato;
import codice.EccezioneBuffer;

class TestBuffer {

	@Test
	void testCostruttore() {
		Buffer b = new Buffer();
		
		EccezioneBuffer e1 = assertThrows(EccezioneBuffer.class, ()->
		b.get());
		
		assertEquals("buffer vuoto",e1.getMessage());
	}
	
	@Test 
	void testPutNumEl() throws EccezioneBuffer {
		Buffer b2 = new Buffer();
		
		b2.put("aurelien");
		b2.put("essock");
		assertEquals(b2.get(),"aurelien");
		assertEquals(b2.nunEl(),2);
		
		//System.out.println(b2.toString());
	}
	
	@Test
	void testCostruttoreBufferL() {
		BufferLimitato bL = new BufferLimitato(4);
		
		assertEquals(bL.nunEl(),0);
	}
	
	@Test
	void testCostruttoreBufferLVuoto() {
		BufferLimitato bV = new BufferLimitato();
		
		assertEquals(bV.limite,3);
	}
	
	@Test
	void testPutBufferL() throws EccezioneBuffer {
		BufferLimitato bP = new BufferLimitato(4);
		
		bP.put("aurelien");
		bP.put("essock");
		bP.put("babel");
		bP.put("AnneMarlyse");
		
		 EccezioneBuffer e2 = assertThrows(EccezioneBuffer.class, ()->
		 bP.put("mamma"));
		
		 assertEquals(e2.getMessage(),"buffer pieno");
	}
	
	@Test
	void testToStringBufferL() throws EccezioneBuffer {
        BufferLimitato bP = new BufferLimitato();
		
		bP.put("aurelien");
		bP.put("essock");
		bP.put("babel");
		EccezioneBuffer e3 = assertThrows(EccezioneBuffer.class, () ->
		bP.put("AnneMarlyse"));
		
		//System.out.println(bP.toString());
		assertEquals(bP.toString(),"aurelien"+"\n"+"essock"+"\n"+"babel"+"\n"+"limite :"+"3");
	   }
    }
