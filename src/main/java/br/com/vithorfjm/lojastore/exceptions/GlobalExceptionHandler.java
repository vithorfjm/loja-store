package br.com.vithorfjm.lojastore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> entityNotFound(EntityNotFoundException e) {
        ExceptionDTO err = new ExceptionDTO();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMesssage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

}
