import java.util.Scanner;

public class loggbok {
    public static void main(String[] args) {
        Scanner tgb = new Scanner(System.in);


        System.out.println(
                "1, visa \n" +
                "2, lägg till post \n" +
                "3, uppdatera \n" +
                "4, spara \n" +
                "5, läs in \n" +
                "6, avsluta" );

        System.out.println("Vad vill du göra?");
        int choice = tgb.nextInt();

        if (choice == 1) {
            
        }
    }
}
