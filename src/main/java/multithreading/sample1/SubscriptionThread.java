package multithreading.sample1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

class Test {
}

@Slf4j
public class SubscriptionThread {

   private Test notifier;
   private BlockingQueue<Test> bq;
   private Thread thread;
   private AtomicBoolean threadStopped;
   private AtomicBoolean serviceStarted;
   private Semaphore emptyQueueSignal;

   public SubscriptionThread(Test notifier) {
      this.notifier = notifier;
      bq = new LinkedBlockingQueue<>();
      threadStopped = new AtomicBoolean(false);
      serviceStarted = new AtomicBoolean(false);
      emptyQueueSignal = new Semaphore(0);
      thread = new Thread(() -> pullNotification());
      thread.setDaemon(true);
   }

   public void startService() {
      if (serviceStarted.get()) {
         throw new RuntimeException("Service has already been started and can be started only once");
      }
      thread.start();
      serviceStarted.set(true);
   }

   public void stopService() {
      if (!serviceStarted.get()) {
         throw new RuntimeException("Service has not been started yet, please start the service");
      } else if (threadStopped.get()) {
         throw new RuntimeException("Service has already been stopped");
      }
      try {
         emptyQueueSignal.acquire();
         threadStopped.set(true);
         thread.interrupt();
      } catch (InterruptedException ex) {
         log.warn("Exception in stopping subscriber thread; exception;{}", ex.getMessage());
      }
   }

   public void pushNotification(Test notification) {
      if (threadStopped.get()) {
         throw new RuntimeException("Cannot process 'Notification Message' as thread service has been stopped");
      }
      try {
         bq.put(notification);
      } catch (InterruptedException ex) {
         log.warn("Exception;{}", ex.getMessage());
      }
   }

   private void pullNotification() {
      while (!threadStopped.get()) {
         try {
            emptyQueueSignalCheck();
            Test subscriberNotificationDto = bq.take();
         } catch (InterruptedException ex) {
            threadStopped.set(true);
            log.warn("Stopping subscriber thread; exception;{}", ex.getMessage());
         }
      }
   }

   private void emptyQueueSignalCheck() {
      if (!bq.isEmpty())
         emptyQueueSignal.drainPermits();
      else
         emptyQueueSignal.release();
   }

}