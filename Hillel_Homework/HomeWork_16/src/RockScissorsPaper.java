import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaper {

    private User user;
    private Computer computer;
    private int userScore;
    private int computerScore;
    private int numberOfGames;
    File f;

    public RockScissorsPaper(){
        f = new File("/Users/vlad/Desktop/Hillel_HomeWork/Hillel_Homework/HomeWork_16","result.txt");
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
    private void read(File f) throws IOException {
        FileInputStream fos = new FileInputStream (f);
        int size = fos.available();
        char[] chars = new char[size];
        for (int i = 0; i < size; i++){
           chars[i] = (char) fos.read();
        }
        String[] str;
        String s = new String(chars);
        str = s.split("%");

        String s1;
        String[] str2;
        for (int j = 0; j < str.length; j++) {
            s1 = str[j];
            str2 = s1.split(" ");

            for (int i = 0; i < str.length; i += 7) {
                System.out.println("");
                System.out.println("Name : " + str2[i]);
                System.out.println("Count games : " + str2[i + 1]);
                System.out.println("Wins : " + str2[i + 2]);
                System.out.println("Loses : " + str2[i + 3]);
                System.out.println("Ties : " + str2[i + 4]);
                System.out.println("Wins (%) : " + str2[i + 5]);
            }
        }
    }
    private void printGame() throws IOException {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;
        double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;
        String res = user.getName() +" "+ numberOfGames +" "+ wins +" "+ computerScore +" "+ ties +" "+ percentageWon;
        if (f.exists()){
        FileWriter fileWriter = new FileWriter(f,true);
        fileWriter.write(res);
        fileWriter.write("%");
        fileWriter.close();
        }else {
            f.createNewFile();
        }
        read(f);
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
                try {
                   read(f);
                   System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
