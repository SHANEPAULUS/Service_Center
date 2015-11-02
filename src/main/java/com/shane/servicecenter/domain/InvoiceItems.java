package com.shane.servicecenter.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by SHANE on 2015/08/20.
 */
@Entity
public class InvoiceItems implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;

    public InvoiceItems() {
    }
    public InvoiceItems(Builder builder) {
        this.id=builder.id;
        this.quantity=builder.quantity;
    }

    public static class Builder{
        private int quantity;
        private Long id;

        public Builder(int quantity)
        {
            this.quantity=quantity;
        }


        public Builder copy(InvoiceItems value)
        {
            this.quantity=value.quantity;
            this.id=value.id;
            return this;
        }

        public InvoiceItems build()
        {
            return new InvoiceItems(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceItems)) return false;

        InvoiceItems that = (InvoiceItems) o;

        return id.equals(that.id);

    }

    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "InvoiceItems{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
