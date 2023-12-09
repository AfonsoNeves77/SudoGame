package org.example;

import java.util.Arrays;


public class Board {

    private int[][] initialBoard;
    private int[][] currentBoard;
    private int difficulty;

    public Board(int difficulty) throws InstantiationException{
        this.difficulty = difficulty;
        int[][] generatedBoard = initialBoardGenerator();
        if (Arrays.deepEquals(generatedBoard, new int[0][0])) {
            throw new InstantiationException("Invalid difficulty level.");
        }
        this.initialBoard = initialBoardGenerator();
        this.currentBoard = getInitialBoard();
    }


    private int[][] initialBoardGenerator(){
        return switch (difficulty) {
            case 1 -> new int[][]{
                    {5, 3, 0, 0, 7, 0, 0, 0, 0},
                    {6, 0, 0, 1, 9, 5, 0, 0, 0},
                    {0, 9, 8, 0, 0, 0, 0, 6, 0},
                    {8, 0, 0, 0, 6, 0, 0, 0, 3},
                    {4, 0, 0, 8, 0, 3, 0, 0, 1},
                    {7, 0, 0, 0, 2, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 0, 2, 8, 0},
                    {0, 0, 0, 4, 1, 9, 0, 0, 5},
                    {0, 0, 0, 0, 8, 0, 0, 7, 9}
            };
            case 2 -> new int[][]{
                    {0, 0, 3, 0, 0, 0, 8, 0, 0},
                    {0, 7, 0, 0, 0, 9, 0, 4, 0},
                    {0, 0, 0, 6, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 8, 2, 0, 0},
                    {0, 0, 0, 4, 0, 0, 0, 0, 0},
                    {0, 6, 4, 3, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 8, 0, 2, 0, 0, 0, 5, 0},
                    {0, 0, 9, 0, 0, 0, 4, 0, 0}
            };

            case 99 -> new int[][]{
                    {5, 3, 4, 6, 7, 8, 9, 1, 2},
                    {6, 7, 2, 1, 9, 5, 3, 4, 8},
                    {1, 9, 8, 3, 4, 2, 5, 6, 7},
                    {8, 5, 9, 7, 6, 1, 4, 2, 3},
                    {4, 2, 6, 8, 5, 3, 7, 9, 1},
                    {7, 1, 3, 9, 2, 4, 8, 5, 6},
                    {9, 6, 1, 5, 3, 7, 2, 8, 4},
                    {2, 8, 7, 4, 1, 9, 6, 3, 5},
                    {3, 4, 5, 2, 8, 6, 1, 7, 9}

            };
            default -> new int[0][0];
        };

    }

    public void printBoard() {
        System.out.println("Initial Sudoku Board:");

        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }

            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }

                System.out.print(this.currentBoard[i][j] == 0 ? "  " : this.currentBoard[i][j] + " ");
            }

            System.out.println();
        }
    }


    public int[][] getInitialBoard() {
        int[][] newBoard = new int[9][9];
        for(int i = 0; i < this.initialBoard.length; i++){
            newBoard[i] = this.initialBoard[i].clone();
        }
        return newBoard;
    }

    public int[][] getCurrentBoard() {
        int[][] newBoard = new int[9][9];
        for(int i = 0; i < this.initialBoard.length; i++){
            newBoard[i] = this.currentBoard[i].clone();
        }
        return newBoard;
    }

    //b) verificar se o jogo está completo
    private boolean areThereSpacesToFill(){
        for (int[] ints : this.currentBoard) {
            for (int j = 0; j < this.currentBoard.length; j++) {
                if (ints[j] == 0)
                    return true;
            }
        }
        return false;
    }

    public void addNumber(int number, int row, int col) {
        if (isValidMove(row, col) && isValidNumber(number) && this.initialBoard[row][col] == 0 && this.currentBoard[row][col] == 0) {
            this.currentBoard[row][col] = number;
        }
        else {
            System.out.println("You can´t add an element in this cell");
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 9 && col >= 0 && col < 9;
    }

    private boolean isValidNumber(int number) {
        return number >= 1 && number <= 9;
    }


    public void removeANumberFromTheGame(int line, int column) {
        if (isValidMove(line, column) && this.initialBoard[line][column] == 0){
            this.currentBoard[line][column] = 0;
        }
        else {
            System.out.println("You can´t remove this element");
        }
    }

    private boolean canInsertNumberInPosition(int number, int line, int column){
        if(!isValidNumber(number) || !isValidMove(line,column))
            return false;
        if(!spaceChosenIsEmpty(line,column))
            return false;
        if(isNumberInColumn(column,number))
            return false;
        if(isNumberInLine(line,number))
            return false;
        //Para validar se o nr já está no quadrado:
        if(isNumberInThe3By3Matrix(number,line,column))
            return false;
        return true;
    }

    private boolean spaceChosenIsEmpty(int line, int column) {
        return this.currentBoard[line][column] == 0;
    }

    private boolean isNumberInColumn(int column, int number) {
        for(int i = 0; i < this.currentBoard.length; i++) {
            if (this.currentBoard[i][column] == number)
                return true;
        }
        return false;
    }

    private boolean isNumberInLine(int line, int number) {
        for(int j = 0; j < this.currentBoard[0].length; j++) {
            if (this.currentBoard[line][j] == number)
                return true;
        }
        return false;
    }

    private boolean isNumberInThe3By3Matrix(int number, int line, int column){
        int minLine = 3 * (line/3);
        int maxLine = minLine + 3;
        int minColumn = 3 * (column/3);
        int maxColumn = minColumn + 3;
        for(int i = minLine; i < maxLine; i++) {
            for (int j = minColumn; j < maxColumn; j++) {
                if (this.currentBoard[i][j] == number)
                    return true;
            }
        }
        return false;
    }


    public boolean isGameFinished(){
        if(areThereSpacesToFill())
            return false;
        for(int i = 0; i < this.currentBoard.length; i++) {
            for (int j = 0; j < this.currentBoard.length; j++) {
                if (this.initialBoard[i][j] == 0){
                    int aux = this.currentBoard[i][j];
                    this.currentBoard[i][j] = 0;
                    if (!canInsertNumberInPosition(aux, i, j))
                        return false;
                    this.currentBoard[i][j] = aux;
                }
            }
        }
        return true;
    }


}
