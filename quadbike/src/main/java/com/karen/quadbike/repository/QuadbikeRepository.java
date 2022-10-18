package com.karen.quadbike.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karen.quadbike.model.Quadbike;
import com.karen.quadbike.repository.crud.QuadbikeCrudRepositoryInterfaz;

@Repository
public class QuadbikeRepository {
    @Autowired
    private QuadbikeCrudRepositoryInterfaz quadbikeCrudRepositoryInterfaz;

    public List<Quadbike> obtenerQuadbikeCompleta(){
        return (List<Quadbike>) quadbikeCrudRepositoryInterfaz.findAll();
    }

    public Optional<Quadbike> obtenerQuadbikeId(Integer id){
        return quadbikeCrudRepositoryInterfaz.findById(id);
    }

    public Quadbike salvarQuadbike(Quadbike quadbike){
        return quadbikeCrudRepositoryInterfaz.save(quadbike);     
    }

    public void delete(Quadbike quadbike) {
        quadbikeCrudRepositoryInterfaz.delete(quadbike);
    }
}
