package com.shane.servicecenter.services.Impl;

import com.shane.servicecenter.domain.InvoiceItems;
import com.shane.servicecenter.repository.InvoiceItemsRepostiory;
import com.shane.servicecenter.services.InvoiceItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
@Service
public class InvoiceItemsServiceImpl implements InvoiceItemsService {
    @Autowired
    InvoiceItemsRepostiory repository;

    @Override
    public List<InvoiceItems> getInvoiceAllInvoiceItems() {
        List<InvoiceItems> allInvoiceItems=new ArrayList<>();
        Iterable<InvoiceItems> invoiceItems=repository.findAll();
        for(InvoiceItems items:invoiceItems)
        {
            allInvoiceItems.add(items);
        }
        return allInvoiceItems;
    }

    @Override
    public InvoiceItems getInvoiceItems(long id) {
        return repository.findOne(id);
    }

    @Override
    public InvoiceItems addInvoiceItems(InvoiceItems invoiceItems) {
        return repository.save(invoiceItems);
    }

    @Override
    public InvoiceItems updateInvoiceItems(InvoiceItems invoiceItems) {
        return repository.save(invoiceItems);
    }

    @Override
    public void removeInvoiceItems(long id) {
        repository.delete(id);
    }
}
