package ru.andrey_merkulov.trader.instrument.Exception;

public class InstrumentNotFoundException extends RuntimeException{
    public InstrumentNotFoundException(String message) {
        super(message);
    }
}
