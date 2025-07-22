package br.com.bassi.ecommerce.dto;

import br.com.bassi.ecommerce.domain.Order;
import br.com.bassi.ecommerce.domain.OrderItem;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderResponseDto(Long orderId,
                               BigDecimal total,
                               LocalDateTime orderDate,
                               UUID userId,
                               List<OrderItemResponseDto> items) {

    public static OrderResponseDto fromEntity(Order entity){

        return new OrderResponseDto(
                entity.getId(),
                entity.getTotal(),
                entity.getOrderDate(),
                entity.getUser().getId(),
                getItems(entity.getItem())
        );
    }

    private static List<OrderItemResponseDto> getItems(List<OrderItem> item) {

        return item.stream()
                .map(OrderItemResponseDto::fromEntity)
                .toList();
    }
}
