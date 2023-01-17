package ru.myitschool.lab23.controller.producer;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

import ru.myitschool.lab23.controller.locker.ILocker;
import ru.myitschool.lab23.model.NoHandlerException;
import ru.myitschool.lab23.model.LengthType;
import ru.myitschool.lab23.controller.consumer.Handler;

public class ProducerService implements IProducer {
    private final List<Handler> handlers;
    private final ILocker lock;

    public ProducerService(List<Handler> handlers, ILocker lock) {
        this.handlers = handlers;
        this.lock = lock;
    }

    @Override
    public void sendUpdateRequest(LengthType typeFrom, double valueInCustomLength) throws NoHandlerException {
        double valueInBaseLength = handlers.stream()
                .filter(handler -> handler.getType().equals(typeFrom))
                .findFirst()
                .orElseThrow(NoHandlerException::new)
                .convertToBase(valueInCustomLength);
        lock.lock();
        handlers.forEach(handler -> {
            if (handler.getType() != typeFrom) {
                handler.consume(valueInBaseLength);
            }
        });
        lock.unlock();
    }

    @Override
    public void sendUpdateRequest(String text) {
        lock.lock();
        handlers.forEach(handler -> handler.consume(text));
        lock.unlock();
    }

    @NonNull
    @Override
    public String toString() {
        return "ProducerService{" +
                "handlers=" + Arrays.toString(handlers.toArray()) +
                '}';
    }
}
