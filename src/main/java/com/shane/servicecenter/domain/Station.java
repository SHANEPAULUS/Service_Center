package com.shane.servicecenter.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 * Created by SHANE on 2015/08/04.
 */
@Entity
public class Station implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Embedded
    private ContactDetails address;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="Station_id")
    private List<Staff> staff;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="Station_id")
    private List<Manager> managerList;

    public Station() {
    }

    public List<Manager> getManagerList() {
        return managerList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ContactDetails getAddress() {
        return address;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public Station(Builder builder) {
        this.address=builder.address;
        this.id=builder.id;
        this.name=builder.name;
        this.address=builder.address;
        this.staff=builder.staff;
        this.managerList=builder.managerList;
    }

    public static class Builder{
        private Long id;
        private String name;
        private ContactDetails address;
        private List<Staff> staff;
        private List<Manager> managerList;

        public Builder(String name){this.name=name;}

        public Builder managerList(List<Manager> list)
        {
            this.managerList=list;
            return this;
        }

        public Builder address(ContactDetails address)
        {
            this.address=address;
            return this;
        }

        public Builder id(long value)
        {
            this.id=value;
            return this;
        }

        public Builder staff(List<Staff> staff)
        {
            this.staff=staff;
            return this;
        }

        public Builder copy(Station value)
        {
            this.id= value.id;
            this.staff=value.staff;
            this.address=value.address;
            this.name=value.name;
            this.managerList=value.managerList;

            return this;
        }

        public Station build(){return new Station(this);}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station)) return false;

        Station station = (Station) o;

        return id.equals(station.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", staff=" + staff +
                ", managerList=" + managerList +
                '}';
    }
}
