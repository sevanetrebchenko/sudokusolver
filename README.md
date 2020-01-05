# Java Sudoku Solver
Simple sudoku solver written in Java.
Takes in a sudoku board in a one line command line argument (no spaces between numbers, dots for zeroes) and prints out
the ASCII solution of the board to the console.

If no solution to the provided board is found, the line "No solution to given board." is printed instead.

## Artifacts
Provided is a sudoku board generator executable, qqwing. Source: [Download QQWing](https://qqwing.com/download.html)

## Compilation
Generate puzzles to console window: 
    java -jar qqwing-1.3.4.jar --generate 100 --one-line

Solutions: 
    java -jar qqwing-1.3.4.jar --generate 100 --one-line | java -jar sudoku-solver.jar > solved_sudoku.txt | mv solved_sudoku.txt ../../../solution/
