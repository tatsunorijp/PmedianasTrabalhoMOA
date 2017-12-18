import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Utilidades utilidades = new Utilidades();
        int linha[] = new int[4];
        int i = 0, j = 0;

        //comandos do arquivo
        File arq = new File("/home/tatsunori/IdeaProjects/trabalhoMOA2/src/entrada.txt");

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
        Solucao solucao1 = new Solucao(quantVertice, quantMedianas, arquivo);
        Solucao solucao2 = new Solucao(quantVertice, quantMedianas, arquivo);
        Solucao solucao3 = new Solucao(quantVertice, quantMedianas, arquivo);
        Solucao solucao4 = new Solucao(quantVertice, quantMedianas, arquivo);
        Solucao solucao5 = new Solucao(quantVertice, quantMedianas, arquivo);
        Solucao solucao6 = new Solucao(quantVertice, quantMedianas, arquivo);
        Solucao solucao7 = new Solucao(quantVertice, quantMedianas, arquivo);
        Solucao solucao8 = new Solucao(quantVertice, quantMedianas, arquivo);
        Solucao solucao9 = new Solucao(quantVertice, quantMedianas, arquivo);
        Solucao solucao10 = new Solucao(quantVertice, quantMedianas, arquivo);



        br.close();
        leitor.close();

    }
}
