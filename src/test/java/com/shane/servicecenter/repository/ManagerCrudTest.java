package com.shane.servicecenter.repository;

import com.shane.servicecenter.App;
import com.shane.servicecenter.domain.ContactDetails;
import com.shane.servicecenter.domain.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.management.ManagementFactory;

/**
 * Created by SHANE on 2015/05/08.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ManagerCrudTest extends AbstractTestNGSpringContextTests {

    @Autowired
    ManagerRepository repository;

    private Long id=1L;

    // @Test
    public void create() throws Exception
    {
        ContactDetails address=new ContactDetails
                .Builder("0611092344")
                .address("2 Kerk Straat,Hopetown")
                //.email("msmith@gmail.com")
                .build();

        Manager manager=new Manager
                .Builder("Smith")
                .age(29)
                .firstName("Markus")
                .address(address)
                .build();
        repository.save(manager);
        id=manager.getID();
        Assert.assertNotNull(id);
    }

    // @Test
    public void read() throws Exception
    {
        Manager manager=repository.findOne(id);
        Assert.assertNotNull(manager);
    }

    // @Test
    public void update() throws Exception
    {
        //Still have to refactor the update part...
        //Managers and staff cannot service their personal vehicle(s) at this point..
        //Due to business rules
        Manager manager=repository.findOne(1L);
        Manager newManager=new Manager
                .Builder(manager.getlastName())
                .copy(manager)
                .firstName("Thinie")
                .build();

        repository.save(newManager);
        Assert.assertEquals(newManager.getfirstName(),"Thinie");
    }

    // @Test
    public void delete() throws Exception
    {
        Manager manager=repository.findOne(id);
        repository.delete(manager);

        Manager deletedManager=repository.findOne(id);
        Assert.assertNull(deletedManager);
    }
}
