package br.com.bassi.ecommerce.dto;

import java.util.List;
import java.util.UUID;

public record OrderDto(UUID userId,
                       List<OrderItemDto> itens) {
}
