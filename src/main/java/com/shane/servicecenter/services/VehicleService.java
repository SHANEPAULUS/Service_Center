package com.shane.servicecenter.services;

import com.shane.servicecenter.domain.Vehicle;

import java.util.List;

/**
 * Created by SHANE on 2015/05/27.
 */
public interface VehicleService {
    List<Vehicle> getVehicles();

    Vehicle getVehicle(long id);
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    void removeVehicle(Vehicle vehicle);
}
