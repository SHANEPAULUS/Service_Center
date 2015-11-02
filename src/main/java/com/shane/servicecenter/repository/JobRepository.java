package com.shane.servicecenter.repository;

import com.shane.servicecenter.domain.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SHANE on 2015/05/05.
 */
@Repository
public interface JobRepository extends CrudRepository<Job,Long> {
}
