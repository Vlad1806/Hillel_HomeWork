import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaper {

    private User user;
    private Computer computer;
    private int userScore;
    private int computerScore;
    private int numberOfGames;
    WriteRead writeRead = new WriteRead("/Users/vlad/Desktop/Hillel_HomeWork/Hillel_Homework/HomeWork_16/result.txt");

    public RockScissorsPaper() {
        user = new User();
        computer = new Computer();
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    public void start() {
        System.out.print("Enter: Rock, Scissors, Paper : ");
        Move userMove = user.getMove();
        Move computerMove = computer.getMove();
        System.out.println("\nUser  " + userMove + ".");
        System.out.println("Computer  " + computerMove + ".\n");

        int compareMoves = userMove.compareMoves(computerMove);
        switch (compareMoves) {
            case 0:
                System.out.println("Tie!");
                break;
            case 1:
                System.out.println(userMove + " beats " + computerMove + ". You win!");
                userScore++;
                break;
            case -1:
                System.out.println(computerMove + " beats " + userMove + ". You lose.");
                computerScore++;
                break;
        }
        numberOfGames++;

        if (user.playAgain()) {
            System.out.println();
            start();
        } else {
            try {
                printGame();// insert write file;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void printGame() throws IOException {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;
        double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;
        writeRead.write(user.name,numberOfGames,wins,losses,ties,percentageWon);
        String s =  writeRead.readToString();
        System.out.println(s);
    }
    private class User {
        private String name;
        private Scanner inputScanner;

        public String getName() {
            return name;
        }

        public User() {
            inputScanner = new Scanner(System.in);
            System.out.print("Enter your name : ");
            name = inputScanner.nextLine();
            exit(name);
        }

        public boolean playAgain() {
            System.out.print("You wanna play again? ");
            String userInput = inputScanner.nextLine();
            userInput = userInput.toUpperCase();
            return userInput.charAt(0) == 'Y';
        }

        private void exit(String val){
           val =  val.toUpperCase();
            if (val.equals("RESULT")){
               String s =  writeRead.readToString();
                System.out.println(s);
                System.exit(0);
            }
            else
                if (val.equals("EXIT")){
                    System.exit(0);
                }
        }
        public Move getMove() {
            String val = inputScanner.nextLine();
            if (Objects.isNull(val) || val.equals("")) throw new NullPointerException();
            val = val.toUpperCase();
            exit(val);
            char firstLetter = val.charAt(0);
            if (firstLetter == 'R' || firstLetter == 'S' || firstLetter == 'P') {
                switch (firstLetter) {
                    case 'R':
                        return Move.ROCK;
                    case 'P':
                        return Move.PAPER;
                    case 'S':
                        return Move.SCISSORS;
                }
            }
            return getMove();
        }
    }

    private class Computer {
        public Move getMove() {
            Move[] moves = Move.values();
            Random random = new Random();
            int index = random.nextInt(moves.length);
            return moves[index];
        }
    }

    private enum Move {
        ROCK, PAPER, SCISSORS;
        public int compareMoves(Move otherMove) {
            if (this == otherMove) return 0;

            switch (this) {
                case ROCK:
                    return (otherMove == SCISSORS ? 1 : -1);
                case PAPER:
                    return (otherMove == ROCK ? 1 : -1);
                case SCISSORS:
                    return (otherMove == PAPER ? 1 : -1);
            }
            return 0;
        }
    }
}
