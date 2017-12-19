import java.util.Random;

/**
 * Created by tatsunori on 19/12/17.
 */
public class Cruzamento{

    public Solucao cruza(Solucao s1, Solucao s2, int arquivo[][], int quantMedianas, int quantVertices){
        Solucao filho = null;
        int list1[] = new int [quantMedianas];
        int list2[] = new int [quantMedianas];
        int listaMedianas[] = new int [quantMedianas];
        int listaCapacidadeMedianas[] = new int[quantMedianas];

        int k = 0, x, y, aux;
        Random gerador = new Random();


        //copia as medianas para listas locais
        for(int i: s1.medianas){
            list1[k] = i;
            k++;
        }
        k = 0;

        for(int i: s2.medianas){
            list2[k] = i;
            k++;
        }
        k = 0;

        //seleciona medianas em comun
        for (x = 0; x < list1.length; x++){
            for(y = 0; y < list2.length; y++){
                if ( (list1[x] == list2[y]) && (list1[x]!=-9) ){
                    listaMedianas[k] = list1[x];
                    listaCapacidadeMedianas[k] = s1.capacidadeMediana[x];
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
                listaCapacidadeMedianas[k] = s1.capacidadeMediana[x];
                x++; k++;
            }else{
                if(list2[y] == -9){
                    y++;
                    continue;
                }
                listaMedianas[k] = list2[y];
                listaCapacidadeMedianas[k] = s2.capacidadeMediana[y];
                y++; k++;
            }

        }


        filho.setMedianas(listaMedianas);



    return filho;
    }
}
