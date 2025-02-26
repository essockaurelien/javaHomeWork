package rubrica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.instrument.IllegalClassFormatException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Contatto implements Iterable<Contatto> {

	private String nome;
	private String email;
	private ArrayList<String> tels;
	
	
	public Contatto(String nome, String email) throws ContattoException{
		//20027012@uniupo.it
		/*
		try {
		    if(email.matches("{0-9}+@uniupo.it") == true)
		}catch(IllegalClassFormatException e) {
			
		}*/
	
		
		String app = "", app1 = "";
		   
		   //int conta=0;
			          
			//for(int i=0; i<=email.length(); i++){
		       // if(email.matches(""))
		       // if(email.length() == 16)   
				//if(email.indexOf("@") == 9)
					
			    for(int i=0;i<email.indexOf('@');i++) {
			    	//Integer.parseInt(app1, email.charAt(i));
			    	app +=email.charAt(i);
			    }
		        Integer.parseInt(app);
		        for(int j=email.indexOf("@");j<=email.length();j++) {
			    	app1 +=email.charAt(j);
			    }		
			    if(app1 == "uniupo.it");
		
		
		
		this.nome = nome;
		this.email = email;
		tels = new ArrayList<String>();
	}
	
	public Contatto(String email) throws ContattoException {
		this("",email);
	}

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	
	public int numElTels() {
		return tels.size();
	}
	
	public String numTels() {
		
		String app = "";
		
		if(tels.size()!=0) {
		for(String y : tels) {
			app += y + ";";             
			}
		return app;
		}
		return null;
	}
	
	public boolean inserisciNumTel(String num) {
		
		if(!tels.contains(num)) {
			tels.add(num);
			return true;
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "Contatto [tels=" + tels + "]";
	}

	public boolean eliminaTel(String num) {
		
		if(tels.contains(num)) {
			tels.remove(num);
			return true;
		}
		return false;
	}
	
	public boolean matchNome(String name) {
		
		if(nome.indexOf(name) != -1) {
			return true;
		}
		return false;
	}
	
	
	public boolean matchEmail(String mail) {
			if(email.indexOf(mail) != -1) {
				return true;
			}
		return false;
	}
    
    /*public boolean equals(Object contatto)
    che ritorna true se contatto e’ un oggetto di
     tipo contatto che ha la stessa email del
    corrente oggetto.*/
    
	@Override
	public int hashCode() {
		return Objects.hash(email, nome, tels);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contatto other = (Contatto) obj;
		return Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(tels, other.tels);
	}

	
	/*
	leggiContatti ( String fileName )
che aggiunge alla rubrica corrente i contatti contenuti nel file di nome
fileName (li aggiungete 1 ad uno con la addContact e gestite eventuali
eccezioni non aggiungendo il contatto)
	*/
	/*
	public boolean leggiContatti(String fileName ) throws FileNotFoundException, IOException, ClassNotFoundException {
	     
		ObjectOutputStream fbinarioOut = new ObjectOutputStream(new FileOutputStream("persone.dat"));
		fbinarioOut.writeObject(p1);
		fbinarioOut.flush();
		fbinarioOut.close();
		// LEGGE lâ€™oggetto alunno salvato nel file, tramite la deserializzazione
		ObjectInputStream fin = new ObjectInputStream(new FileInputStream("persone.dat"));
		Persona p2 = (Persona) fin.readObject();
		
		
		
		
		return true;
	}
	
	/*
	scriviContatti ( String fileName )
che salva tutti i contatti della Rubrica sul file di nome fileName
	*/
	
	public boolean scriviContatto(String fileName) throws FileNotFoundException, IOException {
		
	
		ObjectOutputStream fwrite = new ObjectOutputStream(new FileOutputStream(fileName));
		fwrite.writeObject(this);
		fwrite.flush();
		fwrite.close();
		return true;
}
	
	
	
	
	
	
	
	//List myList = new ArrayList<>();
	
	@Override
	public Iterator<Contatto> iterator() {
		return new ContattoIterator(tels);
	}
    
   
    public class ContattoIterator<Contatto> implements Iterator<Contatto>{

    	int indexPosition = 0;
    	List<Contatto> internaList;
    	
    	public ContattoIterator(List<Contatto> internaList) {
    		this.internaList = internaList;
    	}
    	
		@Override
		public boolean hasNext() {
			if(internaList.size() >= indexPosition+1) {
			return true;
		    } 
			return false;
		}

		@Override
		public Contatto next() {
			
			Contatto val = internaList.get(indexPosition);
			indexPosition++;
			
			return val;
		}
    }
    
    
}
