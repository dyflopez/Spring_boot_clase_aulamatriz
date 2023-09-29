package com.app.aulamatriz.micro.usuarios.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ControlarExcepciones {

    /**
     * Excecion global o de ejecucion , no controlada
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> manejarExcepcion(Exception ex){
        log.error("error del sistema"  + ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("error del sistema"  + ex.getMessage());
    }
    //Exception de Valid (DTO)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> excepcionDeValidDto(MethodArgumentNotValidException ex){
        List<String> errors = new ArrayList<>();
        for(FieldError error :ex.getBindingResult().getFieldErrors() ){
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        log.error("Error del sistema Error validando DTO error info {}",
                errors);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    /**
     * Excepciones personalizadas
     */
    @ExceptionHandler(MyException.class)
    public ResponseEntity<Object> miExcepcionPersonalizada(MyException exception){
        log.error("error perzonalisado" + exception.getMessage() ,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("error perzonalisado" + exception.getMessage() ,
                HttpStatus.BAD_REQUEST
        );
    }
}
