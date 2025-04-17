package demo.eu.algorithm.Honor;

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
}
