package my;
import java.util.concurrent.CountDownLatch;

/**
 * @author fudh
 * @ClassNmme Driver
 * @date 2019/3/19 17:08
 * @Description: TODO
 */
public class Driver {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(100);

        for (int i = 0; i < 100; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal,i)).start();

        doSomethingStart();            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        doSomethingEnd();
        doneSignal.await();           // wait for all to finish
    }

    private static void doSomethingStart() {
        System.out.println("doSomethingStart");
    }

    private static void doSomethingEnd() {
        System.out.println("doSomethingEnd");
    }


}
