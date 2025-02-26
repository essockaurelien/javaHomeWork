package codice;

import java.util.ArrayList;

/**
 * Questa classe gestisce tanti Agende.
 * 
 * @param agende ArrayList di Agenda 
 * @author essock
 * */
public class GestoreAgende {
	
	public static ArrayList<Agenda> agende = new ArrayList<>(); 

	/**
	 * Avendo il nome la creaNuovoAgenda genera un
	 *  nuovo Agenda se non c'è già uno con lo stesso nomeAgenda in agende del Gestore.
	 * 
	 * 
	 * @param nomeAgenda del Agenda da creare.
	 * @return 
	 * @throws AgendaException se il nuovo Agenda da inserire ha il nome uguale ad uno già presente nella lista delle agende
	 * @throws GestorException 
	 */
	public static Agenda creaNuovaAgenda(String nomeAgenda) throws GestorException {
		Agenda agenda = new Agenda(nomeAgenda);
		for(Agenda y: agende) {
			if(y.getNomeAgenda().equals(nomeAgenda)){
			throw new GestorException("Agenda ne creata ne inserita: una con questo nome è già stata inserita!! cambiare nome!!");
		   }		
		}
		agende.add(agenda);
		return agenda;
	}
	
	
	/**
	 * cancella un Agenda nella ArrayList del Gestore avendo il nome. 
	 * 
	 * 
	 * @param nomeAgenda Agenda da cancellare.
	 */
	public static void cancellaAgenda(String nomeAgenda) {
		for(Agenda agenda:agende) {
			if(agenda.getNomeAgenda().equals(nomeAgenda)) {
				agende.remove(agenda);
				break;
			}
		}
	}
	
	/**
	 * seleziona e restituisce un Agenda avendo suo nome.
	 * 
	 * @param nomeAgenda agenda desiderato. 
	 * @return Agenda desiderato se esiste altrimenti null.
	 * 
	 */
	public static Agenda selezionaAgenda(String nomeAgenda) {
		for(Agenda y:agende) {
			if(y.getNomeAgenda().equals(nomeAgenda))
				return y;
		}
		return null;
	}
	
	/**
	 * stampa a console tutte le Agenda.
	 * 
	 */
	public static void stampaAgende(){
		for(Agenda y: agende) {
			System.out.println(y.getNomeAgenda());
		 for(Appuntamento p: y.getAppuntamenti()) {
    		 System.out.println(p.toString());
    	 }
	  }
	}
	
	
	/**
	 * pulisce il gestore una volta chiamato.
	 */
	public static void  clear() {
		agende.clear();
	}

	/**
	 * 
	 * @return tutte le Agende de gestoreAgende.
	 */
	public static ArrayList<Agenda> getAgende() {
			return agende;
			}
}
