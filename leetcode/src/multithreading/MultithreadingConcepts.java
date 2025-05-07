package multithreading;

public class MultithreadingConcepts {
    public static void main(String[] args) {
        String lock1 = "Aditya";
        String lock2 = "Raj";

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("acquired lock 2");
                }
            }

        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("acquired lock 1");
                }
            }
        });

        t1.start();
        t2.start();
    }

}
