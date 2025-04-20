package com.epf.CORE.implementationService;

import com.epf.CORE.models.Plant;
import com.epf.PERSISTANCE.InterfaceDAO.PlantDao;
import com.epf.CORE.interfaceService.PlantService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {

    private final PlantDao plantDao;

    public PlantServiceImpl(PlantDao plantDao) {
        this.plantDao = plantDao;
    }

    public void create(Plant plant) {
        plantDao.create(plant);
    }

    public List<Plant> getAllPlants() {
        return plantDao.getAllPlants();
    }

    public void update(Plant plant) {
        plantDao.update(plant);
    }

    public void delete(Plant plant) {
        plantDao.delete(plant);
    }
}
