package ru.andreymerkulov.trader.glob.exceptionhandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.andreymerkulov.trader.instrument.exception.InstrumentFoundException;
import ru.andreymerkulov.trader.instrument.exception.InstrumentNotFoundException;

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
