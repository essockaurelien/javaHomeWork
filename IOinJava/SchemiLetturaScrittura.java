package IOinJava;

import java.io.*;

public class SchemiLetturaScrittura {
	public static void main(String[] a) throws IOException, ClassNotFoundException {
		System.out.println("\n***Stampa nomi dei file di questa directory!\n");
		stampaNomiFile(new File("."));
		System.out.println("\n***Legge e scrive da file\n");
		leggiScriviFile("studenti.txt", "mailinglist.txt");
		System.out.println("\n***Legge e scrive oggetti\n");
		leggiScriviOggetti();
	}

	public static void stampaNomiFile(File corrente) {
		if (corrente == null || !corrente.exists()) {
			return;
		} else if (corrente.isDirectory()) {
			String[] elenco = corrente.list();
			String padre = corrente.getAbsolutePath();
			for (String nome : elenco) {              
				nome = padre + File.separator + nome;
				stampaNomiFile(new File(nome));

			}
		} else if (corrente.isFile()) {
			System.out.println(corrente.getName());
		}
	}

	public static void leggiScriviFile(String inF, String outF) throws IOException {

		// try {
		BufferedReader in = new BufferedReader(new FileReader(inF));
		PrintWriter out = new PrintWriter(new File(outF));

		String linea = in.readLine();
		int num = 1;
		while (linea != null) {
			String[] dati = linea.split(":");
			if (dati.length >= 3) {
				String cognome = dati[0].trim();
				String nome = dati[1].trim();
				String account = dati[2].trim();
				out.printf(" %s %s <%4s@cli.di.unipi.it>,\n", nome, cognome, account); // %4s significa left-padded con
																						// spazi fino a lunghezza 4
			} else {
				System.out.println("Scarto linea n. " + num);
			}
			linea = in.readLine();
			num++;
		}
		in.close();
		out.printf("%n");
		out.close();
		System.out.println("Finito!");
		// } catch (FileNotFoundException e) {
		// gestione eccezione se non si trova il file studenti.txt

		// }
		// catch (IOException e) {
		// gestione eccezione metodi readLine e printf
		// }
	}

	public static void leggiScriviOggetti() throws FileNotFoundException, IOException, ClassNotFoundException {
		Persona p1 = new Persona("Paolo", "Rossi");
		
		// SCRIVE l'oggetto in un FILE BIANARIO tramite la serializzazione
		ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("persone.dat"));
		fbinarioOut.writeObject(p1);
		fbinarioOut.flush();
		fbinarioOut.close();

		// LEGGE l'oggetto alunno salvato nel file, tramite la deserializzazione
		ObjectInputStream fin = new ObjectInputStream(new FileInputStream("persone.dat"));
		Persona p2 = (Persona) fin.readObject();

		// Visualizza l'oggetto sul monitor, sfruttando (implicitamente) il suo metodo
		// toString()
		System.out.println(p2);

	}

	public static class Persona implements Serializable {

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
}