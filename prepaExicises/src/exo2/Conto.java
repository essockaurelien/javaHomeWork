package exo2;

public class Conto {
  protected int contenuto;
  
  public Conto(int parameter) {
	  this.contenuto = parameter;  
  }
  
  public int saldo() {
	  return this.contenuto;
  }
  
  public void deposito(int quanto) {
	  this.contenuto = this.contenuto+quanto; 
  }
  
  public void preleva(int quanto) throws ContoException {
	if(this.contenuto >= quanto ) {
		contenuto = contenuto-quanto;
	}else {
		throw new ContoException("insufficente per prelevare");
	}
  }

@Override
public String toString() {
	return "Conto [contenuto=" + contenuto + "]";
}
  
  
  
  
}
