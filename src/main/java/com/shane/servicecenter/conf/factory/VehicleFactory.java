package com.shane.servicecenter.conf.factory;

import com.shane.servicecenter.domain.Vehicle;

/**
 * Created by SHANE on 2015/05/04.
 */
public class VehicleFactory {

    public static Vehicle createVehicle(String reg,String model)
    {
        Vehicle vehicle=new Vehicle.Builder(reg)
                .model(model)
                .build();
        return vehicle;
    }
}
