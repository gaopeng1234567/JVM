package com.patrick.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author patrick
 * @date 2021/2/19 10:16 上午
 * @Des 堆内存溢出
 * 最簡單的事是堅持，最難的事還是堅持
 *
 * -Xms1m -Xmx1m
 * -server -Xmx2m -Xms2m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+UseTLAB -XX:+EliminateAllocations
 *
 *
 * [GC (Allocation Failure)  510K->496K(1536K), 0.0006706 secs]
 * [GC (Allocation Failure)  1003K->512K(1536K), 0.0008843 secs]
 * [GC (Allocation Failure)  1024K->600K(1536K), 0.0007779 secs]
 * [GC (Allocation Failure)  1112K->935K(1536K), 0.0007316 secs]
 * [Full GC (Ergonomics)  935K->843K(1536K), 0.0085849 secs]
 * [Full GC (Ergonomics)  1335K->1237K(1536K), 0.0111953 secs]
 * [Full GC (Allocation Failure)  1237K->1219K(1536K), 0.0108171 secs]
 * [Full GC (Ergonomics)  1280K->380K(1536K), 0.0039298 secs]
 *
 *
 *
 *
 * [GC (Allocation Failure)  510K->512K(1536K), 0.0006501 secs]
 * [GC (Allocation Failure)  1019K->544K(1536K), 0.0010385 secs]
 * [GC (Allocation Failure)  1056K->584K(1536K), 0.0005751 secs]
 * [GC (Allocation Failure)  1096K->600K(1536K), 0.0010499 secs]
 * [GC (Allocation Failure)  1112K->624K(1536K), 0.0005300 secs]
 * [GC (Allocation Failure)  1136K->648K(1536K), 0.0006366 secs]
 * [GC (Allocation Failure)  1160K->893K(1536K), 0.0006688 secs]
 * [Full GC (Ergonomics)  893K->373K(1536K), 0.0040737 secs]
 * [Full GC (Ergonomics)  885K->373K(1536K), 0.0032175 secs]
 * [Full GC (Ergonomics)  885K->372K(1536K), 0.0037234 secs]
 * [Full GC (Ergonomics)  884K->372K(1536K), 0.0033314 secs]
 * [Full GC (Ergonomics)  884K->390K(1536K), 0.0032951 secs]
 * [Full GC (Ergonomics)  902K->628K(1536K), 0.0043211 secs]
 * [Full GC (Ergonomics)  898K->646K(1536K), 0.0038338 secs]
 * [Full GC (Ergonomics)  876K->776K(1536K), 0.0039465 secs]
 */
public class HeapOom {
    public static void main(String[] args) {
//        List<Object> objects = new ArrayList<>();
        while (true){
           new Fucker();
        }
    }
}

class Fucker{
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Fucker() {
        super();
    }
}

