package br.com.bassi.ecommerce.dto;

public record OrderItemDto(Integer quantity,
                           Long productId) {
}
