package com.shane.servicecenter.services.Impl;

import com.shane.servicecenter.domain.Job;
import com.shane.servicecenter.domain.Staff;
import com.shane.servicecenter.repository.StaffRepository;
import com.shane.servicecenter.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    StaffRepository repository;

    @Override
    public Staff getStaff(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Staff> getStaffByMail(String mail) {
        List<Staff> allStaff=new ArrayList<>();

        Iterable<Staff> staff=repository.findByeMail(mail);
        for(Staff s:staff)
        {
            allStaff.add(s);
        }

        return allStaff;
    }

    @Override
    public List<Staff> getAllStaff() {
        List<Staff> allStaff=new ArrayList<>();
        Iterable<Staff> staffs=repository.findAll();

        for(Staff staff:staffs)
        {
            allStaff.add(staff);
        }

        return allStaff;
    }

    @Override
    public List<Job> getStaffJobs(long id) {
        return repository.findOne(id).getJobList();
    }

    @Override
    public Staff addStaff(Staff staff) {
        return repository.save(staff);
    }

    @Override
    public Staff updateStaff(Staff staff) {
        return repository.save(staff);
    }

    @Override
    public void removeStaff(Staff staff) {
        repository.delete(staff);
    }
}
