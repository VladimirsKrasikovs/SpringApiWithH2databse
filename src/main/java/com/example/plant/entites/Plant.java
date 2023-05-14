package com.example.plant.entites;

import jakarta.persistence.*;

@Entity
@Table(name="PLANTS")
public class Plant {


    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="QUANTITY")
    private Integer quantity;

    @Column(name="WATERING_FREQUENCY")
    private Integer wateringFrequency;

    @Column(name="HAS_FRUIT")
    private Boolean hasFruit;

    public Plant(String name, Integer quantity, Integer wateringFrequency, Boolean hasFruit) {
        this.name = name;
        this.quantity = quantity;
        this.wateringFrequency = wateringFrequency;
        this.hasFruit = hasFruit;
    }

    public Plant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(Integer wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }

    public Boolean getHasFruit() {
        return hasFruit;
    }

    public void setHasFruit(Boolean hasFruit) {
        this.hasFruit = hasFruit;
    }
}
