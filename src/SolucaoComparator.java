import java.util.Comparator;

/**
 * Created by Tatsunori on 19/12/2017.
 */
public class SolucaoComparator implements Comparator<Solucao>{
    @Override
    public int compare(Solucao sol1, Solucao sol2) {
        Solucao solucao1 = (Solucao) sol1;
        Solucao solucao2 = (Solucao) sol2;

        if(solucao1.aptidao < solucao2.aptidao){
            return -1;
        }

        return 1;
    }
}
