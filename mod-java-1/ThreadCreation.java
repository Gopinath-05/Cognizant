class MyThread extends Thread {
    String msg;
    MyThread(String msg) { this.msg = msg; }
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println(msg + " " + i);
    }
}
public class ThreadCreation {
    public static void main(String[] args) {
        new MyThread("Thread 1").start();
        new MyThread("Thread 2").start();
    }
}
