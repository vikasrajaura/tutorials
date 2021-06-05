package com.vik.cj06;

public class DoSelect
{
    public static void Test(Exception e)
    {
        System.out.println("Exception");
    }
    public static void Test(ArithmeticException ae)
    {
        System.out.println("ArithemticException");
    }
    public static void Test(Object o)
    {
        System.out.println("Object");
    }
    public static void main(String [] args)
    {
        Test(null);
    }
}
