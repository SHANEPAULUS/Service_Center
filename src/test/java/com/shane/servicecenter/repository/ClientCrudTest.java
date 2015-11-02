package com.shane.servicecenter.repository;

import com.shane.servicecenter.App;
import com.shane.servicecenter.domain.Client;
import com.shane.servicecenter.domain.ContactDetails;
import com.shane.servicecenter.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by SHANE on 2015/05/05.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ClientCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    private ClientRepository clientRepository;

//    @Test
    public void create() throws Exception {
        //Creating contact details for the client
        ContactDetails address=new ContactDetails
                .Builder("0611092344")
                .address("23 Main Road, Centurion")
                //.email("juncloete@gmail.com")
                .build();
        //Creating vehicle(s) for this client..
        Vehicle BMW=new Vehicle
                .Builder("BWP 345 NC")
                .model("2015 BMW M3")
                .build();

        List<Vehicle> carList=new ArrayList<>();
        carList.add(BMW);

        Client client=new Client
                .Builder("Cloete")
                .firstName("Junior")
                .age(21)
                .vehicle(carList)
                .address(address)
                .build();

        clientRepository.save(client);
        id=client.getId();
        Assert.assertNotNull(id);
    }


//    @Test
    public void read() throws Exception {
        Client client= clientRepository.findOne(id);
        Assert.assertNotNull(client);
    }

//    @Test
    public void update() throws Exception {

        Client client= clientRepository.findOne(id);
        Client newClient= new Client
                .Builder(client.getLastName())
              //  .copy(client)
                .id(client.getId())
                .age(25)
                .firstName("Shane")
                .address(client.getAddress())
                .vehicle(client.getVehicle())
                .build();

        clientRepository.save(newClient);

        Client updatedClient=clientRepository.findOne(id);
        Assert.assertEquals(updatedClient.getAge(),25);
    }
//    @Test
    public void delete() throws Exception {
       // Client client=clientRepository.findOne(id);
        clientRepository.delete(id);
        Client deletedClient=clientRepository.findOne(id);
        Assert.assertNull(deletedClient);

    }
}
