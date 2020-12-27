package multithreading.basic;

public class ThreadTest {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();

        Thread thread2 = new Thread(new MyRunnable(),"MyRunnableThreadName");
        thread2.start();

        MyRunnable2 myRunnable2 = new MyRunnable2();
        Thread thread3 = new Thread(myRunnable2,"MyRunnable2ThreadName");
        thread3.start();

        System.out.println(Thread.currentThread().getName() + " : Sleeping for 5 secs");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myRunnable2.doStop();
        System.out.println("Ended : Main thread : " + Thread.currentThread().getName());
    }

    static class MyThread extends Thread{
        public void run(){
            System.out.println("Executing : MyThread.run() : " + Thread.currentThread().getName());
        }
    }

    static class MyRunnable implements Runnable{
        public void run(){
            System.out.println("Executing : MyRunnable.run() : " + Thread.currentThread().getName());
        }
    }

    static class MyRunnable2 implements Runnable {
        private boolean doStop = false;
        public synchronized void doStop() {
            this.doStop = true;
        }
        private synchronized boolean keepRunning() {
            return this.doStop == false;
        }
        @Override
        public void run() {
            while(keepRunning()) {
                System.out.println(Thread.currentThread().getName() + " :Running");
                try {
                    Thread.sleep(3L * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
