package com.jjaques.itauVaga99.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**Excessões de Formulários Nulos**/
//@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) se for necessário usar no futuro
public class FormNullException extends RuntimeException{
    //sem corpo como pede o desafio, mas pode ser adicionada mensagens customizadas
}
