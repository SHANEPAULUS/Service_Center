package com.shane.servicecenter.services.Impl;

import com.shane.servicecenter.domain.Client;
import com.shane.servicecenter.domain.Invoice;
import com.shane.servicecenter.domain.InvoiceItems;
import com.shane.servicecenter.domain.Staff;
import com.shane.servicecenter.repository.InvoiceRepository;
import com.shane.servicecenter.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository repository;

    @Override
    public List<Invoice> getInvoices() {
        List<Invoice> allInvoices=new ArrayList<>();

        Iterable<Invoice> invoices=repository.findAll();
        for(Invoice inv:invoices)
        {
            allInvoices.add(inv);
        }

        return allInvoices;
    }

    @Override
    public List<InvoiceItems> getItems(long id) {
        return repository.findOne(id).getInvoiceItemsList();
    }

    @Override
    public Invoice getInvoice(long id) {
        return repository.findOne(id);
    }

    @Override
    public Invoice addInvoice(Invoice inv) {
        return repository.save(inv);
    }

    @Override
    public void removeInvoice(Invoice invoice) {
        repository.delete(invoice);
    }

    @Override
    public Invoice updateInvoice(Invoice inv) {
        return repository.save(inv);
    }
}
