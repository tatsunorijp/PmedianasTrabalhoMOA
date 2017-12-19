import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //Solucao solTemp = inicial.poll();
        //ao retirar, nao esqueça de adicionar novamente

        Utilidades utilidades = new Utilidades();
        PriorityQueue<Solucao> inicial = new PriorityQueue<Solucao>();
        Cruzamento cruzador = new Cruzamento();
        int linha[] = new int[4];
        int i = 0, j = 0;

        //comandos do arquivo
        File arq = new File("/home/tatsunori/IdeaProjects/trabalhoMOA2/src/arquivos/entrada.txt");

        FileReader leitor = new FileReader(arq);
        BufferedReader br = new BufferedReader(leitor);
        StringTokenizer st = new StringTokenizer(br.readLine());

        //leitura do cabecalho
        for(i = 0; i < 4 ;i++){
            linha[i] = Integer.parseInt((String) st.nextElement());
        }

        int quantVertice = linha[0]; //quantidade de vertices do problema
        int quantMedianas = linha[1]; //quantidade de medianas do problema
        int resultadoEsperado = linha[3]; //resultado desejada a alcancar
        int arquivo[][] = new int [quantVertice][4];

        //passa o txt para a memoria
        for( i = 0; i < quantVertice ; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0 ; j < 4 ; j++){
                arquivo[i][j] = Integer.parseInt((String) st.nextElement());
            }
        }

        for( i = 0; i<10 ; i++){
            inicial.add(new Solucao(quantVertice, quantMedianas, arquivo));
        }

        cruzador.cruza(inicial.poll(), inicial.poll(), arquivo, quantMedianas, quantVertice);


        br.close();
        leitor.close();

    }
}
