/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shane.servicecenter.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author SHANE
 */
@Entity
public class Job implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jobDate;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="job_id")
    private List<Invoice> invoiceList;

    public Job() {
    }

    public Job(Builder builder) {
        id=builder.id;
        jobDate=builder.jobDate;
        description=builder.description;
        invoiceList=builder.invoiceList;
    }
    
    public static class Builder{
        private Long id;
        private String jobDate;
        private String description;
        private List<Invoice> invoiceList;
        
        public Builder(String jobDate)
        {
            this.jobDate=jobDate;
        }

        public Builder id(Long id)
        {
            this.id=id;
            return this;
        }

        public Builder description(String desc)
        {
            this.description=desc;
            return this;
        }

        public Builder invoiceList(List<Invoice> list)
        {
            this.invoiceList=list;
            return this;
        }

        public Builder copy(Job job)
        {
            this.description=job.description;
            this.id=job.id;
            this.invoiceList=job.invoiceList;
            return this;
        }

        public Job build()
        {
            return new Job(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getJobDate() {
        return jobDate;
    }

    public String getDescription() {
        return description;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        return !(id != null ? !id.equals(job.id) : job.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobDate='" + jobDate + '\'' +
                ", description='" + description + '\'' +
                ", invoiceList=" + invoiceList +
                '}';
    }
}
