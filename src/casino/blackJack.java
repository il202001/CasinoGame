package casino;

import static java.lang.Character.getNumericValue;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class blackJack {

    private static String[][] deck = new String[13][4];

    public static long blackJack(long coins) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> playerHand = new ArrayList<>();
        ArrayList<String> compHand = new ArrayList<>();
        System.out.println("This is Black Jack");
        long bet = betCheck.makeBet(coins);
        deckMaker();
        System.out.println("The first caricter of a card is the value (e.g. 3, 6, Q, A...) \nThe second caricter of the card of a card is the suit (S = spade, H = Hart ...)");
        boolean playerStand = false;
        boolean compStand = false;
        for (int i = 0; i < 2; i++) {
            playerHand.add(dealCard());
            compHand.add(dealCard());
        }
        while (!(playerStand && compStand)) {
            System.out.println("Your deck is: ");
            printHand(playerHand);
            String choice = "?";
            boolean valid = false;
            while (!valid) {
                System.out.print("\nDo you want to Hit or Stand: ");
                choice = input.next().toLowerCase();
                switch (choice) {
                    case ("hit"):
                        playerHand.add(dealCard());
                        valid = true;
                        break;
                    case ("stand"):
                        playerStand = true;
                        valid = true;
                        break;
                    default:
                        System.out.println("Not a valid answer");
                }
            }
            compStand = compChoice(compHand);
            if (!compStand) {
                System.out.println("The computer has hit");
                compHand.add(dealCard());
            } else {
                System.out.println("The computer has stood");
            }
        }
        coins = winCheck(playerHand, compHand, coins, bet);
        return (coins);
    }

    private static String dealCard() {
        Random rand = new Random();
        String card = "?";
        boolean pickedCard = false;
        while (!pickedCard) {
            int value = rand.nextInt(13);
            int suit = rand.nextInt(4);
            if (!(deck[value][suit] == null)) {
//                System.out.println("Value" + value);
//                System.out.println("suit" + suit);
                switch (value) {
                    case 10:
                        card = "0" + deck[value][suit];
                        break;
                    case 11:
                        card = "J" + deck[value][suit];
                        break;
                    case 12:
                        card = "Q" + deck[value][suit];
                        break;
                    case 13:
                        card = "K" + deck[value][suit];
                        break;
                    default:
                        card = value + deck[value][suit];
                        break;
                }
                //System.out.println(card);
                deck[value][suit] = null;
                pickedCard = true;
            }
        }

        return (card);
    }

    private static int deckCount(ArrayList<String> hand) {
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            char hold = hand.get(i).charAt(0);
            switch (String.valueOf(hold)) {
                case ("0"):
                    total = total + 10;
                    break;
                case ("J"):
                    total = total + 10;
                    break;
                case ("Q"):
                    total = total + 10;
                    break;
                case ("K"):
                    total = total + 10;
                    break;
                default:
                    total = total + getNumericValue(hold);
                    break;
            }
        }
        return (total);
    }

    private static void printHand(ArrayList<String> hand) {
        for (int i = 0; i < hand.size(); i++) {
            switch (String.valueOf(hand.get(i).charAt(0))) {
                case ("0"):
                    System.out.print("10" + (hand.get(i).charAt(1)) + " ");
                    break;
                default:
                    System.out.print(hand.get(i) + " ");
                    break;
            }
        }
    }

    private static boolean compChoice(ArrayList<String> hand) {
        boolean stand = false;
        int total = deckCount(hand);
        if (total >= 16) {
            stand = true;
        }
        return (stand);
    }

    private static long winCheck(ArrayList<String> pHand, ArrayList<String> cHand, long coins, long bet) {
        int pTotal = deckCount(pHand);
        int cTotal = deckCount(cHand);
        System.out.println("You got a total of " + pTotal + "\nThe computer got a total of " + cTotal);
        if (pTotal > 21 && cTotal <= 21) {
            coins = coins - bet;
            System.out.println("You lost " + bet + " coins");
        } else if (cTotal > 21 && pTotal <= 21) {
            coins = coins + bet * 2;
            System.out.println("You won " + bet * 3 + " coin");
        } else if ((pTotal > 21 && cTotal > 21)) {
            System.out.println("You both lost \nyou got " + bet + " coins back");
        } else if (pTotal < 22 && cTotal < 22) {
            if ((21 - pTotal) < (21 - cTotal)) {
                coins = coins + bet * 2;
                System.out.println("You won " + bet * 3 + " coin");
            } else if ((21 - pTotal) > (21 - cTotal)) {
                coins = coins - bet;
                System.out.println("You lost " + bet + " coins");
            } else {
                System.out.println("You drew\nyou got " + bet + " coins back");
            }
        }
        return (coins);
    }

    private static void deckMaker() {
        for (int i = 0; i < 13; i++) {
            deck[i][0] = "S";
            deck[i][1] = "H";
            deck[i][2] = "C";
            deck[i][3] = "D";
        }
    }
}
