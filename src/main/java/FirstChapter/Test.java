package FirstChapter;

/**
 * @author zhangmiao3
 * @Description:
 * @date 14:46 2018/6/11
 */
public class Test {
    private static final String s = "test";

    private static void fun() {
        System.out.println(1);
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Test test = new Test();
        String s = test.s;
//        String s1 = Test.s;
        System.out.println(s);
        Test.fun();

    }
}
