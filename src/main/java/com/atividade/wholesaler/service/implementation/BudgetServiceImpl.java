package com.atividade.wholesaler.service.implementation;

import com.atividade.wholesaler.domain.Budget;
import com.atividade.wholesaler.domain.Order;
import com.atividade.wholesaler.domain.OrderItem;
import com.atividade.wholesaler.service.BudgetService;
import com.atividade.wholesaler.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private OrderService orderService;

    private static List<Budget> budgetList;

    private static final String ACCEPTANCE_PENDING = "Pendente";
    private static final String ACCEPTANCE_ACCEPTED = "Aceito";
    private static final String ACCEPTANCE_REJECTED = "Rejeitado";

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
    public Budget create(List<OrderItem> orderItemList, String orderId) {
        // Calculando valor do orçamento
        Double value = calculatePrice(orderItemList);

        // Calculando data de entrega
        Date deliveryDate = calculateDeliveryDate(value);

        // Criando novo orçamento
        Budget budget = new Budget(orderId, value, deliveryDate, ACCEPTANCE_PENDING);

        // Adicionando à lista de orçamentos
        budgetList.add(budget);

        return budget;
    }

    @Override
    public String updateAcceptance(String id, String acceptance) throws IOException, URISyntaxException {
        Budget budget = getById(id);

        if(acceptance.equals(ACCEPTANCE_REJECTED)){
            budget.setAcceptance(acceptance);
            return "Your purchase order was closed.";
        }
        else if(acceptance.equals(ACCEPTANCE_ACCEPTED)){
            budget.setAcceptance(acceptance);
            orderService.updateStatus(budget.getOrderId(), orderService.getStatus(2));
            return "Your purchase order was confirmed! The products you have requested are being produced and will be delivered in the due date.";
        }
        else {
            return "Invalid acceptance value.";
        }
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
