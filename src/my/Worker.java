package my;

import java.util.concurrent.CountDownLatch;

/**
 * @author fudh
 * @ClassNmme Worker
 * @date 2019/3/19 17:10
 * @Description: TODO
 */
public class Worker implements Runnable{

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private  Integer tag;
    Worker(CountDownLatch startSignal, CountDownLatch doneSignal,Integer tag) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.tag = tag;
    }
    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException ex) {} // return;
    }

    void doWork() {
        System.out.println("thread : "+tag+"doWork.....");
    }
}
