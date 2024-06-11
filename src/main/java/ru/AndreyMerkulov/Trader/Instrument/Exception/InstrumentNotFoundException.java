package ru.AndreyMerkulov.Trader.Instrument.Exception;

public class InstrumentNotFoundException extends RuntimeException{
    public InstrumentNotFoundException(String message) {
        super(message);
    }
}
