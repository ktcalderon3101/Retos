package com.karen.quadbike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.quadbike.model.Client;
import com.karen.quadbike.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    public ClientRepository clientRepository;

    public List<Client> obtenerClientCompleta(){
        return clientRepository.obtenerClientCompleta();

    }

    public Optional<Client> obtenerClientId(Integer id){
        return clientRepository.obtenerClientId(id);
    }

    public Client salvarClient(Client client){
        if(client.getIdClient()==null){
            return clientRepository.salvarClient(client);
        }
        else{
            Optional <Client> clientAuxiliar = clientRepository.obtenerClientId(client.getIdClient());
            if(clientAuxiliar.isEmpty()){
                return clientRepository.salvarClient(client);
            }
            else{
                return client;
            }
        }

    }

    public Client updateClient(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = clientRepository.obtenerClientId(client.getIdClient());
            if (!e.isEmpty()) {
                
                 if(client.getEmail()!=null){
                 e.get().setEmail(client.getEmail());
                 }
                 
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                clientRepository.salvarClient(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int id) {
        Boolean d = obtenerClientId(id).map(client -> {
            clientRepository.delete(client);
            return true;

        }).orElse(false);
        return d;
    }
}
