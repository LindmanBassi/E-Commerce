package br.com.bassi.ecommerce.repositories;

import br.com.bassi.ecommerce.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
