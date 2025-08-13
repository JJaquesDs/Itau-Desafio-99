package com.jjaques.itauVaga99.service;

import com.jjaques.itauVaga99.models.Transacao;
import com.jjaques.itauVaga99.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }


    //Serviço de salvar transação
    public Transacao salvarTransacao(Transacao transacao){
        transacaoRepository.salvar(new Transacao(transacao.getValor(), transacao.getDataHora()));
        return transacao;
    }


}
