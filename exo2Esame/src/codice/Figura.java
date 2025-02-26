package codice;

public abstract class Figura {
    
	protected abstract float area();
    protected abstract float perimetro();
    protected abstract boolean contenuto(float x, float y) throws CerchioException;
	
}
