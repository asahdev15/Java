package multithreading.basic;

public class ThreadStatesExample4 {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            //acquiring lock on Example4.class object
            synchronized (ThreadStatesExample4.class) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        MyTask4 t = new MyTask4();
        t.setName("Thread4");
        ThreadStatesExample1.runExampleThread(t);
    }

    private static class MyTask4 extends Thread {
        @Override
        public void run() {
            ThreadStatesExample1.printState("attempting to enter synchronized block", this);
            synchronized (ThreadStatesExample4.class) {
                ThreadStatesExample1.printState("entered synchronized block", this);
                //do something
            }
            ThreadStatesExample1.printState("thread finishing", this);
        }
    }
}