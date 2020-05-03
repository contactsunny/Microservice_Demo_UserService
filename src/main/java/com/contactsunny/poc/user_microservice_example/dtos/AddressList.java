package com.contactsunny.poc.user_microservice_example.dtos;

import java.util.List;

public class AddressList {

    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
