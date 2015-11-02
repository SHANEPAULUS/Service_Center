/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shane.servicecenter.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 *
 * @author SHANE
 */
@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private int age;
    @Embedded
    private ContactDetails address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private List<Vehicle> vehicle;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private List<Invoice> invoices;

    public Client() {
    }

    public Client(Builder builder) {
        this.password=builder.password;
        this.eMail=builder.eMail;
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.vehicle=builder.vehicle;
        this.address=builder.address;
        this.age=builder.age;
        this.invoices=builder.invoices;
    }

    public static class Builder{
        private Long id;
        private String eMail;
        private String password;
        private String firstName;
        private String lastName;
        private List<Vehicle> vehicle;
        private List<Invoice> invoices;
        private ContactDetails address;
        private int age;
        
        public Builder(String lastName)
        {
            this.lastName=lastName;
        }
        
        public Builder firstName(String value)
        {
            this.firstName=value;
            return this;
        }

        public Builder eMail(String email)
        {
            this.eMail=email;
            return  this;
        }

        public Builder password(String password) throws Exception
        {
            this.password=convertPasswordToMD5(password);
            return this;
        }

        public Builder invoices(List<Invoice> list)
        {
            this.invoices=list;
            return this;
        }


        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }
        
        public Builder vehicle(List<Vehicle> value)
        {
            this.vehicle=value;
            return this;
        }

        public Builder address(ContactDetails address)
        {
            this.address=address;
            return this;
        }

        public Builder age(int age)
        {
            this.age=age;
            return this;
        }
        
        public Builder copy(Client value)
        {
            this.eMail=value.geteMail();
            this.password=value.getPassword();
            this.id=value.getId();
            this.firstName=value.getFirstName();
            this.lastName=value.getLastName();
            this.vehicle=value.getVehicle();
            this.address=value.getAddress();
            this.age=value.getAge();
            this.invoices=value.getInvoices();

          return this;  
        }
        
        public Client build(){
            return new Client(this);
        }
       
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    private static String convertPasswordToMD5(String pass) throws NoSuchAlgorithmException {
        MessageDigest md=MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());

        byte byteData[]=md.digest();

        StringBuffer sb=new StringBuffer();
        for(int x=0;x<byteData.length;x++)
        {
            sb.append(Integer.toString((byteData[x]&0xff)+0x100,16).substring(1));
        }
        return sb.toString();
    }

    public int getAge(){return age;}

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ContactDetails getAddress() {
        return address;
    }

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!id.equals(client.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", vehicle=" + vehicle +
                ", invoices=" + invoices +
                '}';
    }
}
