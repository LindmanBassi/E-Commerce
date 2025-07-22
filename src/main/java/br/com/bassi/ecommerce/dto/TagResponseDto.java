package br.com.bassi.ecommerce.dto;

import br.com.bassi.ecommerce.domain.Tag;

public record TagResponseDto(Long tagId,
                             String name) {

    public static TagResponseDto fromEntity(Tag entity) {

        return new TagResponseDto(
                entity.getId(),
                entity.getName()
        );
    }
}
