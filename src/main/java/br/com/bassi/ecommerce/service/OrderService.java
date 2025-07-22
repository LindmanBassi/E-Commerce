package br.com.bassi.ecommerce.service;

import br.com.bassi.ecommerce.domain.*;
import br.com.bassi.ecommerce.dto.OrderDto;
import br.com.bassi.ecommerce.dto.OrderItemDto;
import br.com.bassi.ecommerce.exception.OrderException;
import br.com.bassi.ecommerce.repositories.OrderItemRepository;
import br.com.bassi.ecommerce.repositories.OrderRepository;
import br.com.bassi.ecommerce.repositories.ProductRepository;
import br.com.bassi.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;


    public OrderService(UserRepository userRepository, OrderRepository orderRepository, ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    public Order createOrder(OrderDto dto){

        var order = new Order();
        //1-validate user
        var user = validateUser(dto);

        //2-validate order item
        var orderItems = validadeOrderItems(order, dto);

        //3-calculate order total
        var total = calculateOrderTotal(orderItems);

        //4-map to entity
        order.setOrderDate(LocalDateTime.now());
        order.setUser(user);
        order.setItem(orderItems);
        order.setTotal(total);

        //5-repository save
        return orderRepository.save(order);

    }



    private User validateUser(OrderDto dto){

        return userRepository.findById(dto.userId())
                .orElseThrow(()-> new OrderException("user not found"));
    }

    private List<OrderItem> validadeOrderItems(Order order,
                                               OrderDto dto){

        if(dto.itens().isEmpty()){
            throw new OrderException("order itens is empty");
        }

        return dto.itens()
                .stream().map(orderItemDto -> getOrderItem(order, orderItemDto)).toList();
    }

    private OrderItem getOrderItem(Order order,
                                   OrderItemDto orderItemDto) {

        var orderItem = new OrderItem();
        var id = new OrderItemId();
        var product = getProduct(orderItemDto.productId());

        id.setOrder(order);
        id.setProduct(product);

        orderItem.setOrderItemId(id);
        orderItem.setQuantity(orderItemDto.quantity());
        orderItem.setSalePrice(product.getPrice());

        return orderItem;
    }

    private Product getProduct(Long productId){
        return productRepository.findById(productId)
                .orElseThrow(()-> new OrderException("product not found"));
    }

    private BigDecimal calculateOrderTotal(List<OrderItem> items) {

        return items.stream()
                .map(i -> i.getSalePrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
