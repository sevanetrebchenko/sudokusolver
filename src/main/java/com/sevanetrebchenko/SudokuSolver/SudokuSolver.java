
package com.sevanetrebchenko.SudokuSolver;

import java.util.Scanner;

public class SudokuSolver {

    public static void main(String[] args) {
        // Read fro stdin
        Scanner console = new Scanner(System.in);

        while(console.hasNextLine()) {
            // Read the line from stdin and convert to int array
            int[] data = parse(console.nextLine());

            int[][] sudokuBoard = new int[9][9];
            int counter = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudokuBoard[i][j] = data[counter++];
                }
            }

            System.out.println("PUZZLE: ");

            SudokuBoard board = new SudokuBoard(sudokuBoard);
            board.printBoard();
            System.out.println();

            if (board.solve()) {
                System.out.println("SOLUTION: ");
                board.printBoard();
            } else {
                System.out.println("No solution to given board.");
            }
            System.out.println();
        }
    }

    private static int[] parse(String data) {
        return data.chars().map(c -> c == '.' ? 0 : c - '0').toArray();
    }
}
// COMPLETELY BLANK BOARD FOR TESTING PURPOSES
//int sudokuBoard[][] = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//                                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//                                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//                                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//                                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//                                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//                                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//                                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//                                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
