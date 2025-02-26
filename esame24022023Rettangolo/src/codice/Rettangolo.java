package codice;

public class Rettangolo implements Confrontabile{
   
	private int base;
	private int altezza;
	
	public Rettangolo(int a, int b) throws Exception {
		if(a <= 0) {
		 throw new Exception ("rettangolo ha base maggiore di zero");
		} else if(b <= 0) {
			throw new Exception ("rettangolo ha altezza maggiore di zero");
		}
		this.base=a;
		this.altezza=b;
	}
	
	
	public int area() {
		return base*altezza;
	}
	
	public int perimetro() {
		return (base+altezza)*2;
	}
	
	
	@Override
	public int confronta(Object obj) {
	  if(obj instanceof Rettangolo) {
		  Rettangolo objVero = (Rettangolo)obj;
		  if((objVero.getBase() == this.base) && (objVero.getAltezza() == this.altezza)) {
			return 0;  
		  }else if(objVero.area() > this.area()) {
			  return 1;
		  }else if(objVero.area() < this.area()) {
			  return -1;
		  }
	  }	
		return -1;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) throws Exception {
		if(base <= 0) {
			throw new Exception("non settato: rettangolo ha base maggiore di zero ");
		}
		this.base = base;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) throws Exception {
		if(altezza <= 0) {
			throw new Exception("non settato: rettangolo ha altezza maggiore di zero ");
		}		
		this.altezza = altezza;
	}
	
	
    	
	

}
