import java.util.ArrayList;
import java.util.Scanner;

public class loggbok {
    public static void main(String[] args) {
        Scanner tgb = new Scanner(System.in);
        ArrayList<String> posts = new ArrayList<String>();

        System.out.println("Vad vill du göra?");
        System.out.println(
                "1, visa \n" +
                "2, lägg till post \n" +
                "3, uppdatera \n" +
                "4, spara \n" +
                "5, läs in \n" +
                "6, avsluta" );

        int choice = tgb.nextInt();
        tgb.nextLine();

        if (choice == 2) {
            System.out.println("Vad ska loggen heta?");
            String name = tgb.nextLine();
            System.out.println("Innehål");
            String info = tgb.nextLine();
            String post = name + "\n\n" + info;
            posts.add(post);
            System.out.println(posts);
        }
    }
}
