package EigthChapter.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zhangmiao3
 * @Description: CyclicBarrier与CountDownLatch的区别
 * @date 19:32 2018/6/14
 */
public class CyclicBarrierTest3 {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
           try {
               c.await();
           } catch (Exception e) {

           }
        });
        thread.start();
        thread.interrupt();

        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
        }
    }
}
