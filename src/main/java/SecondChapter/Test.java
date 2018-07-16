package SecondChapter;


/**
 * @author zhangmiao3
 * @Description:
 * @date 11:56 2018/6/20
 */
public class Test {
    public static void main(String[] args) {
        int[] table = getPartMatchTable("ABCDABD");
        for (int i = 0; i < table.length; ++i) {
            System.out.print(table[i] + " ");
        }
    }

    public static int strStr(String source, String target) {
        // write your code here
        if (source == null) {
            return -1;
        }
        if (target == null) {
            return -1;
        }
        char[] sourceCharArray = source.toCharArray();
        char[] targetCharArray = target.toCharArray();
        for (int i = 0; i < sourceCharArray.length; ++i) {
            if (sourceCharArray[i] == targetCharArray[0]) {
                int tempI = i;
                for (int j = 0; j < targetCharArray.length; ++j, ++tempI) {
                    if (sourceCharArray[tempI] != sourceCharArray[j]) {
                        break;
                    }
                }
                if (tempI == (i + targetCharArray.length)) {
                    return i;
                }
            }
        }
        return -1;
    }

    //KMP字符串匹配算法
    public static int[] getPartMatchTable(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        char[] charArray = str.toCharArray();
        int[] table = new int[str.length()];
        int j = 0;
        int i = 1;
        int count = 0;
        table[0] = 0;
        while (i < length)
            if (charArray[i] == charArray[j]) {
                ++count;
                table[i] = count;
                ++i;
                ++j;
            } else {

                count = 0;
                table[i] = count;
                j = 0;
                ++i;
            }
        return table;
    }
}
