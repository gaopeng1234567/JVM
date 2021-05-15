package com.patrick.jvm.runengine;

/**
 * 标量替换
 */
public class ScalarReplace {

    public static void main(String[] args) {

    }

    public static void test() {
        Position position = new Position(1, 2, 3);

        System.out.println(position.x);
        System.out.println(position.y);
        System.out.println(position.z);

//         System.out.println(1);
//        System.out.println(2);
//        System.out.println(3);
    }
}

class Position {
    int x;
    int y;
    int z;

    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}