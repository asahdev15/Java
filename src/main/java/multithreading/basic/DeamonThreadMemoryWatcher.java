package multithreading.basic;

import java.util.ArrayList;
import java.util.List;

public class DeamonThreadMemoryWatcher implements Runnable {

    static List<String> list = new ArrayList<>();

    public static void main (String[] args) throws InterruptedException {
        DeamonThreadMemoryWatcher.start();
        for (int i = 0; i < 100000; i++) {
            String str = new String("str" + i);
            list.add(str);
        }
        System.out.println("end of main method");
        System.exit(0);
    }

    public static void start () {
        Thread thread = new Thread(new DeamonThreadMemoryWatcher());
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void run () {
        long memoryUsed = getMemoryUsed();
        System.out.println("Memory used :" + memoryUsed + " MB");

        while (true) {
            long memoryUsed1 = getMemoryUsed();
            if (memoryUsed != memoryUsed1) {
                memoryUsed = memoryUsed1;
                System.out.println("Memory used :" + memoryUsed + " MB");
            }
        }
    }

    private long getMemoryUsed () {
        return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024;
    }
    
}