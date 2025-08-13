package com.jjaques.itauVaga99.controller;

import com.jjaques.itauVaga99.models.dto.EstatisticaResponse;
import com.jjaques.itauVaga99.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatistica")
public class EstatisticaController {

    @Autowired
    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService){
        this.estatisticaService = estatisticaService;
    }


    @GetMapping
    public EstatisticaResponse estatisticas(){
        return estatisticaService.estatisticasTransacoes();
    }
}
