package dev.vf.tickerservice.web;

import dev.vf.tickerservice.domain.TickerAlreadyExistsException;
import dev.vf.tickerservice.domain.TickerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// mark class as a centralized exception handler to decouple from business logic
// define what happens the moment the exceptions are thrown
@RestControllerAdvice
public class TickerControllerAdvice {

    @ExceptionHandler(TickerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public String tickerAlreadyExistsHandler(TickerAlreadyExistsException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(TickerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String tickerNotFoundHandler(TickerNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exception) {
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
