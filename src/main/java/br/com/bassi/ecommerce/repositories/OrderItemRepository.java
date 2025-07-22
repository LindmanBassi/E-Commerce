package br.com.bassi.ecommerce.repositories;

import br.com.bassi.ecommerce.domain.OrderItem;
import br.com.bassi.ecommerce.domain.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
}
