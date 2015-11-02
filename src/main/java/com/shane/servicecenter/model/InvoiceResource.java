package com.shane.servicecenter.model;

import com.shane.servicecenter.domain.Client;
import com.shane.servicecenter.domain.Inventory;
import com.shane.servicecenter.domain.Staff;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
import java.util.List;

/**
 * Created by SHANE on 2015/08/10.
 */
public class InvoiceResource extends ResourceSupport {
    private Long resid;
    private String station;
    private Client client;
    private Staff assistant;
    private Date date;
    private List<Inventory> inventoryList;

    public InvoiceResource() {
    }
    public InvoiceResource(Builder builder)
    {
        this.assistant=builder.assistant;
        this.client=builder.client;
        this.station=builder.station;
        this.resid=builder.resid;
        this.date=builder.date;
        this.inventoryList=builder.inventoryList;
    }

    public Long getResid() {
        return resid;
    }

    public String getStation() {
        return station;
    }

    public Client getClient() {
        return client;
    }

    public Staff getAssistant() {
        return assistant;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public static class Builder{
        private Long resid;
        private String station;
        private Client client;
        private Staff assistant;
        private Date date;
        private List<Inventory> inventoryList;

        public Builder(Date today){this.date=today;}
        public Builder resid(Long value)
        {
            this.resid=value;
            return this;
        }

        public Builder station(String value)
        {
            this.station=value;
            return this;
        }

        public Builder client(Client value)
        {
            this.client=value;
            return this;
        }

        public Builder assistant(Staff value)
        {
            this.assistant=value;
            return this;
        }

        public Builder date(Date value)
        {
            this.date=value;
            return this;
        }

        public Builder items(List<Inventory> inv)
        {
            this.inventoryList=inv;
            return this;
        }

        public Builder copy(InvoiceResource value)
        {
            this.date=value.date;
            this.inventoryList=value.inventoryList;
            this.client=value.client;
            this.station=value.station;
            this.assistant=value.assistant;
            this.resid=value.resid;
            return this;
        }

        public InvoiceResource build(){return new InvoiceResource(this);}
    }
}
