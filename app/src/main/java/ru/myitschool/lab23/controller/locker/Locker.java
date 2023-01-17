package ru.myitschool.lab23.controller.locker;

public class Locker implements ILocker {
    protected LockStatus status;

    public Locker() {
        this.status = LockStatus.UNLOCKED;
    }

    @Override
    public void lock() {
        this.status = LockStatus.LOCKED;
    }

    @Override
    public void unlock() {
        this.status = LockStatus.UNLOCKED;
    }

    @Override
    public boolean isLocked() {
        return this.status.equals(LockStatus.LOCKED);
    }

    @Override
    public boolean isUnlocked() {
        return this.status.equals(LockStatus.UNLOCKED);
    }

    protected enum LockStatus {
        LOCKED,
        UNLOCKED
    }
}
