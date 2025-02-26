package codice;

import static org.junit.Assert.assertEquals;

//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.Date;

/**
 * la classe Appuntamento mi istanzia un Appuntamento passato tutti i valori(validi da parseData/Ora) in ingresso.
 * una volta creato può essere inserito in un Agenda.
 * 
 * @author essock
 * */
public class Appuntamento implements Comparable<Appuntamento> {
	
    private String dataAppuntamento; //gg-mm-aaaa
	private String orarioAppuntamento; //hh-mm
	private int durataAppuntamento;
	private String nomePersona;
	private String nomeLuogoAppuntamento;
	
	
	/**
	 * @param data  data (giorno) del appuntamento
	 * @param ora ora del l'appuntamento
	 * @param durata  durata del appuntamento
	 * @param cliente  nome della persona con chi si ha l'appuntamento
	 * @param luogo     nome del luogo del l'appuntamento
	 * @throws AppuntamentoException se i parametri per formare la data e l'ora non siano Interi(parse int è andata male)
	 */
	public Appuntamento(String data, String ora, int durata, String cliente, String luogo) throws AppuntamentoException {
		try{
            boolean boold = parseDate(data);
            boolean boolt = parseOra(ora);
            assertEquals(boold,true);
            assertEquals(boolt,true);
		}catch(AppuntamentoException e1) {
			throw new AppuntamentoException("non istanziabile: " + e1.getMessage());
		}
		
		
		
	   this.dataAppuntamento = data;
       this.orarioAppuntamento = ora;
       this.durataAppuntamento = durata;
       this.nomePersona = cliente;
       this.nomeLuogoAppuntamento = luogo;
	}
	
	public String getDataAppuntamento() {
		return dataAppuntamento;
	}
    
	
	/**
	 * non prende niente in ingresso
	 * @return String orario del appuntamento su cui viene chiamato(this.)
	 */
	public String getOrarioAppuntamento() {
		return orarioAppuntamento;
	}

	
	/**
	 * setta la dataAppuntamento su cui è chiamato(this) con quella che riceve in ingresso
	 * @param String dataAppuntamento preso in ingresso
	 */
	public void setDataAppuntamento(String dataAppuntamento) {
		this.dataAppuntamento = dataAppuntamento;
	}

	
	/**
	 * setta l'OrarioAppuntamento su cui è chiamato(this) con quello che riceve in ingresso
	 * @param orarioAppuntamento presso in ingresso
	 */
	public void setOrarioAppuntamento(String orarioAppuntamento) {
		this.orarioAppuntamento = orarioAppuntamento;
	}
    
	
	/**
	 * non prende niente in ingresso 
	 * @return int durataAppuntamento del appuntamento su cui viene chiamato(this.)
	 */
	public int getDurataAppuntamento() {
		return durataAppuntamento;
	}

	
	/**
	 * Setta la durata del appuntamento su cui viene chiamato
	 * @param int durataAppuntamento presso in ingresso 
	 */
	public void setDurataAppuntamento(int durataAppuntamento) {
		this.durataAppuntamento = durataAppuntamento;
	}

	
	/**
	 * non prende niente in ingresso
	 * @return String nomeLuogoAppuntamento
	 */
	public String getNomeLuogoAppuntamento() {
		return nomeLuogoAppuntamento;
	}

	
	/**
	 * prernde una Stringa nomeLuogoAppuntamento ed aggiorna il nome del luogo del appuntamento
	 * @param nomeLuogoAppuntamento preso in ingresso
	 */
	public void setNomeLuogoAppuntamento(String nomeLuogoAppuntamento) {
		this.nomeLuogoAppuntamento = nomeLuogoAppuntamento;
	}

