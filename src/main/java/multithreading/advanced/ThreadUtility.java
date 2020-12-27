package multithreading.advanced;

public class ThreadUtility {

    public static void printThreadProperties(){
        System.out.println("ID : " + Thread.currentThread().getId());
        System.out.println("Name : " + Thread.currentThread().getName());
        System.out.println("State : " + Thread.currentThread().getState());
        System.out.println("Thread Group Name : " + Thread.currentThread().getThreadGroup().getName());
    }

    public static void printLineSplitter(){
        System.out.println("----------------------------------------");
    }
}
