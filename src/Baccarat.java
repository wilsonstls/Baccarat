package baccarat;


import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

import static baccarat.RandInt.*;

/**
* Date: 8/22/15 
* Author: Kevin Wilson
* this application simulates the card game - Baccarat.
*/ 
public class Baccarat {


    public static void main(String[] varArgs) {


        System.out.println("\n  ! The Baccarat Game !\n");
        System.out.println("\n  For instructions on how to play, read the new window that just pop up.\n");

        //display how the game is played
        Baccarat baccarat = new Baccarat();
        baccarat.rules();

        boolean continueGame = true;
        Scanner input = new Scanner(System.in);
        System.out.println("\n If you are ready to begin playing hit enter  or ");
        System.out.println(" if you want to quit just type 'quit' ");
        String userInput = input.nextLine();
        if (userInput.equals("quit")) {
            continueGame = false;
        }

        //run the game until user enters 'quit'
        while (continueGame) {

            //initialize the array for 4 objects; randomly generate the numbers & fill in the array
            int [ ] gameArray = new int [ 4 ];
            for (int I = 0; I < 4; I++) {
                //calls the static method  getNum
                getNum();
                gameArray[I] = getNum();

            }
            //Player draws the 1st & 3rd cards; Bank draws 2nd & 4th cards
            System.out.println("PLAYER: " + gameArray[0]);
            System.out.println("PLAYER: " + gameArray[2]);
            System.out.println("BANK:   " + gameArray[1]);
            System.out.println("BANK:   " + gameArray[3]);

            //check if any elements in array > 9; if so change to 0
            for(int i = 0; i < gameArray.length; i++){

                if(gameArray[i] > 9){
                    gameArray[i] = 0;
                }
            }

             //sum the value for both hands & retrieve its right most value
            Integer pValue = (gameArray[0] + gameArray[2]) % 10;
            Integer bValue = (gameArray[1] + gameArray[3]) % 10;
            System.out.println("\nPLAYER:  " + pValue + "    BANK:  " + bValue);

            //determine who won by comparing the two integers
            int result =  pValue.compareTo(bValue);
            switch(result)
            {
                case 1 :
                    System.out.println("\n   PLAYER wins! \n");
                    break;
                case -1 :
                    System.out.println("\n   BANK wins! \n");
                    break;
                case 0 :
                    System.out.println("\n   TIE - nobody wins or loses \n");
                    break;
                default :
                    System.out.println("\n   Invalid");
            }


            System.out.println("\n To play another hand hit enter else type  'quit' ");
            String handInput = input.nextLine();
            if (handInput.equals("quit")) {
                continueGame = false;
                System.out.println("\n   Thank you for playing");
            }

        } //closes while loop
    } //closes main




    public void rules() {

            JPanel P = new JPanel();
            JLabel B1 = new JLabel("\n");
            JLabel B2 = new JLabel("\n");
            JLabel B3 = new JLabel("\n");
            JLabel B4 = new JLabel("\n");
            JLabel B5 = new JLabel("\n");
            JLabel B6 = new JLabel("\n");
            JLabel B7 = new JLabel("\n");
            JLabel B8 = new JLabel("\n");
            JLabel B9 = new JLabel("\n");

            JLabel L1 = new JLabel("Welcome to Baccarat !! " );
            JLabel L2 = new JLabel(" Baccarat is a game with no playing strategies to master, its based solely on the luck of the draw");
            JLabel L3 = new JLabel(" The object of the game is simple - the hand closes to 9, with out going over, wins.");
            JLabel L4 = new JLabel(" Only two hands are played - the PLAYER  &  the BANK ");
            JLabel L5 = new JLabel(" Two cards are drawing for each hand - PLAYER receives the 1st & 3rd cards, BANK gets 2nd & 4th");
            JLabel L6 = new JLabel(" The hand value is determined by the sum of the two cards (numbers)");
            JLabel L7 = new JLabel(" 10 & Face cards(11,12,13) are worth zero");
            JLabel L8 = new JLabel(" All others (1 - 9) are worth their value ");
            JLabel L9 = new JLabel(" exp:  PLAYER draws 8 & 12  /  BANK draws 4 & 3");
            JLabel L10 = new JLabel(" hand value:    8 + 0 = 8            4 + 3 = 7 ");
            JLabel L11 = new JLabel(" PLAYER wins");
            JLabel L12 = new JLabel(" What if the sum of a hand totals 10 or higher?");
            JLabel L13 = new JLabel(" exp: one hand draws  8 & 5 = 13");
            JLabel L14 = new JLabel(" when this happens the first digit is dropped and the 2nd digit is used as the sum value for the hand");
            JLabel L15 = new JLabel(" in the above example the sum value for the hand is 3 ");
            JLabel L16 = new JLabel(" What if both hand values are the same?");
            JLabel L17 = new JLabel(" then its a TIE; nobody wins or loses");
            JLabel L18 = new JLabel(" If you are ready to begin playing just minimize this window and go back to main program ");

            L1.setAlignmentX(Component.CENTER_ALIGNMENT);
            P.setLayout(new BoxLayout(P, BoxLayout.PAGE_AXIS));
            P.add(B1);
            P.add(L1);
            P.add(B2);
            P.add(B3);
            P.add(L2);
            P.add(B4);
            P.add(L3);
            P.add(B5);
            P.add(L4);
            P.add(L5);
            P.add(L6);
            P.add(L7);
            P.add(L8);
            P.add(B6);
            P.add(L9);
            P.add(L10);
            P.add(L11);
            P.add(B7);
            P.add(L12);
            P.add(L13);
            P.add(L14);
            P.add(L15);
            P.add(B8);
            P.add(L16);
            P.add(L17);
            P.add(B9);
            P.add(L18);

            //create the new window
            JFrame frame = new JFrame("Rules of the Game");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.getContentPane().add(P);
            frame.setVisible(true);


        } //closes rules

}  //closes Baccarat
