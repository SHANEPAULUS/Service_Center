package com.shane.servicecenter.conf.factory;

import com.shane.servicecenter.domain.Invoice;
import com.shane.servicecenter.domain.InvoiceItems;
import com.shane.servicecenter.domain.Job;

import java.util.List;

/**
 * Created by SHANE on 2015/05/04.
 */
public class InvoiceFactory {
    public static Invoice createInvoice(String date,List<Job> jobList,List<InvoiceItems> invoiceItems)
    {
        Invoice invoice=new Invoice.Builder(date)
                .build();
        return invoice;
    }
}
