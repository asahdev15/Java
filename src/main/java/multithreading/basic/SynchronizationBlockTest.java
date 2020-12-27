package multithreading.basic;

public class SynchronizationBlockTest {

    public static void main(String[] args) {
        int testVariable = 0;
        TwoSums twoSums = new  TwoSumsSynchronizedWay2();
        Thread thread1 = new Thread(new MyRunnable(twoSums));
        Thread thread2 = new Thread(new MyRunnable(twoSums));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        twoSums.printSums();
    }

    static class MyRunnable implements Runnable{
        TwoSums twoSums;
        MyRunnable(TwoSums twoSums){
            this.twoSums = twoSums;
        }
        @Override
        public void run() {
            twoSums.add(1,1);
        }
    }

    private interface TwoSums{
        public void add(int val1, int val2);
        public void printSums();
    }

    static private class TwoSumsUnsynchronized implements TwoSums{
        private volatile int testVariable = 0; // read from main memory into CPU Register by Thread
        private int sum1 = 0;
        private int sum2 = 0;
        public void add(int val1, int val2){
                this.sum1 += val1;
                this.sum2 += val2;
        }
        public void printSums(){
            System.out.println(Thread.currentThread().getName() + " :: Sum1:"+sum1 + ", Sum2:"+sum2);
        }

    }

    static private class TwoSumsUnsynchronizedMethodInstance implements TwoSums{
        private int sum1 = 0;
        private int sum2 = 0;
        public synchronized void add(int val1, int val2){
            this.sum1 += val1;
            this.sum2 += val2;
        }
        public void printSums(){
            System.out.println(Thread.currentThread().getName() + " :: Sum1:"+sum1 + ", Sum2:"+sum2);
        }

    }

    static private class TwoSumsSynchronizedWay1  implements TwoSums{
        private int sum1 = 0;
        private int sum2 = 0;
        public void add(int val1, int val2){
            synchronized(this){
                this.sum1 += val1;
                this.sum2 += val2;
            }
        }
        public void printSums(){
            System.out.println(Thread.currentThread().getName() + " :: Sum1:"+sum1 + ", Sum2:"+sum2);
        }
    }

    static private class TwoSumsSynchronizedWay2  implements TwoSums{
        private int sum1 = 0;
        private int sum2 = 0;
        private Integer sum1Lock = new Integer(1);
        private Integer sum2Lock = new Integer(2);
        public void add(int val1, int val2){
            synchronized(this.sum1Lock){
                this.sum1 += val1;
            }
            synchronized(this.sum2Lock){
                this.sum2 += val2;
            }
        }
        public void printSums(){
            System.out.println(Thread.currentThread().getName() + " :: Sum1:"+sum1 + ", Sum2:"+sum2);
        }
    }
}
