package codice;

public class Punto {

	private float X;
	private float Y;
	
	public Punto(int a, int b) {
		this.X=(float)a;
		this.Y=(float)b;
	}

	public float getX() {
		return X;
	}

	public void setX(float x) {
		X = x;
	}

	public float getY() {
		return Y;
	}

	public void setY(float y) {
		Y = y;
	}

	@Override
	public String toString() {
		return "X=" + X + ", Y=" + Y ;
	}
	
	
}
