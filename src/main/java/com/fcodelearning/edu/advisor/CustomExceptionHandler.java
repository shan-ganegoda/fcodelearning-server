package com.fcodelearning.edu.advisor;

import com.fcodelearning.edu.dto.StandardResponse;
import com.fcodelearning.edu.exception.ResourceAlreadyExistException;
import com.fcodelearning.edu.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(ResourceNotFoundException ex){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error",ex), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<StandardResponse> handleAlreadyExistException(ResourceAlreadyExistException ex){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error",ex), HttpStatus.FOUND
        );
    }
}
