package com.shane.servicecenter.services;

import com.shane.servicecenter.App;
import com.shane.servicecenter.domain.Invoice;
import com.shane.servicecenter.domain.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class JobServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    JobService service;

    @Autowired
    InvoiceService invoiceService;

    private Long id=1L;
    //    @Test
    public void create() throws Exception {
        Job job=new Job
                .Builder("12/04/2015")
                .description("Full Service")
                .build();
        service.addJob(job);
        id=job.getId();
        Assert.assertNotNull(id);
    }

    //    @Test
    public void read() throws Exception {
        Job job=service.getJob(id);
        Assert.assertNotNull(job);
    }

    //    @Test
    public void update() throws Exception {
        Invoice inv=invoiceService.getInvoice(id);
        List<Invoice> invList=new ArrayList<>();
        invList.add(inv);

        Job job=service.getJob(id);
        Job newJob=new Job
                .Builder(job.getJobDate())
                .copy(job)
                .invoiceList(invList)
                .build();

        service.updateJob(newJob);
        Assert.assertEquals(newJob.getInvoiceList(),invList);
    }


    //    @Test
    public void delete() throws Exception {
        Job job=service.getJob(id);
        service.removeJob(job);
        Job deletedJob=service.getJob(id);
        Assert.assertNull(deletedJob);
    }
}
