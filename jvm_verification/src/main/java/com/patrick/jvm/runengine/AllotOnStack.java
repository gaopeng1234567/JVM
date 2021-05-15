package com.patrick.jvm.runengine;

/**
 *
 *
 * 上述代码调用了1亿次alloc()，如果是分配到堆上，大概需要1.5GB的堆空间，如果堆空间小于该值，必然会触发GC。
 *
 * 使用如下参数运行，发现不会触发GC
 * 使用server模式 最大堆空间为15m 初始堆空间为15m 启用逃逸分析 打印ＧＣ日志 关闭TLAB 启用标量替换，允许对象打散分配到栈上
 * -server -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB -XX:+EliminateAllocations
 */
public class AllotOnStack {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("blueStarWei");
    }


}

class User {

    public void setId(int i) {
    }

    public void setName(String blueStarWei) {
    }
}