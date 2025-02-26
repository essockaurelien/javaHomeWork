package codice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * 
 *  
 * 
 * @author essock
 * */

public class Main {
/**
 * 
 * @param args
 * @throws AppuntamentoException
 * @throws AgendaException
 * @throws GestorException
 */
	public static void main(String[] args) throws AppuntamentoException, AgendaException, GestorException {
		Scanner sc = new Scanner(System.in);
	while(true) {
		try {
			
		System.out.println("--- Agenda Management System ---\n");
		System.out.println("scegli una operazione.");
		
		System.out.println("1. Crea una nuova agenda");
		System.out.println("2. Crea una nuova agenda da File");
		System.out.println("3. Mostra tutte le agende");
		System.out.println("4. Leggi Agenda");
		System.out.println("5. Elimina Agenda");
		System.out.println("0. Esci");
        
        
        System.out.print("\nScegli un'opzione: ");	
		System.out.print("Inserire numero operazione:");
		
		String opt = sc.nextLine();
		int option = Integer.parseInt(opt);
			
		
		switch (option) {
		case 1 :
			try {
			System.out.println("inserire il nome dell'Agenda");
		    String nomeAgenda = sc.nextLine();
		    Agenda agenda = GestoreAgende.creaNuovaAgenda(nomeAgenda);
		    System.out.println("agenda " + agenda.getNomeAgenda() + " creata.\n\n");
		    break;
			}catch(GestorException e1) {
				System.out.println(e1.getMessage());
				break;
			}
		case 2 : 
			try {
			System.out.println("inserire il nome dell'Agenda");
			String nomeAgenda2 = sc.nextLine();
			System.out.println("inserire il nome del file da leggere");
			String nomefile = sc.nextLine();
	
			Agenda agenda2 = GestoreAgende.creaNuovaAgenda(nomeAgenda2);
			agenda2.agendaFileReader(nomefile);

			for(Appuntamento p : agenda2)
				System.out.println(p.toString());
			
			System.out.println("agenda creata con successo");			
			}catch(AgendaException e1) {
				System.out.println(e1.getMessage() + "\n");
			}catch(GestorException eRipeat) {
			System.out.println(eRipeat.getMessage());
			  break; 
		    }
			break;
			
		case 3:
			if(GestoreAgende.agende.isEmpty() == true) {
				System.out.println("Nessun Agenda Presente");
				break;
			}
			GestoreAgende.stampaAgende();
			System.out.println("\n");
			break;
			
			
		case 4: 
			System.out.println("scegli Agenda che voi leggere\n");
			GestoreAgende.stampaAgende();
			System.out.println("\nnome Agenda: ");
			
			String y = sc.nextLine();
			
			boolean bool = false;
			
			for(Agenda i: GestoreAgende.getAgende()) {
				if(i.getNomeAgenda().equals(y)) {
			         bool = true;
			         
			         System.out.println("\nAgenda : " + i.getNomeAgenda());
			         System.out.println("\nScegli una operazione.");
			         System.out.println("1. Inserire Appuntamento");
			         System.out.println("2. Cerca un Appuntamento");
			         System.out.println("3. Modifica un Appuntamento");
			         System.out.println("4. Ordina gli Appuntamenti");
			         System.out.println("0.  MENU");
			         
			         int line = 0;
		
			         do {
			        	 try {
			        		 System.out.println("\nNumero operazione: ");
			        		String opzione = sc.nextLine(); 
			        		line = Integer.parseInt(opzione);
			        		if(line < 0 || line >4) {
			        			System.out.println("le scelte vanno da 0 a 4 ");
			        		}
			        	 }catch(NumberFormatException e) {
			        		 System.out.println("l'opzione è un numero per operazione da 0 a 4");
			        	 }
			         }while(line < 0 || line > 4);// fine do.
			         
			         switch(line) {
			         
			         case 1:
			        	 System.out.println("inserire la stringa dataAppuntamento");
			        	 String dataAppuntamento = sc.nextLine();
			        	
			        	 System.out.println("inserire la stringa oraAppuntamento"); 
			        	 String oraAppuntamento = sc.nextLine();
			        	 
			        	 System.out.println("inserire l'intero durataAppuntamento");
			        	 int durataAppuntamento;
			        	    try {
			        		       String durata = sc.nextLine();
			        		       durataAppuntamento = Integer.parseInt(durata);
			                     }catch(NumberFormatException e) {
			        		 System.out.println("la durata è in minuti ed è un intero");
			        		 break; 
			        	    }
			        	 
			        	 System.out.println("inserire il nome della persona con cui si ha l'Appuntamento"); 
			        	 String nomeCliente = sc.nextLine();
			        	 
			        	 System.out.println("inserire il nome del luogo del Appuntamento");
			        	 String nomeLuogoAppuntamento = sc.nextLine();
			      	 try {
			        	Appuntamento appY = new Appuntamento(dataAppuntamento, oraAppuntamento, durataAppuntamento, nomeCliente,nomeLuogoAppuntamento);
			        	boolean resultInsert = i.inserisciAppointment(appY);
			        	if(resultInsert) {
			        		System.out.println("Appuntamento inserito con successo.");	
			        	  }
			         }catch(AppuntamentoException e7) {
			        		System.out.println("non inseribile perchè :" +e7.getMessage());
			        		break;
			        	}catch(AgendaException e0) {
			        		System.out.println("non inseribile perchè :" +e0.getMessage());
			        		break;
			        	}
			        	break;
			         
			         case 2:
			        	 System.out.println("inserire il nome della persona / la data");
			        	 String datoPerLaCerca = sc.nextLine();
			        	 ArrayList<Appuntamento> trovati = new ArrayList<>();
			        	 trovati.addAll(i.cercaAppuntamento(datoPerLaCerca));
			        	 for(Appuntamento k: trovati) {
			        		 System.out.println(k.toString());
			        	   }
			        	 
			       	 break;
			   
			        
			         case 3:
			        	 System.out.println(i.getNomeAgenda());
			        	 
			        	 for(Appuntamento p: i.getAppuntamenti()) {
			        		 System.out.println(p.toString());
			        	 }
			        	 
			        	 System.out.println("\ninserire la stringa dataAppuntamento del Appuntamento da Modificare");
			        	 String data = sc.nextLine();
			        	 
			        	 System.out.println("inserire la stringa oraAppuntamento del Appuntamento da Modificare");
			        	 String oraC = sc.nextLine();
			        	 int c=0;
			        	 boolean bolean = false;
			        	 Appuntamento a = new Appuntamento("01-01-2100","01:00",0,"bsdehj","kjdhur");
			        	 for(Appuntamento z: i.getAppuntamenti()) {
			        		 if(z.getDataAppuntamento().equals(data)) {
			        			 if(z.getOrarioAppuntamento().equals(oraC)) {
			        	            bolean = true;
			        				 break;
			        		     }
			         		} 
			        		 c++;
			         	 } 
			        		if(!bolean) {
			        			System.out.println("Appuntamento con questa DataAppuntamento e OraAppuntamento non esiste, Quindi non Modificabile.\n");
			        		    break;
			        		}
			        	 System.out.println("mi servono i dati del l'Appuntamento da modificare.\n");
			        	 
			        	 System.out.println("la data nuova da settare se no la vecchia.");
			        	 String date = sc.nextLine();
			        	 
			        	 System.out.println("l'ora nuova da settare se no la vecchia.");
			        	 String hours = sc.nextLine();
			        	 
			        	 System.out.println("durata nuova da settare se no la vecchia.");
			        	 int duration = Integer.parseInt(sc.nextLine());
			        	 
			        	 System.out.println("il nome della persona da settare se no il vecchio.");
			        	 String name = sc.nextLine();
			        	 
			        	 System.out.println("il lugo nuovo da settare se no il vecchio.");
			        	 String place = sc.nextLine();
			        	 
			        	 i.modificaAppuntamento(i.getAppuntamenti().get(c), date, hours, duration, name, place);
			        	 
			    
			        	 
			        	 
			        	 for(Appuntamento s: i.getAppuntamenti()) {
			        		 System.out.println(s.toString());
			        	 }
			        	break; 
			            	
			         case 4:
			        	 if(i.getAppuntamenti().isEmpty()) {
			        		 System.out.println("Agenda vuota, quindi Ordinati tutti gli Appuntamenti.\n");
			        		 break;
			        	 }
			        	 i.ordinaAppuntamenti();
			        	 break;
			        	 
			         case 0: 
			        	 break;
			         }//switch leggi

				}
			}//end for
		     if(bool == false)
		    	 System.out.println("Agenda non presente nel Gestor");
		     break;
		case 5:
			if(GestoreAgende.agende.isEmpty()) {
				System.out.println("nessun agenda nel Gestor.");
				break;
			}
       	 for(Agenda u: GestoreAgende.getAgende()) {
       		 System.out.println(u.getNomeAgenda());
       	 }
       	 System.out.println("scrivi il nome del Agenda da eliminare\n");
       	 String cancella = sc.nextLine();
       	 int d=0,e=0;
       	 for(Agenda r: GestoreAgende.getAgende()) {
       		 if(r.getNomeAgenda().equals(cancella)) {
       			 e=1;
       		    break;	 
       		 }
       		 d++;
       		}
       	 if(e!=1) {
       		 System.out.println("Agenda non essistente.\n");
       		 break;
       	 }
       	 GestoreAgende.getAgende().remove(d);
       	 System.out.println("le agende sono: \n");
       	 GestoreAgende.stampaAgende();
       	 break;
		case 0:
			System.out.println("Programma terminato.");
		    System.exit(0);
		}//switch(option)	
	}
	catch(AgendaException e){
	 System.out.println(e.getMessage() + "\n\n");
		}
	catch(AppuntamentoException e){
	 System.out.println(e.getMessage() + "\n\n");
		}
		 catch(NumberFormatException e){
			 System.out.println("Inserimento non valido \n\n"); 
			 continue;
		 }
	   } // while	
	}// metodo main
	
} // classe main