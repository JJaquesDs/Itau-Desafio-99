package com.jjaques.itauVaga99.service;

import com.jjaques.itauVaga99.models.Transacao;
import com.jjaques.itauVaga99.models.dto.EstatisticaResponse;
import com.jjaques.itauVaga99.repository.repositoryImpl.TransacaoRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.Clock;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EstatisticaServiceTest {


    @Mock
    private TransacaoRepositoryImpl transacaoRepository;

    @InjectMocks
    private EstatisticaService estatisticaService;

    @Mock
    private Clock clock;


    @BeforeEach
    void setup(){
        Instant instantFixo = Instant.parse("2025-08-19T12:00:00Z");  // 19/08/2025 ao meio-dia
        ZoneId zona = ZoneId.systemDefault();  //zona padrão do sistema

        //Mock de horários fixos para não ter erros nos testes
        Mockito.when(clock.instant()).thenReturn(instantFixo);
        Mockito.when(clock.getZone()).thenReturn(zona);
    }


    @Test
    void contarApenasEstatisticasNos60s() {

        // Cenário para teste

        OffsetDateTime horaTeste = OffsetDateTime.now(clock);  //pega o horário do mock

        List<Transacao> transacoesTest = new ArrayList<>();

        // dentro do range de 60seg
        transacoesTest.add(new Transacao(120.00, horaTeste));
        transacoesTest.add(new Transacao(100.00, horaTeste.minusSeconds(1)));
        transacoesTest.add(new Transacao(150.00, horaTeste.minusSeconds(3)));

        //fora do range de 60seg
        transacoesTest.add(new Transacao(100.00, horaTeste.minusSeconds(61)));
        transacoesTest.add(new Transacao(200.00, horaTeste.minusSeconds(62)));

        Mockito.when(this.transacaoRepository.getTransacoes()).thenReturn(transacoesTest);


        // Ação a testar
        EstatisticaResponse estatisticas = estatisticaService.estatisticasTransacoes();


        // Afirmar o teste (apenas dentro do range de 60seg)
        assertEquals(3, estatisticas.count());  //qtd de transações
        assertEquals(370, estatisticas.sum());  // soma
        assertEquals((double) 370 / 3, estatisticas.avg());  // média
        assertEquals(100, estatisticas.min());  //minimo
        assertEquals(150, estatisticas.max());
    }


    @Test
    void retornarZeroQuandoNaoHaNosUltimos60s(){

        // cenário de teste
        Mockito.when(transacaoRepository.getTransacoes()).thenReturn(new ArrayList<>());  //Array vazio

        // Ação a testar
        EstatisticaResponse estatisticaTeste = estatisticaService.estatisticasTransacoes();

        assertEquals(0, estatisticaTeste.count());
        assertEquals(0.0, estatisticaTeste.sum());
        assertEquals(0.0, estatisticaTeste.avg());
        assertEquals(0.0, estatisticaTeste.min());
        assertEquals(0.0, estatisticaTeste.max());

    }
}