package codice;

public class Conto {
    protected int contenuto;
    
	public Conto(int quanto) {
		this.contenuto = quanto;
	}
	
	public int saldo() {
		return this.contenuto;
	}
	
	public void deposita(int depose) {
	   this.contenuto += depose;
	}
	
	public void preleva(int daPrelevare) throws ContoConEccezioniException {
		if(this.contenuto < daPrelevare) {
			return;
		}
		contenuto -= daPrelevare;
	}

	@Override
	public String toString() {
		return "Conto [contenuto=" + contenuto + "]";
	}
	
	
}
