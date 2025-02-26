package codice;

public class Cerchio extends Figura{

	Punto punto;
	double raggio;
	
	public Cerchio(double a, double b, double c) throws Exception {
		if(c<0) {
			throw new Exception("il Cerchio ha raggio maggiore di zero.");
		}
		this.punto = new Punto(a,b);
		this.raggio = c;
	}
	
	@Override
	public double area() {
		return raggio*raggio*Math.PI;
	}

	@Override
	public double perimetro() {
		return 2*raggio*Math.PI;
	}

	@Override
	public boolean contenuto(double X1, double Y1) {
		double containResult = Math.sqrt( (Y1-this.punto.getY())*(Y1-this.punto.getY()) + (X1-this.punto.getX())*(X1-this.punto.getX()) );
		if(containResult > raggio) {
			return true;
		}
		return false;
	}
   
	
}
