package figuraQuadrataCodice;

public class Quadrato extends Figura{
    public Punto puntoQuadrato;
    private float l;
	
	public Quadrato(int a, int b, int c) {
		
		this.puntoQuadrato.setX((float)a);
		this.puntoQuadrato.setY((float)b);
		this.l=(float)c;
	}
	
	
	@Override
	public float areaFloat() {
		return l*l;
	}

	@Override
	public float perimetro() {
		return l*4;
	}

	public boolean contenuto(float x1, float y1) {
		if( this.puntoQuadrato.getX() <= x1  &&  (x1 <= (this.puntoQuadrato.getX())+1) &&  this.puntoQuadrato.getY() <= y1  && y1 <= (this.puntoQuadrato.getY() +1) ) {
              return true;			
		}
		return false;
	}


	public Punto getPuntoQuadrato() {
		return puntoQuadrato;
	}


	public float getL() {
		return l;
	}

}
