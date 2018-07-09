
package arvoregeradoraminima;

import java.util.Scanner;

/**
 *
 * @author guilh
 */
public class TesteMain {
  
    public static void main(String[] args) {
        System.out.println("\n"
                + "\n==================Árvore Geradora Mínima============="
                + "\nVértices:12"
                + "\nArestas: 21" 
                + "\n\nIndice dos nós e o peso de cada aresta:\n"+
                  "1--2 8\n" +
                  "2--3 7\n" +
                  "1--5 7\n" +
                  "2--5 7\n" +
                  "3--5 7\n" +
                  "3--6 7\n" +
                  "4--5 6\n" +
                  "5--6 3\n" +
                  "4--7 9\n" +
                  "4--8 9\n" +
                  "5--8 8\n" +
                  "5--9 5\n" +
                  "6--9 4\n" +
                  "7--8 7\n" +
                  "7--10 8\n" +
                  "8--10 5\n" +
                  "8--11 4\n" +
                  "9--11 1\n" +
                  "9--12 2\n" +
                  "10--11 3\n" +
                  "11--12 2");
        Scanner scan = new Scanner(System.in);
        int numeroDeVertices, numeroDeArestas;
        System.out.println("Qual o numero de vertices? ");
        numeroDeVertices = scan.nextInt();
        System.out.print("Qual o numero de arestas? ");
        numeroDeArestas = scan.nextInt();
        System.out.println("Insira os valores da tabela:\n(vertice [espaço] vertice [espaço] comprimento)");
        
                ArvoreGeradoraMinima g = new ArvoreGeradoraMinima(numeroDeVertices, numeroDeArestas);
        g.leEConstroiTabela();
        System.out.println("\nCaminho mínimo:\n");
        g.encontraCaminhoMinimo();
    }
}  

