package ElevenChapter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author zhangmiao3
 * @Description: 测试
 * @date 15:05 2018/7/6
 */
public class Test {
    public static void main(String[] args) {
        // 无界队列
//        BlockingQueue blockingQueue = new LinkedBlockingDeque();
        // 有界队列
        BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
