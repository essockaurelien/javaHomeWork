package codice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * la classe Agenda mi istanzia un Agenda avendo il nome.
 * è caratterizzata dall’avere un nome (unico) e dal contenere un insieme(ArrayList) di appuntamenti.
 * 
 * @author essock
 * */
public class Agenda implements Iterable<Appuntamento>{
	
	private String nomeAgenda;
	private ArrayList<Appuntamento> appuntamenti;

	
	/**
	 * 
	 * @param nome del Agenda
	 * @param appuntamenti dato il nome setta un new arrayList a vuoto per gli Appuntamenti dell'agenda.visibilità solo nelclasse stessa
	 */
	public Agenda(String nomeAgenda) {
		   this.nomeAgenda = nomeAgenda;
		   this.appuntamenti = new ArrayList<Appuntamento>();
	   }
      
	
	/**
	 * Dato un parametro (DataAppuntamento/nomeCliente) cerca nel Agenda sul quale è chiamato(this) tutti gli Appuntamenti relativi a quel dato.
	 * 
	 * 
	 * @param dataCliente 
	 * @return ArrayList degli Appuntamenti trovati secondo al parametro che ricevo(nomeCliente/dataAppuntamento)
	 * @throws AgendaException se non trova nessun Appuntamento con il relativo dato passato in ingresso
	 */
	public  ArrayList<Appuntamento> cercaAppuntamento(String dataPersona) throws AgendaException {
		boolean bool =false;
		ArrayList<Appuntamento> resultCerca = new ArrayList<>();
			if(!isAlpha(dataPersona)){

				for(Appuntamento y : this.appuntamenti){
					if(y.getDataAppuntamento().equals(dataPersona)) {
					   resultCerca.add(y);
					 bool = true;  
					}
				}
		      }else {
		        for(Appuntamento y : this.appuntamenti) {
		           if(y.getNomePersona().equals(dataPersona)) {
						resultCerca.add(y);	
							bool = true;
						}
					}
			}
			if(!bool) {
	        	throw new AgendaException("nessun appointment trovato");
	        }
			return resultCerca;
	}

	
	
	private boolean isAlpha(String s) {
	    return s != null && s.matches("^[a-zA-Z]*$");
	}


