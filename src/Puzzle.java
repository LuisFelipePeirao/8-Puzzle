import java.util.Arrays;

public class Puzzle {

    private int [][] estadoInicial;
    private int [][] estadoFinal;

    public Puzzle(String estadoInicial, String estadoFinal) {
        this.estadoInicial = converterEmMatriz(estadoInicial);
        this.estadoFinal = converterEmMatriz(estadoFinal);
    }

    private int[][] converterEmMatriz(String estado) {
        int[][] matriz = new int[3][3];
        String[] numeros = estado.split(" ");
        int aux = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = Integer.parseInt(numeros[aux]);
                aux++;
            }
        }
        return matriz;
    }

    private void imprimeMatriz(int [][] matriz) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int [] encontrarPosicaoVazia(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public void resolvePuzzle() {

        System.out.println("Resolveremos o 8-Puzzle aqui!");
        System.out.println("Estado Inicial: ");
        imprimeMatriz(estadoInicial);
        System.out.println("Estado Final: ");
        imprimeMatriz(estadoFinal);

        int [] posicao = encontrarPosicaoVazia(estadoInicial);
        System.out.println("O espaço vazio está na " + (posicao[0] + 1) + "º linha, " + (posicao[1]+ 1) + "º coluna.");

    }

}
