package com.shane.servicecenter.services;

import com.shane.servicecenter.domain.Manager;

import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
public interface ManagerService {
    List<Manager> getAllManagers();
    Manager addManager(Manager manager);
    Manager updateManager(Manager manager);
    void removeManager(Manager manager);
    Manager getManager(long id);
}
