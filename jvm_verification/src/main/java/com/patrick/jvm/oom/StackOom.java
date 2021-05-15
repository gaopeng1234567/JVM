package com.patrick.jvm.oom;

/**
 * @author patrick
 * @date 2021/2/17 11:23 上午
 * @Des 测试栈帧的大小
 * 最簡單的事是堅持，最難的事還是堅持
 *
 * 一个虚拟机栈中有多少个栈帧？ 方法调用个数个， 每一个方法的调用，就是栈帧的入栈和出栈的过程
 * 一个栈帧记录什么？
 * ---> 栈帧是虚拟机进行方法调用和方法执行的数据结构，是虚拟机运行时数据区中的虚拟机栈的栈元素
 * ---> 栈帧存储了方法的局部变量表和操作数栈、动态连接和方法返回地址等信息。
 *
 * 设置jvm启动参数 栈的大小  虚拟机栈默认大小1024K
 * -Xss160k -XX:+HeapDumpOnOutOfMemoryError
 * 22322
 * 命令查询 java -XX:+PrintFlagsFinal -version | grep -iE 'HeapSize|PermSize|ThreadStackSize'
 * 850
 */
public class StackOom {
    static int count = 0;
    static void add(){
        count += 1;
        add();
    }
    public static void main(String[] args) {

        try {
            add();
        } catch (Error e) {
            System.out.println(StackOom.count);
            e.printStackTrace();
        }

    }
}