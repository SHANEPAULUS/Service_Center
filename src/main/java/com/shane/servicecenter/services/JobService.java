package com.shane.servicecenter.services;

import com.shane.servicecenter.domain.Invoice;
import com.shane.servicecenter.domain.Job;
import com.shane.servicecenter.domain.Vehicle;

import java.util.List;

/**
 * Created by SHANE on 2015/08/11.
 */
public interface JobService {
    List<Job> getJobs();
    Job addJob(Job job);
    Job updateJob(Job job);
    List<Invoice> getInvoices(long id);
    void removeJob(Job job);
    Job getJob(long id);
}
