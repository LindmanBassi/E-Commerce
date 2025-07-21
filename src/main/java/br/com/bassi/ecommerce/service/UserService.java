package br.com.bassi.ecommerce.service;

import br.com.bassi.ecommerce.domain.BillingAddress;
import br.com.bassi.ecommerce.repositories.BillingAddressRepository;
import br.com.bassi.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }
}
