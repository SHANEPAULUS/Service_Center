package com.shane.servicecenter.conf.factory;

import com.shane.servicecenter.domain.ContactDetails;
import com.shane.servicecenter.domain.Manager;
import com.shane.servicecenter.domain.Staff;
import com.shane.servicecenter.domain.Station;

import java.util.List;

/**
 * Created by SHANE on 2015/08/12.
 */
public class StationFactory {
    public static Station createStaion(ContactDetails address,List<Staff> staff
            ,Manager manager,String name){
        Station station=new Station
                .Builder(name)
                .address(address)
                .staff(staff)
                .build();
        return station;
    }
}
