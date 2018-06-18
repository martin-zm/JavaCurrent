package FourthChapter;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangmiao3
 * @Description: 定义睡眠时间，以秒为单位
 * @date 11:02 2018/6/17
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
