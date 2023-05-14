package com.example.plant.repositories;

import com.example.plant.PlantApplication;
import com.example.plant.entites.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlantRepo extends CrudRepository <Plant, Integer>  {


    List <Plant> findByHasFruitTrue();
    List<Plant> findByHasFruitFalse();
    List<Plant> findByQuantityLessThan(Integer quantity);
    List<Plant> findByHasFruitTrueAndQuantityLessThan(Integer quantity);
    List<Plant> findByHasFruitFalseAndQuantityLessThan(Integer quantity);


}
