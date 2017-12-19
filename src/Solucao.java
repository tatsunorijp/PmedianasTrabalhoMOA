import java.util.Random;

/**
 * Created by tatsunori on 18/12/17.
 */
public class Solucao implements Comparable<Solucao>{
    int vetVertice[];
    int medianas[];
    int capacidadeMediana[];
    double aptidao;

    //nao foi utilizado o construtor padrao devido a ser necessario que ela seja vazio em certa parte do codigo
    //metodo construtor
    public void construtor (int quantVertice, int quantMedianas, int[][] arquivo){
        this.vetVertice = new int[quantVertice];
        this.medianas = new int[quantMedianas];
        this.capacidadeMediana = new int[quantMedianas];

        atribuiMedianasCapacidades(quantMedianas, quantVertice, arquivo);
        atribuiVertices(quantVertice, quantMedianas, arquivo);
        calculaAptidao(quantVertice, arquivo, this.vetVertice);

    }

    //seleciona as medianas, e calcula suas respectivas capacidades atuais, e altera no vetorSolucao quem eh mediana
    public void atribuiMedianasCapacidades(int quantMedianas, int quantVertice, int arquivo[][]){
        int i,j;
        Random gerador = new Random();

        //seleciona as medianas
        for(i = 0; i < quantMedianas; i++){
            medianas[i] = gerador.nextInt(quantVertice);
            capacidadeMediana[i] = (arquivo[ medianas[i] ][2] - arquivo[ medianas[i]] [3]);
        }

        for(i = 0; i < quantVertice; i++) {
            for (j = 0; j < quantMedianas; j++) {
                if (i == this.medianas[j]) { //caso seja uma mediana, atribui -1
                    this.vetVertice[i] = -1;
                    continue;

                }
            }
        }

    }

    //procura uma mediana para ser atribuida ao vertice
    public void atribuiVertices(int quantVertice, int quantMedianas, int arquivo[][]){
        int i,j;

        for(i = 0; i< quantVertice; i++) {
            for (j = 0; j < quantMedianas; j++) {
                if ((this.capacidadeMediana[j] - arquivo[i][3]) >= 0) { //verifica a capacidade atual da mediana
                    this.vetVertice[i] = this.medianas[j];
                    this.capacidadeMediana[j] = this.capacidadeMediana[j] - arquivo[i][3];
                    break;
                }
            }
        }
    }

    //calcula a aptidao da solucao
    public void calculaAptidao(int quantVertice, int arquivo[][], int vetVertice[]){
        //calcula o valor
        double resultadoAux = 0;
        int i;

        for(i = 0; i < quantVertice; i++) {
            if (vetVertice[i] != -1) {
                resultadoAux = (resultadoAux + (Utilidades.calculaDistancia(arquivo[i][0], arquivo[i][1],
                        arquivo[vetVertice[i]][0], arquivo[vetVertice[i]][1])));
            }
        }
        this.aptidao = resultadoAux;

    }

    public double imprimeAptidao(){
        return this.aptidao;
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

    public void setMedianas(int[] medianas) {
        this.medianas = medianas;
    }

    @Override
    public int compareTo(Solucao solucao) {
        return (int) (aptidao - solucao.aptidao);
    }
}


