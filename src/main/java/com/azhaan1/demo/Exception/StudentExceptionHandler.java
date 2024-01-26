package com.azhaan1.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String ,String> handleException(MethodArgumentNotValidException ex){

        Map<String ,String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors() // it will find all the errors and display it t0 you
                .forEach(error -> errors.put(error.getField() ,error.getDefaultMessage()));

        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFountException.class)
    public Map<String ,String> studentNotFound(StudentNotFountException ex){

        Map<String ,String> error = new HashMap<>();

        error.put("error" ,ex.getMessage());
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(StudentAlreadyExistsException.class)
    public Map<String ,String> alreadyAStudent(StudentAlreadyExistsException ex){

        Map<String ,String> error = new HashMap<>();

        error.put("error" ,ex.getMessage());
        return error;
    }
}
