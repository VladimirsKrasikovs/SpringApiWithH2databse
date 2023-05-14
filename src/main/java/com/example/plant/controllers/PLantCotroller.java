package com.example.plant.controllers;


import com.example.plant.entites.Plant;
import com.example.plant.repositories.PlantRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PLantCotroller {

    private final PlantRepo plantRepo;

    public PLantCotroller(PlantRepo plantRepo) {
        this.plantRepo = plantRepo;
    }

    @GetMapping(path = "/plants")
    public Iterable<Plant> getAllPlants(){
        return plantRepo.findAll();
    }

    @GetMapping (path = "/plants/{id}")
        public Optional<Plant> getPlantById (@PathVariable int id){
        return plantRepo.findById(id);

    }
    @PostMapping("/plantsNew")
    public Plant createNewPlant (@RequestBody Plant plant){
        return this.plantRepo.save(plant);
    }

    @PutMapping(path = "/plants/{id}")
    public Plant updatePlant (@PathVariable Integer id, @RequestBody Plant p){
        Optional<Plant> plantToUpdateOptional = plantRepo.findById(id);
        if(plantToUpdateOptional.isEmpty()){
            return null;
        }
        Plant plantTodo = plantToUpdateOptional.get();
        if(p.getHasFruit()!=null){
            plantTodo.setHasFruit(p.getHasFruit());
        }
        if(p.getQuantity()!=null){
            plantTodo.setQuantity(p.getQuantity());
        }
        if (p.getName() != null) {
            plantTodo.setName(p.getName());
        }
        if (p.getWateringFrequency() != null) {
            plantTodo.setWateringFrequency(p.getWateringFrequency());
        }

        return this.plantRepo.save(plantTodo);
    }

    @DeleteMapping ("/plants/{id}")
    public Plant deletePlant(@PathVariable ("id") Integer id){
        Optional<Plant> plantToDeleteOptional = this.plantRepo.findById(id);
        if(!plantToDeleteOptional.isPresent()){
            return null;
        }
        Plant plantToDelete = plantToDeleteOptional.get();
        this.plantRepo.delete(plantToDelete);
        return plantToDelete;
    }

    @GetMapping("/plants/search")
    public List<Plant> searchPlants(
            @RequestParam(name="hasFruit", required = false) Boolean hasFruit,
            @RequestParam(name="maxQuantity", required = false) Integer quantity
    ) {
        if (hasFruit != null && quantity != null && hasFruit) {
            return this.plantRepo.findByHasFruitTrueAndQuantityLessThan(quantity);
        }
        if (hasFruit != null && quantity != null) {
            return this.plantRepo.findByHasFruitFalseAndQuantityLessThan(quantity);
        }
        if (hasFruit != null && hasFruit) {
            return this.plantRepo.findByHasFruitTrue();
        }
        if (hasFruit != null) {
            return this.plantRepo.findByHasFruitFalse();
        }
        if (quantity != null) {
            return this.plantRepo.findByQuantityLessThan(quantity);
        }
        return new ArrayList<>();
    }


}
