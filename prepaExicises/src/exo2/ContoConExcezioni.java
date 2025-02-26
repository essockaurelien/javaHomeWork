package exo2;

public class ContoConExcezioni extends Conto{
   private int maxScoperto;
   
   public ContoConExcezioni(int parPerC, int max) {
	   super(parPerC);
	   this.maxScoperto = max;   
   }	    
   
   public ContoConExcezioni(int parPerC) {
	   super(parPerC);
	   this.maxScoperto = 0;
   }
   
   @Override
   public void preleva(int quanto) throws ContoException {
	   if(this.contenuto <= quanto) {
		   throw new ContoException("saldo non sufficente");
	   }else if((contenuto-quanto) < maxScoperto) {
		   throw new ContoException("saldo base inn violazione"); 
	   }
   }
   
   @Override
   public String toString() {
	   return super.toString() + maxScoperto; 
   }
}
