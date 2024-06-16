package ru.andreymerkulov.trader.instrument.exception;

public class InstrumentNotFoundException extends RuntimeException{
    public InstrumentNotFoundException(String message) {
        super(message);
    }
}
