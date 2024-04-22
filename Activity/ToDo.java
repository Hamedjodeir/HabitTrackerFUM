package Activity;
import Activity.Task;
import Activity.Habit;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ToDo {
    public String name;
    protected double start_time;
    protected String color;

    public ToDo() {

    }
    public ToDo(String name) {
        setName(name);
    }
    public ToDo(String name, double start_time, String color) {
        setStartTime(start_time);
        setName(name);
        setColor(color);
    }

    // methods

    public void setStartTime(double start_time) {
        if (start_time > 0) {
            this.start_time = start_time;
        }
        else {
            System.out.println("start time is not VALID: ");
        }
    }
    public void setName(String name) {
        if (name.length() <= 10) {
            this.name = name;
        }
        else {
            System.out.println("length of name should be less than or equal to 10 characters");
        }
    }
    public String getInfo() {
        String info = "The name of the activity is: " + this.name + "\n The start time of the activity is: " + start_time;
        return info;
    }
    protected void setColor(String color) {
        if (color.matches("^[0-9A-Fa-f]{6}$")) {
            this.color = color;
        }
        else {
            System.out.println("Color is not valid! Default color has been assigned.");
            this.color = "5BEDE6";
        }
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public double getStart_time() {
        return start_time;
    }
}
