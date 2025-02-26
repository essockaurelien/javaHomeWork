package esempiPrimi;

import jbook.util.Input;

/*
 * *******************************************************************
1) Scrivere un programma che chiede la temperatura in gradi
Fahrenheit e stampa la stessa temperatura in gradi Celtius. 
Formula (9 x tC = 5 x (tF-32)) dove tC e' la temperatura in gradi 
Celtius e tF in gradi Farhrenheit.
**********************************************************************
*/

public class ConvertTemp {

       public static void main(String[] args) {
    	     	  
   System.out.println("Mi dai la temp in Fahrenheit!!!!");
       
     float tF = Input.readFloat();
        float tC1 = ( tF - 32 )*5;
        float tC = tC1/9;
   System.out.println("in Celtius la temp vale : " + tC + "°C");

   
    System.out.println("*************" + "\n");
  }
}         