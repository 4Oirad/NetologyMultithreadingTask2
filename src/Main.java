import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable<Integer> myCallable = new MyCallable();

        ExecutorService threadPool = Executors.newFixedThreadPool(4, new CustomThreadFactory());

        Future<Integer> task1 = threadPool.submit(myCallable);
        Future<Integer> task2 = threadPool.submit(myCallable);
        Future<Integer> task3 = threadPool.submit(myCallable);
        Future<Integer> task4 = threadPool.submit(myCallable);

        int result = task1.get() + task2.get() +task3.get() + task4.get() + 1;
        System.out.println("Всего выведено в консоль "  + result + " сообщений!");
        threadPool.shutdown();
    }
}