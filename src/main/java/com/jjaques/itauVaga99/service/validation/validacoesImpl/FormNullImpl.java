package com.jjaques.itauVaga99.service.validation.validacoesImpl;

import com.jjaques.itauVaga99.models.Transacao;
import com.jjaques.itauVaga99.service.exceptions.FormNullException;
import com.jjaques.itauVaga99.service.validation.Validacao;


public class FormNullImpl implements Validacao {

    @Override
    public void validar(Transacao transacao){

        //Se os formulários estiverem nulos retorna status 422
        if (transacao.getValor() == null || transacao.getDataHora() == null){
            throw new FormNullException();
        }
    }

}
