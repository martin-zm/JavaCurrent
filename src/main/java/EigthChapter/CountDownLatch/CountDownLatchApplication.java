package EigthChapter.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author miao
 * @Description: 使用countdownlatch实现 1！+2！+3！+4！+5！
 * @Date 2018/9/8 9:37
 */
public class CountDownLatchApplication {
    private static volatile int sum = 0;
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread phrase1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sum += factorial(1) + factorial(2) + factorial(3);
                countDownLatch.countDown();
            }
        });
        Thread phrase2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sum += factorial(4) + factorial(5);
                countDownLatch.countDown();
            }
        });
        phrase1.start();
        phrase2.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; ++i) {
            result *= i;
        }
        return result;
    }
}