package com.shane.servicecenter.services;

import com.shane.servicecenter.domain.Inventory;

import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
public interface InventoryService {
    Inventory addInventory(Inventory inv);
    Inventory updateInventory(Inventory inv);
    void removeInventory(Inventory inv);
    Inventory getInventory(long id);
    List<Inventory> getAllItems();
}
