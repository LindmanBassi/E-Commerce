package br.com.bassi.ecommerce.repositories;

import br.com.bassi.ecommerce.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
