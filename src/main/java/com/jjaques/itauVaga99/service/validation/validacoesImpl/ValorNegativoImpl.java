package com.jjaques.itauVaga99.service.validation.validacoesImpl;

import com.jjaques.itauVaga99.exceptions.ValorNegativosException;
import com.jjaques.itauVaga99.models.Transacao;
import com.jjaques.itauVaga99.service.validation.Validacao;
import org.springframework.stereotype.Component;

@Component
public class ValorNegativoImpl implements Validacao {

    @Override
    public void validar(Transacao transacao){

        // Se o formulário tiver transações com valores negativos, lança a excessão
        if (transacao.getValor() < 0){
            throw new ValorNegativosException();
        }
    }
}
