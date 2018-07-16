package Fiveth;

import FourthChapter.SleepUtils;

import java.util.concurrent.locks.Lock;

/**
 * @author zhangmiao3
 * @Description: 两个线程共享锁测试
 * @date 10:27 2018/7/10
 */
public class TwinsLockTest {
    public static void main(String[] args) {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
//                        SleepUtils.second(1);
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
//                        SleepUtils.second(3);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        // 启动10个线程
        for (int i = 0; i < 10; ++i) {
            Worker w = new Worker();
            // 保证主线程退出后，创建的其它线程也退出
            w.setDaemon(true);
            w.start();
        }
        // 每隔1s换行
        for (int i = 0; i < 10; ++i) {
//            SleepUtils.second(1);
            try {
                Thread.sleep(1000);
                System.out.println("------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
