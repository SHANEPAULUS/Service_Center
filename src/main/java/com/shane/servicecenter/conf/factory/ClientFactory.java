package com.shane.servicecenter.conf.factory;

import com.shane.servicecenter.domain.Client;
import com.shane.servicecenter.domain.ContactDetails;
import com.shane.servicecenter.domain.Vehicle;


import java.util.List;
import java.util.Map;

/**
 * Created by SHANE on 2015/05/04.
 */
public class ClientFactory {
    public static Client createClient(Map<String,String> values,int age
                                      ,ContactDetails address,List<Vehicle> cars)
    {
        Client client=new Client
                .Builder(values.get("lastName"))
                .firstName(values.get("firstName"))
                .address(address)
                .vehicle(cars)
                .age(age)
                .build();
        return client;
    }
}
