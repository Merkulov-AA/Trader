package ru.AndreyMerkulov.Trader.GlobExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.AndreyMerkulov.Trader.Instrument.Exception.InstrumentFoundException;
import ru.AndreyMerkulov.Trader.Instrument.Exception.InstrumentNotFoundException;

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
