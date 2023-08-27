package CodSoft;
import java.util.Scanner;

import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int random = rand.nextInt(1, 100);

        int count = 1, attempt = 10, temp = 0,round=1,win=0;
        boolean ch=true;


        while (ch) {
            while (count <= attempt) {
                System.out.println("Enter the choice");
                int choice = sc.nextInt();
                if (choice == random) {
                    temp = 1;
                    break;
                } else if (choice > random) {
                    System.out.println("Entered number is too high");
                } else {
                    System.out.println("Entered number is too low");
                }
                count++;
            }
            if (temp == 1) {
                System.out.println("You guessed it right in " + count + " attempt");
                win++;
            } else {
                System.out.println("Attempts finished");
            }


            String c;
            System.out.println("To continue press any key");
            System.out.println("To exit press e");
            c = sc.next().toLowerCase();
            if (c.equals("e")) {
                ch = false;
            }
            else {
                round++;
                count=0;
            }
        }
        System.out.println("You have played a total "+round+" and win in "+win+" round");




    }
}
