import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner oldScanner = new Scanner(System.in);
        System.out.println("Please enter a password. The password should be at least 12 characters long and contain an uppercase, lowercase, symbols, and numbers");
        String password = oldScanner.nextLine();
        if(passwordValidate(password)){
            while(passwordValidate(password)){
                System.out.println("Password not valid. Please enter another password.");
                System.out.println("Please enter a password. The password should be at least 12 characters long and contain an uppercase, lowercase, symbols, and numbers");
                password = oldScanner.nextLine();
            }//end while loop
        }//end if statement

        String hashPassword = hashedPassword(password);
        System.out.println(hashPassword);

    }//end main

    private static String hashedPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashbytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for(byte b: hashbytes){
            String hex = Integer.toHexString(0xff & b);
            System.out.println(b+" "+hex);
            if (hex.length() == 1){
                sb.append("0");
            }else{
                sb.append(hex);
            }
        }
        return sb.toString();
    }

    public static boolean passwordValidate(String password){
        if(password.length()<12){
            return true;
        }

        boolean isUpper = false;
        boolean isLower = false;
        boolean isNum = false;
        boolean isSymbol = false;

        for(int i = 0; i<password.length();i++){
            if(Character.isDigit(password.charAt(i))){
                isNum = true;
            }else if(Character.isUpperCase(password.charAt(i))){
                isUpper = true;
            }else if(Character.isLowerCase(password.charAt(i))){
                isLower = true;
            }else if(Character.isLetterOrDigit(password.charAt(i))==false){
                isSymbol = true;
            }
        }

        return !isUpper || !isLower || !isNum || !isSymbol;

    }
}