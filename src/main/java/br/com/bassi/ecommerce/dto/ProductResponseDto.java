package br.com.bassi.ecommerce.dto;

import br.com.bassi.ecommerce.domain.Product;
import br.com.bassi.ecommerce.domain.Tag;
import java.util.List;

public record ProductResponseDto(Long productId,
                                 String productName,
                                 List<TagResponseDto> tags) {

    public static ProductResponseDto fromEntity(Product product) {

        return new ProductResponseDto(
                product.getProductId(),
                product.getProductName(),
                getTags(product.getTags())
        );
    }

    private static List<TagResponseDto> getTags(List<Tag> tags) {

        return tags.stream()
                .map(TagResponseDto::fromEntity)
                .toList();
    }
}
