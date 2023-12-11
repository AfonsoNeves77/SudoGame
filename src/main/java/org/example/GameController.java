package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {

    private Board board;
    private Scanner scanner;

    public final String MESSAGE_OPTION = """
        Options:
        1 - Add Number
        2 - Remove Number:
        Option:\s
        """;

    public GameController(int dif) throws InstantiationException {
        this.board = new Board(dif);
        this.scanner = new Scanner(System.in);
    }

    public void startGame(){
        System.out.println("Welcome to Sudoku Game!");
        board.printBoard();
        while(!board.isGameFinished()){
            int option = optionInput(MESSAGE_OPTION);
            if(option == 1) {
                int number = getUserInput("Enter a number 1-9: ");
                int line = getUserInput("Enter a line 0-8: ");
                int column = getUserInput("Enter a row 0-8: ");

               addNumberUserInput(number, line, column);
            }
            else {
                int line = getUserInput("Enter a line 0-8: ");
                int column = getUserInput("Enter a row 0-8: ");

               removeNumberUserInput(line,column);
            }
            board.printBoard();
        }

        System.out.println("Congrats! You have completed the game!");

    }

    private int optionInput(String prompt){
        int option = -1;
        boolean validOption = false;

        while (!validOption){
            try{
                System.out.print(prompt);
                option = scanner.nextInt();
                if (option >= 1 && option <= 2) {
                    validOption = true;
                } else {
                    System.out.println("Invalid Option. Please chose valid option");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid format input. Enter a valid format please");
                scanner.nextLine();
            }

        }
        return option;
    }


    private int getUserInput(String prompt){
        int input = -1;
        boolean validInput = false;

        while (!validInput){
            try{
                System.out.print(prompt);
                input = scanner.nextInt();
                if (input >= 0 && input <= 9) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input. Enter a valid number please");
                scanner.nextLine();
            }

        }
        return input;
    }

    private void addNumberUserInput(int number, int row, int col) {
        board.addNumber(number, row, col);
        if (board.isGameFinished()) {
            System.out.println("Congratulations! You have completed the Sudoku puzzle.");
        }
    }

    private void removeNumberUserInput(int row, int col) {
        board.removeANumberFromTheGame(row, col);
    }






}
