package com.shane.servicecenter.repository;

import com.shane.servicecenter.domain.Staff;
import com.shane.servicecenter.domain.Station;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SHANE on 2015/08/12.
 */
@Repository
public interface StationRepository extends CrudRepository<Station,Long> {
}
