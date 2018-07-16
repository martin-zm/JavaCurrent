package ElevenChapter.onetoone;

/**
 * @author zhangmiao3
 * @Description:
 * @date 17:23 2018/7/6
 */
public class Main {
    public static void main(String[] args) {

        CookieList cookieList = new CookieList();

        P p = new P(cookieList);
        C c = new C(cookieList);
        p.start();
        c.start();
    }

    //生产者线程
    public static class P extends Thread {

        public CookieList cookieList;

        public P(CookieList cookieList) {
            this.cookieList = cookieList;
        }

        @Override
        public void run() {
            while (true) {

                this.cookieList.product();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者线程
    public static class C extends Thread {

        public CookieList cookieList;

        public C(CookieList cookieList) {
            this.cookieList = cookieList;
        }

        @Override
        public void run() {
            while (true) {
                this.cookieList.customer();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
            }
        }
    }

}
