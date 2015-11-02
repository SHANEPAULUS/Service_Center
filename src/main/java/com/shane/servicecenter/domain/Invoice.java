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
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Invoice_id")
    private List<InvoiceItems> invoiceItemsList;


    public Invoice() {
    }

    public Invoice(Builder builder) {
        this.id=builder.id;
        this.date=builder.date;
        this.invoiceItemsList=builder.invoiceItemsList;
    }

    public static class Builder{
        private Long id;
        private String date;
        private List<InvoiceItems> invoiceItemsList;

        public Builder(String date)
        {
            this.date=date;
        }

        public Builder invoiceItemsList(List<InvoiceItems> list)
        {
            this.invoiceItemsList=list;
            return this;
        }

        public Builder id(Long id)
        {
            this.id=id;
            return this;
        }


        public Builder copy(Invoice value)
        {
            this.date=value.date;
            this.id=value.id;
            this.invoiceItemsList=value.invoiceItemsList;
            return this;
        }

        public Invoice build()
        {
            return new Invoice(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public List<InvoiceItems> getInvoiceItemsList() {
        return invoiceItemsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        return id.equals(invoice.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", invoiceItemsList=" + invoiceItemsList +
                '}';
    }
}
