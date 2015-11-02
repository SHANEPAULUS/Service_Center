/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shane.servicecenter.repository;

import com.shane.servicecenter.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SHANE
 */
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,Long>{
}
