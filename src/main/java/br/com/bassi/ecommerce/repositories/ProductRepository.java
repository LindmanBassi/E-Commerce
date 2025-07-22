package br.com.bassi.ecommerce.repositories;

import br.com.bassi.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
