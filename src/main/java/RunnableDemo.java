import org.apache.log4j.Logger;

public class RunnableDemo implements Runnable {
    private static final int MAX_COUNTER = 100;
    private static final Logger logger = Logger.getLogger(RunnableDemo.class);
    private Counter counter;

    public RunnableDemo(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getValue() < MAX_COUNTER) {
            logger.info("Thread-0 value = " + counter.getValue());
            counter.increment();
        }
    }
}
