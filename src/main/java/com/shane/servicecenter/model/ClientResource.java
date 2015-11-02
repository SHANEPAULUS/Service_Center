package com.shane.servicecenter.model;

import com.shane.servicecenter.domain.ContactDetails;
import com.shane.servicecenter.domain.Vehicle;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.List;

/**
 * Created by SHANE on 2015/08/21.
 */
public class ClientResource extends ResourceSupport {

    private Long resid;
    private String firstName;
    private String lastName;
    private int age;

    private ContactDetails address;
    private List<Vehicle> vehicle;

    public ClientResource() {
    }

    public ClientResource(Builder builder) {
        resid=builder.resid;
        firstName=builder.firstName;
        lastName=builder.lastName;
        vehicle=builder.vehicle;
        address=builder.address;
        age=builder.age;
    }

    public static class Builder{
        private Long resid;
        private String firstName;
        private String lastName;
        private List<Vehicle> vehicle;
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


        public Builder resid(Long value)
        {
            this.resid=value;
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

        public Builder copy(ClientResource value)
        {
            this.resid=value.getResidId();
            this.firstName=value.getFirstName();
            this.lastName=value.getLastName();
            this.vehicle=value.getVehicle();
            this.address=value.getAddress();
            this.age=value.getAge();

            return this;
        }

        public ClientResource build(){
            return new ClientResource(this);
        }

    }

    public int getAge(){return age;}

    public Long getResidId() {
        return resid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientResource client = (ClientResource) o;

        if (!resid.equals(client.resid)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return resid.hashCode();
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + resid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", vehicle=" + vehicle +
                '}';
    }
}
