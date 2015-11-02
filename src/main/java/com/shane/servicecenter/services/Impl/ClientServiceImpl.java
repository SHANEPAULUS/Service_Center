package com.shane.servicecenter.services.Impl;

import com.shane.servicecenter.domain.Client;
import com.shane.servicecenter.domain.Invoice;
import com.shane.servicecenter.domain.Vehicle;
import com.shane.servicecenter.repository.ClientRepository;
import com.shane.servicecenter.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHANE on 2015/05/27.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public Client addClient(Client client) {
        return repository.save(client);
    }

    @Override
    public void removeClient(Client client) {
        repository.delete(client);
    }

    @Override
    public Client updateClient(Client client) {
        return repository.save(client);
    }

    @Override
    public Client getClient(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Client> getClients() {
        List<Client> clientList=new ArrayList<Client>();

        Iterable<Client> clients=repository.findAll();
        for(Client client:clients)
        {
            clientList.add(client);
        }

        return clientList;
    }

    @Override
    public List<Invoice> getInvoices(long id) {
        return repository.findOne(id).getInvoices();
    }

    @Override
    public List<Vehicle> getVehicles(long id)
    {
        return repository.findOne(id).getVehicle();
    }
}
