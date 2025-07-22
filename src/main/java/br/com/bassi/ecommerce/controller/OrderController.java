package br.com.bassi.ecommerce.controller;

import br.com.bassi.ecommerce.dto.OrderDto;
import br.com.bassi.ecommerce.service.OrderService;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto dto){

       var order = orderService.createOrder(dto);

       return ResponseEntity.created(URI.create("/orders/" + order.getId())).build();

    }
}
