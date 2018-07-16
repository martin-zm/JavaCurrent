package ElevenChapter;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhangmiao3
 * @Description: 消费者
 * @date 15:02 2018/7/6
 */
public class Consumer implements Runnable{

    private BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("开始消费" + blockingQueue.take());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
