package com.shane.servicecenter.services;

import com.shane.servicecenter.domain.InvoiceItems;

import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */
public interface InvoiceItemsService {
    List<InvoiceItems> getInvoiceAllInvoiceItems();
    InvoiceItems getInvoiceItems(long id);
    InvoiceItems addInvoiceItems(InvoiceItems invoiceItems);
    InvoiceItems updateInvoiceItems(InvoiceItems invoiceItems);
    void removeInvoiceItems(long id);

}
