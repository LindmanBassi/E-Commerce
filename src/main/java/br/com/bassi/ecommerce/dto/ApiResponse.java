package br.com.bassi.ecommerce.dto;

import java.util.List;

public record ApiResponse<T>(List<T> data,
                             PaginationResponseDto pagination) {
}
