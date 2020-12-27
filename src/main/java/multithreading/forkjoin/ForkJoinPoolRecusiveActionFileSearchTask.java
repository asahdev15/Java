package multithreading.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolRecusiveActionFileSearchTask extends RecursiveAction {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        ForkJoinPoolRecusiveActionFileSearchTask forkJoinPoolRecusiveActionFileSearchTask = new ForkJoinPoolRecusiveActionFileSearchTask(new File("/Users/asahdev/Work/Test/Java"));
        ForkJoinPool.commonPool().invoke(forkJoinPoolRecusiveActionFileSearchTask);
        System.out.println("time taken : " + (System.currentTimeMillis() - time));
    }

    static long count;
    private final File file;

    public ForkJoinPoolRecusiveActionFileSearchTask(File file) {
        this.file = file;
    }

    @Override
    protected void compute() {
        List<ForkJoinPoolRecusiveActionFileSearchTask> tasks = new ArrayList<>();
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    ForkJoinPoolRecusiveActionFileSearchTask newTask = new ForkJoinPoolRecusiveActionFileSearchTask(f);
//                    tasks.add(newTask); // Comment for Sequential Processing
//                    newTask.fork();
                    newTask.compute(); // Un-Comment for Sequential Processing
                } else if (f.getName().endsWith(".java")) {
                    System.out.println(Thread.currentThread().getName() + " - " + f.getAbsolutePath());
                    count++;
                }
            }
        }
        if (tasks.size() > 0) {
            for (ForkJoinPoolRecusiveActionFileSearchTask task : tasks) {
                task.join();
            }
        }
    }


}