package com.shane.servicecenter.services;

import com.shane.servicecenter.domain.Client;
import com.shane.servicecenter.domain.Invoice;
import com.shane.servicecenter.domain.InvoiceItems;
import com.shane.servicecenter.domain.Staff;

import java.util.List;

/**
 * Created by SHANE on 2015/08/12.
 */
public interface InvoiceService {
    List<InvoiceItems> getItems(long id);
    Invoice getInvoice(long id);
    Invoice addInvoice(Invoice inv);
    void removeInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice inv);
    List<Invoice> getInvoices();
}
