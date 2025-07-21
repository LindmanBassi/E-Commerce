package br.com.bassi.ecommerce.service;


import br.com.bassi.ecommerce.domain.BillingAddress;
import br.com.bassi.ecommerce.domain.User;
import br.com.bassi.ecommerce.dto.UserDto;
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

    public User createUser(UserDto dto){

        var billingAddress = new BillingAddress();
        billingAddress.setAddress(dto.address());
        billingAddress.setNumber(dto.number());
        billingAddress.setComplement(dto.complement());

       var savedBillingAddress = billingAddressRepository.save(billingAddress);
       var user = new User();
       user.setFullName(dto.fullName());
       user.setBillingAddress(savedBillingAddress);

        return userRepository.save(user);
    }
}
