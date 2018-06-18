package FourthChapter;

/**
 * @author zhangmiao3
 * @Description: ThreadLocal的使用
 * @date 17:08 2018/6/17
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREDALOCAL = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREDALOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREDALOCAL.get();
    }

    public static void main(String[] args) {
        Profiler.begin();
        SleepUtils.second(2);
        System.out.println("cost: " + Profiler.end() + "mills");
    }
}
