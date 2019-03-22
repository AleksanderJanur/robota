package com.company;

public class Main {

    public static void main(String[] args) {

        com.company.Matrix m = new Matrix(new double[][]{{1,2,3},{4,5,6},{7,8,9});
        System.out.print(m);


        System.out.println(m.get(1,0));

        m.set(1,2,10);
        System.out.println(m);
        m.reshape(2,10);
        System.out.println(m);
        m.shape();
        m.sumRows();
    }

    public static void test(Object obj) {

    }
}