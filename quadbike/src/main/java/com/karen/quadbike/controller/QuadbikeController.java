
package com.karen.quadbike.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.karen.quadbike.model.Quadbike;
import com.karen.quadbike.service.QuadbikeService;

@RestController
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class QuadbikeController {
    @Autowired
    private QuadbikeService quadbikeService;
    @GetMapping("/all")
    public List<Quadbike> obtenerQuadbikeCompleta(){
        return quadbikeService.obtenerQuadbikeCompleta();
    }

    @GetMapping("/{id}")
    public Optional<Quadbike> obtenerQuadbikeId(@PathVariable("id")Integer identificador){
        return quadbikeService.obtenerQuadbikeId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike salvarQuadbike(@RequestBody Quadbike quadbike){
        return quadbikeService.salvarQuadbike(quadbike);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike update(@RequestBody Quadbike quadbike) {
        return quadbikeService.updateQuadbike(quadbike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return quadbikeService.deleteQuadbike(id);
    }
}
