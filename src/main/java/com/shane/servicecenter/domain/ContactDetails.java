/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shane.servicecenter.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author SHANE
 */
@Embeddable
public class ContactDetails implements Serializable {
    private String tel;
    private String address;

    public ContactDetails() {
    }

    public ContactDetails(Builder builder) {
        this.address=builder.address;
        this.tel=builder.tel;
    }

    public static class Builder{
        private String tel;
        private String address;

        public Builder(String tel){this.tel=tel;}

        public Builder address(String value)
        {
            this.address=value;
            return this;
        }


        public Builder copy(ContactDetails value)
        {
            this.address=value.address;
            this.tel=value.tel;
            return this;
        }

        public ContactDetails build(){return new ContactDetails(this);}
    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactDetails)) return false;

        ContactDetails that = (ContactDetails) o;

        if (!tel.equals(that.tel)) return false;
        return address.equals(that.address);

    }

    @Override
    public int hashCode() {
        int result = tel.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
