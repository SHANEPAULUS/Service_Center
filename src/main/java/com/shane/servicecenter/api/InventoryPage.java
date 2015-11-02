package com.shane.servicecenter.api;


import com.shane.servicecenter.domain.Inventory;
import com.shane.servicecenter.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
@RestController
@RequestMapping(value="/inventory/**")
public class InventoryPage {
    @Autowired
    InventoryService service;

    @RequestMapping(value="/inventory",method= RequestMethod.GET)
    public ResponseEntity<List<Inventory>> getAllInventory()
    {
        List<Inventory> inventoryList=service.getAllItems();
        if(inventoryList.isEmpty())
        {
            return new ResponseEntity<List<Inventory>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Inventory>>(inventoryList,HttpStatus.OK);
    }

    @RequestMapping(value="inventory/{id}",method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Inventory> getInventory(@PathVariable("id") long id)
    {
        Inventory inv=service.getInventory(id);

        if(inv==null)
        {
            return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Inventory>(inv,HttpStatus.OK);
    }

    @RequestMapping(value="/inventory/create",method= RequestMethod.POST)
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory)
    {
        service.addInventory(inventory);

        return new ResponseEntity<Inventory>(inventory,HttpStatus.OK);
    }

    @RequestMapping(value="/inventory/{id}/update",method= RequestMethod.PUT)
    public ResponseEntity<Inventory> updateInventory(@PathVariable("id") long id,@RequestBody Inventory inventory)
    {
        Inventory inv=service.getInventory(id);

        if(inv==null)
        {
            return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
        }

        Inventory newInventory=new Inventory
                .Builder(inventory.getDescription())
                .copy(inventory)
                .id(id)
                .build();

        service.updateInventory(newInventory);
        return new ResponseEntity<Inventory>(newInventory,HttpStatus.OK);
    }

    @RequestMapping(value="/inventory/{id}/delete",method= RequestMethod.DELETE)
    public ResponseEntity<Inventory> removeInventory(@PathVariable("id") long id)
    {
        Inventory inventory=service.getInventory(id);
        if(inventory==null)
        {
            return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
        }

        service.removeInventory(inventory);
        return new ResponseEntity<Inventory>(HttpStatus.NO_CONTENT);
    }

}
