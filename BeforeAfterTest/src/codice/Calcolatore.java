package codice;

import java.util.ArrayList;

public class Calcolatore {
	 
	private static ArrayList<Integer> risultati;
	
	public int add(int a, int b) {
        return a + b;
    }
	
	public int multiply(int a, int b) {
        return a * b;
    }
	
	public int divide(int a, int b) {
        return a / b;
    }

	public float divide(float a, int b) {
        return a / b;
    }
	
	public float divide(int a, float b) {
        return a / b;
    }
	
}