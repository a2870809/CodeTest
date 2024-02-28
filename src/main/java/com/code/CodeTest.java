package com.code;

public class CodeTest {

    /**
     * 1.删除连续字符
     *
     * @param s
     * @return String
     */
    public static void reduceString(String s) {

        StringBuilder sb = new StringBuilder(s);
        //循环结束标识，用于记录是否删除了连续字符串，如未删除说明已经删完，无需下一轮循环
        boolean reductionOccurred;
        do {
            reductionOccurred = false;

            for (int left = 0, right = 0; right <= sb.length(); right++) {
                if (right == sb.length() || sb.charAt(left) != sb.charAt(right)) {
                    //连续字母长度大于等于3，删除
                    if (right - left >= 3) {
                        sb.delete(left, right);
                        reductionOccurred = true;
                        System.out.println(sb);
                        //重置右指针，避免字符串长度变化导致漏扫描
                        right = left;
                    } else {
                        //左指针移动
                        left = right;
                    }

                }
            }
        } while (reductionOccurred);
    }

    /**
     * 2.连续相同字母替换为字母表中前一个字母
     *
     * @param s
     */
    public static void replaceString(String s) {

        StringBuilder sb = new StringBuilder(s);
        //循环结束标识，用于记录是否删除了连续字符串，如未删除说明已经删完，无需下一轮循环
        boolean reductionOccurred;
        do {
            reductionOccurred = false;

            for (int left = 0, right = 0; right <= sb.length(); right++) {

                if (right == sb.length() || sb.charAt(left) != sb.charAt(right)) {
                    //连续字母长度大于等于3，替换
                    if (right - left >= 3) {
                        //连续字母的前一个字母
                        char preChar = (char) (sb.charAt(left) == 'a' ? ' ' : sb.charAt(left) - 1);
                        sb.replace(left, right, String.valueOf(preChar).trim());
                        reductionOccurred = true;
                        System.out.println(sb);

                        //重置右指针，避免字符串长度变化导致漏扫描
                        right = left;
                    } else {
                        //左指针移动
                        left = right;
                    }
                }
            }
        } while (reductionOccurred);
    }

    public static void main(String[] args) {
        reduceString("aabcccbbad");
        replaceString("abcccbad");
    }
}
