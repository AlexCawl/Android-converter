package ru.myitschool.lab23.controller.locker;

public interface ILocker {
    void lock();
    void unlock();
    boolean isLocked();
    boolean isUnlocked();
}
