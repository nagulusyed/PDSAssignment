package Demo;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {
    public static void main(String[] args) {
        String dataString = "username1+password1-username2+password2-username3+password3-usernamen+passwordn";
        List<String> usernames = new ArrayList<>();
        List<String> passwords = new ArrayList<>();
        extractUsernamesPasswords(dataString, usernames, passwords);
        
        System.out.println("Usernames List:");
        for (String username : usernames) {
            System.out.println(username);
        }
        
        System.out.println("\nPasswords List:");
        for (String password : passwords) {
            System.out.println(password);
        }
    }

    public static void extractUsernamesPasswords(String dataString, List<String> usernames, List<String> passwords) {
        String[] parts = dataString.split("-");
        for (String part : parts) {
            String[] usernamePassword = part.split("\\+");
            String username = usernamePassword[0];
            String password = usernamePassword[1];
            usernames.add(username);
            passwords.add(password);
        }
    }
}
