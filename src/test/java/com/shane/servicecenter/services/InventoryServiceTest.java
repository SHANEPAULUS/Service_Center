package com.shane.servicecenter.services;

import com.shane.servicecenter.App;
import com.shane.servicecenter.conf.factory.InventoryFactory;
import com.shane.servicecenter.domain.Inventory;
import com.shane.servicecenter.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by SHANE on 2015/08/25.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class InventoryServiceTest  extends AbstractTestNGSpringContextTests {
    @Autowired
    InventoryService service;

    private Long id=3L;
   //    @Test
    public void create() throws Exception {

        Inventory inventory= InventoryFactory.createInventory("5L Engine Motor Oil", 450, 30);
        service.addInventory(inventory);
        id=inventory.getId();
        Assert.assertNotNull(id);
        //For some reason the id seem to lose its value...
    }

    //    @Test
    public void read() throws Exception {
        Inventory inventory=service.getInventory(id);
        Assert.assertNotNull(inventory);
    }

    //    @Test
    public void update() throws Exception {
        Inventory inventory=service.getInventory(id);

        Inventory newInventory=new Inventory
                .Builder(inventory.getDescription())
                .copy(inventory)
                .price(499.99)
                .stock(20)
                .build();
        service.updateInventory(newInventory);
        Inventory updatedItem=service.getInventory(id);
        Assert.assertEquals(updatedItem.getPrice(),499.99);
    }

    //    @Test
    public void delete() throws Exception {
        Inventory inventory=service.getInventory(id);
        service.removeInventory(inventory);
        Inventory deletedItem=service.getInventory(id);
        Assert.assertNull(deletedItem);

    }

    //    @Test
    public void testGetAllItems() throws Exception {


    }
}
