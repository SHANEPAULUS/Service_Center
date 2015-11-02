package com.shane.servicecenter.services;

import com.shane.servicecenter.domain.Job;
import com.shane.servicecenter.domain.Staff;

import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
public interface StaffService {
    List<Staff> getAllStaff();
    List<Job> getStaffJobs(long id);
    List<Staff> getStaffByMail(String mail);
    Staff addStaff(Staff staff);
    Staff updateStaff(Staff staff);
    Staff getStaff(long id);
    void removeStaff(Staff staff);
}
