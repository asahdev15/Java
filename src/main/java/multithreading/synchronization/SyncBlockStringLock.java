package multithreading.synchronization;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class SyncBlockStringLock {

    public static void main (String[] args) {
        SyncBlockStringLock obj = new SyncBlockStringLock();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String path = rootFolder.getAbsolutePath() + File.separatorChar + i;
                obj.writeData(path, " thread1 data " + i);
                obj.readData(path);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String path = rootFolder.getAbsolutePath() + File.separatorChar + i;
                obj.writeData(path, " thread2 data " + i);
                obj.readData(path);
            }
        });

        thread1.start();
        thread2.start();
    }

    private Map<String, Object> locks = new HashMap<>();

    private static final File rootFolder = new File("/Users/asahdev/Work/Test/Java/src/main/java/multithreading/locks/test");

    static {
        if (!rootFolder.exists()) {
            rootFolder.mkdir();
        }
    }
    
    private void writeData (String path, String data) {
        synchronized (getLock(path)) {
            try {
                Files.write(Paths.get(path), data.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readData (String path) {
        synchronized (getLock(path)) {
            String s = null;
            try {
                s = new String(Files.readAllBytes(Paths.get(path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        }
    }

    private Object getLock (String path) {
        if (!locks.containsKey(path)) {
            locks.put(path, new Object());
        }

        return locks.get(path);
    }
}