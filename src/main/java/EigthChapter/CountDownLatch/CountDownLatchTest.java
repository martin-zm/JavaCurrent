package EigthChapter.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangmiao3
 * @Description: 测试countDownLatch实现同步多个线程
 * @date 20:04 2018/6/13
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException{
        final CountDownLatch c = new CountDownLatch(2);
        new Thread(new Runnable() {
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println(3);
    }
}
