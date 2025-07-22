package br.com.bassi.ecommerce.dto;

public record PaginationResponseDto(Integer page,
                                    Integer pageSize,
                                    Long totalElements,
                                    Integer totalPages) {
}