	/**
	 * non prende niente in ingresso
	 * @return String nome della persona con cui si ha l'appuntamento
	 */
	public String getNomePersona() {
		return nomePersona;
	}
	
	
	/**
	 * aggiorna il nome della persona con chi si ha l'appuntamento
	 * @param nomeCliente in ingresso String
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomePersona = nomeCliente;
	}
   
	
	/**
	 * Stampa l'appuntamento istanziato ovvero tutti suoi parametri come settati
	 */
	@Override
	public String toString() {
		return "Appuntamento [dataAppuntamento=" + dataAppuntamento + ", orarioAppuntamento=" + orarioAppuntamento
				+ ", durataAppuntamento=" + durataAppuntamento + ", nomePersona=" + nomePersona
				+ ", nomeLuogoAppuntamento=" + nomeLuogoAppuntamento + "]";
	}

	
    private boolean parseDate(String str) throws AppuntamentoException  {
		
		    boolean bool = false;
		try {
			
			
			String[] resultSplit = str.split("-");
			
			if(!(Integer.parseInt(resultSplit[0]) <=31));
			if(!(Integer.parseInt(resultSplit[1])<=12)) ;
			if(!(Integer.parseInt(resultSplit[2]) >= 2023));
			guardaPerData( resultSplit[0], resultSplit[1], resultSplit[2]);
			bool=true;
			return bool;
			
			  }catch(NumberFormatException e2) { 
				  throw new AppuntamentoException("data sblagliata: (int)gg-(int)mm-(int)yr");
			 }catch(AppuntamentoException f1) {
				 throw new AppuntamentoException(f1.getMessage());
			 }
    }	
	
    
    private boolean parseOra(String ora) throws AppuntamentoException {
		    
    	try {
    	  boolean bool = false;
		    String[] resultSplit = ora.split(":");
				if(Integer.parseInt(resultSplit[0]) <= 24) {
				    if(Integer.parseInt(resultSplit[1]) < 60) {
				    	bool = true; 
					    return bool;	
				    }  return bool;
				    
				 }else{
					 return bool;		 
				 }
				 }catch(NumberFormatException e3) {
				    throw new AppuntamentoException("ora sblagliata: (int)hh:(int)mm"); 
				 }
           
    }
    
    
	/**
	 * 
	 * @param appuntamento da inserire
	 * @return <b>true</b> se non sono sovrapposti e <b>false</b> altrimenti
	 * @throws AppuntamentoException se il formato data del Appuntamento non è virificato
	 */
	public boolean nonSovrapposto(Appuntamento app) throws AppuntamentoException {
             boolean bool = true;
            
            String[] data1 = this.getDataAppuntamento().split("-");
    		String[] data2 = app.getDataAppuntamento().split("-");
    		
    		String[] ora1 = this.getOrarioAppuntamento().split(":");
    	    String[] ora2 = app.getOrarioAppuntamento().split(":");
    	    
            if(guardaPerData(data2[0],data2[1],data2[2])) {
            	if(Integer.parseInt(data1[2]) == Integer.parseInt(data2[2]) && Integer.parseInt(data1[1]) == Integer.parseInt(data2[1]) && Integer.parseInt(data1[0]) == Integer.parseInt(data2[0])) { 
        	    	bool = guardaOra(ora1[0], ora1[1], ora2[0], ora2[1], this.getDurataAppuntamento(), app.getDurataAppuntamento());
        	     }
            }
            
    	    if(!bool) {
    	    	throw new AppuntamentoException("Appuntamento sovrapposto");
    	    }
			return bool;
    }	
	
	
    private boolean guardaPerData(String giorno, String mese, String anno) throws AppuntamentoException {	
    	try {
    	LocalDate date = LocalDate.of(Integer.parseInt(anno), Integer.parseInt(mese), Integer.parseInt(giorno));
    
    	if((date.isAfter(LocalDate.now()) == true) || date.equals(LocalDate.now())) 
    		return true;
    	else throw new AppuntamentoException("appointment con data precedente a quella di oggi impossible");
    	}catch(DateTimeException e0) {
    		throw new AppuntamentoException("Invalid date think about leap year or not.");
    	}
    	   	
    }
    
    
    private boolean guardaOra(String hr1, String min1, String hr2, String min2, int durata1, int durata2) throws AppuntamentoException{
        long initThis = (long)   (   (Integer.parseInt(hr1))*60  ) +    (long)Integer.parseInt(min1) ;	
        long fineThis = initThis + (long)durata1;   	
        
        long initApp = (long)   (   (Integer.parseInt(hr2))*60  ) +    (long)Integer.parseInt(min2) ;
        long fineApp = initApp + (long)durata2;		
        
         if(initApp<initThis) {
        	 if(fineApp<initThis) {
        		 return true;
        	 }else {
        		 throw new AppuntamentoException("non inseribilePerGuardaOra0, sovrappone uno già presente.");
        	 }
         }else if(initApp>initThis) {
        	 if(initApp>fineThis) {
        		 return true;
        	 }else {
        		 throw new AppuntamentoException("non inseribilePerGuardaOra1, sovrappone uno già presente.");
        	 }
         }else if(initApp == initThis){
        	 throw new AppuntamentoException("non inseribilePerGuardaOra2, sovrappone uno già presente.");
         }
         throw new AppuntamentoException("non inseribilePerGuardaOra3, sovrappone uno già presente.");   
    }

   
    /**
     * <p>il metodo fa il confronto fra due Appuntamenti</p>
     * return un int maggiore,inferiore o uguale a zero se resppettivamente thisDataAppuntamento 
     * è dopo,prima o allo stesso momento di o.getDataAppuntamento
     */
    @Override
    public int compareTo(Appuntamento o) {  	
    	
    	String[] appThis = this.dataAppuntamento.split("-");
    	LocalDate dateThis = LocalDate.of(Integer.parseInt(appThis[2]), Integer.parseInt(appThis[1]), 
    			Integer.parseInt(appThis[0]));
    	
    	String[] appO = o.getDataAppuntamento().split("-");
    	LocalDate dateO = LocalDate.of(Integer.parseInt(appO[2]), Integer.parseInt(appO[1]),
    			Integer.parseInt(appO[0]));
    	
    	return dateThis.compareTo(dateO);
    }
    
}   
    