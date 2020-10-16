import java.util.*;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RockScissorsPaper {
    @Getter
    private ResourceBundle resourceBundle;
    private User user;
    private Computer computer;
    private int userScore;
    private int computerScore;
    private int numberOfGames;
    private WriteRead writeRead;

    @Getter
    private final Logger logg = LoggerFactory.getLogger(RockScissorsPaper.class);

    public RockScissorsPaper(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        user = new User();
        computer = new Computer();
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
        writeRead = new WriteRead("/Users/vlad/Desktop/Hillel_HomeWork/" +
                "Hillel_Homework/HomeWork_22/src/main/resources/result.txt",resourceBundle);
    }

    public void start() {
        System.out.println(resourceBundle.getString("exit"));
        logg.info("User " + user.name +" plays " + (numberOfGames + 1) + "-th game");
        System.out.print(resourceBundle.getString("move"));
        Move userMove = user.getMove();
        Move computerMove = computer.getMove();
        //logg
        logg.info("User "+ user.name + " : {}  Computer: {}", userMove, computerMove);
        System.out.println(resourceBundle.getString("user") + resourceBundle.getString(userMove.toString()));
        System.out.println(resourceBundle.getString("computer") + resourceBundle.getString(computerMove.toString()) + "\n");

        int compareMoves = userMove.compareMoves(computerMove);
        switch (compareMoves) {
            case 0:
                System.out.println(resourceBundle.getString("draw"));
                break;
            case 1:
                System.out.println(resourceBundle.getString(userMove.toString()) + resourceBundle.getString("beats")
                        + resourceBundle.getString(computerMove.toString()) + resourceBundle.getString("youWin"));
                userScore++;
                break;
            case -1:
                System.out.println(resourceBundle.getString(computerMove.toString())
                        + resourceBundle.getString("beats") + resourceBundle.getString(userMove.toString())
                        + resourceBundle.getString("youLose"));
                computerScore++;
                break;
        }
        numberOfGames++;

        if (user.playAgain()) {
            //logg
            logg.info("User decided to play again");
            System.out.println();
            start();
        } else {
            printGame();
        }
    }

    private void printGame() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;
        double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;
        logg.info("User "+ user.name + " Games: " + numberOfGames + " Wins: " + wins + " Looses: " +
                computerScore + " Ties: " + ties + " W/L(%): " + percentageWon );
        writeRead.write(user.name,numberOfGames,wins,losses,ties,percentageWon);
        String s =  writeRead.readToString();
        System.out.println(s);

    }
    private class User {
        private String name;
        private final Scanner inputScanner;

        public String getName() {
            return name;
        }

        public User() {
            System.out.print(resourceBundle.getString("hello"));
            inputScanner = new Scanner(System.in);
            name = inputScanner.nextLine();
        }

        public boolean playAgain() {
            System.out.print(resourceBundle.getString("again"));
            String userInput = inputScanner.nextLine();
            userInput = userInput.toUpperCase();
            return userInput.charAt(0) == resourceBundle.getString("yes").toUpperCase().charAt(0);
        }

        private void exit(String val){
            char val1 =  val.toUpperCase().charAt(0);
            if (val1 == resourceBundle.getString("chooseResult").charAt(0)){
                logg.info("User press \"result\"");
                String s =  writeRead.readToString();
                System.out.println(s);
                System.exit(0);
            }
            else
            if (val1 == resourceBundle.getString("chooseExit").charAt(0)){
                logg.info("User press \"exit\"");
                System.exit(0);
            }
        }


        public Move getMove() {
            String val = inputScanner.nextLine();
            if (Objects.isNull(val) || val.equals("")) throw new NullPointerException();
            val = val.toUpperCase();
            exit(val);
            char firstLetter = val.charAt(0);
            char Rock = resourceBundle.getString("ROCK").charAt(0);
            char Scissors = resourceBundle.getString("SCISSORS").charAt(0);
            char Paper = resourceBundle.getString("PAPER").charAt(0);

            if (firstLetter == Rock || firstLetter == Scissors || firstLetter == Paper) {

                if (firstLetter == Rock) return Move.ROCK;
                if (firstLetter == Scissors) return Move.SCISSORS;
                if (firstLetter == Paper) return Move.PAPER;
            }
            return getMove();
        }
    }

    private static class Computer {
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
