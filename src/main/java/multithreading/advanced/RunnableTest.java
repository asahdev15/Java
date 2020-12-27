package multithreading.advanced;

public class RunnableTest implements java.lang.Runnable {

    public static void main(String[] args){
        Thread newThread = new Thread(new RunnableTest("Task A"));
        Thread newThread2 = new Thread(new RunnableTest("Task B"));
        newThread.start();
        newThread2.start();
    }

    private String taskName;

    public RunnableTest(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        int counter = 5;
        while(counter > 0){
            System.out.printf("%s -> %s : %d \n", Thread.currentThread().getName(), taskName, counter );
            counter--;
        }
    }


}
