/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvoregeradoraminima;

import java.util.Scanner;

/**
 *
 * @author guilh
 */
public class TesteMain {
  
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numeroDeVertices, numeroDeArestas;
        System.out.print("Qual o numero de vertices? ");
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

