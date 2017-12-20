import java.util.Random;

/**
 * Created by tatsunori on 19/12/17.
 */
public class Cruzamento{

    public Solucao cruza(Solucao pai1, Solucao pai2, int arquivo[][], int quantMedianas, int quantVertices){
        Solucao filho = new Solucao();
        int list1[] = new int [quantMedianas];
        int list2[] = new int [quantMedianas];
        int listaMedianas[] = new int [quantMedianas];
        int listaCapacidadeMedianas[] = new int[quantMedianas];
        int vetVertice[] = new int[quantVertices];
        int i,j;
        double resultadoAux = 0;

        int k = 0, x, y, aux;
        Random gerador = new Random();


        //copia as medianas para listas locais
        for(int m: pai1.medianas){
            list1[k] = m;
            k++;
        }
        k = 0;

        for(int m: pai2.medianas){
            list2[k] = m;
            k++;
        }
        k = 0;

        System.out.println("Antes: ");
        for(int m: list1){
            System.out.print(m + " ");
        }

        System.out.println();
        for(int m: list2){
            System.out.print(m + " ");
        }
        System.out.println();
        System.out.println("Depois ");

        //seleciona medianas em comun
        for (x = 0; x < list1.length; x++){
            for(y = 0; y < list2.length; y++){
                if ( (list1[x] == list2[y]) && (list1[x]!=-9) ){
                    listaMedianas[k] = list1[x];
                    listaCapacidadeMedianas[k] = pai1.capacidadeMediana[x];
                    k++;
                    list1[x] = -9;
                    list2[y] = -9;
                }
            }
        }

        x = 0; y = 0;
        while( k != quantMedianas ){
            aux = gerador.nextInt(2);
            if (aux == 1) {
                if(list1[x] == -9){
                    x++;
                    continue;
                }
                listaMedianas[k] = list1[x];
                listaCapacidadeMedianas[k] = pai1.capacidadeMediana[x];
                x++; k++;
            }else{
                if(list2[y] == -9){
                    y++;
                    continue;
                }
                listaMedianas[k] = list2[y];
                listaCapacidadeMedianas[k] = pai2.capacidadeMediana[y];
                y++; k++;
            }

        }



        //atribui vertices
        for(i = 0; i< quantVertices; i++) {
            for (j = 0; j < quantMedianas; j++) {
                if (((listaCapacidadeMedianas[j] - arquivo[i][3]) >= 0) && (i != listaMedianas[j])) { //verifica a capacidade atual da mediana
                    vetVertice[i] = listaMedianas[j];
                    listaCapacidadeMedianas[j] = listaCapacidadeMedianas[j] - arquivo[i][3];
                    break;
                }
            }
        }

        //calcula aptidao


        for(i = 0; i < quantVertices; i++) {
            if (vetVertice[i] != -1) {
                resultadoAux = (resultadoAux + (Utilidades.calculaDistancia(arquivo[i][0], arquivo[i][1],
                        arquivo[vetVertice[i]][0], arquivo[vetVertice[i]][1])));
            }
        }

        filho.setMedianas(listaMedianas);
        filho.setCapacidadeMediana(listaCapacidadeMedianas);
        filho.setVetVertice(vetVertice);
        filho.setAptidao(resultadoAux);


        System.out.println();
        for(int m: list1){
            System.out.print(m + " ");
        }

        System.out.println();
        for(int m: list2){
            System.out.print(m + " ");
        }

        System.out.println();
        for(int m: listaMedianas){
            System.out.print(m + " ");
        }




    return filho;
    }
}
