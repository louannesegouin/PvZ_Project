package com.epf.CORE.implementationService;

import com.epf.CORE.models.Plant;
import com.epf.PERSISTANCE.InterfaceDAO.PlantDao;
import com.epf.CORE.interfaceService.PlantService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService {

    private final PlantDao plantDao;

    public PlantServiceImpl(PlantDao plantDao) {
        this.plantDao = plantDao;
    }

    @Override
    public Plant create(Plant plant) {
        return plantDao.create(plant);
    }

    @Override
    public Optional<Plant> findById(Long id) {
        return plantDao.findById(id);
    }

    @Override
    public List<Plant> findAll() {
        return plantDao.findAll();
    }

    @Override
    public Plant update(Plant plant) {
        return plantDao.update(plant);
    }

    @Override
    public boolean deleteById(Long id) {
        return plantDao.deleteById(id);
    }
}
