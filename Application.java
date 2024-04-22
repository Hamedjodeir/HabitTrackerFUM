import Activity.Task;

import java.util.Optional;

import Activity.Habit;
import Activity.ToDo;
import User.User;

public class Application {
    private User[] users = new User[100];
    private int userCounter = 0;
    public User[] getUserByName(String name) {
        User[] usersFound = new User[100];
        int j = 0;
        for (int i = 0; i < userCounter; i++) {
            if (users[i].getFullName().equals(name)) {
                usersFound[j] = users[i];
                j++;
            }
        }
        if (j == 0) {
            System.out.println("NO such User found");
        }
        return usersFound;
    }
    public User addUser(String username, String password) {
        User user = new User(username, password);
        users[userCounter] = user;
        userCounter++;
        return user;
    }
    public User removeUser(User removeUser) {
        for (User user : users) {
            if (user.equals(removeUser)) {
                user.remove();
                return user;
            }
        }
        return null;
    }
}
