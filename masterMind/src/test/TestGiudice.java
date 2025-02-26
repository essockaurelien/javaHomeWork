package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import codice.Giudice;

class TestGiudice {

	@Test
	void testValida(){
		assertTrue(Giudice.valida("3617"));
		assertFalse(Giudice.valida("361789"));
		assertFalse(Giudice.valida("36"));
		assertFalse(Giudice.valida(""));
		assertTrue(Giudice.valida("3124"));
	}
	
	@Test
    void testRepeatCharater() {
	   
	   assertFalse(Giudice.repeatCharater("2540")); 
	   assertTrue(Giudice.repeatCharater("2208"));
	   assertEquals(Giudice.repeatCharater("2080"),true);
	   assertEquals(Giudice.repeatCharater("2055"),true);
	}
	
	@Test
	void testNumBulls() {
	 
		//assertEquals(Giudice.numBulls("2055","9584"),-1);
		//assertEquals(Giudice.numBulls("58763","9584"),-1);
		assertEquals(Giudice.numBulls("2587","9587"),3);
	}
	
	@Test
	void testNumMaggots() {
     
		assertEquals(Giudice.numMaggots("5423","2531"),3);
		assertTrue(Giudice.numMaggots("5423","2534")==4);
		//assertEquals(Giudice.numMaggots("5423","2511"),-1);
		//assertEquals(Giudice.numMaggots("50423","2531"),-1);
	}
	
	/*
    @Test
    void testGenTargetRandom() {
        
    	String target = Giudice.genTargetRandom();
    	String guess = "2541";
    	
    	int numBulls = Giudice.numBulls(guess, target);
    	int numMaggots = Giudice.numMaggots(guess, target);
    	
    	System.out.println("numBulls: " +numBulls);
    	System.out.println("numMaggots: " +numMaggots); 
    }
    */
    @Test 
    void testComb() {
    	ArrayList<String> tutteLeStringhe = new ArrayList<String>();
    	ArrayList<String> tutteValide = new ArrayList<String>();
    	ArrayList<Character> CHARS = new ArrayList<Character>(
    			Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
    	
    	
    	tutteLeStringhe = Giudice.comb(4,CHARS);
    	tutteValide = Giudice.combValide(tutteLeStringhe);
    	int conta=0;
    	int contare=0;
         for(String y: tutteLeStringhe) {
        	   contare++;
          }
         System.out.println("tutteLeStringhe:" +contare);
        for(String y: tutteValide) {
          conta++;
         }
        System.out.println("leValide:" +conta);
    	}
        
    @Test
    void testCkTargetTnt() {
    	int conta=0;
    	ArrayList<String> tutteLeStringhe = new ArrayList<String>();
    	ArrayList<String> tutteValide = new ArrayList<String>();
    	ArrayList<Character> CHARS = new ArrayList<Character>(
    			Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
    	
    	
    	tutteLeStringhe = Giudice.comb(Giudice.LUNGHEZZA,CHARS);
    	tutteValide = Giudice.combValide(tutteLeStringhe);
    	
    	//boolean possible = Giudice.
           	
    } 
}

