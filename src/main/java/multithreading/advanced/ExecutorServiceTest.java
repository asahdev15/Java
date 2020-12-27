package multithreading.advanced;

import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        executorServiceExample();
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    public static void executorServiceExample(){
        ExecutorService pool = getThreadPool(); // Create Thread Pool Executor Service
        pool.execute(new RunnableTest("Task 1")); // Submit multiple task
        pool.execute(new RunnableTest("Task 2"));
        pool.execute(new RunnableTest("Task 3"));
        pool.execute(new RunnableTest("Task 4"));
        pool.execute(new RunnableTest("Task 5"));
        pool.shutdown(); // shutdown the executor service, otherwise it will keep on running in background.
        try {
            pool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static ExecutorService getThreadPool(){
        return newCachedThreadPool();
    }

    private static ExecutorService newSingleThreadExecutor(){
        System.out.println("Using newSingleThreadExecutor");
        return Executors.newSingleThreadExecutor();
    }

    private static ExecutorService newFixedThreadPool(){
        System.out.println("Using newFixedThreadPool");
        return Executors.newFixedThreadPool(2);
    }

    private static ExecutorService newCachedThreadPool(){
        System.out.println("Using newCachedThreadPool");
        return Executors.newCachedThreadPool();
    }

    private static ExecutorService customThreadPool(){
        System.out.println("Using customThreadPool");
        int corePoolSize = 1; // the number of threads to keep in the pool.
        int maxPoolSize = 5; // the maximum number of threads to allow in the pool.
        int keepAliveTime = 1; // if the pool currently has more than corePoolSize threads, excess threads will be terminated if they have been idle for more than keepAliveTime.
        BlockingQueue<Runnable> workQueue = new SynchronousQueue<Runnable>(); // the queue used for holding tasks before they are executed. Default choices are SynchronousQueue for multi-threaded pools and LinkedBlockingQueue for single-threaded pools.
        return new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue);
    }

    public static void executorServiceCallableExample(){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Callable<Integer> task = new Callable<Integer>() {
            public Integer call() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                return 1000;
            }
        };
        Future<Integer> result = pool.submit(task);
        try {
            Integer returnValue = result.get();
            System.out.println("Return value = " + returnValue);
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
        pool.shutdown(); // important to call, otherwise executor service will keep on running at background.
    }
}