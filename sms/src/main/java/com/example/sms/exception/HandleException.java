package com.example.sms.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {
    // @ExceptionHandler(NoSuchElementException.class)
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // public Map<String, String>
    // handleNoSuchElementException(NoSuchElementException e) {
    // var map = new HashMap<String, String>();
    // map.put("title", "Not Found");
    // map.put("detail", e.getMessage());
    // map.put("timestamp", LocalDateTime.now().toString());
    // return map;
    // }

    // @ExceptionHandler(StudentNotFoundException.class)
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // public Map<String, String>
    // handleNoSuchElementException(StudentNotFoundException e) {
    // var map = new HashMap<String, String>();
    // map.put("title", "Not Found");
    // map.put("detail", e.getMessage());
    // map.put("timestamp", LocalDateTime.now().toString());
    // return map;
    // }

    @ExceptionHandler(StudentNotFoundException.class)
    public ProblemDetail handleNoSuchElementException(StudentNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());

        problemDetail.setTitle("Not Found");
        problemDetail.setProperty("timestamp", LocalDateTime.now());

        return problemDetail;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ProblemDetail handleRequestNotSpportedException(HttpRequestMethodNotSupportedException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.METHOD_NOT_ALLOWED, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handler(MethodArgumentNotValidException e) {
        var details = new StringJoiner(", ");
        e.getAllErrors().forEach(error -> {
            var errorMessage = error.getDefaultMessage();
            var fieldName = ((FieldError) error).getField();
            details.add(fieldName + " : " + errorMessage);
        });

        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, details.toString());
        problemDetail.setTitle("invalid Data");
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handlException(Exception e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
