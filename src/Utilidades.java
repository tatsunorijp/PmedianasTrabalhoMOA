/**
 * Created by tatsunori on 18/12/17.
 */
public class Utilidades {
    public double calculaDistancia(double x1, double y1, double x2, double y2){
        double resultado = 0;
        resultado = Math.sqrt( (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)) );
        return resultado;
    }
}
