package com.jjaques.itauVaga99.repository.repositoryImpl;

import com.jjaques.itauVaga99.models.Transacao;
import com.jjaques.itauVaga99.repository.TransacaoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepositoryImpl implements TransacaoRepository {


    private final List<Transacao> transacoes = new ArrayList<>();

    @Override
    public void salvar(Transacao transacao){
        transacoes.add(transacao);
    }

    @Override
    public List<Transacao> buscarTodas(){
        return new ArrayList<>(transacoes);
    }

    @Override
    public void deletar(){
        transacoes.clear();
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
