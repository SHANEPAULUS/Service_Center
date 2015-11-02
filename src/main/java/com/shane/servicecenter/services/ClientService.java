package com.shane.servicecenter.services;

import com.shane.servicecenter.domain.Client;
import com.shane.servicecenter.domain.Invoice;
import com.shane.servicecenter.domain.Vehicle;

import java.util.List;

/**
 * Created by SHANE on 2015/05/27.
 */
public interface ClientService {
    List<Client> getClients();
    List<Vehicle> getVehicles(long id);
    List<Invoice> getInvoices(long id);
    //Crud services..
    Client getClient(long id);
    Client addClient(Client client);
    void removeClient(Client client);
    Client updateClient(Client client);
}
