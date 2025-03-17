package com.epf.CORE;

import com.epf.CORE.Plant;
import java.util.List;
import java.util.Optional;

public interface PlantService {

    Plant create(Plant plant);
    Optional<Plant> findById(Long id);
    List<Plant> findAll();
    Plant update(Plant plant);
    boolean deleteById(Long id);
}
