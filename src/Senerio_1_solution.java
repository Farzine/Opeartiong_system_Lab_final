import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Bakery {
     static final int PRODUCTION_TIME = 3;
    static final int SHOPS = 5;


    int breadInventory = 0;
   int totalBreadProduced = 0;
 final Object lock = new Object();

  public void produceBread() throws InterruptedException {
        synchronized (lock) {
            Thread.sleep(PRODUCTION_TIME * 1000);
            breadInventory++;
            totalBreadProduced++;
            System.out.println("Bakery produced 1 bread. Inventory: " + breadInventory);
            lock.notifyAll();
        }
    }

    public void sellBread(Shop shop) throws InterruptedException {
        synchronized (lock) {
            while (breadInventory <= 0) {
                System.out.println("Shop " + shop.getId() + " is waiting for bread.");
                lock.wait();
            }

            breadInventory--;
            System.out.println("Shop " + shop.getId() + " bought 1 bread. Inventory: " + breadInventory);
        }
    }

    public int TotalBreadProduced() {
        return totalBreadProduced;
    }
}

class Shop extends Thread {
    static final int MAX_WAIT_TIME = 5;

    final Bakery bakery;
    final Random random = new Random();

    public Shop(Bakery bakery, int id) {
        super("Shop-" + id);
        this.bakery = bakery;
    }

    @Override
    public void run() {
        while (true) {
            try {
                bakery.sellBread(this);
                Thread.sleep((random.nextInt(MAX_WAIT_TIME) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Senerio_1_solution {
    public static void main(String[] args) {
        Bakery bakery = new Bakery();
        List<Shop> shops = new ArrayList<>();

        for (int i = 1; i <= Bakery.SHOPS; i++) {
            Shop shop = new Shop(bakery, i);
            shops.add(shop);
            shop.start();
        }

        while (true) {
            try {
                bakery.produceBread();
                Thread.sleep(Bakery.PRODUCTION_TIME * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

