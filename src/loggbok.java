import java.util.ArrayList;
import java.util.Scanner;

public class loggbok {
    public static void main(String[] args) {
        Scanner tgb = new Scanner(System.in);
        ArrayList<String> posts = new ArrayList<String>();
        int running = 1;
        int seePost = 1;

        while (running == 1) {
            System.out.println("Vad vill du göra?");
            showMenu();

            int choice = tgb.nextInt();
            tgb.nextLine();

            if (choice == 1) {
                while (seePost == 1) {
                    System.out.println("Skriv 0 för att gå tillbaka till menyn");
                    System.out.println("Posts: ");
                    for (int i = 0 ; i < posts.size() ; i++) {
                        System.out.println("[ " + posts.get(i) + " ]");
                    }
                    seePost = tgb.nextInt();
                }
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
                running = 0;
            }
        }

    }

    private static void addPost(Scanner tgb, ArrayList<String> posts) {
        System.out.println("Vad ska loggen heta?");
        String name = tgb.nextLine();
        System.out.println("Innehål");
        String info = tgb.nextLine();
        String post = name + " - " + info;
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
