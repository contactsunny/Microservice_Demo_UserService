package com.contactsunny.poc.user_microservice_example.services;

import com.contactsunny.poc.user_microservice_example.dtos.Address;
import com.contactsunny.poc.user_microservice_example.dtos.AddressList;
import com.contactsunny.poc.user_microservice_example.dtos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private AddressService addressService;

    public User getUserById(int userId) {
        User user = new User();
        user.setId(userId);
        user.setName("Sunny Srinidhi");
        user.setEmail("contactsunny@email.com");

        List<Address> addressList = addressService.getAddressForUser(userId);
        user.setAddresses(addressList);

        return user;
    }
}
