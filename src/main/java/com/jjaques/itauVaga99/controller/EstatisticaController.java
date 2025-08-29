package com.jjaques.itauVaga99.controller;

import com.jjaques.itauVaga99.models.dto.EstatisticaResponse;
import com.jjaques.itauVaga99.service.EstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatistica")
@Tag(name = "Estatísticas", description = "Rotas para lidar com estatísticas de Transações")
public class EstatisticaController {

    @Autowired
    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService){
        this.estatisticaService = estatisticaService;
    }


    @GetMapping
    @Operation(summary = "Gerar Estatísticas", description = "Rota para gerar estatísticas de transações")
    public EstatisticaResponse estatisticas(){
        return estatisticaService.estatisticasTransacoes();
    }
}
