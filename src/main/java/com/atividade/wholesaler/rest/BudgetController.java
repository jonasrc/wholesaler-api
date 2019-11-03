package com.atividade.wholesaler.rest;

import com.atividade.wholesaler.domain.Order;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URISyntaxException;

public interface BudgetController {
    @ApiOperation(value = "Aceitar ou rejeitar proposta de orçamento")
    public ResponseEntity<String> putBudgetAcceptance(String budgetId, String acceptance) throws IOException, URISyntaxException;
}
