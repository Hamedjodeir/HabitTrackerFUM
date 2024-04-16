package TaskPackage;
import TaskPackage.Task;
import UserPackage.User;
import UtilityPackage.Utils;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Task {
    public String name;
    private double start_time;
    private double finish_time;
    private final String color;
    private User user;

    public Task(String name, User user) {
        this.name = name;
        setUser(user);
        color = "5BEDE6";
    }
    public Task(String name, User user, String color) {
        setName(name);
        setUser(user);
        if (isColorValid(color) == true) {
            this.color = color;
        }
        else {
            System.out.println("Color is NOT valid");
            this.color = "5BEDE6";
        }
    }
    
    public double getDuration() {
        return finish_time - start_time;
    }

    private boolean isColorValid(String color) {
        boolean answer1 = true;
        for (int i = 0; i < color.length(); i++) {
            if ((Character.isLetter(color.charAt(i))) == true && ('A' > color.charAt(i) || color.charAt(i) > 'F')) {
                answer1 = false;
            }
            else if ((Character.isDigit(color.charAt(i))) == true && ('0' > color.charAt(i) || color.charAt(i) > '9')) {
                answer1 = false;
            }
        }
        return answer1;
    }
    private boolean isColorValid2(String color) {
        return color.matches("^[0-9A-Fa-f]{6}$");
    }


    // setters & getters
    public void setStartTime(double start_time) {
        if (start_time > 0) {
            this.start_time = start_time;
        }
        else {
            System.out.println("start time is not VALID: ");
            Scanner scan = new Scanner(System.in);
            double new_start_time = scan.nextDouble();
            scan.close();
            setStartTime(new_start_time);
        }
    }
    public void setFinishTime(double finish_time) {
        if (start_time > 0) {
            this.finish_time = finish_time;
        }
        else {
            System.out.println("Finish time is not VALID: ");
            Scanner scan = new Scanner(System.in);
            double new_finish_time = scan.nextDouble();
            scan.close();
            setStartTime(new_finish_time);
        }
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setName(String name) {
        if (name.length() <= 10) {
            this.name = name;
        }
        else {
            System.out.println("length of name should be less than or equal to 10 characters");
        }
    }
    private void setColor(String color) {
        
    }
    public String getColor() {
        return color;
    }
    
}
