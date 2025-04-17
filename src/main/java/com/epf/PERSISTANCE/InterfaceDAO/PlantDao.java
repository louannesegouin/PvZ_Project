package com.epf.PERSISTANCE.InterfaceDAO;

import java.util.List;
import java.util.Optional;

import com.epf.CORE.models.Plant;

public interface PlantDao {
    Plant create(Plant plant);
    Optional<Plant> findById(Long id);
    List<Plant> findAll();
    Plant update(Plant plant);
    boolean deleteById(Long id);
}
