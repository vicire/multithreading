import org.apache.log4j.Logger;

public class ThreadDemo extends Thread {
    private static final int MAX_COUNTER = 100;
    private static final Logger logger = Logger.getLogger(ThreadDemo.class);
    private Counter counter;

    public ThreadDemo(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getValue() < MAX_COUNTER) {
            logger.info("Thread-1 value = " + counter.getValue());
            counter.add();
        }
    }
}
