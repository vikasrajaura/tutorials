package com.vik.cj06;

public class DoSelect
{
    public static void test(Exception e)
    {
        System.out.println("Exception");
    }
    public static void test(ArithmeticException ae)
    {
        System.out.println("ArithemticException");
    }
    public static void test(Object o)
    {
        System.out.println("Object");
    }
    public static void main(String [] args)
    {
        test(null);
    }
}
