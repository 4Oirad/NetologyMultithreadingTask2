import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(4, new CustomThreadFactory());

        MyCallable t1 = new MyCallable();
        MyCallable t2 = new MyCallable();
        MyCallable t3 = new MyCallable();
        MyCallable t4 = new MyCallable();

        final List<MyCallable> tasks = List.of(t1, t2, t3, t4);
        final List<Future<Integer>> futures = executorService.invokeAll(tasks);

        int result = 0;
        for (Future<Integer> future : futures) {
            result = result + future.get();
        }
        System.out.println("Всего выведено в консоль "  + result + " сообщений!");

        System.out.println("Получение результата самой быстрой задачи...");
        final int fastFuture = executorService.invokeAny(tasks);
        System.out.println("Самая быстрая задача вывела в консоль " + fastFuture + " сообщений");

        executorService.shutdown();
    }
}