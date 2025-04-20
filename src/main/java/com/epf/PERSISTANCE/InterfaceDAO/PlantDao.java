package com.epf.PERSISTANCE.InterfaceDAO;

import java.util.List;
import com.epf.CORE.models.Plant;

public interface PlantDao {
    void create(Plant plant);
    List<Plant> getAllPlants();
    void update(Plant plant);
    void delete(Plant plant);
}
