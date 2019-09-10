/**
 *
 *
 *
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class loggbok {
    public static void main(String[] args) {
        Scanner tgb = new Scanner(System.in);
        ArrayList<String> posts = new ArrayList<String>();
        boolean running = true;
        boolean seePost = true;

        while (running) {
            seePost = true;
            System.out.println("Vad vill du göra?");
            showMenu();

            int choice = tgb.nextInt();
            tgb.nextLine();

            if (choice == 1) {
                postsMenu(tgb, posts, true);
            }

            if (choice == 2) {
                addPost(tgb, posts);
            }

            if (choice == 3) {
                System.out.println("Funktionen finns inte än");
            }

            if (choice == 4) {
                System.out.println("Funktionen finns inte än");
            }

            if (choice == 5) {
                System.out.println("Funktionen finns inte än");
            }

            if (choice == 6) {
                System.out.println("Avslutar");
                running = false;
            }
        }

    }

    private static void postsMenu(Scanner tgb, ArrayList<String> posts, boolean seePost) {
        while (seePost) {
            System.out.println("Skriv 0 för att gå tillbaka till menyn");
            System.out.println("Posts: ");
            for (int i = 0 ; i < posts.size() ; i++) {
                System.out.println("[ " + posts.get(i) + " ]");
            }
            if (tgb.nextInt() == 0) {
                seePost = false;
            }
        }
    }

    private static void addPost(Scanner tgb, ArrayList<String> posts) {
        //fixar så man kan hämta en tidsstamp
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd-HH:mm");
        //Skapar och sparar loggen i en arraylist
        System.out.println("Vad ska loggen heta?");
        String date = sdf.format(cal.getTime());
        System.out.println("Innehål");
        String info = tgb.nextLine();
        String post = date + " - " + info;
        posts.add(post);
    }

    private static void showMenu() {
        System.out.println(
                "1, visa \n" +
                "2, lägg till post \n" +
                "3, uppdatera \n" +
                "4, spara \n" +
                "5, läs in \n" +
                "6, avsluta" );
    }
}
