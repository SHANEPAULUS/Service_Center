package com.shane.servicecenter.services;

import com.shane.servicecenter.App;
import com.shane.servicecenter.conf.factory.VehicleFactory;
import com.shane.servicecenter.domain.Client;
import com.shane.servicecenter.domain.ContactDetails;
import com.shane.servicecenter.domain.Vehicle;
import com.shane.servicecenter.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/05/27.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ClientServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ClientService service;

    @Autowired
    private ClientRepository repository;

//    @Test
    public void create() throws Exception {
        //Using the service instead of repository to add a client..
        Client client=new Client
                .Builder("Pedro")
                .firstName("Auldrin")
                .age(21)
                .build();

        Client newClient=service.addClient(client);
        Assert.assertNotNull(newClient.getId());
    }

//    @Test
    public void update() throws Exception {
        //Creating contact details for the client
        ContactDetails address=new ContactDetails
                .Builder("0611092344")
                .address("3 Madeliefie Road, Hopetown")
                //.email("jhonnyp@gmail.com")
                .build();

        Client client=repository.findOne(2L);
        Client newClient=new Client
                .Builder(client.getLastName())
                .copy(client)
                .address(address)
                .firstName("Tony")
                .build();

        service.updateClient(newClient);
        Client cl=repository.findOne(2L);
        Assert.assertEquals(cl.getFirstName(),"Tony");
    }

//    @Test
    public void testGetVehicles() throws Exception {
        Client client=service.getClient(1L);
        List<Vehicle> cars=service.getVehicles(client.getId());
        Assert.assertEquals(cars.get(0).getReg(), "2015 BMW M3");
    }

//    @Test
    public void testDelete() throws Exception {
        Client client=service.getClient(1L);
        service.removeClient(client);
        Client deletedClient=service.getClient(1L);
        Assert.assertNull(deletedClient);
    }
}
