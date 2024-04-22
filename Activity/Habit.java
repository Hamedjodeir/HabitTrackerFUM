package Activity;
import Activity.ToDo;
import Activity.Task;

public class Habit extends ToDo {
    private int new_start_time; // setStartTime should make an int from start_time. I was not sure if I should put this int into the frequency attribute 
                                // or I should make a new attribute. So i made a new attribute. but if it was meant to be put into the frequency attribute
                                // This can be easily achived by replacing the new_start_time attribute with frequency attribute in setStartTime method 
    private int frequency;
    private String category;
    public Habit() {
        
    }
    public Habit(String name, double start_time, String color, int frequency, String category) {
        super(name, start_time, color);
        setFrequency(frequency);
        setCategory(category);
    }
    // setters
    public void setFrequency(int frequency) {
        if (frequency > 0) {
            this.frequency = frequency;
        }
        else {
            System.out.println("Frequency is not valid");
        }
    }
    public void setCategory(String category) {
        if (category.length() >= 1) {
            this.category = category;
        }
        else {
            System.out.println("name of the category is too short");
        }
    }

    // methods
    @Override public String getInfo() {
        String info = super.getInfo() + "\nThe frequency of the habit is: " + frequency + "\nThe category of the habit is: " + category + "\n The new start time (Integer) of the habit is: " + new_start_time;
        return info;
    }
    @Override public void setStartTime(double start_time) {
        new_start_time = (int) start_time;
    }
}
