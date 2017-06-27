/**
 * Created by Саша on 25.06.2017.
 */
public class MyRunnable implements Runnable {
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        go();
        System.out.println("run()");
    }
    public void go() {
        doMore();
        System.out.println("go()");
    }
    public void doMore() {
        System.out.println(" =2= вершина стека");
        System.out.println("doMore");
    }
}
class ThreadTestDrive {
    public static void main(String[] args) {


        Runnable threadJob = new MyRunnable();
        Thread myThread= new Thread(threadJob);

        myThread.start();

        System.out.println(" =1= oВозвращаемся в метод main");
    }
}