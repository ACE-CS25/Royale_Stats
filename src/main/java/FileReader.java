import java.io.*;
import java.util.Scanner;

public class FileReader {

    public String getPlayerTag(){

        Scanner scanner = null;
        File file = new File("src/main/resources/MyPlayerTag");
        try {
            scanner = new Scanner(file);
        } catch(FileNotFoundException e) {
            System.out.println("file not found...");
            System.exit(0);
        }
        String playerTag = scanner.nextLine();

        return playerTag;
    }

    public String getAuthCode(){

        Scanner scanner = null;
        File file = new File("src/main/resources/AuthorizationCode");

        try {
            scanner = new Scanner(file);
        }
        catch(FileNotFoundException e){
            System.out.println("file not found...");
            System.exit(0);
        }

        return scanner.nextLine();
    }
}
