import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Fork {
    private final Lock lock = new ReentrantLock();
     int id;

    public Fork(int id) {
        this.id = id;
    }

    public boolean pickUp() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }

    public int getId() {
        return id;
    }
}

class Philosopher implements Runnable {
     int id;
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");

    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is waiting for fork " + leftFork.getId() + ".");
        leftFork.pickUp();
        System.out.println("Philosopher " + id + " picks up fork " + leftFork.getId() + ".");

        System.out.println("Philosopher " + id + " is waiting for fork " + rightFork.getId() + ".");
        rightFork.pickUp();
        System.out.println("Philosopher " + id + " picks up fork " + rightFork.getId() + ".");

        System.out.println("Philosopher " + id + " is eating.");


        leftFork.putDown();
        System.out.println("Philosopher " + id + " puts down fork " + leftFork.getId() + ".");

        rightFork.putDown();
        System.out.println("Philosopher " + id + " puts down fork " + rightFork.getId() + ".");
    }
}

public class Senerio_2_solution {
    public static void main(String[] args) {
        int numPhilosophers = 3;
        Fork[] forks = new Fork[numPhilosophers];
        Philosopher[] philosophers = new Philosopher[numPhilosophers];


        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Fork(i);
        }


        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % numPhilosophers]);
            new Thread(philosophers[i]).start();
        }
    }
}
