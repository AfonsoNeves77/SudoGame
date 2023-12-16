package org.example.SopaLetras;

public class WordGameController {
    private WordBoard board;
    public final String MESSAGE_OPTION = """
        Options:
        1 - Check if a certain word exists;
        2 - Check if a certain word is complete;
        3 - Check if two words intersect;
      
        Option:\s
        """;

    public WordGameController(int dif) throws InstantiationException {
        this.board = new WordBoard(dif);
    }

    public void gameLogic(int option,String word1,String word2,int startLine, int startColumn, int endLine, int endColumn){
        System.out.println("Welcome to word finder Game!");
        board.printWoardBoard();
        System.out.println(MESSAGE_OPTION);
        char[] wordOne = word1.toCharArray();
        char[] wordTwo = word2.toCharArray();

        if(option == 1) {
            if(board.wordExists(wordOne).length != 0){
                System.out.println("This word exists");
            }
            else {
                System.out.println("This word doesnt´t exist");
                }
            }
        if(option == 2) {
            if(board.isWordComplete(wordOne,startLine,startColumn,endLine,endColumn)){
                System.out.println("This word is complete");
            }
            else {
                System.out.println("This word is not complete");
            }
        }
        if(option == 3) {
            if(board.wordsIntersect(wordOne,wordTwo)){
                System.out.println("These words intersect");
            }
            else {
                System.out.println("These words don´t intersect");
            }
        }
        }





}
