package programs;

import java.util.Timer;

public class SchedulerMain {
    public static void main(String args[]) throws InterruptedException {
        Timer timer = new Timer();               // Instantiate Timer Object
        ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
        timer.schedule(st, 0, 1000);             // Create task repeating every 1 sec
        //for demo only.
        System.out.println("Waiting Thread");
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
        }
        timer.cancel();
        System.out.println("Stopping Thread");
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
        }
    }
}