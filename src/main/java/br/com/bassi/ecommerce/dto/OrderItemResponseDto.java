package br.com.bassi.ecommerce.dto;

import br.com.bassi.ecommerce.domain.OrderItem;
import java.math.BigDecimal;

public record OrderItemResponseDto(BigDecimal salePrice,
                                   Integer quantity,
                                   ProductResponseDto productResponseDto) {

    public static OrderItemResponseDto fromEntity(OrderItem entity) {

        return new OrderItemResponseDto(
                entity.getSalePrice(),
                entity.getQuantity(),
                ProductResponseDto.fromEntity(entity.getOrderItemId().getProduct())
        );
    }
}
