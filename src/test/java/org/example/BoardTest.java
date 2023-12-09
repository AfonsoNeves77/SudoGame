package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {


    @Test
    void instantiationError_InvalidDifficultLevel() throws InstantiationException {
        //Arrange
        String actualMessage = "Invalid difficulty level.";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> new Board(4));
        String result = exception.getMessage();
        //Assert
        assertEquals(actualMessage,result);
    }


    @Test
    void instantiationSuccessful() throws InstantiationException {
        //Arrange
        Board board = new Board(1);
        int[][] expected = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9},
        };
        //Act
        int result[][] = board.getInitialBoard();
        //Assert
        assertArrayEquals(expected,result);
    }


    //____________________________________________________________

    @Test
    void gameIsFinished() throws InstantiationException {
        //Arrange
        Board myBoard = new Board(99);

        //Act
        boolean result = myBoard.isGameFinished();

        //Assert
        assertTrue(myBoard.isGameFinished());
    }

    @Test
    void gameIsNotFinished() throws InstantiationException {
        //Arrange
        Board myBoard = new Board(1);

        //Act
        boolean result = myBoard.isGameFinished();

        //Assert
        assertFalse(myBoard.isGameFinished());
    }

    //____________________________________________________________

}