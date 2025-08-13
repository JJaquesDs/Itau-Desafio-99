package com.jjaques.itauVaga99.repository;

import com.jjaques.itauVaga99.models.Transacao;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TransacaoRepository {

    public void salvar(Transacao transacao);

    public List<Transacao> buscarTodas();

    public void deletar();
}
