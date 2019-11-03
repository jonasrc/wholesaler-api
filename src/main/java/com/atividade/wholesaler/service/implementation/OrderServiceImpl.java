package com.atividade.wholesaler.service.implementation;

import com.atividade.wholesaler.domain.Budget;
import com.atividade.wholesaler.domain.Order;
import com.atividade.wholesaler.domain.OrderItem;
import com.atividade.wholesaler.domain.Product;
import com.atividade.wholesaler.service.BudgetService;
import com.atividade.wholesaler.service.OrderService;
import com.atividade.wholesaler.service.ProductService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {

    private List<Order> orderList = new ArrayList<>();

    // Status possíveis para um pedido
    private static final String STATUS_PENDING = "Solicitado";
    private static final String STATUS_PRODUCING = "Em fabricação";
    private static final String STATUS_PRODUCED = "Finalizado";
    private static final String STATUS_SENT = "Despachado";

    @Autowired
    private ProductService productService;

    @Autowired
    private BudgetService budgetService;

    @Override
    public String create(String retailerApiData) {
        // Recuperar lista de itens de pedido (com produto e quantidade) dos dados enviados da API do lojista
        List<OrderItem> orderItemList = processRetailerApiData(retailerApiData);

        // Criação do pedido na API do atacadista
        Order order = new Order(STATUS_PENDING, orderItemList);

        // Adição do pedido à lista de pedidos salvos na API
        this.orderList.add(order);

        // Criando orçamento baseado no pedido já criado
        Budget budget = budgetService.create(orderItemList);

        JSONObject response = new JSONObject();
        response.put("orderId", order.getId());
        response.put("orderStatus", order.getStatus());
        response.put("budgetValue", budget.getValue());
        response.put("deliveryDate", budget.getDeliveryDate());

        // Criação do pedido na API do atacadista
        return response.toString();
    }

    @Override
    public List<Order> getList() {
        return this.orderList;
    }

    @Override
    public Order getById(String id) {
        Order order = orderList.stream().filter(element -> element.getId().equals(id)).findAny().orElse(null);

        if(order == null){
            throw new NoSuchElementException("Order not found.");
        }

        return order;
    }

    private List<OrderItem> processRetailerApiData(String data) {
        List<OrderItem> orderItemList = new ArrayList<>();
        Product product;
        Long productQuantity;
        String notes;

        JSONArray jsonArrayData = new JSONArray(data);
        for(int i = 0; i < jsonArrayData.length(); i++){
            // Recuperando produto a partir do código
            product = productService.getByCode(jsonArrayData.getJSONObject(i).getLong("productCode"));

            // Recuperando quantidade do produto identificado pelo código
            productQuantity = jsonArrayData.getJSONObject(i).getLong("productQuantity");

            // Recuperando notas adicionais
            notes = jsonArrayData.getJSONObject(i).getString("notes");

            // Adição do item aos demais itens do pedido
            orderItemList.add(new OrderItem(product, productQuantity, notes));
        }

        return orderItemList;
    }
}
