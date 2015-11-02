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
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private double price;
    private int stock;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="Item_id")
    private List<InvoiceItems> invoiceItemsList;


    public Inventory() {
    }

    public Inventory(Builder builder) {
        this.description=builder.description;
        this.id=builder.id;
        this.price=builder.price;
        this.stock=builder.stock;
        this.invoiceItemsList=builder.invoiceItemsList;
    }
    
    public static class Builder{
        
        private Long id;
        private String description;
        private double price;
        private int stock;
        private List<InvoiceItems> invoiceItemsList;
        
        public Builder(String desc) {
            this.description = desc;
        }
         
          public Builder price(Double value)
        {
            this.price=value;
            return this;
        }

        public Builder invoiceItemsList(List<InvoiceItems> list)
        {
            this.invoiceItemsList=list;
            return this;
        }

          
        public Builder stock(int value)
        {
            this.stock=value;
            return this;
        }

        public Builder id(Long id)
        {
            this.id=id;
            return this;
        }
        
        
        public Builder copy(Inventory value)
        {
            this.invoiceItemsList=value.invoiceItemsList;
            this.id=value.id;
            this.description=value.description;
            this.stock=value.stock;
            this.price=value.price;
            this.price=value.price;
            return this;
        }
        
        public Inventory build()
        {
            return new Inventory(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public List<InvoiceItems> getInvoiceItemsList() {
        return invoiceItemsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        return !(id != null ? !id.equals(inventory.id) : inventory.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", invoiceItemsList=" + invoiceItemsList +
                '}';
    }
}
