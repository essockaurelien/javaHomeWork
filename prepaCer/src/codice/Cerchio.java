package codice;

public class Cerchio extends Figura{
 
	private Punto punto;
	private float radio;
	
	public Cerchio(int a, int b, int c) {
		this.punto=new Punto(a,b);
		this.radio=(float)c;
	}
	
	public Cerchio(Punto p, float radio) {
		this.punto=p;
		this.radio=radio;
	}
	@Override
	public float area() {
 	 	return (float)(3.14*radio*radio);
	}

	@Override
	public float perimetro() {
		return (float)(2*radio*3.14);
	}

	@Override
	public boolean contenuto(float x1, float y1) throws CerchioException{
        if(this.punto.getX() <= x1 && x1 <= this.punto.getX()+1 && this.punto.getY() <= y1 && y1 <= this.punto.getY()+1) {
              return true;        	
        }
		throw new CerchioException("non sono contenuto nel Cerchio.");
	}

	@Override
	public String toString() {
		return "Cerchio [punto:" + punto.toString() + ", radio=" + radio + "]";
	}
	
	
	
	}
   

