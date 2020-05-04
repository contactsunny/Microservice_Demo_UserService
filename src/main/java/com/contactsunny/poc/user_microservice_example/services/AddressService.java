package com.contactsunny.poc.user_microservice_example.services;

import com.contactsunny.poc.user_microservice_example.dtos.Address;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class AddressService {

    @Value("${address.api.baseUrl}")
    private String addressServiceBaseUrl;

    @Autowired
    RestTemplate restTemplate;

    public List<Address> getAddressForUser(int userId) {
        String url = addressServiceBaseUrl + "/address/" + userId;
        String response = restTemplate.getForObject(url, String.class);
        Type addressListType = new TypeToken<ArrayList<Address>>(){}.getType();
        List<Address> addressList = new Gson().fromJson(response, addressListType);
        return addressList;
    }
}