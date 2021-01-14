package multithreading;

import java.util.TimerTask;

public class ScheduledTask extends TimerTask {

    public void run() {
        System.out.println("Fetch checks for frequency defined...." );
        System.out.println("For each, Check for website uptime/downtime...." );
        System.out.println("Update DB and check if fail notification is required to send...." );
    }
}