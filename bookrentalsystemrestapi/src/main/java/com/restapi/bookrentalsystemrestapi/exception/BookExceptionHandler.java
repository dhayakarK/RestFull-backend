package com.restapi.bookrentalsystemrestapi.exception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class BookExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler()
    public ResponseEntity<Object> duplicateException(BookDetailsRequired bookdetails)
    {
       ResponseMsg responseMsg=new ResponseMsg();
       responseMsg.setStatuscode(HttpStatus.CONFLICT.value());
       responseMsg.setMessage(bookdetails.getMessage());
       return new ResponseEntity<Object>(responseMsg,HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details=new ArrayList<>();
        for (ObjectError error:ex.getBindingResult().getAllErrors()) {
           details.add(error.getDefaultMessage());

        }
        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setStatuscode(400);
        responseMsg.setMessage("input validation failed please check inputs");
        return new ResponseEntity<>(responseMsg,HttpStatus.BAD_REQUEST);
    }
}
