import java.util.Random;

/**
 * Created by tatsunori on 18/12/17.
 */
public class Solucao {
    int vetVertice[];
    int medianas[];
    int capacidadeMediana[];

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
//            System.out.print(medianas[i] + " ");
//            System.out.println(capacidadeMediana[i]);
        }

        //cria a solucao
        System.out.print("[");
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
                    System.out.print(this.vetVertice[i] + " ");
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("]");

    }
}

