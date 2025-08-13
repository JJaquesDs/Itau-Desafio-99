package com.jjaques.itauVaga99.models.dto;


/** Como Estatísticas é apenas uma resposta de métricas sobre transações, achei que fazia sentido fazê-la como um Data Object Transfer**/
public record EstatisticaResponse(Long count, Double sum, Double avg, Double min, Double max) {
}
