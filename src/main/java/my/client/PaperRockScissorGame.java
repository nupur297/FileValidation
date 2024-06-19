package my.client;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import my.client.data.Move;


public class PaperRockScissorGame {
    static int wins = 0;
    static int losses = 0;
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Paper-Rock-Scissors game!");
        System.out.println("How many rounds you would like to play?");
        try {
            int rounds = Integer.parseInt(scanner.nextLine());

            System.out.println("Choose one :\n  paper \n  rock \n  scissor");
            playGame(rounds, scanner);
        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException caught " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception caught " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void playGame(int rounds, Scanner scanner) {
        for (int round = 1; round <= rounds; round++) {
            playRound(round, scanner);
        }
    }

    public static void playRound(int round, Scanner scanner) {
        //getting input from the player
        System.out.println("------------ Round " + round + " -------------");
        System.out.print("Take your pick : ");

        String input = scanner.nextLine();

        Optional<Move> playerMove = getPlayersMove(input);

        if (playerMove.isEmpty()) {
            System.out.println("Your move isn't valid!");
            return;
        }

        my.client.data.Move computerMove = getComputerMove();
        System.out.println("Computer's pick : " + computerMove.getValue());
        getResult(playerMove.get(), computerMove);
    }


    public static Optional<Move> getPlayersMove(String input) {
        if (("quit").equals(input)) {
            System.out.println("You won " + wins + " times and lost " + losses + " times.");
            System.out.println("Thanks for playing! See you again.");
            return Optional.empty();
        }

        for (Move move : Move.values()) {
            if (move.getValue().equalsIgnoreCase(input)) {
                return Optional.of(move);
            }
        }
        return Optional.empty();
    }


    //random computer move
    public static Move getComputerMove() {
        return Move.values()[random.nextInt(Move.values().length)];
    }

    public static void getResult(Move playerMove, Move computerMove) {
        if (playerMove.equals(computerMove)) {
            System.out.println("TIE");
        } else if (isPlayerWin(playerMove, computerMove)) {
            System.out.println("YOU WIN!");
            wins++;
        } else {
            System.out.println("YOU LOSE!");
            losses++;
        }
    }

    public static boolean isPlayerWin(Move playerMove, Move computerMove) {
        return playerMove.equals(Move.PAPER) && computerMove.equals(Move.ROCK)
                || (playerMove.equals(Move.ROCK) && computerMove.equals(Move.SCISSOR))
                || (playerMove.equals(Move.SCISSOR) && computerMove.equals(Move.PAPER));
    }
}