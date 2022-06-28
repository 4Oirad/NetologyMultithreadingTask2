import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomThreadFactory implements ThreadFactory {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final String prefix = "Поток ";

    @Override
    public Thread newThread(Runnable task) {
        return new Thread(task, prefix + counter.incrementAndGet());
    }
}