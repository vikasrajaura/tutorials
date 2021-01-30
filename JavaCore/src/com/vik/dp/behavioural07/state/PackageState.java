package com.vik.dp.behavioural07.state;

public interface PackageState {

    void next(Package pkg);

    void prev(Package pkg);

    void printStatus();
}