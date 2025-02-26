package codice;

public class Quadrato extends Figura {
   private Punto p;
   private float l;
   
   public Quadrato(int a, int b, int c) {
	   this.p= new Punto((float)a,(float)b);
	   this.l=(float)c;
   }
   
	@Override
	public float area() {
		return l*l;
	}

	@Override
	public float perimetro() {
      return l*4;		
	}

	@Override
	public boolean contenuto(float X, float Y) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public boolean contenuto(float X1, float Y1) {
//      if() {
//    	  
//      }		
//		return false;
//	}

}
