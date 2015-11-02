/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shane.servicecenter.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author SHANE
 */
@Entity
public class Manager implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @Embedded
    private ContactDetails address;

    public Manager() {
    }

    public Manager(Builder builder) {
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.age=builder.age;
        this.address=builder.address;
    }
    
    public static class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        private int age;
        private ContactDetails address;
        
        public Builder(String lastName)
        {
            this.lastName=lastName;
        }

        public Builder address(ContactDetails address)
        {
            this.address=address;
            return this;
        }
        
        public  Builder firstName(String value)
        {
            this.firstName=value;
            return this;
        }
        
        public  Builder age(int value)
        {
            this.age=value;
            return this;
        }

        public Builder id(long id)
        {
            this.id=id;
            return this;
        }
        
        public Builder copy(Manager value)
        {
            this.id=value.getID();
            this.firstName=value.getfirstName();
            this.lastName=value.getlastName();
            this.age=value.getAge();
            this.address=value.getAddress();
            return this;
        }
        
        public Manager build()
        {
            return new Manager(this);
        }
        
        
    }

    public ContactDetails getAddress() {
        return address;
    }

    public Long getID() {
        return id;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        return !(id != null ? !id.equals(manager.id) : manager.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
