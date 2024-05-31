package ru.AndreyMerkulov.Trader.Instrument;

public class InstrumentNotFoundException extends RuntimeException{
    public InstrumentNotFoundException(String message) {
        super(message);
    }
}
