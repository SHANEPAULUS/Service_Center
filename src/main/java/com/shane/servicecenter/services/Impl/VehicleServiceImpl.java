package com.shane.servicecenter.services.Impl;

import com.shane.servicecenter.domain.Vehicle;
import com.shane.servicecenter.repository.VehicleRepository;
import com.shane.servicecenter.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/05/27.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;
    @Override
    public List<Vehicle> getVehicles() {
        List<Vehicle> allCars=new ArrayList<Vehicle>();

        Iterable<Vehicle> cars=repository.findAll();
        for(Vehicle car: cars)
        {
            allCars.add(car);
        }

        return allCars;
    }

    @Override
    public Vehicle getVehicle(long id) {
        return repository.findOne(id);
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        repository.delete(vehicle);
    }
}
