package User;
import Activity.ToDo;
import Activity.Task;
import Activity.Habit;

import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;


public class User {
    // needed mathods for setters
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
    // attributes
    private String username;
    private String password;

    private String first_name;
    private String last_name;
    private String email;
    private int streak;

    private ToDo[] ToDos = new ToDo[10];
    private int ToDoCounter = 0;

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }
    public User(String username, String password, String first_name, String last_name, String email) {
        setUsername(username);
        setPassword(password);
        setFistName(first_name);
        setLastName(last_name);
        setEmail(email);
    }

    public ToDo createToDo(String ToDoName) {
        if (isToDoRepetitive(ToDoName) == false) {
            ToDo t1 = new ToDo(ToDoName);
            ToDos[ToDoCounter] = t1;
            ToDoCounter++;
            return t1;
        }
        else {
            System.out.println("ToDo is already in your ToDo list. Enter new ToDo name: ");
            return null;
        }

    }

    public boolean isToDoRepetitive(String ToDoName) {
        for (int i = 0; i < ToDoCounter; i++) {
            if (ToDoName.equals(ToDos[i].name)) {
                return true;
            }
        }
        return false;
    }
    // setters and getters
    public String getFullName() {
        String fullName = first_name;
        fullName = fullName.concat(" ");
        fullName = fullName.concat(last_name);
        return fullName;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String password) {
        if (isPasswordValid(password) == true) {
            this.password = password;
        }
        else {
            System.out.println("New password is INVALID. Password must include at least a letter and a digit: ");
            Scanner scan = new Scanner(System.in);
            String p = scan.next();
            scan.close();
            setPassword(p);
        }
    }
    public String getPassword() {
        return password;
    }
    public void setFistName(String first_name) {
        first_name = first_name.toLowerCase();
        StringBuilder firstName = new StringBuilder(first_name);
        firstName.setCharAt(0, Character.toUpperCase(first_name.charAt(0)));
        this.first_name = firstName.toString();
    }
    public void setLastName(String last_name) {
        last_name = last_name.toLowerCase();
        StringBuilder lastName = new StringBuilder(last_name);
        lastName.setCharAt(0, Character.toUpperCase(last_name.charAt(0)));
        this.last_name = lastName.toString();
    }
    // Methods
    
    public Optional<ToDo[]> getToDosByColor(String color) {
        int j = 0;
        ToDo[] foundToDos = new ToDo[100];
        for (int i = 0; i < ToDoCounter; i++) {
            if (ToDos[i].getColor().equals(color)) {
                foundToDos[j] = ToDos[i];
                j++;
            }
        }
        if (j == 0) {
            System.out.println("NO such task found");
            return Optional.empty();
        }
        else {
            return Optional.of(foundToDos);
        }
        
    }
    public void setEmail(String email) {
        if (isEmailValid(email)) {
            this.email = email;
        }
        else {
            System.out.println("Email is not Valid");
        }
    }
    public void remove() {
        username = null;
        password = null;
        first_name = null;
        last_name = null;
        email = null;
        streak = 0;
    }

}
