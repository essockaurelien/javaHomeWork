package esempiPrimi;

import jbook.util.Input;

public class MassimoComuneDivisore {

	public static void main(String[] args) {
		  System.out.println("inserisci il primo numero x:");
		   int x = Input.readInt();
		   System.out.println("inserisci il secondo numero y:");
		   int y = Input.readInt();
		   
		   int maxDiv=0;
		    
		   if(x<0 || y<0)
		   return;
		   if(x<y) {
			   maxDiv = x+1;
			   do{
		    	  maxDiv --;
		       }while(y%maxDiv!=0 && x%maxDiv!=0);  	   
		    }
		   else{
			   maxDiv = y+1;
			   do {
				   maxDiv--;
			   }while(x%maxDiv!=0 && y%maxDiv !=0);
		   } 
		  System.out.println("il massimoComuneDivisore è :" + maxDiv); 
		 }
 }
