package com.atividade.wholesaler.rest;

import com.atividade.wholesaler.domain.Order;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.net.URISyntaxException;

public interface BudgetController {
    @ApiOperation(value = "Aceitar ou rejeitar proposta de orçamento")
    public ResponseEntity<String> putBudgetAcceptance(
            @ApiParam(value = "JSON enviado da API de lojista (retailer)", required = true)
            @RequestBody String data) throws IOException, URISyntaxException;
}
