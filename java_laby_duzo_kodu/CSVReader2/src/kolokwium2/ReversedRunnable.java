package kolokwium2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;


class ReversedRunnable implements Runnable {

    Semaphore semaphore;
    Semaphore allIn;
    List<Integer> list;
    int from;
    int to;

    public ReversedRunnable(Semaphore semaphoreForList,
                            Semaphore allIn,
                            List<Integer> list,
                            int from,
                            int to) {
        this.semaphore = semaphoreForList;
        this.allIn = allIn;
        this.list = list;
        this.from = from;
        this.to = to;

    }

    public void run() {
        List<Integer> chunkList = this.list.subList(from, to);
        Collections.reverse(chunkList);
        semaphore.tryAcquire();

        for (int i = 0; i < chunkList.size(); i++) {
            list.set(i + from, chunkList.get(i));
        }
        try {
            allIn.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}


class Test {
    private final int AMOUNT = 100000000;

    private Semaphore semaphore = new Semaphore(1);

    private Semaphore allIn;
    List<Integer> list = new ArrayList<>(AMOUNT);

    public void fillTheList() {
        for (int i = 0; i < AMOUNT; i++) {
            list.add(i);
        }
    }

    public void reverse(int threadAmount) {
        allIn = new Semaphore(threadAmount);
        for (int i = 0; i < threadAmount; i++) {
            int from = list.size() / threadAmount * (i);
            int to = list.size() / threadAmount * i + 1;

            new Thread(new ReversedRunnable(semaphore, allIn, list, from, to)).start();
        }

//        while (allIn.availablePermits() != threadAmount) {
//            // wait for all task.
//        }

        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.fillTheList();
        test.reverse(10);

    }
}
