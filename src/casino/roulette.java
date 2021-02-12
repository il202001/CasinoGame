package casino;

import java.util.Scanner;
import java.util.Random;

public class roulette {

    public static long theMainGame(long coins) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("What do you want to bet on:\nBlack or Red (1)\nTriple (2)\nOne number (3)");
                int rouletteNum = rand.nextInt(37);
                int Choice = input.nextInt();
                long bet;
                switch (Choice) {
                    case (1):
                        bet = betCheck.makeBet(coins);
                        while (!validInput) {
                            System.out.print("Black or Red? ");
                            String BRchoice = input.next().toLowerCase();
                            switch (BRchoice) {
                                case ("black"):
                                    if (rouletteNum == 0) {
                                        System.out.println(rouletteNum + "\nYou lost " + (bet) + " coins");
                                        coins = coins - bet;
                                    } else if (rouletteNum % 2 == 0) {
                                        System.out.println(rouletteNum + " Black\nYou won\nYou made " + (bet * 2) + " coins back");
                                        coins = coins + bet;
                                    } else {
                                        System.out.println(rouletteNum + " red\nYou lost " + (bet) + " coins");
                                        coins = coins - bet;
                                    }
                                    validInput = true;
                                    break;
                                case ("red"):
                                    if (rouletteNum == 0) {
                                        System.out.println(rouletteNum + "\nYou lost " + (bet) + " coins");
                                        coins = coins - bet;
                                    } else if (rouletteNum % 2 == 1) {
                                        System.out.println(rouletteNum + " Red\nYou won\nYou made " + (bet * 2) + " coins back");
                                        coins = coins + bet;
                                    } else {
                                        System.out.println(rouletteNum + " Black\nYou lost " + (bet) + " coins");
                                        coins = coins - bet;
                                    }
                                    validInput = true;
                                    break;
                                default:
                                    System.out.println("Input not valid");
                                    break;
                            }
                        }
                        break;
                    case (2):
                        bet = betCheck.makeBet(coins);
                        System.out.println("Where do you want to bet:\n1-12 (1)\n13-24 (2)\n25-36 (3)");
                        int low = -1;
                        int high = -1;
                        while (!validInput) {
                            try {
                                int TripChoice = input.nextInt();

                                switch (TripChoice) {
                                    case (1):
                                        low = 1;
                                        high = 12;
                                        validInput = true;
                                        break;
                                    case (2):
                                        low = 13;
                                        high = 24;
                                        validInput = true;
                                        break;
                                    case (3):
                                        low = 25;
                                        high = 36;
                                        validInput = true;
                                        break;
                                    default:
                                        System.out.println("Input not valid");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("Error: " + e);
                            }
                        }
                        if (rouletteNum >= low && rouletteNum <= high) {
                            System.out.println(rouletteNum + " \nYou won\nYou made " + (bet * 3) + " coins back");
                            coins = coins + bet * 2;
                        } else {
                            System.out.println(rouletteNum + "\nYou lost " + (bet) + " coins");
                            coins = coins - bet;
                        }
                        break;
                    case (3):
                        bet = betCheck.makeBet(coins);
                        System.out.print("Where do you want to bet (1-36): ");
                        while (!validInput) {
                            try {
                                int betLocation = input.nextInt();
                                if (betLocation >= 1 && betLocation <= 36) {
                                    if (rouletteNum == betLocation) {
                                        System.out.println(rouletteNum + " \nYou won\nYou made " + (bet * 36) + " coins back");
                                        coins = coins + bet * 35;
                                    } else {
                                        System.out.println(rouletteNum + "\nYou lost " + (bet) + " coins");
                                        coins = coins - bet;
                                    }
                                    validInput = true;
                                }
                            } catch (Exception e) {
                                System.out.println("Error: " + e);
                            }
                        }

                        break;
                    default:
                        System.out.println("Not a valid input");

                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return (coins);
    }
}
