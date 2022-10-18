package com.karen.quadbike.repository.crud;

import org.springframework.data.repository.CrudRepository;

import com.karen.quadbike.model.Message;

public interface MessageCrudRepositoryInterfaz extends CrudRepository<Message, Integer> {
    
}
