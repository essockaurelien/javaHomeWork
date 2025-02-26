package codice;

public class ContoConEccezioni extends Conto{
   private int maxScoperto;
	
	public ContoConEccezioni(int quanto, int max) {
		super(quanto);
		this.maxScoperto = max;
	}
	
    public ContoConEccezioni(int quanto) {
    	super(quanto);
    	this.maxScoperto = 0;
    }
	
    @Override
    public void preleva(int daPrelevare) throws ContoConEccezioniException {
    	if((contenuto-daPrelevare) < this.maxScoperto) {
    		throw new ContoConEccezioniException("contenuto andrà sotto di maxScoperto");
    	}
    	contenuto -= daPrelevare;
    }
    
    @Override
    public String toString() {
    	return super.toString() + " " +"maxScoperto: [" +this.maxScoperto+"]";
    }
}
