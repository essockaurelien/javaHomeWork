package codice;

public abstract class Figura {

	public abstract float area();
	public abstract float perimetro();
	public abstract boolean contenuto(float x, float y) throws CerchioException;
}
