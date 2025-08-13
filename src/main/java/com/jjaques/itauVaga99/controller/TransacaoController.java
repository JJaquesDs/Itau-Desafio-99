package com.jjaques.itauVaga99.controller;

import com.jjaques.itauVaga99.models.Transacao;
import com.jjaques.itauVaga99.repository.TransacaoRepository;
import com.jjaques.itauVaga99.service.TransacaoService;
import com.jjaques.itauVaga99.service.validation.Validacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;
    private final List<Validacao> validacoes;

    public TransacaoController(TransacaoService transacaoService,
                               TransacaoRepository transacaoRepository,
                               List<Validacao> validacoes){
        this.transacaoService = transacaoService;
        this.transacaoRepository = transacaoRepository;
        this.validacoes = validacoes;
    }

    @PostMapping
    public ResponseEntity<Void> criarTransacao(@RequestBody Transacao transacao){

        // Itera sobre a lista de validações e se for o caso persistir a transação no db
        validacoes.forEach(validacao -> validacao.validar(transacao));
        transacaoService.salvarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTransacoes(){
        transacaoService.deletarTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
