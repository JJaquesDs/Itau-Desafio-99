package com.jjaques.itauVaga99.controller;

import com.jjaques.itauVaga99.models.Transacao;
import com.jjaques.itauVaga99.repository.TransacaoRepository;
import com.jjaques.itauVaga99.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController()
@RequestMapping("transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;

    public TransacaoController(TransacaoService transacaoService,
                               TransacaoRepository transacaoRepository){
        this.transacaoService = transacaoService;
        this.transacaoRepository = transacaoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> criarTransacao(@RequestBody Transacao transacao){
        Transacao transacaoSalva = transacaoService.salvarTransacao(transacao);

        return ResponseEntity.created(URI.create("/transacao")).build();
    }
}
