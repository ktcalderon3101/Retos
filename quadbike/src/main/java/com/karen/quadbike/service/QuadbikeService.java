package com.karen.quadbike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.quadbike.model.Quadbike;
import com.karen.quadbike.repository.QuadbikeRepository;

@Service
public class QuadbikeService {
    @Autowired
    public QuadbikeRepository quadbikeRepository;

    public List<Quadbike> obtenerQuadbikeCompleta(){
        return quadbikeRepository.obtenerQuadbikeCompleta();

    }

    public Optional<Quadbike> obtenerQuadbikeId(Integer id){
        return quadbikeRepository.obtenerQuadbikeId(id);
    }

    public Quadbike salvarQuadbike(Quadbike quadbike){
        if(quadbike.getId()==null){
            return quadbikeRepository.salvarQuadbike(quadbike);
        }
        else{
            Optional <Quadbike> quadbikeAuxiliar = quadbikeRepository.obtenerQuadbikeId(quadbike.getId());
            if(quadbikeAuxiliar.isEmpty()){
                return quadbikeRepository.salvarQuadbike(quadbike);
            }
            else{
                return quadbike;
            }
        }

    }

    public Quadbike updateQuadbike(Quadbike quadbike) {
        if (quadbike.getId() != null) {
            Optional<Quadbike> e = quadbikeRepository.obtenerQuadbikeId(quadbike.getId());
            if (!e.isEmpty()) {
                if (quadbike.getYear() != null) {
                    e.get().setYear(quadbike.getYear());
                }
                if (quadbike.getBrand() != null) {
                    e.get().setBrand(quadbike.getBrand());
                }
                if (quadbike.getDescription() != null) {
                    e.get().setDescription(quadbike.getDescription());
                }
                if (quadbike.getCategory() != null) {
                    e.get().setCategory(quadbike.getCategory());
                }
                if (quadbike.getName() != null) {
                    e.get().setName(quadbike.getName());
                }
                quadbikeRepository.salvarQuadbike(e.get());
                return e.get();
            } else {
                return quadbike;
            }
        } else {
            return quadbike;
        }
    }

    public boolean deleteQuadbike(int id) {
        Boolean d = obtenerQuadbikeId(id).map(quadbike -> {
            quadbikeRepository.delete(quadbike);
            return true;

        }).orElse(false);
        return d;
    }


}
