package com.shane.servicecenter.services.Impl;

import com.shane.servicecenter.domain.Inventory;
import com.shane.servicecenter.repository.InventoryRepository;
import com.shane.servicecenter.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryRepository repository;

    @Override
    public Inventory addInventory(Inventory inv) {
        return repository.save(inv);
    }

    @Override
    public Inventory updateInventory(Inventory inv) {
        return repository.save(inv);
    }

    @Override
    public void removeInventory(Inventory inv) {
        repository.delete(inv);
    }

    @Override
    public Inventory getInventory(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Inventory> getAllItems() {
        List<Inventory> allInventory=new ArrayList<>();
        Iterable<Inventory> items=repository.findAll();

        for(Inventory inv:items)
        {
            allInventory.add(inv);
        }

        return allInventory;
    }
}
