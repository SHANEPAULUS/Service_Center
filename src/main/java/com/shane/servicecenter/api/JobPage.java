package com.shane.servicecenter.api;

/**
 * Created by SHANE on 2015/08/25.
 */

import com.shane.servicecenter.domain.Invoice;
import com.shane.servicecenter.domain.Job;
import com.shane.servicecenter.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/jobs/**")
public class JobPage {

    @Autowired
    JobService service;

    @RequestMapping(value="/jobs",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Job>> getAllJobs()
    {
        List<Job> jobs=service.getJobs();
        if(jobs.isEmpty())
        {
            return new ResponseEntity<List<Job>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
    }

    @RequestMapping(value="/create",method = RequestMethod.POST)
    public ResponseEntity<Job> addJob(@RequestBody Job job)
    {
        service.addJob(job);
        return new ResponseEntity<Job>(job,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<Job> getJob(@PathVariable("id") long id)
    {
        Job job=service.getJob(id);
        if(job==null)
        {
            return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Job>(job,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/update",method = RequestMethod.PUT)
    public ResponseEntity<Job> updateJob(@PathVariable("id") long id,@RequestBody Job job)
    {
        Job current=service.getJob(id);
        if(current==null)
        {
            return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
        }

        Job updatedJob=new Job
                .Builder(job.getJobDate())
                .copy(job)
                .id(current.getId())
                .build();

        service.updateJob(updatedJob);

        return new ResponseEntity<Job>(updatedJob,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method = RequestMethod.DELETE)
    public ResponseEntity<Job> removeJob(@PathVariable("id") long id)
    {
        Job job=service.getJob(id);
        if(job==null)
        {
            return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
        }

        service.removeJob(job);
        return new ResponseEntity<Job>(job,HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/{id}/job_invoice",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Invoice>> getInvoice(@PathVariable("id") long id)
    {
        List<Invoice> invoices=service.getInvoices(id);
        if(invoices.isEmpty())
        {
            return new ResponseEntity<List<Invoice>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Invoice>>(invoices,HttpStatus.OK);
    }

}
