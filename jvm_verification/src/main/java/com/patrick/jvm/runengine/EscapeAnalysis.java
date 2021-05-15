package com.patrick.jvm.runengine;

/**
 * 逃逸分析
 *
 * 逃到哪里去了？
 *  方法外
 *  线程外
 */
public class EscapeAnalysis {

    public static Object globalVariableObject;

    public Object instanceObject;

    //静态变量,外部线程可见,发生逃逸
    public void globalVariableEscape(){
        globalVariableObject = new Object();
    }

    //赋值给堆中实例字段,外部线程可见,发生逃逸
    public void instanceObjectEscape(){
        instanceObject = new Object();
    }

    //返回实例,外部线程可见，发生逃逸
    public Object returnObjectEscape(){
        return new Object();
    }

    //仅创建线程可见,对象无逃逸
    public void noEscape1(){
        synchronized (new Object()){
            System.out.println("hello");
        }
    }

    //仅创建线程可见,对象无逃逸
    public void noEscape2() {
        Object noEscape = new Object();
    }

    public static void main(String[] args) {
        EscapeAnalysis analysis = new EscapeAnalysis();

        analysis.globalVariableEscape();
    }
}
