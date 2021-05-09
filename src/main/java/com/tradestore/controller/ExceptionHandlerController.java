package com.tradestore.controller;

import com.tradestore.model.TradeStoreException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(TradeStoreException.class)
    public ResponseEntity<List<String>> handleCustomeException(TradeStoreException tradeStoreException) {
       return new ResponseEntity<List<String>>
               (Arrays.asList(tradeStoreException.getMessage())
                       , new HttpHeaders(),
                       HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleException(Exception tradeStoreException) {
        return new ArrayList<>();
    }
}
