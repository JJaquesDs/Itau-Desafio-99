package com.jjaques.itauVaga99.service;

import com.jjaques.itauVaga99.models.Transacao;
import com.jjaques.itauVaga99.models.dto.EstatisticaResponse;
import com.jjaques.itauVaga99.repository.repositoryImpl.TransacaoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {

    @Autowired
    private final TransacaoRepositoryImpl transacaoRepository;

    public EstatisticaService(TransacaoRepositoryImpl transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public EstatisticaResponse estatisticasTransacoes(){

        /*
         subtrai a hora atual de 60s e depois usa o tempo após esse range, obtendo os exatos últimos 60seg
         utiliza-se stream() para controlar o fluxo da lista e filtra ela com o lambda descrito
        */
        OffsetDateTime range60Seg = OffsetDateTime.now().minusSeconds(60);
        List<Transacao> transacoes60Seg = transacaoRepository.getTransacoes().stream().filter(
                transacao -> transacao.getDataHora().isAfter(range60Seg)
        ).toList();

        DoubleSummaryStatistics estatisticas = transacoes60Seg.stream()
                .mapToDouble(Transacao::getValor).summaryStatistics();


        return new EstatisticaResponse(
                estatisticas.getCount(),
                estatisticas.getSum(),
                estatisticas.getAverage(),
                estatisticas.getMin(),
                estatisticas.getMax()
        );
    }
}
