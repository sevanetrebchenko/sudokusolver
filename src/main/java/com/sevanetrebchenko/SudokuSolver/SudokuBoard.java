package com.sevanetrebchenko.SudokuSolver;

import java.awt.Point;

public class SudokuBoard {
    private int boardDimension = 9;
    private int sudokuBoard[][] = new int [9][9];

    SudokuBoard(int[][] otherBoard) {
        this.sudokuBoard = otherBoard;
    }
    
    SudokuBoard() {
        for (int i = 0; i < this.boardDimension; i++) {
            for (int j = 0; j < this.boardDimension; j++) {
                this.sudokuBoard[i][j] = 0;
            }
        }
    }
    
    public boolean solve() {
        // completed board
        if (getBlankLocation().x == 9 && getBlankLocation().y == 9) {
            return true;
        }
        
        Point currentLocation = getBlankLocation();
        int x = currentLocation.x;
        int y = currentLocation.y;
        
        // check all the numbers
        for (int num = 1; num <= this.boardDimension; num++) {
            if (isValid(x, y, num)) {
                this.sudokuBoard[x][y] = num;
                
                // continue recursively checking
                if (solve()) {
                    return true;
                }
            }
            
            // incorrect assumption made before, backtrack
            this.sudokuBoard[x][y] = 0;
        }
        
        return false; 
    }
    
    // Prints out the board onto the screen
    public void printBoard() {
        for (int i = 0; i < this.boardDimension; i++) {
            for (int j = 0; j < this.boardDimension; j++) {
                System.out.print(this.sudokuBoard[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    private Point getBlankLocation() {
        for (int i = 0; i < this.boardDimension; i++) {
            for (int j = 0; j < this.boardDimension; j++) {
                if (this.sudokuBoard[i][j] == 0) {
                    return new Point(i, j);
                }
            }
        }
        
        // return point indicating grid is full
        return new Point (9, 9);
    }
    
    private boolean isValid(int row, int col, int num) {
        return !isUsedInRow(row, num) && !isUsedInColumn(col, num) && !isUsedInSquare(row - row % 3, col - col % 3, num);
    }
    
    private boolean isUsedInRow(int row, int num) {
        for (int col = 0; col < this.boardDimension; col++) {
            if (this.sudokuBoard[row][col] == num) {
                return true;
            }
        }
        return false; 
    }
    
    private boolean isUsedInColumn(int col, int num) {
        for (int row = 0; row < this.boardDimension; row++) {
            if (this.sudokuBoard[row][col] == num) {
                return true;
            }
        }
        return false; 
    }
        
    private boolean isUsedInSquare(int box_start_row, int box_start_col, int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (this.sudokuBoard[box_start_row + row][box_start_col + col] == num) {
                    return true;
                }
            }
        }
        return false;
    }
}
