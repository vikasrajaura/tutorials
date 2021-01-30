package com.vik.dp.creational02.abstractfactory;

public interface AbstractFactory<T> {
    T create(String type) ;
}