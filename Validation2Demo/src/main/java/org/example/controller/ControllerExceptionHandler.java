package org.example.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.example.entity.Result;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<Result> handlerValidationException(MethodArgumentNotValidException exception) {

        List<Result> result = new ArrayList<Result>();

        BindingResult bindingResult = exception.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            System.out.println(fieldError.getDefaultMessage());
            result.add(new Result(1, fieldError.getDefaultMessage()));
        }

        return result;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result handlerException(MethodArgumentTypeMismatchException exception) {


        return new Result(1, exception.getMessage());

    }
}
