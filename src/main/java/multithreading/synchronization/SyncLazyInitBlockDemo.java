package multithreading.synchronization;

import java.util.ArrayList;
import java.util.List;

public class SyncLazyInitBlockDemo {
    private volatile List<String> list;

    public static void main (String[] args) throws InterruptedException {
        SyncLazyInitBlockDemo obj = new SyncLazyInitBlockDemo();

        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 : " + System.identityHashCode(obj.getList()));
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 : " + System.identityHashCode(obj.getList()));
        });

        thread1.start();
        thread2.start();
    }

    private List<String> getList () {
        if (list == null) {
            synchronized (this) {
                if(list == null) {
                    list = new ArrayList<>();
                }
            }
        }
        return list;
    }
}