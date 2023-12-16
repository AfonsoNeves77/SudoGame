package org.example;

import org.example.SopaLetras.WordBoard;
import org.example.SopaLetras.WordGameController;
import org.example.Sudoku.GameController;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InstantiationException {
      /*GameController gameController = new GameController(2);
      gameController.startGame();*/
        WordGameController wb = new WordGameController(1);
        wb.gameLogic(3, "cats","coff",0,0,0,3);




    }
}