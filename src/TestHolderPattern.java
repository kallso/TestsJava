import java.util.HashSet;
import java.util.Set;

public class TestHolderPattern {

    public static void main(String[] args) {

        Set<Thread> threadsSet = new HashSet<>();
        Set<Thread> threadsHoldingSet = new HashSet<>();

        for (int i = 0; i < 4000; i++) {
            threadsSet.add(new Thread(new MyRunnable()));
        }

        for (int i = 0; i < 4000; i++) {
            threadsHoldingSet.add(new Thread(new MyRunnableHolding()));
        }

        long start = System.currentTimeMillis();

        threadsSet.forEach(Thread::start);
        threadsSet.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        long end = System.currentTimeMillis();

        long timeForSynchronizedSingleton = end - start;

        start = System.currentTimeMillis();

        threadsHoldingSet.forEach(Thread::start);
        threadsHoldingSet.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        end = System.currentTimeMillis();

        System.out.printf("Time elapsed for access to Singleton by Syncro: %d \n", timeForSynchronizedSingleton);
        System.out.printf("Time elapsed for access to Singleton by Holding: %d \n", end - start);
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Singleton singleton = Singleton.getInstance();
                System.out.println("singleton ref : " + singleton);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class MyRunnableHolding implements Runnable {

        @Override
        public void run() {
            try {
                SingletonByHolding singleton = SingletonByHolding.getInstance();
                System.out.println("singleton ref : " + singleton);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SingletonByHolding {
    private static class Holder {
        public static SingletonByHolding instance = new SingletonByHolding();
    }

    private SingletonByHolding() {
    }

    public static SingletonByHolding getInstance() throws InterruptedException {
        //Thread.sleep(2);
        return Holder.instance;
    }
}

class Singleton {
    private static Singleton instance;

    public static synchronized Singleton getInstance() throws InterruptedException {
        //Thread.sleep(2);

        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class SingletonStatic {
    static public long field;

    private SingletonStatic() {
    }
}
