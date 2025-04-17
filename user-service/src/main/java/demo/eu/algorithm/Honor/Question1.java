package demo.eu.algorithm.Honor;

import java.util.HashMap;
import java.util.Map;

/**
 * 背景: linux shell输入中${xxx}表示引用了变量xxx, 若有xxx=hello, aaa=a/${xxx}/, 则aaa=a/hello/
 * 输入:
 * 第1行: n 变量个数
 * 第2~n+1行: 变量赋值字符串
 * 输出：
 * 最后一个变量的值
 * 例:
 * 输入： 4
 *       xxx=yes${rrr}
 *       rrr=www
 *       yyy=happy
 *       aa=nn/${xxx}/mm/${yyy}/ccc
 * 输出:  nn/www/mm/happy/ccc
 */

public class Question1 {
  
    public static void main(String[] args) {
        getValue(4);
    }

  
   public static String getValue(int num) {
        String a1 = "xxx=yes${rrr}";
        String a2 = "rrr=www";
        String a3 = "yyy=happy";
        String a4 = "aa=nn/${xxx}/mm/${yyy}/ccc";

        Map<String, String> map = new HashMap<>();
        putMap(a1, map);
        putMap(a2, map);
        putMap(a3, map);

        String s = a4.split("=")[1];
        while (s.split("\\$").length > 1) {
            for (String key : map.keySet()){
                String value = map.get(key);
                String replace = "${" + key + "}";
                if (s.contains(replace)) {
                    s = s.replace(replace, value);
                }
            }
        }
        System.out.println(s);
        return s;
    }

    private static void putMap(String a, Map<String, String> map) {
        String[] split = a.split("=");
        if (split.length == 2) {
            map.put(split[0], split[1]);
        }
    }
}
