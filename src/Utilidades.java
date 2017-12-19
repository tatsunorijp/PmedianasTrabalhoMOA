import java.util.ArrayList;

/**
 * Created by tatsunori on 18/12/17.
 */
public class Utilidades {
    public double[] calculaResultado(ArrayList<Solucao> solucoes, int arquivo[][], int quantMedianas, int quantVertices){
        double[] resultados = new double[quantMedianas];
        double resultadoAux = 0;
        int i,j=0;

        for (Solucao solucao: solucoes){
            for(i = 0; i < quantVertices; i++) {
                if (solucao.vetVertice[i] != -1) {
                    resultadoAux = resultadoAux + (calculaDistancia(arquivo[i][0], arquivo[i][1],
                            arquivo[solucao.vetVertice[i]][0], arquivo[solucao.vetVertice[i]][1]));
                }
            }
            resultados [j] = resultadoAux;
            j++;
            System.out.println(resultadoAux);
            resultadoAux = 0;
        }
        return resultados;
    }

    public static double calculaDistancia(double x1, double y1, double x2, double y2){
        double resultado = 0;
        resultado = Math.sqrt( (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)) );
        return  resultado;
    }
}
