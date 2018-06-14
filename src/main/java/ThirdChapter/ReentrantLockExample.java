package ThirdChapter;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangmiao3
 * @Description: 通过ReentrantLock源码分析锁的内存语义
 * @date 20:26 2018/6/12
 */
public class ReentrantLockExample {
    int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer() {
        lock.lock(); //获取锁
        try {
            a++;
        } finally {
            lock.unlock(); //释放锁
        }
    }

    public void reader() {
        lock.lock(); //获取锁
        try {
            int i = a;
            //……
        } finally {
            lock.unlock(); //释放锁
        }
    }
}
