package com.shane.servicecenter.conf.factory;

import com.shane.servicecenter.domain.Manager;
import com.shane.servicecenter.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by SHANE on 2015/05/04.
 */
public class ManagerFactory {

    public static Manager createManager(Map<String,String> values,int age,List<Staff> staffList)
    {
        Manager manager=new Manager.Builder(values.get("lastName"))
                .firstName(values.get("firstName"))
                .age(age)
                //.staff(staffList)
                .build();

        return manager;
    }
}
