package com.shane.servicecenter.repository;

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
 * Created by SHANE on 2015/05/08.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StaffCrudTest extends AbstractTestNGSpringContextTests {

    @Autowired
    StaffRepository repository;
    @Autowired
    JobRepository jobRepository;

    private Long id=(long)1;

    // @Test
    public void create() throws Exception
    {
        ContactDetails contactDetails=new ContactDetails
                .Builder("0612345678")
                .address("23 Bloomsbury, Paarl")
                //.email("billy@yahoo.net")
                .build();

        Staff staff=new Staff
                .Builder("Nel")
                .firstName("Koos")
                .age(27)
                .address(contactDetails)
                .build();
        repository.save(staff);
        id=staff.getId();
        Assert.assertNotNull(id);

    }

    // @Test
    public void read() throws Exception
    {
        Staff staff=repository.findOne(id);
        Assert.assertNotNull(staff);
    }

    // @Test
    public void update() throws Exception
    {
        Job job=jobRepository.findOne((long)1);
        List<Job> jobList=new ArrayList<>();
        jobList.add(job);

        Staff staff=repository.findOne(id);
        Staff updatedStaff=new Staff
                .Builder(staff.getLastName())
                .copy(staff)
                .age(25)
                .jobs(jobList)
                .build();

        repository.save(updatedStaff);
        Assert.assertEquals(updatedStaff.getAge(),25);
    }

    // @Test
    public void delete() throws Exception
    {
        Staff staff=repository.findOne(id);
        repository.delete(staff);

        Staff deletedStaff=repository.findOne(id);
        Assert.assertNull(deletedStaff);
    }
}
