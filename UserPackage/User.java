package UserPackage;
import TaskPackage.Task;
import UserPackage.User;
import UtilityPackage.Utils;

import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Scanner;


public class User {
    private String username;
    private String password;

    public String first_name;
    public String last_name;
    public String email;
    public int streak;

    private Task[] tasks = new Task[10];
    private int taskCounter = 0;

    public User(String username, String password, String first_name, String last_name, String email) {
        setUsername(username);
        setPassword(password);
        setFistName(first_name);
        setLastName(last_name);
        setEmail(email);
    }

    public Task createTask(String taskName) {
        if (isTaskRepetitive(taskName) == false) {
            Task t1 = new Task(taskName, this);
            tasks[taskCounter] = t1;
            taskCounter++;
            return t1;
            
        }
        else {
            System.out.println("Task is already in your task list. Enter new task name: ");
            Scanner scan = new Scanner(System.in);
            String p = scan.next();
            scan.close();
            return createTask(p);
        }

    }



    private boolean isTaskRepetitive(String taskName) {
        for (int i = 0; i < taskCounter; i++) {
            if (taskName.equals(tasks[i].name)) {
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
        if (Utils.isPasswordValid(password) == true) {
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
    public Optional<Task> getTaskByName(String name) {
        
        for (int i = 0; i < taskCounter; i++) {
            if (tasks[i].name == name) {
                return Optional.of(tasks[i]);
            }
        }
        System.out.println("NO such task found");
        return Optional.empty();
        
    }
    public Optional<Task[]> getTaskByColor(String color) {
        int j = 0;
        Task[] foundTasks = new Task[100];
        for (int i = 0; i < taskCounter; i++) {
            if (tasks[i].getColor() == color) {
                foundTasks[j] = tasks[i];
                j++;
            }
        }
        if (j == 0) {
            System.out.println("NO such task found");
            return Optional.empty();
        }
        else {
            return Optional.of(foundTasks);
        }
        
    }
    public void setEmail(String email) {
        if (Utils.isEmailValid(email)) {
            this.email = email;
        }
        else {
            System.out.println("Email is not Valid");
        }
    }

}