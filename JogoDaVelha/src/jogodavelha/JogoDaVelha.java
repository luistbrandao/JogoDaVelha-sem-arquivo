/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import java.util.Scanner;


/**
 *
 * @author luiso
 */
public class JogoDaVelha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner entrada = new Scanner(System.in);
        Tabuleiro tab = new Tabuleiro();
        boolean jogoContinua = true;
        int rodada = 1;
        int linha, coluna;

        System.out.println("Jogador X, digite seu nome:");
        String nome = entrada.nextLine();

        System.out.println("Jogador O, digite seu nome:");
        String nome2 = entrada.nextLine();

        Jogador j1 = new Jogador(1, nome);
        Jogador j2 = new Jogador(2, nome2);

        while (jogoContinua) {
            //tab.exibeTabuleiro();
            System.out.println(tab.exibirTabuleiro());
            if (rodada % 2 == 1) {
                System.out.println("Vez do jogador: " + j1.getNome());
                    System.out.println("Digite linha:");
                    linha = entrada.nextInt();

                    System.out.println("Digite coluna:");
                    coluna = entrada.nextInt();

                if (!tab.fazJogada(linha, coluna, j1)) {
                    System.out.println("Jogada invalida!");
                    break;
                }
            } else {
                System.out.println("Vez do jogador: " + j2.getNome());
                    System.out.println("Digite linha:");
                    linha = entrada.nextInt();
                    
                    System.out.println("Digite coluna:");
                    coluna = entrada.nextInt();
                    
                if (!tab.fazJogada(linha, coluna, j2)) {
                    System.out.println("Salvo com sucesso");
                    break;
                }
            }
            rodada++;
            int i = tab.quemGanhou();

            if (i == 1) {
                System.out.println(" O jogador " + j1.getNome() + " ganhou!");
                jogoContinua = false;
            } else if (i == -1) {
                System.out.println("O jogador" + j2.getNome() + " ganhou!");
                jogoContinua = false;
            } else if (i == 0) {
                if (!tab.verificaTabuleiro()) {
                    System.out.println("Deu velha!");
                    jogoContinua = false;
                }
            }
        }
        System.out.println(tab.exibirTabuleiro());
    }
}
