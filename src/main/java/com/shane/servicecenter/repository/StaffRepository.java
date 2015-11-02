/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shane.servicecenter.repository;

import com.shane.servicecenter.domain.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author SHANE
 */
@Repository
public interface StaffRepository extends CrudRepository<Staff,Long>{
    List<Staff> findByeMail(String mail);
}
