package multithreading.advanced;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueues {

    static private class Consumer implements Runnable {
        private BlockingQueue<String> blockingQueue;

        public Consumer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            for (int i = BlockingQueues.itemsCounter; i > 0; i--) {
                try {
                    System.out.println(Thread.currentThread().getName() + " -> Consumer taking item : " + i + blockingQueue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {

                System.out.println(Thread.currentThread().getName() + " -> Consumer taking item : " + blockingQueue.take());
                System.out.println(Thread.currentThread().getName() + " -> Consumer taking item : " + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static private class Producer implements Runnable {
        private BlockingQueue<String> blockingQueue;

        public Producer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            for (int i = BlockingQueues.itemsCounter; i > 0; i--) {
                try {
                    System.out.println(Thread.currentThread().getName() + " -> Producer putting item : " + i);
                    blockingQueue.put(String.valueOf(i));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int itemsCounter = 10;

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(itemsCounter);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}





