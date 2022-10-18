package com.karen.quadbike.repots;

import com.karen.quadbike.model.Client;

import lombok.*;

@Getter
@Setter
public class ContadorClientes {
    private Long total;
    private Client client;

    public ContadorClientes(Long total, Client client){
        this.total = total;
        this.client = client;
    }
}
