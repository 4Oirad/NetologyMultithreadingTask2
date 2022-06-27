import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadGroup myGroup = new ThreadGroup("my group");
//
//        MyCallable myCallable = new MyCallable();
//
//        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
//
//
//        Thread task1 = new Thread(myGroup, futureTask);
//        Thread task2 = new Thread(myGroup, futureTask);
//        Thread task3 = new Thread(myGroup, futureTask);
//        Thread task4 = new Thread(myGroup, futureTask);
//
//        task1.setName("Поток 1");
//        task2.setName("Поток 2");
//        task3.setName("Поток 3");
//        task4.setName("Поток 4");
//
//        System.out.println("Создаю потоки...");
//        task1.start();
//        task2.start();
//        task3.start();
//        task4.start();
//
//        int result = futureTask.get();
//        System.out.println(result);
//
//        Thread.sleep(15000);
//
//        System.out.println("Завершаю все потоки...");
//
//        myGroup.interrupt();
        Thread t1 = new MyCallable();
        Thread t2 = new MyCallable();
        Thread t3 = new MyCallable();
        Thread t4 = new MyCallable();

        t1.setName("Поток 1");
        t2.setName("Поток 2");
        t3.setName("Поток 3");
        t4.setName("Поток 4");

        Callable<Integer> myCallable = new MyCallable();


        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        Future<Integer> task = threadPool.submit(myCallable);

        Future<Integer> task2 = threadPool.submit(myCallable);

        Future<Integer> task3 = threadPool.submit(myCallable);
        Future<Integer> task4 = threadPool.submit(myCallable);



        int result = task.get();
        System.out.println(result);

        List<Future<Integer>>invokeAll

        threadPool.shutdown();

    }
}
