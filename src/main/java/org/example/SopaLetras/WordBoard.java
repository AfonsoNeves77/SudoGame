package org.example.SopaLetras;

import java.util.Arrays;

public class WordBoard {

    private char[][] wordBoard;
    private int difficulty;

    public WordBoard(int difficulty) throws InstantiationException{
        this.difficulty = difficulty;
        char[][] generatedBoard = woardBoardGenerator();
        if (Arrays.deepEquals(generatedBoard, new int[0][0])) {
            throw new InstantiationException("Invalid difficulty level.");
        }
        this.wordBoard = woardBoardGenerator();
    }


    private char[][] woardBoardGenerator(){
        return switch (difficulty) {
            case 1 -> new char[][]{

                {'c', 'a', 't', 's'},
                {'l', 'o', 'w', 'o'},
                {'d', 'o', 'f', 'h'},
                {'b', 'i', 'r', 'f'},
            };
            case 2 -> new char[][]{
                    {'s', 'u', 'n', 'f', 'l', 'c'},
                    {'b', 'u', 't', 't', 'e', 'r'},
                    {'p', 'p', 'c', 'n', 'i', 'o'},
                    {'b', 'e', 'a', 'c', 'h', 'w'},
                    {'f', 'r', 'u', 'i', 't', 's'},
                    {'a', 'l', 'r', 'd', 'i', 'n'},
            };

            case 3 -> new char[][]{
                    {'m', 'o', 'u', 'n', 't', 'a', 'i', 'n'},
                    {'r', 'i', 'v', 'e', 'r', 'v', 'a', 'l'},
                    {'f', 'o', 'r', 'e', 's', 't', 'w', 'o'},
                    {'o', 'c', 'e', 'a', 'n', 'b', 'e', 'a'},
                    {'d', 'e', 's', 'e', 'r', 't', 's', 'a'},
                    {'n', 'd', 'd', 'u', 'n', 'e', 's', 't'},
                    {'f', 'a', 'l', 'l', 'i', 'n', 'g', 's'},
                    {'s', 'u', 'n', 's', 'e', 't', 's', 't'},

            };
            default -> new char[0][0];
        };

    }

