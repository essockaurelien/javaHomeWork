package codice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainCerchio implements Runnable{

	
public static ArrayList<Cerchio> prendiDaFile(String nomeFile) throws IOException, CerchioException {
		
	ArrayList<Cerchio> cerchi = new ArrayList<>();
	
		FileReader f;
		f = new FileReader(nomeFile); 
		
		BufferedReader bR ;
		bR = new BufferedReader(new BufferedReader(f));
		
		try {
		    String line;
		   while((line = bR.readLine()) != null){
			   	 String[] parts = line.split(";");
			     int a =Integer.parseInt(parts[0]);
			     int b =Integer.parseInt(parts[1]);
			     int c =Integer.parseInt(parts[2]);
			     
			     Cerchio p = new Cerchio(a, b,c);
			     cerchi.add(p);  
		     }  
		   }catch(IOException e1) {
			   throw new CerchioException("file non trovato.");	
			}catch(NumberFormatException e) {
				bR.close();
				throw new CerchioException("dati presi problem tutti interi separato da ;");
			}
		   
		bR.close();
		   return cerchi;
		}

public static void scriviSuFile(ArrayList<Cerchio> daSalvare, String nomeFile) throws IOException, CerchioException {
	 try (BufferedWriter bW = new BufferedWriter(new FileWriter("nomeFile"))){
	if(daSalvare.isEmpty()) 
		throw new CerchioException("nessun Cerchio.");
	for(Cerchio y: daSalvare) {
		bW.write(y.toString());
	}
	 }catch(IOException e) {
		 throw new CerchioException("file non esistente.");
	 }
}



       public void  run() {
			
		Cerchio cechio = new Cerchio(6, 9,4);
				try{
				  ArrayList<Cerchio> presi = prendiDaFile("fileRead.txt");
				for(Cerchio y: presi) {
					System.out.println(y.toString());
				}
				System.out.println("\nci sono: " +presi.size() +" Punti");
				presi.add(cechio);
				scriviSuFile(presi,"nomeFile");				
				
				}catch(IOException e) {
					System.out.println(e.getMessage());
				}catch(NumberFormatException e) {
					System.out.println(e.getMessage());
				}catch(CerchioException e) {
					System.out.println(e.getMessage());
				}
	}
          
}
