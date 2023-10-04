package module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cartela {
    private int[][] matriz = new int[5][5];

    private List<Integer> numerosJaJogado = new ArrayList<>();

    public Cartela() {
        for (int i = 0; i < 5; i++) {

            int[] initialRange = new int[2];
            initialRange[0] = 1;
            initialRange[1] = 15;

            for (int j = 0; j < 5; j++) {

                if(i == 2 && i == j){
                    matriz[i][j] = -1;
                }else {
                    int numeroGerado = gerarNumero(initialRange[0], initialRange[1] + 1);
                    matriz[i][j] = numeroGerado;
                }

                initialRange[0] = initialRange[0] + 15;
                initialRange[1] = initialRange[1] + 15;

            }
        }
    }


    private int gerarNumero(int range1, int range2){
        Random random = new Random();

        int numero;

        numero = random.nextInt(range1, range2);

        boolean jaJogado = verificarNumero(numero);

        while (jaJogado){
            int numeroAntigo = numero;
            numero = random.nextInt(range1, range2);
            while(numero == numeroAntigo){
                numero = random.nextInt(range1, range2);
            }
            jaJogado = verificarNumero(numero);
        }

        numerosJaJogado.add(numero);

        return numero;
    }


    public void mostrarCartela(){
        System.out.println("Sua Cartela de Bingo. Boa sorte!");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("[%2d] ", matriz[i][j]);
            }

            System.out.println();
        }
    }

    private boolean verificarNumero(int numero){

        for (int numeroJaJogado : numerosJaJogado) {
            if (numero == numeroJaJogado ){
                return true;
            }
        }

        return false;
    }

    public void mostrarListaNumeros(){
        System.out.println();
        System.out.println("Os numeros jogados foram:");
        System.out.println(numerosJaJogado);
    }
}
