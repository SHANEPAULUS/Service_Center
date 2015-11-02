package com.shane.servicecenter.repository;

import com.shane.servicecenter.App;
import com.shane.servicecenter.domain.Client;
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
 * Created by SHANE on 2015/05/07.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class JobCrudTest extends AbstractTestNGSpringContextTests {
    @Autowired
    JobRepository repository;

    @Autowired
    InvoiceRepository invoiceRepository;

    private Long id=(long)1;

    // // @Test
    public void create() throws Exception
    {
        Job job=new Job
                .Builder("12/04/2015")
                .description("Replaced Brake Pads on front wheels")
                .build();
        repository.save(job);
        id=job.getId();
        Assert.assertNotNull(id);
    }

    // // @Test
    public void read() throws Exception {
        Job job=repository.findOne(id);
        Assert.assertNotNull(job);
    }

    // // @Test
    public void update() throws Exception
    {
        Invoice inv=invoiceRepository.findOne(1L);
        List<Invoice> invList=new ArrayList<>();
        invList.add(inv);

        Job job=repository.findOne(1L);
        Job newJob=new Job
                .Builder(job.getJobDate())
                .copy(job)
                .invoiceList(invList)
                .build();
        repository.save(newJob);
        Assert.assertNotNull(newJob.getInvoiceList());
    }

    // // @Test
    public void delete() throws Exception {
        Job job=repository.findOne(id);
        repository.delete(job);
        Job newJob=repository.findOne(id);
        Assert.assertNull(newJob);
    }
}
