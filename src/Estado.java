import java.util.Arrays;

public class Estado {

        int[][] quadro;  // Matriz 3x3 do tabuleiro
        int linhaVazia, colunaVazia;  // Posição do espaço vazio
        int custoG;  // Custo de g(n), ou seja, o número de movimentos até o estado
        int custoH;  // Heurística (distância de Manhattan)
        int custoF;  // Custo total f(n) = g(n) + h(n)

        // Construtor para inicializar o estado
        public Estado(int[][] quadro, int linhaVazia, int colunaVazia, int custoG, int custoH) {
            this.quadro = quadro;
            this.linhaVazia = linhaVazia;
            this.colunaVazia = colunaVazia;
            this.custoG = custoG;
            this.custoH = custoH;
            this.custoF = custoG + custoH;  // Cálculo do custo total f(n)
        }

        // Método para calcular a heurística (distância de Manhattan)
        public int calcularHeuristica() {
            int heuristica = 0;
            int[] objetivo = {1, 2, 3, 4, 5, 6, 7, 8, 0};  // Estado objetivo do puzzle
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int valor = quadro[i][j];
                    if (valor != 0) {
                        int pos = Arrays.binarySearch(objetivo, valor);
                        int objetivoRow = pos / 3;
                        int objetivoCol = pos % 3;
                        heuristica += Math.abs(i - objetivoRow) + Math.abs(j - objetivoCol);
                    }
                }
            }
            return heuristica;
        }

        // Método para gerar os estados filhos (movimentos possíveis do espaço vazio)
        public Estado[] gerarEstadosFilhos() {
            Estado[] filhos = new Estado[4];  // Máximo de 4 movimentos possíveis (cima, baixo, esquerda, direita)
            int count = 0;

            // Movimentos possíveis (cima, baixo, esquerda, direita)
            int[] dLinha = {-1, 1, 0, 0};
            int[] dColuna = {0, 0, -1, 1};

            // Gerar filhos
            for (int i = 0; i < 4; i++) {
                int novaLinha = linhaVazia + dLinha[i];
                int novaColuna = colunaVazia + dColuna[i];

                // Verificar se o movimento é válido
                if (novaLinha >= 0 && novaLinha < 3 && novaColuna >= 0 && novaColuna < 3) {
                    int[][] novoQuadro = clonarTabuleiro(quadro);
                    // Trocar o 0 com o número na nova posição
                    novoQuadro[linhaVazia][colunaVazia] = novoQuadro[novaLinha][novaColuna];
                    novoQuadro[novaLinha][novaColuna] = 0;
                    filhos[count++] = new Estado(novoQuadro, novaLinha, novaColuna, custoG + 1, calcularHeuristica());
                }
            }

            return Arrays.copyOf(filhos, count);  // Retornar os filhos gerados
        }

        // Método para clonar o tabuleiro
        private int[][] clonarTabuleiro(int[][] tabuleiro) {
            int[][] novoTabuleiro = new int[3][3];
            for (int i = 0; i < 3; i++) {
                novoTabuleiro[i] = tabuleiro[i].clone();
            }
            return novoTabuleiro;
        }
}
