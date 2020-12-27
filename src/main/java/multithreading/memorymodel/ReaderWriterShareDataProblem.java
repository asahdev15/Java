package multithreading.memorymodel;

public class ReaderWriterShareDataProblem {
    static int c;

    public static void main (String[] args) {

        Thread thread1 = new Thread(() -> {
            int temp = 0;
            while (true) {
                if (temp != c) {
                    temp = c;
                    System.out.println("reader: value of c = " + c);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                c++;
                System.out.println("writer: changed value to = " + c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            // sleep some time to allow reader thread to read changes (if it can!).
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //exit the program
            System.exit(0);
        });

        thread1.start();
        thread2.start();
    }
}