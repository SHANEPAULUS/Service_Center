package com.shane.servicecenter.api;

import com.shane.servicecenter.domain.Vehicle;
import com.shane.servicecenter.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
@RestController
@RequestMapping(value="/vehicles/**")
public class VehiclePage {
    @Autowired
    VehicleService service;

    @RequestMapping(value="/vehicles",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vehicle>> getAllVehicles()
    {
        List<Vehicle> cars=service.getVehicles();
        if(cars.isEmpty())
        {
            return new ResponseEntity<List<Vehicle>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Vehicle>>(cars,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") long id)
    {
        Vehicle vehicle=service.getVehicle(id);
        if(vehicle==null)
        {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
    }

    @RequestMapping(value="/create",method= RequestMethod.POST)
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle)
    {
        service.addVehicle(vehicle);
        return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/update",method= RequestMethod.PUT)
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") long id,@RequestBody Vehicle vehicle)
    {
        Vehicle oldVehicle=service.getVehicle(id);
        if(oldVehicle==null)
        {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        }

        Vehicle updatedVehicle=new Vehicle
                .Builder(vehicle.getReg())
                .copy(vehicle)
                .id(oldVehicle.getId())
                .build();
        service.updateVehicle(updatedVehicle);
        return new ResponseEntity<Vehicle>(updatedVehicle,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method= RequestMethod.DELETE)
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id") long id)
    {
        Vehicle vehicle=service.getVehicle(id);
        if(vehicle==null)
        {
            return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
        }

        service.removeVehicle(vehicle);
        return new ResponseEntity<Vehicle>(HttpStatus.NO_CONTENT);
    }


}
