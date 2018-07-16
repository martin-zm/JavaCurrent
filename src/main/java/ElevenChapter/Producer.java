package ElevenChapter;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhangmiao3
 * @Description: 生产者
 * @date 14:52 2018/7/6
 */
public class Producer implements Runnable {

    private BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    volatile int task = 1;

    public void run() {
        while (true) {
            try {
                blockingQueue.put(task);
                System.out.println("开始生产" + task);
                ++task;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
