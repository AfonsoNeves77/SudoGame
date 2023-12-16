package org.example;

import org.example.SopaLetras.WordBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordBoardTest {

    @Test
    void wordExists_HorizontalRight() throws InstantiationException {
        //Arrange
        WordBoard wordBoard = new WordBoard(1);
        String word1 = "cats";
        int[] expected = {0,0,0,3};

        //Act
        int[] result = wordBoard.wordExists(word1.toCharArray());

        //Assert
        assertArrayEquals(expected,result);
    }
    @Test
    void invalidDifficulty()  {
        /*String word1 = "cats";
        String word2 = "coff";
        int startLine = 0;
        int endLine = 0;
        int startColumn = 0;
        int endColumn = 0;
        int[] expected = {0,0,0,3}; Para ser usado e outros testes*/

        //Act + Arrange
        String expected = "Invalid difficulty level.";
        Exception exception = assertThrows(InstantiationException.class,() -> new WordBoard(99));
        String result = exception.getMessage();

        //Assert
        assertEquals(expected,result);
    }



}
