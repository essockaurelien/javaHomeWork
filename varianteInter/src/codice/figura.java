package codice;

public interface figura {
     float area();
     float perimetro();
     boolean contenuto(float x, float y) throws EccezioneQuadrato;
}
