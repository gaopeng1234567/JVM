package com.patrick.jvm.string;

/**
 * @author patrick
 * @date 2021/2/17 7:03 下午
 * @Des demo
 * 最簡單的事是堅持，最難的事還是堅持
 *
 * String字符串理解
 * 自JDK1.8之后，字符串常量池就已经不在方法区了，在堆中开辟了一个空间存放字符串，那么在代码中势必存在好多变量名不同，
 * 但是值是相同的字符串，而我们的堆又是有固定大小的，所义JVM实现字符串常量池是这样设计的，
 * 采用StringTable而它的底层又是HashTable，HashTable又是数组+链表实现的，那什么作为key？
 * 什么作为value?（看上面的）String定义的变量，在JVM中都是对象，之前我们讲过，java中的对象在JVM中都是对应的都是oop模型，
 * 那么我们定义一个String str = "1";在堆中是怎样存储的呢？首先运行代码时候，栈中会存放字符串的内存地址，
 * 在堆中首先判断常量池中是否有HashTableEntry，若有直接返回内存地址，
 * 若无则创建一个String对象（instanceOopDesc ），包含char[]（TypeArrarOopDesc）对象（作用存放1的）。
 * 那么如果 String str = new String(“1”) 有什么不同呢？
 * 在刚才的基础上会指向new指令创建一个String对象其会指向刚才的String对象。
 * 那如果是字符串拼接呢？ 字符串拼接在jvm中是StringBuilder方法，不会在常量池中存放这个字符串，但是如果调用inturn()方法，则创建到常量池中。
 * 那如果是2个 final String str = '1' 进行拼接呢？ 会创建，因为在编译的时候已经定义了新的字符串，不是在运行时创建的，也就不会调用Builder方法。
 */
public class String_001 {
    public static void main(String[] args) {
        fun2();
    }

    public static void fun1(){
        String s1 = new String("1");
        String s2 = "1";
        String s3 = s1 + s2;

//        s3.intern();

        String s4 = "11";
        System.out.println(s4 == s3);
    }
    public static void fun2(){
        final String s1 = "1";
        final String s2 = "1";
        String s3 = s1 + s2;

//        s3.intern();

        String s4 = "11";
        System.out.println(s4 == s3);
    }
    public static void fun3(){
        final String s1 = new String("1");
        final String s2 = new String("1");
        String s3 = s1 + s2;

//        s3.intern();

        String s4 = "11";
        System.out.println(s4 == s3);
    }
}
