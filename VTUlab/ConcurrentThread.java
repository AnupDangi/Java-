package labprog;

public class ConcurrentThread {

    public static class MyThread extends Thread {
        MyThread() {
            super("My Thread");
            System.out.println("Child thread :" + this);
            start();
        }

        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Child thread:" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Child Thread interrupted");
            }
            System.out.println("Child Thread Exiting");
        }
    }

    public static void main(String[] args) {
        new MyThread();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Main thread:" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}











