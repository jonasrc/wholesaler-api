package com.atividade.wholesaler.rest;

import com.atividade.wholesaler.domain.Order;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface OrderController {
    @ApiOperation(value = "Health check")
    public ResponseEntity<String> isAlive();

    @ApiOperation(value = "Criar novo pedido de produtos")
    public ResponseEntity<Order> create(
            @ApiParam(value = "Dados enviados a partir da API do lojista", required = true)
            @RequestBody String data);

    @ApiOperation(value = "Listar pedidos rastreados na API do lojista")
    public ResponseEntity<List<Order>> getList();
}
