package test;

import codice.Calcolatore;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Le stampe che ho messo nei metodi di test servono SOLAMENTE a farvi vedere
 * la sequenza di esecuzioni dei metodi @Before e @After rispetto ai metodi @Test
 * Dalle classi di test NON si devono fre STAMPE!!!!
 * I metodi @Befor e e @After NON devono avere assert...  perche' NON sono metodi di
 * test.
 * Notate anche che calcolatoreSt NON e' usato. Anche questo NON si deve fare. Qua
 * serve solo a far vedere che nel @BeforeAll posso solo accedere a variabili static.
*/

class BeforeAfterEachAllTest {

	private Calcolatore calcolatore;
	private static Calcolatore calcolatoreSt;

	@BeforeAll
	public static void setup() {
		calcolatoreSt = new Calcolatore();
		System.out.println("Chiamato BeforeAll setup()");

	}

	@AfterAll
	public static void teardown() {
		System.out.println("Chiamato AfterAll teardown()");

	}

	@BeforeEach
	public void initEach() {
		calcolatore = new Calcolatore();
		System.out.println("Chiamato BeforeEach initEach()");
	}

	@AfterEach
	public void teardownEach() {
		System.out.println("Chiamato AfterEach teardownEach()");
	}

	@Test
	void addNumber() {
		System.out.println("Test per addNUmber");
		assertEquals(2, calcolatore.add(1, 1), "1 + 1 uguale a 2");
	}

	@Test
	void multiplyNumber() {
		System.out.println("Test per multiplyNUmber");
		assertEquals(56, calcolatore.multiply(7, 8), "7 * 8 uguale a 56");
	}

	@Test
	void divideIntInt() {
		System.out.println("Test per divideIntInt");
		assertEquals(0, calcolatore.divide(7, 9), "7 / 9 uguale a 0");
	}

	@Test
	void divideIntFloat() {
		System.out.println("Test per divideIntFloat");
		assertEquals(0.7777, calcolatore.divide(7, (float) 9), 0.0001, "7.0 / 9.0 uguale a 0.777777777777778");
	}

	@Test

	void divideFloatInt() {
		System.out.println("Test per divideFloatInt");
		assertEquals(0.7777, calcolatore.divide((float) 7, 9), 0.0001, "7.0 / 9.0 uguale a 0.777777777777778");
	}
}
