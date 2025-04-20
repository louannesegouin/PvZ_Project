package com.epf.PERSISTANCE.InterfaceDAO;

import java.util.List;
import com.epf.CORE.models.Map;

public interface MapDao {
    Map create(Map gameMap);
    List<Map> getAllMaps();
    Map update(Map gameMap);
    boolean deleteById(Long id);
}
