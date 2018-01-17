package com.javaCommApi;

import org.junit.Test;

import java.security.PublicKey;
import java.util.*;

/**
 * Created by chenfengfu on 2018/1/17.
 *  集合类 详解
 *  http://blog.csdn.net/u014136713/article/details/52089156
 */
public class CollectionDtls {
    /*
    Set
    Set它表示数学意义上的集合概念。不包含重复的元素,
    由于Set接口提供的数据结构是数学意义上集合概念的抽象，因此它需要支持对象的添加、删除，而不需提供随机访问。

    HashSet 类和 TreeSet 类
    HashSet 无序;    TreeSet 有序;

    List 允许重复, 有序集合
    Linked 改快读慢
    Array 读快改慢
    Hash 两都之间

    Collection是集合接口
    |————Set子接口:不允许重复, TreeSet 有序, HashSet 无序。
    |————List子接口:有序，可以有重复元素。

    区别：Collections是集合类

    Set和List对比：
    Set：检索元素效率低下，删除和插入效率高，插入和删除不会引起元素位置改变。
    List：和数组类似，List可以动态增长，查找元素效率高，插入删除元素效率低，因为会引起其他元素位置改变。

    Set和List具体子类：
    Set
     |————HashSet：以哈希表的形式存放元素，插入删除速度很快, 无序。
     |————TreeSet：以二叉树的形式存放元素，有序

    List
     |————ArrayList：动态数组
     |————LinkedList：链表、队列、堆栈。

    Vector是一种老的动态数组，是线程同步的，效率很低，一般不赞成使用。

     HashMap 允许null为key 和value, 无序, 不同步
     Hashtable 不允许null, 线程同步
    */
    @Test
    public void setTest(){
        Set set = new HashSet();
        set.add("Bernadine");        set.add("Elizabeth");        set.add("Gene");        set.add("Elizabeth");        set.add("Clara");
        System.out.println(set.size());
        Set treeSet = new TreeSet(set);
        Iterator i = set.iterator();
        while (i.hasNext()){
            String  str = (String) i.next();
            System.out.println(str);
        }
        System.out.println(treeSet);
    }

    @Test
    public void mapTest(){
        Map hashMap = new HashMap();
        hashMap.put("aa", "aaValue");
        hashMap.put("cc", "ccValue");
        hashMap.put("bb", "bbValue");
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        Map treeMap = new TreeMap(hashMap);
        System.out.println(treeMap);
        Set<Map.Entry> entrySet = hashMap.entrySet();
        for(Map.Entry entry : entrySet){
            System.out.print(entry.getKey()+"    ");
            System.out.println(entry.getValue());
        }
    }

}
