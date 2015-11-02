package com.shane.servicecenter.services.Impl;

import com.shane.servicecenter.domain.Invoice;
import com.shane.servicecenter.domain.Job;
import com.shane.servicecenter.repository.JobRepository;
import com.shane.servicecenter.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository repository;

    @Override
    public Job getJob(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Job> getJobs() {
        List<Job> allJobs=new ArrayList<>();
        Iterable<Job> jobs=repository.findAll();

        for(Job job:jobs)
        {
            allJobs.add(job);
        }

        return allJobs;
    }

    @Override
    public Job addJob(Job job) {
        return repository.save(job);
    }

    @Override
    public Job updateJob(Job job) {
        return repository.save(job);
    }

    @Override
    public List<Invoice> getInvoices(long id) {
        return repository.findOne(id).getInvoiceList();
    }

    @Override
    public void removeJob(Job job) {
        repository.delete(job);
    }
}
