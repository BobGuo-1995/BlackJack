package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        /*this is a black jack program:

       The computer deals four cards drawn randomly from the deck.  The cards are dealt in this order:
       •	one to player (shown)
       •	one to dealer (not shown)
       •	one to player (shown)
       •	one to dealer (shown)
       The player wants to get a total score of 21 or less on the cards dealt.
       She can repeatedly ask for another card until she indicates that she does not want any more cards.
       The player determines if she wants another card by seeing how close she is to 21.
       The closer she is to 21, the riskier it is for her to get another card.
       But she wants to get as close as possible so as to beat the dealer.


       After the player has gotten all the cards she wants, it's the dealer's turn.
       The dealer's hidden card is revealed.  Then, the dealer gets more cards as long as his score is less than 17.
       The dealt cards should be displayed. As soon as the dealer's score goes to 17 or higher, he stops getting more cards.

       After both the dealer and the player have gotten their cards, their scores are compared.
       If the player has gone over 21, the dealer wins.  Otherwise if the dealer has gone over 21, the player wins.
       Otherwise, if the dealer's score is greater than or equal to the player's score, the dealer wins.

*/

        // get the name from the player

        String nameplayer = "a";
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to the Game");
        System.out.println("Please enter your name: ");
        nameplayer = scnr.nextLine();
        System.out.println(nameplayer+" ,please begin");



        //declare and initialize deck - including card values and names

        String [] cardName = {"SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK",
                "HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK",
                "DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK",
                "CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK",
        };

        int[] cardValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
        boolean[] used = new boolean[52];
        //System.out.println("MARKER0");
        for (int i = 0; i < 52; i++) {
            used[i] = false;
        }
        Random randGen = new Random();

        // define the initial four cards
        String input = "A";
        while (input.equals("A")) {
            int numcard1 = randGen.nextInt(52);//we generated a random integer by using a random generator
        /*we have already set the Index to false,so the first time the while loop won't do anything and it will
        go right to the end and transform the index to true so the while loop will run again.
         */


            while (used[numcard1] == true) {
                numcard1 = randGen.nextInt(52);
            }

            //System.out.println(cardName[numcard1]);

            used[numcard1] = true;
            //we get the cardName for the first card

            int valfirstcard = cardValue[numcard1];// the card value of the first card


        /*get a second card*/
            int numcard2 = randGen.nextInt(52);
            while (used[numcard2] == true) {
                numcard2 = randGen.nextInt(52);
            }

            //System.out.println(cardName[numcard2]);
            used[numcard2] = true;

            int valsecondcard = cardValue[numcard2];// the card value of the second card

        /*get a third card*/
            int numcard3 = randGen.nextInt(52);
            while (used[numcard3] == true) {
                numcard3 = randGen.nextInt(52);
            }
            //System.out.println(cardName[numcard3]);
            used[numcard3] = true;

            int valthirdcard = cardValue[numcard3];//the card value of the third card

        /*get a fourth card*/
            int numcard4 = randGen.nextInt(52);
            while (used[numcard4] == true) {
                numcard4 = randGen.nextInt(52);
            }
            //System.out.println(cardName[numcard4]);
            used[numcard4] = true;

            int valfourthcard = cardValue[numcard4];//the card value of the fourth card

            //the game begins here

            System.out.println("Cards dealt to the " + nameplayer + " :" + cardName[numcard1] + " " + cardName[numcard3]);//the card given to the player would be shown
            int sumplayer = valfirstcard + valthirdcard;
            System.out.println("the score of player: " + sumplayer);
            System.out.println("Cards dealt to the dealer :" + "* " + cardName[numcard4]);//the first card given to the deale can't be seen
            int sumdealer = valsecondcard + valfourthcard;

            //the player's turn
            System.out.println("<<  THE PLAYER'S TURN  >>");
            System.out.println(nameplayer + " ,you wanna add one more card? enter yes to get a new card and no to stop (enter only yes or no)");
            String ans = "a";
            ans = scnr.nextLine();
            while (ans.equals("yes")) {
                int numcardnew = randGen.nextInt(52);
                while (used[numcardnew] == true) {
                    numcardnew = randGen.nextInt(52);
                }

                used[numcardnew] = true;
                System.out.println("the card you get is: " + cardName[numcardnew]);
                sumplayer = sumplayer + cardValue[numcardnew];
                System.out.println("your current score is: " + sumplayer);
                if (sumplayer > 21) {
                    System.out.println("RESULT: YOU LOSE AND THE DEALER WINS");
                    System.out.println("\n\n");
                    break;
                }
                System.out.println(nameplayer + " ,you wanna add one more card?(yes/no)");


                ans = scnr.nextLine();

            }


            //the dealer's turn
            if(sumplayer<=21) {

                System.out.println("<<  THE DEALER'S TURN  >>");
                System.out.println("the original two cards of the player: " + cardName[numcard2] + " " + cardName[numcard4]);
                System.out.println("the current score of the dealer is: " + sumdealer);
                while (sumdealer < 17) {
                    int numcarddealer = randGen.nextInt(52);
                    while (used[numcarddealer] == true) {
                        numcarddealer = randGen.nextInt(52);
                    }
                    used[numcarddealer] = true;
                    sumdealer = sumdealer + cardValue[numcarddealer];
                    System.out.println("the card the dealer got now is: " + cardName[numcarddealer]);
                    System.out.println("the current score of the dealer is: " + sumdealer);
                    if (sumdealer > 21) {
                        System.out.println("RESULT:DEALERR LOSE AND "+ nameplayer+" WINS");
                        System.out.println("\n\n");
                        break;
                    }


                }
            }
            //compare the scores between the dealer and the player
            if(sumdealer<22&& sumplayer <22){
                if(sumdealer>=sumplayer){
                    System.out.println("RESULT: the dealer wins and "+ nameplayer+ " lose.");
                }

                else {
                    System.out.println("RESULT: "+nameplayer+" wins");

                }

            }

            System.out.println("You wanna play another round? (A) yes (B)no     HINT:ENTEER CAPTALIZE (A) TO CONTINUE");
            input = scnr.nextLine();
            System.out.println("---------------NEW GAME----------------");
        }


    }
}
