package com.jjaques.itauVaga99.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Exception para transações que acontecem em um tempo futuro
 * <p> Devem ocorrer no presente ou em qualquer momento do passado </p>**/

//@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class TempoFuturoException extends RuntimeException{
}
