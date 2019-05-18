package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int DealCards() {
        boolean[] used = new boolean[52];

        for (int i = 0; i < 52; i++) {
            used[i] = false;
        }
        Random randGen = new Random();
        int numcard = randGen.nextInt(52);//we generated a random integer by using a random generator
        /*we have already set the Index to false,so the first time the while loop won't do anything and it will
        go right to the end and transform the index to true so the while loop will run again.
         */


        while (used[numcard] == true) {
            numcard = randGen.nextInt(52);
        }

        used[numcard] = true;
        //we get the cardName for the first card

        return numcard;
    }


    public static int playgame(String nameplayer) {
        boolean[] used = new boolean[52];
        Random randGen = new Random();
        Scanner scnr = new Scanner(System.in);

        System.out.println(nameplayer + " ,the game begins");
        for (int i = 0; i < 52; i++) {
            used[i] = false;
        }
        String[] cardName = {"SA", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK",
                "HA", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HJ", "HQ", "HK",
                "DA", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK",
                "CA", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CJ", "CQ", "CK",
        };

        int[] cardValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        int numcard1 = DealCards();//you will get the variable numcard
        int numcard2 = DealCards();
        int numcard3 = DealCards();
        int numcard4 = DealCards();
       /*get a first card*/
        String cardName1 = cardName[numcard1];
        int valfirstcard = cardValue[numcard1];


        /*get a second card*/
        String cardName2 = cardName[numcard1];
        int valsecondcard = cardValue[numcard1];


        /*get a third card*/
        String cardName3 = cardName[numcard3];
        int valthirdcard = cardValue[numcard3];


        /*get a fourth card*/
        String cardName4 = cardName[numcard4];
        int valfourthcard = cardValue[numcard4];

        //the game begins here

        System.out.println("Cards dealt to the " + nameplayer + " :" + cardName1 + " " + cardName3);//the card given to the player would be shown
        int sumplayer = valfirstcard + valthirdcard;
        System.out.println("the score of player: " + sumplayer);
        System.out.println("Cards dealt to the dealer :" + "* " + cardName4);//the first card given to the deale can't be seen
        int sumdealer = valsecondcard + valfourthcard;

        //the player's turn
        System.out.println("<<  THE PLAYER'S TURN  >>");
        System.out.println(nameplayer + " ,you wanna add one more card? enter yes to get a new card and no to stop (enter only yes or no)");
        String ans = "a";
        ans = scnr.nextLine();
        while (ans.equals("yes")) {
            //get a new card for the player
            int numnewCards = DealCards();
            String NewcardName = cardName[numnewCards];
            int valnewcard = cardValue[numnewCards];
            System.out.println("the card you get is: " + NewcardName);
            sumplayer = sumplayer + valnewcard;
            System.out.println("your current score is: " + sumplayer);
            if (sumplayer > 21) {
                System.out.println("RESULT: YOU LOSE AND THE DEALER WINS");
                System.out.println("\n\n");

                return 0;
            }
            System.out.println(nameplayer + " ,you wanna add one more card?(yes/no)");


            ans = scnr.nextLine();

        }


        //the dealer's turn
        if (sumplayer <= 21) {

            System.out.println("<<  THE DEALER'S TURN  >>");
            System.out.println("the original two cards of the dealer: " + cardName[numcard2] + " " + cardName[numcard4]);
            System.out.println("the current score of the dealer is: " + sumdealer);
            while (sumdealer < 17) {
                int numcarddealer = DealCards();
                String namedealerCards = cardName[numcarddealer];
                int valdealerCards = cardValue[numcarddealer];
                sumdealer = sumdealer + valdealerCards;
                System.out.println("the card the dealer got now is: " + namedealerCards);
                System.out.println("the current score of the dealer is: " + sumdealer);
                if (sumdealer > 21) {
                    System.out.println("RESULT:DEALERR LOSE AND " + nameplayer + " WINS");
                    System.out.println("\n\n");
                    return 1;
                }


            }
        }
        //compare the scores between the dealer and the player
        if (sumdealer < 22 && sumplayer < 22) {
            if (sumdealer >= sumplayer) {
                System.out.println("RESULT: the dealer wins and " + nameplayer + " lose.");
                return 0;
            } else {
                System.out.println("RESULT: " + nameplayer + " wins");
                return 1;

            }

        }

        return 2;
    }

    public static void annouceOverallWinner(int playerwins,int dealerwins){
        int overallplayerwin =0;
        int overalldealerwin =0;
        overalldealerwin = dealerwins;
        overallplayerwin = playerwins;
        if(overalldealerwin>overallplayerwin){
            System.out.println("Overall result:the dealer wins the game");
        }
        else{
            System.out.println("Overall result:the player wins the game");
        }


    }









    public static void main(String[] args) {
        String input = "A";
        int dealerwins = 0;
        int playerwins = 0;
        Scanner scnr = new Scanner(System.in);

        String nameplayer;
        System.out.println("<<<               BLACKJACK                >>>");
        System.out.println("Welcome to the Blackjack");
        System.out.println("Please enter your name: ");
        nameplayer = scnr.nextLine();

        while (input.equals("A")) {

            int numbergetfromplaygame= playgame(nameplayer);

            if ( numbergetfromplaygame== 0) {
                dealerwins++;

            } else if (numbergetfromplaygame == 1) {
                playerwins++;
            }
            System.out.println();
            System.out.println("<<<               The Score Board                >>>"        );
            System.out.println("the number of times the dealer wins right now is " + dealerwins);
            System.out.println("the number of times the player wins right now is " + playerwins);
            System.out.println();
            System.out.println();


            System.out.println("You wanna play another round? (A) yes (B)no     HINT:ENTEER CAPTALIZE (A) TO CONTINUE");

            input = scnr.nextLine();}
        annouceOverallWinner(playerwins,dealerwins);
    }


}
