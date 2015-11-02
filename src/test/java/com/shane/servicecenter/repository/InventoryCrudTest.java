package com.shane.servicecenter.repository;

import com.shane.servicecenter.App;
import com.shane.servicecenter.conf.factory.InventoryFactory;
import com.shane.servicecenter.domain.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import org.testng.Assert;


/**
 * Created by SHANE on 2015/05/08.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class InventoryCrudTest extends AbstractTestNGSpringContextTests {

    @Autowired
    InventoryRepository repository;

    private Long id=(long)1;

//    // @Test
    public void create() throws Exception
    {
        Inventory inventory=InventoryFactory.createInventory("Brembo Brake Pads",399.99,12);
        repository.save(inventory);
        id=inventory.getId();
        Assert.assertNotNull(id);
    }

    // @Test
    public void read() throws Exception
    {
        Inventory inventory=repository.findOne(id);
        Assert.assertNotNull(inventory);
    }

    // @Test
    public void update() throws Exception
    {
        Inventory inventory=repository.findOne(id);

        Inventory newInventory=new Inventory
                .Builder(inventory.getDescription())
                .copy(inventory)
                .price(499.99)
                .stock(20)
                .build();

        repository.save(newInventory);

        Inventory updatedInventory=repository.findOne(id);
        Assert.assertEquals(499.99,updatedInventory.getPrice());
    }

    // @Test
    public void delete() throws Exception
    {
        Inventory inventory=repository.findOne(id);
        repository.delete(inventory);
        Inventory deletedInventory=repository.findOne(id);
        Assert.assertNull(deletedInventory);
    }
}
