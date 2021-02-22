public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.setValue(0);
        ThreadDemo threadDemo = new ThreadDemo(counter);
        RunnableDemo runnableDemo = new RunnableDemo(counter);
        threadDemo.start();
        Thread runnable = new Thread(runnableDemo);
        runnable.start();
    }
}
