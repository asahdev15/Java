package multithreading.sample1;

class ExecuteMe implements Runnable {

    public static void main(String args[]) throws InterruptedException {

        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        innerThread.setDaemon(true);
        innerThread.start();

        Thread.sleep(3000);
//        System.out.println("Interupting");
//        innerThread.interrupt();
    }

    public void run() {
        boolean run = true;
        while (run) {
            try {
                System.out.println("Say Hello over and over again.");
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                run=false;
                // swallow interrupted exception
            }
        }
    }
}