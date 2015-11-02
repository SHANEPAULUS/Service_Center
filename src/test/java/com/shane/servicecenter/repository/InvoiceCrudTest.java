package com.shane.servicecenter.repository;

import com.shane.servicecenter.App;
import com.shane.servicecenter.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/05/08.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class InvoiceCrudTest extends AbstractTestNGSpringContextTests {

    @Autowired
    InvoiceRepository repostiory;
    @Autowired
    ClientRepository clientRepostiory;
    @Autowired
    InvoiceItemsRepostiory itemsRepository;

    private Long id=(long)1;

    // @Test
    public void create() throws Exception
    {
        Invoice invoice=new Invoice
                .Builder("21/04/2015")
                .build();
        repostiory.save(invoice);
        id=invoice.getId();
        Assert.assertNotNull(id);
    }

    // @Test
    public void read() throws Exception
    {
        Invoice invoice=repostiory.findOne(id);
        Assert.assertNotNull(invoice);

    }

    // @Test
    public void update() throws Exception
    {
        //For the purpose of this update I'm gonna give value to this invoice
        //by issue-ing it to an owner and adding inventory items(later after a job is completed)

        //Giving an order_line to this invoice...
        InvoiceItems items=itemsRepository.findOne(1L);
        List<InvoiceItems> itemList=new ArrayList<>();
        itemList.add(items);

        Invoice invoice=repostiory.findOne(id);
        Invoice newInvoice=new Invoice
                .Builder(invoice.getDate())
                .copy(invoice)
                .invoiceItemsList(itemList)
                .build();
        List<Invoice> invList=new ArrayList<>();
        invList.add(newInvoice);

        //Giving this Invoice to a certain client...
        Client client=clientRepostiory.findOne((long)1);
        Client updatedClient=new Client
                .Builder(client.getLastName())
                .copy(client)
                .invoices(invList)
                .build();

        clientRepostiory.save(updatedClient);
        Assert.assertNotNull(updatedClient.getInvoices());

        //this invoice is now updated and the client_id on the table is set to 1
        //meaning it belongs to this client above..
    }

    // @Test
    public void delete() throws Exception
    {
        Invoice invoice=repostiory.findOne(id);
        repostiory.delete(invoice);

        Invoice deletedInvoice=repostiory.findOne(id);
        Assert.assertNull(deletedInvoice);
    }
}