    public void printWoardBoard() {

        System.out.println("----------------------------");
        for (int i = 0; i < this.wordBoard.length; i++) {
            for (int j = 0; j < this.wordBoard[i].length; j++) {

                System.out.print(" " + this.wordBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }


    public int[] wordExists(char[] word) {
        if (word.length > 0) {
            for (int y = 0; y < this.wordBoard.length; y++) {
                for (int x = 0; x < this.wordBoard[y].length; x++) {
                    if (this.wordBoard[y][x] == word[0]) {

                        if (verticalUp(word, y, x)) {
                            return new int[]{y,x,y-(word.length-1),x};
                        }
                        if (horizontalRight(word, y, x)) {
                            return new int[]{y,x,y,x+(word.length-1)};
                        }

                        if (horizontalLeft(word, y, x)) {
                            return new int[]{y,x,y,x-(word.length-1)};
                        }

                        if (verticalDown(word, y, x)) {
                            return new int[]{y,x,y+(word.length-1),x};
                        }

                        if (diagonalUpperRight(word, y, x)) {
                            return new int[]{y,x,y-(word.length-1),x+(word.length-1)};
                        }

                        if (diagonalUpperLeft(word, y, x)) {
                            return new int[]{y,x,y-(word.length-1),x-(word.length-1)};
                        }

                        if (diagonalDownRight(word, y, x)) {
                            return new int[]{y,x,y+(word.length-1),x+(word.length-1)};
                        }

                        if (diagonalDownLeft(word, y, x)) {
                            return new int[]{y,x,y+(word.length-1),x-(word.length-1)};
                        }
                    }
                }
            }
        }
        return new int[0];
    }


    private boolean horizontalRight(char[] word, int y, int x) {
        if (x + word.length <= this.wordBoard[y].length) {
            boolean found = true;
            for (int k = 1; k < word.length; k++) {
                if (this.wordBoard[y][x + k] != word[k]) {
                    found = false;
                    break;
                }
            }
            return found;
        }
        return false;
    }

    private boolean horizontalLeft(char[] word, int y, int x) {
        if (x >= word.length - 1) {
            boolean found = true;
            for (int k = 1; k < word.length; k++) {
                if (this.wordBoard[y][x - k] != word[k]) {
                    found = false;
                    break;
                }
            }
            return found;
        }
        return false;
    }

    private boolean verticalDown(char[] word, int y, int x) {
        if (y + word.length <= this.wordBoard.length) {
            boolean found = true;
            for (int k = 1; k < word.length; k++) {
                if (this.wordBoard[y + k][x] != word[k]) {
                    found = false;
                    break;
                }
            }
            return found;
        }
        return false;
    }

    private boolean verticalUp(char[] word, int y, int x) {
        if (y >= word.length - 1) {
            boolean found = true;
            for (int k = 1; k < word.length; k++) {
                if (this.wordBoard[y - k][x] != word[k]) {
                    found = false;
                    break;
                }
            }
            return found;
        }
        return false;
    }

    private boolean diagonalUpperRight(char[] word, int y, int x) {
        if (x + word.length <= this.wordBoard[y].length && y - (word.length - 1) >= 0) {
            boolean found = true;
            for (int k = 1; k < word.length; k++) {
                if (this.wordBoard[y - k][x + k] != word[k]) {
                    found = false;
                    break;
                }
            }
            return found;
        }
        return false;
    }

    private boolean diagonalUpperLeft(char[] word, int y, int x) {
        if (y - (word.length - 1) >= 0 && x >= word.length - 1) {
            boolean found = true;
            for (int k = 1; k < word.length; k++) {
                if (this.wordBoard[y - k][x - k] != word[k]) {
                    found = false;
                    break;
                }
            }
            return found;
        }
        return false;
    }

    private boolean diagonalDownRight(char[] word, int y, int x) {
        if (x + word.length <= this.wordBoard[y].length && y + word.length <= this.wordBoard.length) {
            boolean found = true;
            for (int k = 1; k < word.length; k++) {
                if (this.wordBoard[y + k][x + k] != word[k]) {
                    found = false;
                    break;
                }
            }
            return found;
        }
        return false;
    }

    private boolean diagonalDownLeft(char[] word, int y, int x) {
        if (y + word.length <= this.wordBoard.length && x >= word.length - 1) {
            boolean found = true;
            for (int k = 1; k < word.length; k++) {
                if (this.wordBoard[y + k][x - k] != word[k]) {
                    found = false;
                    break;
                }
            }
            return found;
        }
        return false;
    }

    public boolean isWordComplete(char[] word, int startLine, int startColumn, int endLine, int endColumn) {
            if (startLine == endLine) {
                if (startColumn > endColumn) {
                    return horizontalLeft(word, startLine, startColumn);
                }

                if (startColumn < endColumn) {
                    return horizontalRight(word, startLine, startColumn);
                }
            }

            if (startColumn == endColumn) {
                if (startLine > endLine) {
                    return verticalUp(word, startLine, startColumn);
                }

                if (startLine < endLine) {
                    return verticalDown(word, startLine, startColumn);
                }
            }

            if (startLine == endLine - (word.length - 1)) {
                if (startColumn > endColumn) {
                    return diagonalDownLeft(word, startLine, startColumn);
                }

                if (startColumn < endColumn) {
                    return diagonalDownRight(word, startLine, startColumn);
                }
            }

            if (startLine - (word.length - 1) == endLine) {
                if (startColumn > endColumn) {
                    return diagonalUpperLeft(word, startLine, startColumn);
                }

                if (startColumn < endColumn) {
                    return diagonalUpperRight(word, startLine, startColumn);
                }
            }
            return false;
    }
    public boolean wordsIntersect(char[] word1,char[] word2) {
        int[] coordWord1 = this.wordExists(word1);
        int[] coordWord2 = this.wordExists(word2);

       if(coordWord2.length != 0 && coordWord1.length != 0) {

           int x1Beg = Math.min(coordWord1[0], coordWord1[2]);
           int y1Beg = Math.min(coordWord1[1], coordWord1[3]);
           int x1End = Math.max(coordWord1[0], coordWord1[2]);
           int y1End = Math.max(coordWord1[1], coordWord1[3]);

           int x2Beg = Math.min(coordWord2[0], coordWord2[2]);
           int y2Beg = Math.min(coordWord2[0], coordWord2[3]);
           int x2End = Math.max(coordWord2[0], coordWord2[2]);
           int y2End = Math.max(coordWord2[0], coordWord2[3]);

           return (x1Beg <= x2End && x1End >= x2Beg && y1Beg <= y2End && y1End >= y2Beg);
       }
       return false;
    }

}


