import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int point = 0;
            int sum = rollDice(random);
            System.out.println("First roll: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                point = sum;
                System.out.println("Point is " + point);
            }

            while (point != 0) {
                sum = rollDice(random);
                System.out.println("Next roll: " + sum);
                if (sum == point) {
                    System.out.println("Made point and won.");
                    break;
                } else if (sum == 7) {
                    System.out.println("Got a seven and lost.");
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String choice = scanner.nextLine();
            playAgain = choice.equalsIgnoreCase("yes");
        }
        scanner.close();
    }

    public static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        return die1 + die2;
    }
}
