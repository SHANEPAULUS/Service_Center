package com.shane.servicecenter.domain;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.boot.json.JsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/08/21.
 */
public class DomainTest {

    @Test
    public void testClient() throws Exception {
        Client client=new Client.Builder("Paulus")
                .firstName("Shane")
                .eMail("shanepaulus@gmail.com")
                .password("shann123")
                .age(21)
                .build();
        Assert.assertEquals(client.getFirstName()+" "+client.getLastName(),"Shane Paulus");

        //Just a simple JSON Object Test...
    }

    @Test
    public void testInventory() throws Exception {
        Inventory item=new Inventory.Builder("Brake Fluid")
                .price(250.00)
                .stock(3)
                .build();
        Assert.assertEquals(item.getPrice(),250.00);
        Assert.assertEquals(item.getStock(),3);
        Assert.assertEquals(item.getDescription(),"Brake Fluid");
    }

    @Test
    public void testInvoice() throws Exception {
        Job job1=new Job.Builder("22/04/2015")
                .description("Replaced sparkplugs")
                .build();
        Job job2=new Job.Builder("21/04/2015")
                .description("Tested Engine Torque")
                .build();
        //Adding jobs onto an array list
        List<Job> jobList=new ArrayList<>();
        jobList.add(job1);
        jobList.add(job2);

       // Invoice invoice=new Invoice.Builder("22/04/2015")
       //         .jobList(jobList)
          //      .build();

        //Assert.assertEquals(invoice.getJobList().size(),2);
        //Assert.assertEquals(invoice.getJobList().get(0).getDate(),"22/04/2015");


    }

    @Test
    public void testInvoiceItems() throws Exception {
        InvoiceItems invoiceItems=new InvoiceItems.Builder(3)
                .build();
        Assert.assertEquals(invoiceItems.getQuantity(),3);
    }

    @Test
    public void testJob() throws Exception {
        Job job=new Job.Builder("28/04/2015")
                .description("Gearbox oil change")
                .build();
        Assert.assertEquals(job.getJobDate(),"28/04/2015");
        Assert.assertEquals(job.getDescription(),"Gearbox oil change");
    }

    @Test
    public void testManager() throws Exception {
        Manager manager=new Manager.Builder("Cloete")
                .firstName("Auldrin")
                .age(28)
                .build();
        Assert.assertEquals(manager.getlastName(),"Cloete");
    }

    @Test
    public void testStaff() throws Exception {
        Staff staff=new Staff.Builder("Malema")
                .firstName("Julius")
                .age(12)
                .build();
        Assert.assertEquals(staff.getFirstName(),"Julius");
    }

    @Test
    public void testStation() throws Exception {
        Station station=new Station.Builder("Car Pit Stop")
                .build();
        Assert.assertEquals(station.getName(),"Car Pit Stop");
    }

    @Test
    public void testVehicle() throws Exception {
        Vehicle bmw=new Vehicle.Builder("SHANE WP")
                .model("2015 BMW M5")
                .build();

        Assert.assertEquals(bmw.getReg(),"SHANE WP");
    }

    /*@Test
    public void testContactDetails() throws Exception {
        ContactDetails contact=new ContactDetails.Builder("0213456789")
                .email("shanepaulus@domain.com")
                .address("21 Avenue Street, Paarl")
                .build();

        Assert.assertEquals(contact.getEmail(),"shanepaulus@domain.com");
        Assert.assertEquals(contact.getTel(),"0213456789");

    }*/
}
