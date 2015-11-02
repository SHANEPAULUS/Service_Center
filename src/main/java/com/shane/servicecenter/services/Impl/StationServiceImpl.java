package com.shane.servicecenter.services.Impl;

import com.shane.servicecenter.domain.Manager;
import com.shane.servicecenter.domain.Staff;
import com.shane.servicecenter.domain.Station;
import com.shane.servicecenter.repository.StaffRepository;
import com.shane.servicecenter.repository.StationRepository;
import com.shane.servicecenter.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/08/12.
 */
@Service
public class StationServiceImpl implements StationService {
    @Autowired
    StationRepository repository;

    @Override
    public Station getStation(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Station> getStations() {
        List<Station> allStations=new ArrayList<>();
        Iterable<Station> stations=repository.findAll();
        for(Station station:stations)
        {
            allStations.add(station);
        }

        return allStations;
    }

    @Override
    public List<Staff> getStaff(long id) {
        return repository.findOne(id).getStaff();
    }

    @Override
    public List<Manager> getStationManager(long id) {
        return repository.findOne(id).getManagerList();
    }

    @Override
    public Station addStation(Station station) {
        return repository.save(station);
    }

    @Override
    public Station updateStation(Station station) {
        return repository.save(station);
    }

    @Override
    public void removeStation(Station station) {
        repository.delete(station);
    }
}
