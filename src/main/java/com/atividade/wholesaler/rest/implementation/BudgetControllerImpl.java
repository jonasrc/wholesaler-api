package com.atividade.wholesaler.rest.implementation;

import com.atividade.wholesaler.rest.BudgetController;
import com.atividade.wholesaler.service.BudgetService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
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
    @PutMapping("/budget")
    public ResponseEntity<String> putBudgetAcceptance(String data) throws IOException, URISyntaxException {
        JSONObject jsonData = new JSONObject(data);
        String response = budgetService.updateAcceptance(jsonData.getString("budgetId"), jsonData.getString("acceptance"));
        return ResponseEntity.ok().body(response);
    }
}
