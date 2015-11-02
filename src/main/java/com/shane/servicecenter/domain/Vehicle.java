/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shane.servicecenter.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author SHANE
 */
@Entity
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reg;
    private String model;

    public Vehicle() {
    }

    public Vehicle(Builder builder) {
        id=builder.id;
        reg=builder.reg;
        model=builder.model;
    }
    
    public static class Builder{
        private Long id;
        private String reg;
        private String model;
        
        public Builder(String reg)
        {
            this.reg=reg;
        }

        
        public Builder model(String value)
        {
            this.model=value;
            return this;
        }

        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }
        
        public Builder copy(Vehicle value)
        {
            this.model=value.getModel();
            this.reg=value.getReg();
            this.id=value.getId();
            return this;
        }
        
        public Vehicle build()
        {
            return new Vehicle(this);
        }
    }

    public String getReg() {
        return reg;
    }

    public String getModel() {return model;}
    public Long getId() {return id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        return id.equals(vehicle.id);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", reg='" + reg + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
