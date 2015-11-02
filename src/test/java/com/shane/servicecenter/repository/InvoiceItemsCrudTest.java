package com.shane.servicecenter.repository;

import com.shane.servicecenter.App;
import com.shane.servicecenter.conf.factory.InventoryFactory;
import com.shane.servicecenter.conf.factory.InvoiceItemsFactory;
import com.shane.servicecenter.domain.InvoiceItems;
import com.shane.servicecenter.domain.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/05/08.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class InvoiceItemsCrudTest extends AbstractTestNGSpringContextTests {

    @Autowired
    InvoiceItemsRepostiory repository;
    @Autowired
    InventoryRepository inventoryRepository;

    private Long id=(long)1;

    // @Test
    public void create() throws Exception
    {
       /* List<Inventory> items=new ArrayList<Inventory>();
        items.add(InventoryFactory.createInventory("GearBox Samp",788.00,12));
        items.add(InventoryFactory.createInventory("Engine F50 Oil", 550.99, 5));
        items.add(InventoryFactory.createInventory("m52 Spark Plugs", 30.00, 40));
        */
        InvoiceItems invoiceItems=new InvoiceItems
                .Builder(4)
                .build();
        repository.save(invoiceItems);
        Assert.assertNotNull(id);
    }

    // @Test
    public void read() throws Exception
    {
        InvoiceItems invoiceItems=repository.findOne(id);
        Assert.assertNotNull(invoiceItems);
    }

    // @Test
    public void update() throws Exception
    {
        //This order_line(InvoiceItems) has no purpose because it belongs to no invoice/item
        //We will give it an invoice and items..
        Inventory brakes=inventoryRepository.findOne((long)1);

        InvoiceItems invoiceItems=repository.findOne(id);
        List<InvoiceItems> invoiceItemsList=new ArrayList<>();
        invoiceItemsList.add(invoiceItems);

        Inventory updatedInventory=new Inventory
                .Builder(brakes.getDescription())
                .copy(brakes)
                .invoiceItemsList(invoiceItemsList)
                .stock(brakes.getStock()-invoiceItems.getQuantity())
                .build();
        inventoryRepository.save(updatedInventory);
        Assert.assertEquals(updatedInventory.getStock(),16);
        //Update the invoice this order_line belongs to..
    }

    // @Test
    public void delete() throws Exception
    {
        InvoiceItems invoiceItems=repository.findOne(id);
        repository.delete(invoiceItems);

        InvoiceItems deletedInvoiceItems=repository.findOne(id);
        Assert.assertNull(deletedInvoiceItems);
    }
}
