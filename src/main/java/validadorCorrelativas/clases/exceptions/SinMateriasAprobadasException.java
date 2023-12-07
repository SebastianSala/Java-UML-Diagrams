package validadorCorrelativas.clases.exceptions;

public class SinMateriasAprobadasException extends Exception{
    public SinMateriasAprobadasException(String where) {
        System.out.println("Exception in: " + where);
    }
}
