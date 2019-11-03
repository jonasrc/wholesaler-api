package com.atividade.wholesaler.rest.implementation;

import com.atividade.wholesaler.domain.Budget;
import com.atividade.wholesaler.domain.Order;
import com.atividade.wholesaler.rest.BudgetController;
import com.atividade.wholesaler.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/api/v1/")
public class BudgetControllerImpl implements BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Override
    public ResponseEntity<String> putBudgetAcceptance(String budgetId, String acceptance) throws IOException, URISyntaxException {
        String response = budgetService.updateAcceptance(budgetId, acceptance);
        return ResponseEntity.ok().body(response);
    }
}
