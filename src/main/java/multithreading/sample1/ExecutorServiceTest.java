package multithreading.sample1;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) {
        testShutdown();
    }

    private static void testShutdown(){
        ExecutorService executorService = createExecutorService();
        List<Future<String>> futures = new LinkedList<>();
        for(int i = 1 ; i<=5 ; i++){
            futures.add(executorService.submit(createCallableTask(i)));
        }
        executorService.shutdown();
        for(int i = 6 ; i<=10 ; i++){
            futures.add(executorService.submit(createCallableTask(i)));
        }
        System.out.println("DONE");
    }

    private static void testExecutorService(){
        System.out.println(".............. Executing : createExecutorService ..............");
        ExecutorService executorService = createExecutorService();
        System.out.println(".............. Executing : creating runnable and callable tasks ..............");
        Runnable runnableTask = createRunnableTask();
        Callable<String> callableTask = createCallableTask(1);
        try {
            System.out.println(".............. Executing : executing runnable task ..............");
            executorService.execute(runnableTask);
//            The Future interface provides a special blocking method get()
//            which returns an actual result of the Callable task’s execution
//            or null in the case of Runnable task.
//            Calling the get() method while the task is still running will cause execution to block
//            until the task is properly executed and the result is available
            System.out.println(".............. Executing : submitting callable task  ..............");
            Future<String> future = executorService.submit(callableTask);
            System.out.println(".............. Executing : future.get ..............");
            String result = future.get();
            System.out.println(".............. Callable Execution Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
//            invokeAny() assigns a collection of tasks to an ExecutorService, causing each to be executed,
//            and returns the result of a successful execution of one task
//            (if there was a successful execution).
            List<Callable<String>> callableTasks = new LinkedList<>();
            callableTasks.add(createCallableTask(1));
            callableTasks.add(createCallableTask(2));
            callableTasks.add(createCallableTask(3));
            System.out.println(".............. Executing via invokeAny..............");
            String result = executorService.invokeAny(callableTasks);
            System.out.println(".............. Callable Execution Result: " + result);
//            invokeAll() assigns a collection of tasks to an ExecutorService,
//            causing each to be executed,
//            and returns the result of all task executions in the form of a list of objects of type Future.
            System.out.println(".............. Executing via invokeAll...........");
            List<Future<String>> futures = executorService.invokeAll(callableTasks);
            System.out.println(".............. Executing : future.get for all tasks..............");
            for(Future item : futures){
                System.out.println(".............. Callable Execution Result: " + item.get());
            }
        } catch (InterruptedException | ExecutionException exp) {
            System.out.println("Exception: " + exp.getMessage());
        }
//        shutdown() method doesn’t cause an immediate destruction of the ExecutorService.
//        It will make the ExecutorService stop accepting new tasks
//        and shut down after all running threads finish their current work.
//        executorService.shutdown();
//        shutdownNow() method tries to destroy the ExecutorService immediately,
//        but it doesn’t guarantee that all the running threads will be stopped at the same time.
//        This method returns a list of tasks which are waiting to be processed.
//        It is up to the developer to decide what to do with these tasks
//        List<Runnable> notExecutedTasks = executorService.shutdownNow();
//        One good way to shut down the ExecutorService (which is also recommended by Oracle)
//        is to use both of these methods combined with the awaitTermination() method.
//        With this approach, the ExecutorService will first stop taking new tasks,
//        the wait up to a specified period of time for all tasks to be completed.
//        If that time expires, the execution is stopped immediately
        System.out.println(".............. Executor Service : ShutDown............");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(6000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println(".............. Processing Complete............");
    }

    private static ExecutorService createExecutorService(){
        return Executors.newFixedThreadPool(1);
    }

    private static Runnable createRunnableTask(){
        return () -> {
            try {
                System.out.println("Executing Runnable Task");
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println("Executing Runnable Task : FINISHED");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    private static Callable<String> createCallableTask(int id){
        return () -> {
            String str = "Executing Callable Task : " + id + " - Thread Name - "  + Thread.currentThread().getName();
            System.out.println(str);
            TimeUnit.MILLISECONDS.sleep(2000);
            return str + ": FINISHED";
        };
    }


}
