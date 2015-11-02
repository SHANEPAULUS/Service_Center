/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shane.servicecenter.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Staff implements Serializable {
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
    @JoinColumn(name="Assistant_id")
    private List<Job> jobList;

    public Staff() {
    }

    public Staff(Builder builder) {
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.age=builder.age;
        this.jobList=builder.jobList;
        this.address=builder.address;
        this.password=builder.password;
        this.eMail=builder.eMail;
    }
    
    public static class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        private String eMail;
        private String password;
        private int age;
        private List<Job> jobList;
        private ContactDetails address;
       
        public Builder(String lastName)
        {
           this.lastName=lastName;
        }

        public Builder jobs(List<Job> list)
        {
            this.jobList=list;
            return this;
        }

        public Builder address(ContactDetails address)
        {
            this.address=address;
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


        public Builder id(long value)
        {
            this.id=value;
            return this;
        }

        
        public Builder firstName(String value)
        {
            this.firstName=value;
            return this;
        }
        
        public Builder age(int value)
        {
            this.age=value;
            return this;
        }
        
        public Builder copy(Staff value)
        {
            this.lastName=value.getLastName();
            this.firstName=value.getFirstName();
            this.id=value.getId();
            this.age=value.getAge();
            this.jobList=value.getJobList();
            this.address=value.getAddress();
            return this;
        }
        
        public Staff build()
        {
            return new Staff(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public ContactDetails getAddress() {
        return address;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPassword() {
        return password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        return !(id != null ? !id.equals(staff.id) : staff.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", jobList=" + jobList +
                '}';
    }
}
