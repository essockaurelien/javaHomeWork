package rubrica;

public class RubricaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RubricaException(String string) {
		super();
	}
	
	
	/*
	 *       Persistenza
	 *       
	 * la classe File è una Utilities 
	 *   ->per gestire i File o stream anche
	 *   ->
	 * Costrutti e accorgimenti utili
	 *    File(File parent, String child)
	 *    File(String path)  
	 *    File(String parent, String child)
	 *     
	 * Serializzazione(interfacce)
	 *    -> read (legge un Oggetto(i suoi campi))
	 *    -> write(scrive su Oggetto(sui suoi campi))
	 *    
	 *    -> implements Serialable implica scrivere il metodo
	 *       che scrive e legge gli Oggetti
	 *       
	 *    ->    
	 *    
	 * */
	
	
	
	public RubricaException(String string, int a) {
		super();
		//.x 
	}
	
}
