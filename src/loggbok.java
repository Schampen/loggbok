/**
 * Java loggbok uppgift
 *
 * @author Hampus.M
 */

import java.util.ArrayList;
import java.util.Scanner;

public class loggbok {
    public static void main(String[] args) {
        Scanner tgb = new Scanner(System.in);
        ArrayList<LogEntry> posts = new ArrayList<>();
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
                System.out.println("Vilken logg vill du ändra?");
                int toUpdate = tgb.nextInt();
                System.out.println(posts.get(toUpdate).toString());
                System.out.println("Är det här rätt log? \n1 för ja | 0 för nej");
                int updateChoice = tgb.nextInt();


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

    private static void postsMenu(Scanner tgb, ArrayList<LogEntry> posts, boolean seePost) {
        while (seePost) {
            System.out.println("Skriv 0 för att gå tillbaka till menyn");
            System.out.println("Posts: ");
            for (int i = 0 ; i < posts.size() ; i++) {
                System.out.println("[ " + posts.get(i).toString() + " ]");
            }
            if (tgb.nextInt() == 0) {
                seePost = false;
            }
        }
    }

    private static void addPost(Scanner tgb, ArrayList<LogEntry> posts) {
        System.out.println("Vad ska loggen heta?");
        String name = tgb.nextLine();
        System.out.println("Vad ska stå i loggen?");
        String post = tgb.nextLine();
        posts.add(new LogEntry(name,post));
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
