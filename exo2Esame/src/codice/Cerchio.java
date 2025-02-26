package codice;

public class Cerchio extends Figura{
	private Punto punto;
	private float r;
	
	public Cerchio(int a, int b, int c) {
		this.punto = new Punto((float)a, (float)b);
		this.r = (float)c;
	}
	
	@Override
	public float area() {
		return (float) (3.14*r*r);
	}

	@Override
	public float perimetro() {
		return (float) (3.14*r*2);
	}

	@Override
	public boolean contenuto(float x, float y) throws CerchioException {
		if(this.punto.getX() <= x && x <= (this.punto.getX()+1) 
				&& this.punto.getY() <= y && y <= (this.punto.getY()+1)) {
		    return true;
		}	
		 throw new CerchioException("non'è nel quadratodel cerchio");
	}

	@Override
	public String toString() {
		return "Cerchio [punto= " +"X :"  +punto.getX()+" " +"Y: " +punto.getY() +", r=" + r + "]";
	}
	
}
