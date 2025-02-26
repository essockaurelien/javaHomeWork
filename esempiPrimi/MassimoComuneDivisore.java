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
			   x=x+1;
			   do{
		    	   x--;
		       }while(y%x!=0);
			   
		      maxDiv = x;  	   
		    }
		   else{
			   y=y+1;
			   do {
				   y--;
			   }while(x%y!=0);
			   maxDiv = y;
		   } 
		  System.out.println("il massimoComuneDivisore è :" + maxDiv); 
		 }
 }
