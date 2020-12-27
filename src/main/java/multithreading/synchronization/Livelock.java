package multithreading.synchronization;

public class Livelock {

    public static void main (String[] args) {
        final LivelockWorker worker1 = new LivelockWorker("Worker 1 ", true);
        final LivelockWorker worker2 = new LivelockWorker("Worker 2", true);

        final LivelockCommonResource s = new LivelockCommonResource(worker1);

        new Thread(() -> {
            worker1.work(s, worker2);
        }).start();

        new Thread(() -> {
            worker2.work(s, worker1);
        }).start();
    }
}