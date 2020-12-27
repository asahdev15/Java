package multithreading.sample1;

class NonReentrantLock {

    public static void main(String args[]) throws Exception {
        NonReentrantLock nreLock = new NonReentrantLock();

//        synchronized (NonReentrantLock.class){
//
//            System.out.println("1st Lock");
//            synchronized (NonReentrantLock.class){
//                System.out.println("2nd Lock");
//            }
//            System.out.println("Released");
//
//        }

        // First locking would be successful
        nreLock.lock();
        System.out.println("Acquired first lock");

        // Second locking results in a self deadlock
        System.out.println("Trying to acquire second lock");
        nreLock.lock();
        System.out.println("Acquired second lock");
    }

    boolean isLocked;

    public NonReentrantLock() {
        isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            System.out.println("Waiting..");
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}