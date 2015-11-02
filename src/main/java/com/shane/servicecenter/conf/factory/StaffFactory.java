package com.shane.servicecenter.conf.factory;

import com.shane.servicecenter.domain.Staff;

/**
 * Created by SHANE on 2015/05/04.
 */
public class StaffFactory {
    public static Staff createStaff(String lName,String fname,int age)
    {
        Staff staff=new Staff.Builder(lName)
                .firstName(fname)
                .age(age)
                .build();
        return staff;
    }
}
