package FirstChapter;

import java.util.concurrent.ThreadFactory;

/**
 * @author zhangmiao3
 * @Description: 测试多线程程序是否一定比串行程序运行快？
 * @date 13:41 2018/5/21
 */
public class ConcurrencyTest {
    private static final long count = 10;

    public static void main(String[] args) throws InterruptedException{
        concurrency();
        serial();
    }

    /**
     * @author zhangmiao3
     * @Description: 多线程测试
     * @date 13:49 2018/5/21
     */
    private static void concurrency() throws InterruptedException{
        long start = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long a = 0;
                for (long i = 0; i < count; ++i) {
                    a += 5;
                }
            }
        });
        thread.start();

        long b = 0;
        for (long i = 0; i < count; ++i) {
            --b;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("currency:" + time + "ms, b= " + b);
    }

    /**
     * @author zhangmiao3
     * @Description: 串行测试
     * @date 13:47 2018/5/21
     */
    private static void serial() {
        long start = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < count; ++i) {
            a += 5;
        }

        long b = 0;
        for (long i = 0; i < count; ++i) {
            --b;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms, a= " + a + " b= " + b);
    }


}
