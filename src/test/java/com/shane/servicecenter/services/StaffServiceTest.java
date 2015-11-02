package com.shane.servicecenter.services;

import com.shane.servicecenter.App;
import com.shane.servicecenter.domain.ContactDetails;
import com.shane.servicecenter.domain.Job;
import com.shane.servicecenter.domain.Staff;
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
public class StaffServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    StaffService service;

    @Autowired
    JobService jobService;
    private Long id=1L;

       @Test
    public void create() throws Exception {
        ContactDetails contactDetails=new ContactDetails
                .Builder("0612345678")
                .address("23 Bloomsbury, Paarl")
                .build();

        Staff staff=new Staff
                .Builder("Nel")
                .firstName("Koos")
                .age(27)
                .eMail("nel@yahoo.com")
                .password("Koosie")
                .address(contactDetails)
                .build();
        service.addStaff(staff);
        id=staff.getId();
        Assert.assertNotNull(id);
    }

    //    @Test
    public void read() throws Exception {
        Staff staff=service.getStaff(id);
        Assert.assertNotNull(staff);
    }

    //    @Test
    public void update() throws Exception {
        Job job=jobService.getJob(id);
        List<Job> jobList=new ArrayList<>();
        jobList.add(job);

        Staff staff=service.getStaff(id);
        Staff newStaff=new Staff
                .Builder(staff.getLastName())
                .copy(staff)
                .jobs(jobList)
                .build();

        service.updateStaff(newStaff);
        Assert.assertEquals(newStaff.getJobList(),jobList);

    }

    //    @Test
    public void delete() throws Exception {
        Staff staff=service.getStaff(id);
        service.removeStaff(staff);
        Staff deletedStaff=service.getStaff(id);
        Assert.assertNull(deletedStaff);


    }
}
