package multithreading.sample1;

public class Basics {
    public static void main(String[] args) {
        example3(args);
    }

    private static void example3(String args[]) {
        Thread innerThread = new Thread(() ->
        {
            try {
                // sleep for a thousand minutes
                System.out.println("innerThread goes to sleep at " + System.currentTimeMillis() / 1000);
                Thread.sleep(1000 * 1000);
            } catch (InterruptedException ie) {
                System.out.println("innerThread interrupted at " + +System.currentTimeMillis() / 1000);
            }
        });
        innerThread.start();
        // Interrupt innerThread after waiting for 5 seconds
        System.out.println("Main thread sleeping at " + +System.currentTimeMillis() / 1000);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        innerThread.interrupt();
        System.out.println("Main thread exiting at " + +System.currentTimeMillis() / 1000);
    }

    private static void example2() {
        Thread innerThread = new Thread(() -> {
            while (true) {
                System.out.println("Say Hello over and over again.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    // swallow interrupted exception
                }
            }
        });
        // If commented then this thread will not be stopped
//        A daemon thread runs in the background but as soon as the main application thread exits,
//        all daemon threads are killed by the JVM
//        Note that in case a spawned thread isn't marked as daemon
//        then even if the main thread finishes execution,
//        JVM will wait for the spawned thread to finish before tearing down the process.
        innerThread.setDaemon(true);
        innerThread.start();
        try {
            innerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void example1() {
        // 1st approach
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("Say Hello");
            }
        });
        t.start();
        // 2 approach
        ExecuteMe executeMe = new ExecuteMe();
        executeMe.start();
        try {
            executeMe.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ExecuteMe extends Thread {
        @Override
        public void run() {
            System.out.println("I ran after extending Thread class");
        }
    }

}
