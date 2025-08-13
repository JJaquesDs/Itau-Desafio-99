package com.jjaques.itauVaga99.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Exception de transações negativas **/
//@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ValorNegativosException extends RuntimeException{
    // sem corpo como pede o desafio, mas pode ser adicionada mensagens customizadas

    //mesmo sendo uma classe vazia até o momento, ela deve existir para ser usada com @ExceptionHandler
}
