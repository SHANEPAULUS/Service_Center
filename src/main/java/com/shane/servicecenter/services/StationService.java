package com.shane.servicecenter.services;

import com.shane.servicecenter.domain.Manager;
import com.shane.servicecenter.domain.Staff;
import com.shane.servicecenter.domain.Station;

import java.util.List;

/**
 * Created by SHANE on 2015/08/12.
 */
public interface StationService {
    List<Station> getStations();
    List<Staff> getStaff(long id);
    List<Manager> getStationManager(long id);

    Station getStation(long id);
    Station addStation(Station station);
    Station updateStation(Station station);
    void removeStation(Station station);
}
