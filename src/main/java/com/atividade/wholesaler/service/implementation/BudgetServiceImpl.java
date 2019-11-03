package com.atividade.wholesaler.service.implementation;

import com.atividade.wholesaler.domain.Budget;
import com.atividade.wholesaler.domain.OrderItem;
import com.atividade.wholesaler.service.BudgetService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BudgetServiceImpl implements BudgetService {

    private static List<Budget> budgetList;

    public BudgetServiceImpl() {
        budgetList = new ArrayList<>();
    }

    @Override
    public List<Budget> getList() {
        return budgetList;
    }

    @Override
    public Budget getById(String id) {
        Budget budget = budgetList.stream().filter(element -> element.getId().equals(id)).findAny().orElse(null);

        if(budget == null){
            throw new NoSuchElementException("Budget not found.");
        }

        return budget;
    }

    @Override
    public Budget create(List<OrderItem> orderItemList) {
        // Calculando valor do orçamento
        Double value = calculatePrice(orderItemList);

        // Calculando data de entrega
        Date deliveryDate = calculateDeliveryDate(value);

        // Criando novo orçamento
        Budget budget = new Budget(value, deliveryDate);

        // Adicionando à lista de orçamentos
        budgetList.add(budget);

        return budget;
    }

    private Double calculatePrice(List<OrderItem> orderItemList) {
        Double totalValue = 0d;

        for(OrderItem orderItem: orderItemList){
            totalValue += orderItem.getQuantity() * orderItem.getProduct().getValue();
        }

        return totalValue;
    }

    // O cálculo da data de entrega é baseado no valor do orçamento
    private Date calculateDeliveryDate(Double value){
        int daysUntilDelivery;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        if(value < 1000d){
            daysUntilDelivery = 3;
        }
        else if(value < 10000d){
            daysUntilDelivery = 7;
        }
        else if(value < 50000d){
            daysUntilDelivery = 14;
        }
        else {
            daysUntilDelivery = 30;
        }

        calendar.add(Calendar.DAY_OF_YEAR, daysUntilDelivery);
        return calendar.getTime();
    }
}
