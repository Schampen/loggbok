/**
 * Java loggbok uppgift
 *
 * @author Hampus.M
 */

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class loggbok {
    public static void main(String[] args) {
        Scanner tgb = new Scanner(System.in);
        ArrayList<LogEntry> posts = new ArrayList<>();
        boolean running = true;
        boolean seePost;
        String loggfil = "loggbok.txt";

        readSave(posts, loggfil);

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
                updatePost(tgb, posts);

            }

            if (choice == 4) {
                try {
                    PrintWriter save = new PrintWriter(new BufferedOutputStream(new FileOutputStream(loggfil)));
                    for (int i = 0 ; i < posts.size() ; i++) {
                        String name = posts.get(i).getLogName();
                        Long cDate = posts.get(i).getCreatedAt().getTime();
                        String message = posts.get(i).getMessage();
                        Long uDate = posts.get(i).getUpdatedAt().getTime();
                        String txt = name + "\n" + cDate + "\n" + message + "\n" + uDate;
                        save.println(txt);
                    }
                    save.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (choice == 5) {
                System.out.println("Avslutar");
                running = false;
            }
        }

    }

    private static void readSave(ArrayList<LogEntry> posts, String loggfil) {
        String loggname;
        try {
            BufferedReader read = new BufferedReader(new FileReader(loggfil));
            while ((loggname = read.readLine()) != null) {
                Long createdDate = Long.parseLong(read.readLine());
                Date created = new Date(createdDate);
                String loggBody = read.readLine();
                Long updatedDate = Long.parseLong(read.readLine());
                Date updated = new Date(updatedDate);
                posts.add(new LogEntry(loggname,loggBody,created,updated));
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updatePost(Scanner tgb, ArrayList<LogEntry> posts) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd-HH:mm:ss");
        Date updated = null;
        System.out.println("Vilken logg vill du ändra?");
        show(posts);
        int elementAt = tgb.nextInt();
        tgb.nextLine();
        System.out.println("[ " + posts.get(elementAt).toString() + " ]");
        System.out.println("Uppdatera");
        String newMessage = tgb.nextLine();
        String updatedAt = sdf.format(cal.getTime());
        try {
            updated = sdf.parse(String.valueOf(cal.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        posts.get(elementAt).update(newMessage,updated);
    }

    private static void postsMenu(Scanner tgb, ArrayList<LogEntry> posts, boolean seePost) {
        while (seePost) {
            System.out.println("Posts: ");
            show(posts);
            System.out.println("Skriv 0 för att gå tillbaka till menyn");
            if (tgb.nextInt() == 0) {
                seePost = false;
            }
        }
    }

    private static void show(ArrayList<LogEntry> posts) {
        for (int i = 0 ; i < posts.size() ; i++) {
            System.out.println(i + " [ " + posts.get(i).toString() + " ] \n");
        }
    }

    private static void addPost(Scanner tgb, ArrayList<LogEntry> posts) {
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd-HH:mm:ss");
            System.out.println("Vad ska loggen heta?");
            String name = tgb.nextLine();
            System.out.println("Vad ska stå i loggen?");
            String post = tgb.nextLine();
            String createdAt = sdf.format(cal.getTime());
            Date created = sdf.parse(createdAt);
            String updatedAt = sdf.format(cal.getTime());
            Date updated = sdf.parse(updatedAt);
            posts.add(new LogEntry(name,post,created,updated));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void showMenu() {
        System.out.println(
                "1, visa \n" +
                "2, lägg till post \n" +
                "3, uppdatera \n" +
                "4, spara \n" +
                "5, avsluta" );
    }
}
