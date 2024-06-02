package ru.AndreyMerkulov.Trader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.AndreyMerkulov.Trader.Instrument.InstrumentFoundException;
import ru.AndreyMerkulov.Trader.Instrument.InstrumentNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InstrumentNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(InstrumentNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InstrumentFoundException.class)
    public ResponseEntity<String> handleException(InstrumentFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FOUND);
    }
}
