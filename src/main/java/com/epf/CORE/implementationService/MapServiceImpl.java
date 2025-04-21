package com.epf.CORE.implementationService;

import com.epf.CORE.models.Map;
import com.epf.PERSISTANCE.InterfaceDAO.MapDao;
import com.epf.CORE.interfaceService.MapService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MapServiceImpl implements MapService {

    private final MapDao mapDao;

    public MapServiceImpl(MapDao mapDao) {
        this.mapDao = mapDao;
    }
    
    public void create(Map map) {
        mapDao.create(map);
    }

    public List<Map> getAllMaps() {
        return mapDao.getAllMaps();
    }

    public void update(Map map) {
        mapDao.update(map);
    }

    public void delete(Map map) {
        mapDao.delete(map);
    }
}
