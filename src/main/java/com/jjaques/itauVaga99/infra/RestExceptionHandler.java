package com.jjaques.itauVaga99.infra;

import com.jjaques.itauVaga99.exceptions.FormNullException;
import com.jjaques.itauVaga99.exceptions.ValorNegativosException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/** Anotação para manipular Exceptions**/
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // Manipulando Exception de transações negativas
    @ExceptionHandler(ValorNegativosException.class)
    private ResponseEntity<HttpStatus> valorNegativoException(ValorNegativosException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

    // Exception de fomulário nulo
    @ExceptionHandler(FormNullException.class)
    private ResponseEntity<HttpStatus> formNullException(FormNullException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
}
