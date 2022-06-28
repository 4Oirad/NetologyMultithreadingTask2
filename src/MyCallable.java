import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int n = 0;
        try {
            for (int i = 0; i < 4; i++) {
                Thread.sleep(2500);
                System.out.println("Всем привет! Я " + Thread.currentThread().getName());
                n++;
            }
        } catch (InterruptedException err) {

        } finally{
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
            n++;
        }
        return n;
    }
}