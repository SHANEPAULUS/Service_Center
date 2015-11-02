package com.shane.servicecenter.conf.factory;

import com.shane.servicecenter.domain.Inventory;

/**
 * Created by SHANE on 2015/05/04.
 */
public class InventoryFactory {
    public static Inventory createInventory(String desc,double price,int stock)
    {
        Inventory inventory=new Inventory.Builder(desc)
                .price(price)
                .stock(stock)
                .build();
        return inventory;
    }
}
