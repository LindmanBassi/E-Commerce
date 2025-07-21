package br.com.bassi.ecommerce.repositories;

import br.com.bassi.ecommerce.domain.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAddressRepository extends JpaRepository<BillingAddress,Long> {
}
