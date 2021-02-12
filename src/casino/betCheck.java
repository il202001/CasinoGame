package casino;

import java.util.Scanner;

public class betCheck {
    public static long makeBet(long coins) {
        Scanner input = new Scanner(System.in);
        boolean bigEnoughBal = false;
        long bet = 0;
        while (!bigEnoughBal) {
            try {
                input.nextLine();
                System.out.print("You have " + coins + " coins\nHow much do you want to bet? ");
                bet = input.nextLong();
                if (coins >= bet && bet > 0) {
                    System.out.println("You can make this bet");
                    bigEnoughBal = true;
                } else {
                    System.out.println("You don't have enough to make this bet");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return (bet);
    }
}
