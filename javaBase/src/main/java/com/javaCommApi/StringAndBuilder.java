package com.javaCommApi;

/**
 * Created by chenfengfu on 2018/1/16.
 */
public class StringAndBuilder {

    // String 常量池, String的连接是使用StringBuilder实现的
    // StringBuilder 是可变字符串, 对字符串内容进行计算优先使用StringBuilder, 非线程安全的, 并发处理性能稍快
    // StringBuffer 线程安全的, 同步处理, 性能稍慢

    /*
    正则表达式
    ^           字符串开始
    $           字符串结束
    [abc]       a, b, c中任意一个字符
    [^abc]      除了abc之外的字符
    [a-z]       a到z
    [a-zA-Z0-9] a~z, A~Z, 0~9
    [a-z&&[^bc]] a~z中除了bc之外的
    .           任意字符
    \d          任意一个数字
    \w          单词字符, [a-zA-Z0-9]
    \s          空白字符
    \D          非数字字符
    \W          非单词字符
    \S          非空白字符
    X?          零个或一个X
    X*          零个或任意个X
    X+          一个以上X
    X{n}        n个X
    X{n, }      n以上个X
    X{n,m}      n到m个X

     */

}
