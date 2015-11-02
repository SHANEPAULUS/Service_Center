package com.shane.servicecenter.conf.factory;

import com.shane.servicecenter.domain.Inventory;
import com.shane.servicecenter.domain.InvoiceItems;

import java.util.List;

/**
 * Created by SHANE on 2015/05/04.
 */
public class InvoiceItemsFactory {

    public static InvoiceItems createInvoiceItems(int quantity)
    {
        InvoiceItems invoiceItems=new InvoiceItems.Builder(quantity)
                .build();
        return invoiceItems;
    }
}
