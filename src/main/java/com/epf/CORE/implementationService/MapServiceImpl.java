package com.epf.CORE.implementationService;

import com.epf.CORE.models.Map;
import com.epf.PERSISTANCE.InterfaceDAO.MapDao;
import com.epf.CORE.interfaceService.MapService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MapServiceImpl implements MapService {

    private final MapDao mapDao;

    public MapServiceImpl(MapDao mapDao) {
        this.mapDao = mapDao;
    }

    @Override
    public Map create(Map map) {
        return mapDao.create(map);
    }

    @Override
    public Optional<Map> findById(Long id) {
        return mapDao.findById(id);
    }

    @Override
    public List<Map> findAll() {
        return mapDao.findAll();
    }

    @Override
    public Map update(Map map) {
        return mapDao.update(map);
    }

    @Override
    public boolean deleteById(Long id) {
        return mapDao.deleteById(id);
    }
}
