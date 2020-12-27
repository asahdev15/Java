package multithreading.basic;

public class ThreadStatesExample3 {

    public static void main(String[] args) throws InterruptedException {
        MyTask3 t = new MyTask3();
        t.setName("Thread3");
        ThreadStatesExample1.runExampleThread(t);
        synchronized (ThreadStatesExample3.class) {
            ThreadStatesExample3.class.notifyAll();
        }
    }

    private static class MyTask3 extends Thread {

        @Override
        public void run() {
            ThreadStatesExample1.printState("thread run() started", this);
            //using Example3.class object monitor
            synchronized (ThreadStatesExample3.class) {
                try {
                    //this will put the thread in WAITING state
                    ThreadStatesExample3.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ThreadStatesExample1.printState("thread finishing", this);
        }
    }
}