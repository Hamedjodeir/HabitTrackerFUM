package UtilityPackage;
import java.util.regex.Pattern;

import TaskPackage.Task;
import UserPackage.User;


public class Utils {
    public static boolean isPasswordValid(String password) {
        boolean answer1 = false;
        boolean answer2 = false;
        for (int i = 0; i < password.length(); i++) {
            if ((Character.isLetter(password.charAt(i))) == true) {
                answer1 = true;
            }
            else if ((Character.isDigit(password.charAt(i))) == true) {
                answer2 = true;
            }
        }
        if (answer1 == true && answer2 == true) {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isEmailValid(String email) { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                            
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) {
            return false; 
        } 
        return pat.matcher(email).matches(); 
    } 
}
