package codice;

public class Punto {

	private float x;
	private float y;

	public Punto(int a, int b) {
		this.x = (float)a;
		this.y = (float)b;
	}
	
	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
	
	
	
}
