
 �package IOinJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class LeggiScriviOggetti {

	public static void leggiScriviOggetti() throws FileNotFoundException, IOException, ClassNotFoundException {
		Persona p1 = new Persona("Paolo", "Rossi");
		// SCRIVE l’oggetto in un FILE BINARIO tramite la serializzazione
		ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("persone.dat"));
		fbinarioOut.writeObject(p1);
		fbinarioOut.flush();
		fbinarioOut.close();
		// LEGGE l’oggetto alunno salvato nel file, tramite la deserializzazione
		ObjectInputStream fin = new ObjectInputStream(new FileInputStream("persone.dat"));
		Persona p2 = (Persona) fin.readObject();
		// Visualizza l’oggetto sul monitor, sfruttando (implicitamente) il suo metodo
		// toString() System.out.println(p2);
	}

}

class Persona implements Serializable {
	private String nome;
	private String cognome;

	Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public String toString() {
		return nome + " " + cognome;
	}
}