package com.shane.servicecenter.api;

import com.shane.servicecenter.domain.Manager;
import com.shane.servicecenter.domain.Staff;
import com.shane.servicecenter.domain.Station;
import com.shane.servicecenter.services.StationService;
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
@RequestMapping(value="/stations/**")
public class StationPage {
    @Autowired
    StationService service;

    @RequestMapping(value="/stations",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Station>> getAllStations()
    {
        List<Station> stations=service.getStations();
        if(stations.isEmpty())
        {
            return new ResponseEntity<List<Station>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Station>>(stations,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Station> getStation(@PathVariable("id") long id)
    {
        Station station=service.getStation(id);
        if(station==null)
        {
            return new ResponseEntity<Station>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Station>(station,HttpStatus.OK);
    }

    @RequestMapping(value="/create",method= RequestMethod.POST)
    public ResponseEntity<Station> createStation(@RequestBody Station station)
    {
        service.addStation(station);
        return new ResponseEntity<Station>(station,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/update",method= RequestMethod.PUT)
    public ResponseEntity<Station> updateStation(@PathVariable("id") long id,@RequestBody Station station)
    {
        Station oldStation=service.getStation(id);
        if(oldStation==null)
        {
            return new ResponseEntity<Station>(HttpStatus.NOT_FOUND);
        }

        Station updatedStation=new Station
                .Builder(station.getName())
                .copy(station)
                .id(oldStation.getId())
                .build();

        service.updateStation(updatedStation);
        return new ResponseEntity<Station>(updatedStation,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/delete",method= RequestMethod.DELETE)
    public ResponseEntity<Station> deleteStation(@PathVariable("id") long id)
    {
        Station station=service.getStation(id);
        if(station==null)
        {
            return new ResponseEntity<Station>(HttpStatus.NOT_FOUND);
        }

        service.removeStation(station);
        return new ResponseEntity<Station>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/{id}/staff",method= RequestMethod.GET)
    public ResponseEntity<List<Staff>> getStationStaff(@PathVariable("id") long id)
    {
        List<Staff> staff=service.getStaff(id);
        if(staff.isEmpty())
        {
            return new ResponseEntity<List<Staff>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Staff>>(staff,HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/manager",method= RequestMethod.GET)
    public ResponseEntity<List<Manager>> getStationManager(@PathVariable("id") long id)
    {
        List<Manager> manager=service.getStationManager(id);
        if(manager.isEmpty())
        {
            return new ResponseEntity<List<Manager>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Manager>>(manager,HttpStatus.OK);
    }


}
