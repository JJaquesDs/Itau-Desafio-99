package com.jjaques.itauVaga99.service.validation.validacoesImpl;

import com.jjaques.itauVaga99.exceptions.TempoFuturoException;
import com.jjaques.itauVaga99.models.Transacao;
import com.jjaques.itauVaga99.service.validation.Validacao;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class TempoFuturoImpl implements Validacao {


    @Override
    public void validar(Transacao transacao){

        if (transacao.getDataHora().isAfter(OffsetDateTime.now())){
            throw new TempoFuturoException();
        }
    }
}
