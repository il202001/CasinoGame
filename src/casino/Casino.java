package casino;

import java.util.Scanner;

public class Casino {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int log = -1;
        while (log == -1) {
            System.out.println("hello\nDo you want to login (1) or sign up (2)");
            log = input.nextInt();
        }
        int user = -1;
        switch (log) {
            case (1):
                user = login.login();
                break;
            case (2):
                user = login.signUp();
                break;
        }
        long coins = login.getCoins(user);
        System.out.println("you have " + coins + " coins");

        boolean run = true;
        while (run) {
            boolean valid = false;
            int choice = 0;
            while (!valid) {
                try {
                    System.out.println("What do you want to play?\n(1) Roulette\n(2) 21\n(3) Black Jack\n(4) Log out");
                    choice = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Error: " + e+"\nInput a number");
                    
                }
                valid = true;
            }

            String keepGoing = "yes";
            switch (choice) {
                case (1):
                    while (keepGoing.equals("yes")) {
                        coins = roulette.theMainGame(coins);
                        System.out.println("Do you want to keepGoing? yes or no");
                        keepGoing = input.next().toLowerCase();
                    }
                    break;
                case (2):
                    while (keepGoing.equals("yes")) {
                        coins = firstTo21.theMainGame(coins);
                        System.out.println("Do you want to keepGoing? yes or no");
                        keepGoing = input.next().toLowerCase();
                    }
                    break;
                case (3):
                    while (keepGoing.equals("yes")){
                        coins = blackJack.blackJack(coins);
                        System.out.println("Do you want to keepGoing? yes or no");
                        keepGoing = input.next().toLowerCase();
                    }
                    
                    break;
                case (4):
                    run = false;
                    break;
                default:
                    System.out.println("Thats not a valid input");
            }
        }

        login.logOut(user, coins);

    }
}
