package EigthChapter.CountDownLatch;

/**
 * @author zhangmiao3
 * @Description: 测试join实现同步多个线程
 * @date 19:58 2018/6/13
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("parser1 finished");
            }
        });

        Thread parser2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("parser2 finished");
            }
        });

        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();

        System.out.println("parser all finished");
    }
}
