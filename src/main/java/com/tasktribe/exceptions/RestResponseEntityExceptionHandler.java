package com.tasktribe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tasktribe.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ErrorMessage> JobNotFoundException(JobNotFoundException ex, WebRequest request) {
     ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);     
    }

}
