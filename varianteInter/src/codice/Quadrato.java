package codice;

public class Quadrato implements figura{

	private Punto punto;
	private float l;
	
	public Quadrato(int a, int b, int c) {
		this.punto = new Punto(a, b);
		this.l = (float)c;
	}
	

	public float getL() {
		return l;
	}

	
	public void setL(float l) {
		this.l = l;
	}


	@Override
	public float area() {
		return this.l*l;
	}

	@Override
	public float perimetro() {
		return this.l*4;
	}

	@Override
	public boolean contenuto(float x, float y) throws EccezioneQuadrato {
		if(this.punto.getX() <= x  &&  x <= (this.punto.getX()+1)
				   &&  this.punto.getY() <= y  &&  y <= (this.punto.getY()+1)) {
			return true;
		}
	      throw new EccezioneQuadrato("non'è contenuto");
	}


	@Override
	public String toString() {
		return "Quadrato [punto=" + punto + ", l=" + l + "]";
	}
	
	

}
