package com.wxchen.core.utils;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

final public class StringUtils {


    /**
     * 打印出字节数组，方便查看
     * @param bytes
     * @return
     */
    public static String printByteArray(byte[] bytes) {

        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bytes) {
            stringBuffer.append(b).append(" ");
        }
        return stringBuffer.toString();
    }


    /**
     * 把浮点数转换为只保留两位小数的字符串
     *
     * @param num
     * @return
     */
    public static String getDecimalString(double num) {
        if (num == 0d) {
            return "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String decimalString = decimalFormat.format(num);
        return decimalString;
    }


    /**
     * 判断字符串是否是非空或非null
     *
     * @param s
     * @return
     */
    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    /**
     * 判断字符串是否是空字符串或null
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(Object s) {
        if (s == null)
            return true;
        if ("".equals(s.toString()))
            return true;
        return false;
    }

    /**
     * 把字符串拆分成字符串数组
     *
     * @param splitString 拆分的支付穿
     * @param splitToken  字符串分隔符
     * @return
     */
    public static List<String> split2List(String splitString, String splitToken) {
        return split2List(splitString, splitToken, false);
    }

    /**
     * * 把字符串拆分成字符串数组
     *
     * @param splitString  拆分的支付穿
     * @param splitToken   字符串分隔符
     * @param keepEmptyStr 是否保留空字符串
     * @return
     */
    public static List<String> split2List(String splitString, String splitToken, boolean keepEmptyStr) {
        List<String> stringList = Collections.emptyList();
        if (isEmpty(splitString)) return stringList;
        if (isEmpty(splitToken)) return stringList;

        stringList = new LinkedList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(splitString, splitToken);

        while (stringTokenizer.hasMoreTokens()) {
            String str = stringTokenizer.nextToken();
            if (!keepEmptyStr && isEmpty(str)) {
                continue;
            }
            stringList.add(str.trim());

        }

        return stringList;

    }

    /**
     * @Author wultn
     * @Description 数字金额转大写
     * @Date 14:12 2019/3/20
     * @Param [n]
     **/
    public static String digitUppercase(double n) {
        String fraction[] = { "角", "分"};
        String digit[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String unit[][] = { { "元", "万", "亿"}, { "", "拾", "佰", "仟"}};

        String head = n < 0 ? "负" : "";
        n = Math.abs(n);

        String s = "";
        for (int i = 0; i < fraction.length; i++) {
            s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] + fraction[i]).replaceAll("(零.)+", "");
        }
        if (s.length() < 1) {
            s = "整";
        }
        int integerPart = (int) Math.floor(n);

        for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
            String p = "";
            for (int j = 0; j < unit[1].length && n > 0; j++) {
                p = digit[integerPart % 10] + unit[1][j] + p;
                integerPart = integerPart / 10;
            }
            s = p.replaceAll("(零.)*零$", "").replaceAll("^$", "零") + unit[0][i] + s;
        }
        return head + s.replaceAll("(零.)*零元", "元").replaceFirst("(零.)+", "").replaceAll("(零.)+", "零").replaceAll("^整$", "零元整");
    }
}

