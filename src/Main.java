import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Puzzle puzzle;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o estado inicial (ex: 1 2 3 4 5 6 7 8 0):");
        String estadoInicial = scanner.nextLine();

        System.out.println("Digite o estado final (ex: 1 2 3 4 5 6 7 8 0):");
        String estadoFinal = scanner.nextLine();

        puzzle = new Puzzle(estadoInicial, estadoFinal);

        puzzle.resolvePuzzle();

        scanner.close();

    }
}