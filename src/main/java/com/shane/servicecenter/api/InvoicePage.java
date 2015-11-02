package com.shane.servicecenter.api;

import com.shane.servicecenter.domain.Invoice;
import com.shane.servicecenter.domain.InvoiceItems;
import com.shane.servicecenter.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SHANE on 2015/08/25.
 */@RestController
   @RequestMapping(value="/invoices/**")
public class InvoicePage {
   @Autowired
   InvoiceService service;

   @RequestMapping(value="/invoices",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<Invoice>> getAllInvoices()
   {
      List<Invoice> invoices=service.getInvoices();

      if(invoices.isEmpty())
      {
         return new ResponseEntity<List<Invoice>>(HttpStatus.NOT_FOUND);
      }

      return new ResponseEntity<List<Invoice>>(invoices,HttpStatus.OK);
   }

   @RequestMapping(value="/create",method = RequestMethod.POST)
   public ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice)
   {
      service.addInvoice(invoice);
      return new ResponseEntity<Invoice>(invoice,HttpStatus.OK);
   }

   @RequestMapping(value="/{id}",method = RequestMethod.GET)
   public ResponseEntity<Invoice> getInvoice(@PathVariable("id") long id)
   {
      Invoice invoice=service.getInvoice(id);
      if(invoice==null)
      {
         return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
      }

      return new ResponseEntity<Invoice>(invoice,HttpStatus.OK);
   }

   @RequestMapping(value="/{id}/update",method = RequestMethod.PUT)
   public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") long id,@RequestBody Invoice invoice)
   {
      Invoice current=service.getInvoice(id);
      if(current==null)
      {
         return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
      }

      Invoice updatedInvoice=new Invoice
              .Builder(invoice.getDate())
              .copy(invoice)
              .id(current.getId())
              .build();
      service.updateInvoice(updatedInvoice);
      return new ResponseEntity<Invoice>(updatedInvoice,HttpStatus.OK);
   }

   @RequestMapping(value="/{id}/delete",method = RequestMethod.DELETE)
   public ResponseEntity<Invoice> removeInvoice(@PathVariable("id") long id)
   {
      Invoice invoice=service.getInvoice(id);

      if(invoice==null)
      {
         return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
      }

      service.removeInvoice(invoice);
      return new ResponseEntity<Invoice>(invoice,HttpStatus.NO_CONTENT);
   }

   @RequestMapping(value="/{id}/invoice_items",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<InvoiceItems>> getInvoiceItems(@PathVariable("id") long id)
   {
      List<InvoiceItems> invoiceItemsList=service.getItems(id);
      if(invoiceItemsList.isEmpty())
      {
         return new ResponseEntity<List<InvoiceItems>>(HttpStatus.NOT_FOUND);
      }

      return new ResponseEntity<List<InvoiceItems>>(invoiceItemsList,HttpStatus.OK);
   }

}
