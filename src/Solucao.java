import java.util.Random;

/**
 * Created by tatsunori on 18/12/17.
 */
public class Solucao implements Comparable<Solucao>{
    int vetVertice[];
    int medianas[];
    int capacidadeMediana[];
    double aptidao;

    Solucao (int quantVertice, int quantMedianas, int[][] arquivo){
        int i, j=0, k=0;
        Random gerador = new Random();

        this.vetVertice = new int[quantVertice];
        this.medianas = new int[quantMedianas];
        this.capacidadeMediana = new int[quantMedianas];

        //seleciona as medianas
        for(i = 0; i < quantMedianas; i++){
            medianas[i] = gerador.nextInt(quantVertice);
            capacidadeMediana[i] = (arquivo[ medianas[i] ][2] - arquivo[ medianas[i]] [3]);
        }

        //cria a solucao
        for(i = 0; i < quantVertice; i++){

            for(j = 0; j < quantMedianas; j++){
                if (i == this.medianas[j]){ //caso seja uma mediana, atribui -1
                    this.vetVertice[i] = -1;
                    continue;

                }
            }

            //procura uma mediana para ser atribuida ao vertice

            for(j = 0; j < quantMedianas; j++){
                if( (capacidadeMediana[j] - arquivo[i][3]) >= 0 ) { //verifica a capacidade atual da mediana
                    this.vetVertice[i] = medianas[j];
                    capacidadeMediana[j] = capacidadeMediana[j] - arquivo[i][3];
                    break;
                }
            }
        }

        //calcula o valor
        double resultadoAux = 0;
        for(i = 0; i < quantVertice; i++) {
            if (vetVertice[i] != -1) {
                resultadoAux = resultadoAux + (Utilidades.calculaDistancia(arquivo[i][0], arquivo[i][1],
                        arquivo[vetVertice[i]][0], arquivo[vetVertice[i]][1]));
            }
        }
        this.aptidao = resultadoAux;
    }

    public void imprimeAptidao(){
        System.out.print("[");
        System.out.print(this.aptidao);
        System.out.println("]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solucao solucao = (Solucao) o;

        return Double.compare(solucao.aptidao, aptidao) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(aptidao);
        return (int) (temp ^ (temp >>> 32));
    }

    public int[] getVetVertice() {
        return vetVertice;
    }

    public void setVetVertice(int[] vetVertice) {
        this.vetVertice = vetVertice;
    }

    public int[] getMedianas() {
        return medianas;
    }

    public void setMedianas(int[] medianas) {
        this.medianas = medianas;
    }

    public int[] getCapacidadeMediana() {
        return capacidadeMediana;
    }

    public void setCapacidadeMediana(int[] capacidadeMediana) {
        this.capacidadeMediana = capacidadeMediana;
    }

    public double getAptidao() {
        return aptidao;
    }

    public void setAptidao(double aptidao) {
        this.aptidao = aptidao;
    }

    @Override
    public int compareTo(Solucao solucao) {
        return (int) (aptidao - solucao.aptidao);
    }
}

