/*
Disciplina: Algoritmos e Programação III
Aluno: Guilherme Marcelino Ribeiro
Trabalho de Grafos: Árvore Geradora Mínima



Obs.: o arquivo "kruskal.csv" está anexado, porém a entrada é exigida através do console.
*/

package arvoregeradoraminima;


import static java.io.FileDescriptor.in;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author guilh
 */
public class ArvoreGeradoraMinima {
    private int numeroDeVertices, numeroDeArestas;
    private int[][] arestasAComparar = new int[21][3];
    private int indiceDoArray = 0;
    private boolean[] vertices;
    private int[][] arestas;
    public ArvoreGeradoraMinima(int quantidadeDeVertices, int quantidadeDeArestas) {
        numeroDeVertices = quantidadeDeVertices;
        numeroDeArestas = quantidadeDeArestas;
        vertices = new boolean[quantidadeDeVertices + 1]; //Nao contar o vertice de indice 0
        arestas = new int[quantidadeDeArestas][3]; //o numero de colunas é fixo "3"
    }
    private void adicionaArestaParaComparar (int verticeInicial,int verticeFinal,int custo) {
        arestasAComparar[indiceDoArray][0] = verticeInicial;
        arestasAComparar[indiceDoArray][1] = verticeFinal;
        arestasAComparar[indiceDoArray][2] = custo;
        indiceDoArray++;
    }
    protected void adicionaArestaParaComparar (int[] partida) {
        for (int i = 0; i < partida.length; i++) { //corre as partidas
           for (int j = 0; j < numeroDeArestas; j++) {
                if (arestas[j][0] == partida[i] && vertices[arestas[j][1]] == false) {
                    adicionaArestaParaComparar(arestas[j][0], arestas[j][1], arestas[j][2]);
                }
            }
        }
    }
    private void adicionaArestaParaComparar (Object[] partida) {
        
        for (int i = 0; i < partida.length; i++) { //corre as partidas
            
            for (int j = 0; j < numeroDeArestas; j++) {
                if (arestas[j][0] == Integer.parseInt(partida[i].toString()) && vertices[arestas[j][1]] == false) {
                    adicionaArestaParaComparar(arestas[j][0], arestas[j][1], arestas[j][2]);
                }
                if (arestas[j][1] == Integer.parseInt(partida[i].toString()) && vertices[arestas[j][0]] == false) {
                    adicionaArestaParaComparar(arestas[j][0], arestas[j][1], arestas[j][2]);
                }
            }
        }
    }
    protected void limpaArestasComparadas() {
        for (int i = 0; i < arestasAComparar.length; i++) {
            arestasAComparar[i][0] = 0;
            arestasAComparar[i][1] = 0;
            arestasAComparar[i][2] = 0;
        }
        indiceDoArray = 0;
    }
    private int[] menorCaminho() {
        int[] aresta = new int[3];
        int comp = 9999;
        for (int i = 0; i < arestasAComparar.length && arestasAComparar[i][2] != 0; i++) {
            if (arestasAComparar[i][2] < comp) {
                aresta[0] = arestasAComparar[i][0];
                aresta[1] = arestasAComparar[i][1];
                aresta[2] = arestasAComparar[i][2];
                comp = arestasAComparar[i][2];
            }
        }
        return aresta;
    }
    protected void imprimeMenorCaminho() {
        int[] aresta = menorCaminho();
        //troca aresta[1] e aresta[0] de lugar deixando sempre aresta[0] < aresta[1]
        int aux;
        if (aresta[0] > aresta[1]) {
            aux = aresta[0];
            aresta[0] = aresta[1];
            aresta[1] = aux;
        }
        System.out.printf("%d %d %d\n", aresta[0], aresta[1], aresta[2]);
    }
    private boolean marcaVerticeDoMenorCaminho() {
        int[] aresta = menorCaminho();
        //retorna "true" se o vertice inicial estiver marcado
        if (vertices[aresta[0]] == true){
            vertices[aresta[1]] = true;
            return true;
        } else {
            return false;
        }
    }
    protected void imprimeSituacaoDosVertices() {
        for (int i = 1; i < numeroDeVertices; i++)
            System.out.println("Vertice " + i + " = " + vertices[i]);
    }
    protected void imprimeArestasParaComparação() {
        for (int i = 0; i < 10; i++) {
            System.out.print(arestasAComparar[i][0]);
            System.out.print(" " + arestasAComparar[i][1]);
            System.out.println(" " + arestasAComparar[i][2]);
        }
    }
    public void leEConstroiTabela() {        
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < numeroDeArestas; i++) {
            int x = scan.nextInt(); //lê o nó inicial e coloca em contagem do 0
            int y = scan.nextInt(); //lê o nó final e coloca em contagem do 0
            int z = scan.nextInt(); //lê o custo ambiental
            
              /*   
            int x = in.nextInt();
            int y = in.nextInt();
            int z =in.nextInt();             
            
            if(in.hasNextLine())in.hasNextLine();//proxima linha
            */ 
            
            
            arestas[i][0] = x; //atribui o indice do vertice inicial
            arestas[i][1] = y; //atribui o inice do vertice final
            arestas[i][2] = z; //atribui o comprimento da aresta
        }
    }
    public void encontraCaminhoMinimo() {
        List<Integer> partida = new ArrayList<Integer>();
        partida.add(1);
        vertices[1] = true;
        for (int i = 0; i < (numeroDeVertices - 1); i++) {
            for (int j = 0; j < numeroDeArestas; j++) {
            adicionaArestaParaComparar(partida.toArray());
            imprimeMenorCaminho();
            partida.add(menorCaminho()[1]);
            marcaVerticeDoMenorCaminho();
            limpaArestasComparadas();
            }
        }    
    }
    
}