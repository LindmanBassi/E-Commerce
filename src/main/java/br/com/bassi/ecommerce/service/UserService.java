package br.com.bassi.ecommerce.service;

import br.com.bassi.ecommerce.domain.BillingAddress;
import br.com.bassi.ecommerce.domain.User;
import br.com.bassi.ecommerce.dto.UserDto;
import br.com.bassi.ecommerce.repositories.BillingAddressRepository;
import br.com.bassi.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public User createUser(UserDto dto){

        var billingAddress = new BillingAddress();
        billingAddress.setAddress(dto.address());
        billingAddress.setNumber(dto.number());
        billingAddress.setComplement(dto.complement());


           var user = new User();
           user.setFullName(dto.fullName());
           user.setBillingAddress(billingAddress);

        return userRepository.save(user);
    }

    public Optional<User> findById(UUID userId) {

        return userRepository.findById(userId);

    }

    public boolean deletedById(UUID userId) {

        var user = userRepository.findById(userId);

        if(user.isPresent()){
            userRepository.deleteById(userId);

        }

        return user.isPresent();
    }
}
