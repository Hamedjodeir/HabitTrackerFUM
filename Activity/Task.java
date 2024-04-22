package Activity;
import Activity.ToDo;

import java.util.Scanner;

import Activity.Habit;

public class Task extends ToDo {
    private double finish_time;
    public Task() {

    }
    public Task(String name, double start_time, String color, double finish_time) {
        super(name, start_time, color);
        setFinishTime(finish_time);
    }

    // methods
    @Override public String getInfo() {
        String info = super.getInfo() + "\nThe finish time of the task is: " + finish_time;
        return info;
    }
    public double getDuration() {
        return finish_time - start_time;
    }
    public double getFinish_time() {
        return finish_time;
    }

    // setters
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
}
