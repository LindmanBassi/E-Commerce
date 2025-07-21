package br.com.bassi.ecommerce.repositories;

import br.com.bassi.ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
