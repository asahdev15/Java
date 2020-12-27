package multithreading.basic;

public class ThreadStatesExample2 {
    public static void main(String[] args) {
        MyTask2 t = new MyTask2();
        t.setName("Thread2");
        ThreadStatesExample1.runExampleThread(t);
    }

    private static class MyTask2 extends Thread {
        @Override
        public void run() {
            ThreadStatesExample1.printState("thread run() started", this);
            try {
                //this will put the thread in TIMED_WAITING state
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ThreadStatesExample1.printState("thread finishing", this);
        }
    }
}