	private boolean insertControl(Appuntamento appointment) throws AgendaException, AppuntamentoException {
		try {  
		boolean bool = true;
		 
			for(Appuntamento y: this.appuntamenti) {
				bool = y.nonSovrapposto(appointment);
			   }
		   return bool;
    }catch(AppuntamentoException e2) {
    	throw new AgendaException(e2.getMessage());
    }
  }
    
	
	/**
	 * 
	 * inserisce nel Agenda facendo i controlli di sovrapposizione.
	 * 
	 * @param app Appuntamento da aggiungere nel Agenda
	 * @return  <b>true</b> se inserisce e <b>false</b> se già presente nel Agenda 
	 * @throws AppuntamentoException se incontrasse problemi di sovrapposizioni del suo metodo private insertcontrol che lui chiama sovrapposizioni. 
	 * @throws AgendaException se AppuntamentoException è verificato. 
	 */
    public boolean inserisciAppointment(Appuntamento app) throws AppuntamentoException, AgendaException  {
		
    	try {
    	if(insertControl(app)) {
            appuntamenti.add(app);
            return true;
		 }
    	throw new AgendaException("non inseribile.");
    	}catch(AgendaException e4) {
      throw new AgendaException( e4.getMessage());	
     }catch(AppuntamentoException e9) {
    	 throw new AgendaException(e9.getMessage());
     }
    }
    
    
    /**
     *     
     * @return string nomeAgenda  
     */
    public String getNomeAgenda() {
		return nomeAgenda;
	   }
    
    
    /**
      * 
      * @return Arraylist di tuttin gli Appuntamenti di un Agenda.
      */
    public ArrayList<Appuntamento> getAppuntamenti() {
		return appuntamenti;
	   }
   
    
   /**
    * il metodo legge gli appuntamenti su <b>File</b> e gli inserisce in un Agenda.
    * 
    * @param nomeFile file da leggere.
    * @throws AgendaException se il file non'è stato trovato(cattura una IOExceptio) / se Non valido(sovrappone ad un altro già inserito) 
    * @throws AppuntamentoException se cattura una NumberFormatException(Data(int-int-int) e Ora(int:int)
    */
    public void agendaFileReader(String nomeFile) throws AgendaException, AppuntamentoException{ 
     try {
	  File file = new File(nomeFile); 
	  BufferedReader br = new BufferedReader(new FileReader(file)); 
	  String line; 
	      while ((line = br.readLine()) != null ) {
	        String[] parts = line.split(";"); 
	  
	           if(insertControl((new Appuntamento(parts[0], parts[1], Integer.parseInt(parts[2]) , parts[3], parts[4]))) == true) {
		         this.appuntamenti.add(new Appuntamento(parts[0], parts[1], Integer.parseInt(parts[2]) , parts[3], parts[4])); 
	            }
 	      }   
	   }catch (IOException e) { 
		   throw new AgendaException("File non raggiunto");
	     }catch (NumberFormatException e) { 
		    throw new AgendaException("Durata non valida, inserire un numero intero"); 
	       } catch (AppuntamentoException e) { 
		      throw new AgendaException("Appuntamenti non validi"); 
		      } 
     }
	 
    
    /**
	  * 
	  * il metodo scrive gli oggetti Appuntamento su <b>File</b>
	  * 
	  * @param nomeFile <b> File</b> dove scrivere gli appuntamenti, se non lo trova o problemia raggiungerlo ne crea uno nuovo e scrive gli appuntamenti
	  * @throws AgendaException
	  */
    public void agendaFileWritter(String nomeFile) throws AgendaException{

    		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeFile))) {
    			for(Appuntamento y: this.appuntamenti) {
    				bw.write(y.toString());
    			} 
    		}catch (IOException e){
    			 throw new AgendaException("File non valido");
    		} 
    	}

    
      /**
       * 	
       * @param vecchio   Appuntamento da modificare.
       * @param data      nuovaData se si volesse modificare la Data
       * @param ora       nuovaOra se si volesse modificare l'Ora.
       * @param durata    durataNuova se si volesse modificare la durata 
       * @param persona   nuovoNome se si volesse cambiare il nome della persona con la quale se ha l'appuntamento. 
       * @param luogo     nuovoLuogo se si volesse cambiare il Luogo dell'Appuntamento.
       * @return          <b>true</b> se l'Appuntamenrto  nuovo può essere inserito(no sovrapposizioni  con gli altri)
       * @throws AppuntamentoException se formato dei dati dell'Appuntaamento sono sb gliati dal parseData/Ora.
       * @throws AgendaException se il nuovo sovrapponerà ad un altro.  
       */
	  public boolean modificaAppuntamento(Appuntamento vecchio, String data, String ora, int durata, String persona, String luogo) throws AppuntamentoException, AgendaException {
		    Appuntamento nuovo = new Appuntamento(data, ora, durata, persona, luogo);
		    
		    if(vecchio.equals(nuovo))
		    	return true;
		    
		    appuntamenti.remove(vecchio);
		    try {
		    for (Appuntamento appuntamento : appuntamenti) {
		      if (appuntamento.nonSovrapposto(nuovo));    
		     }
		    }catch(AppuntamentoException s){
		    	throw new AgendaException(s.getMessage());
		    }
		    appuntamenti.add(nuovo);
		    
		    return true;
	  }
	  
	  
	  /**
	   * @return an Iterator di tipo Iteratore di Appuntamento.
	   */
	  @Override
	  public Iterator<Appuntamento> iterator() {
		return appuntamenti.iterator();
	  }
	  
	  
	  /**
	   * <p>il metodo ci Ordini gli Appuntamenti di this.Agenda e ce gli restituisce in un ArrayList.</p>
	   * @return un ArrayList degli Appuntamenti di this.Agenda utti Ordinati per Data.
	   */
	  public ArrayList<Appuntamento> ordinaAppuntamenti() {
		  
		ArrayList<Appuntamento> tmp = new ArrayList<>();
		  tmp.addAll(appuntamenti);
		  
		  Collections.sort(tmp);
		  
		  for(Appuntamento y: tmp) {
			  System.out.println(y.toString());
		  }
		  return tmp;  
	  }
	
}
