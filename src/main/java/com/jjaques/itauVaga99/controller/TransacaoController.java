package com.jjaques.itauVaga99.controller;

import com.jjaques.itauVaga99.models.Transacao;
import com.jjaques.itauVaga99.repository.TransacaoRepository;
import com.jjaques.itauVaga99.service.TransacaoService;
import com.jjaques.itauVaga99.service.exceptions.FormNullException;
import com.jjaques.itauVaga99.service.validation.validacoesImpl.FormNullImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        try {

            //validar se esta nulo ou invalido
            new FormNullImpl().validar(transacao);
            transacaoService.salvarTransacao(transacao);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (FormNullException e) {

            return ResponseEntity.unprocessableEntity().build();

        }
    }

}
