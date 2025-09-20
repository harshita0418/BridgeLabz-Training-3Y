package string_practice_level_2;

import java.util.Scanner;

public class RockPaperScissors {

    static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        return switch (choice) {
            case 0 -> "Rock";
            case 1 -> "Paper";
            default -> "Scissors";
        };
    }

    static String getWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if (user.equals("Rock") && computer.equals("Scissors")) return "User";
        if (user.equals("Paper") && computer.equals("Rock")) return "User";
        if (user.equals("Scissors") && computer.equals("Paper")) return "User";
        return "Computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        int userWins = 0, computerWins = 0, draws = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Game " + i + " - Enter Rock, Paper, or Scissors: ");
            String user = sc.next();
            String computer = getComputerChoice();
            String winner = getWinner(user, computer);
            System.out.println("Computer chose: " + computer);
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;
            else draws++;
            System.out.println("Winner: " + winner + "\n");
        }

        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Draws: " + draws);
        System.out.printf("User Win%%: %.2f%%\n", (userWins*100.0/n));
        System.out.printf("Computer Win%%: %.2f%%\n", (computerWins*100.0/n));
        sc.close();
    }
}
