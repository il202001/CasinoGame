package casino;

import java.util.Scanner;

public class firstTo21 {

    public static long theMainGame(long coins) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello this is 21\nYou need to input a number from 1-3 and that would add to the total\nThen the computer will say a number and that would get added to the total\nThe player (you or the computer) who takes the total to 21 or higher will loose.");
        long bet = betCheck.makeBet(coins);
        int total = 0;
        while (total < 21) {
            boolean valid = false;
            int userNum = 0;
            while (!valid) {
                try {
                    System.out.print("What is your number: ");
                    userNum = input.nextInt();
                    if (userNum == 1 || userNum == 2 || userNum == 3) {
                        valid = true;
                    } else {
                        System.out.println("That isn't a valid number.\nIt needs to be iether 1, 2 or 3");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }
            System.out.println("The total is " + (total = (total + userNum)));
            if (total < 21) {
                total = total + computerResponce(userNum);
                System.out.println("The total is " + total);
            }
        }
        System.out.println("you lost " + bet + " coins");
        coins = coins - bet;
        return (coins);
    }

    public static int computerResponce(int playersNum) {
        int compNum = 0;
        switch (playersNum) {
            case (1):
                compNum = 3;
                break;
            case (2):
                compNum = 2;
                break;
            case (3):
                compNum = 1;
                break;
        }
        System.out.println("I'm going to say " + compNum);
        return (compNum);
    }
}
