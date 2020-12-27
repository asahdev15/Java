package multithreading.sample1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args){
        new BlockingQueueExample().run();
    }

    private Map<Integer, SubscriberThread> subscribers = new HashMap<>();

    private void run(){
        System.out.println("Starting....");
        subscribers.put(1, new SubscriberThread("1"));
        subscribers.put(2, new SubscriberThread("2"));
        subscribers.put(3, new SubscriberThread("3"));
        for(int i = 0 ; i<10 ; i++){
            subscribers.get(1).insertItem(new NotificationMessage(String.valueOf(1), "New Message : "+i));
        }
        System.out.println("Shutting Down...");
    }

    class SubscriberThread{
        private BlockingQueue<NotificationMessage> bq = new LinkedBlockingQueue<NotificationMessage>();
        private Thread thread ;
        public SubscriberThread(String name){
            thread = new Thread(()->readItem());
            thread.setName("ThreadName:"+name);
            thread.start();
        }
        public void insertItem(NotificationMessage notificationMessage){
            try {
                bq.put(notificationMessage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        private void readItem(){
            while(true){
                try {
                    NotificationMessage i = bq.take();
                    System.out.println("Message Fetched: " + i + " ThreadName : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class NotificationMessage{
        public String id;
        public String message;
        public NotificationMessage(String id, String message){
            this.id = id;
            this.message = message;
        }
        public String toString(){
            return "Notification;id:"+id+";message:"+message;
        }
    }
}
