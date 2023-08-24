package br.com.vithorfjm.lojastore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> entityNotFound(EntityNotFoundException e) {
        ExceptionDTO err = new ExceptionDTO();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMesssage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionDTO> argumentTypeMismatch(MethodArgumentTypeMismatchException e) {
        ExceptionDTO err = new ExceptionDTO();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMesssage("Invalid argument");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
